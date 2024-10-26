package com.mock_project_102024_nhom02.controller;

import jakarta.servlet.http.HttpServletResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.mock_project_102024_nhom02.dto.response.PagingResponse;
import com.mock_project_102024_nhom02.dto.request.IncomeRequest;
import com.mock_project_102024_nhom02.dto.response.ApiResponse;
import com.mock_project_102024_nhom02.dto.response.IncomeResponse;
import com.mock_project_102024_nhom02.service.IncomeService;

@RestController
@RequestMapping("${api.prefix}"+"/incomes")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class IncomeController {

    IncomeService incomeService;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse> getAll(){
        ApiResponse<List<IncomeResponse>> apiResponse = ApiResponse.<List<IncomeResponse>>builder()
                .message("This is the data of income")
                .response(HttpStatus.OK.value())
                .result(incomeService.getAllIncomes())
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<PagingResponse> getAllStaff(
            @RequestParam(name = "search-value", required = false) String apartmentId,
            @RequestParam(name = "service-id", required = false) String serviceId,
            @RequestParam(name = "start-date", required = false) LocalDate startDate,
            @RequestParam(name = "end-date", required = false) LocalDate endDate,
            @RequestParam(name = "current-page", defaultValue = "1", required = false) int currentPage,
            @RequestParam(name = "page-size", defaultValue = "9", required = false) int pageSize
    ){

        Page<IncomeResponse> staffList = incomeService.getAllIncomesWithCondition(apartmentId, serviceId,
                startDate, endDate, currentPage, pageSize);

        Map<String, String> searchBody = new HashMap<>();

        if(!Objects.isNull(apartmentId)){
            searchBody.put("searchValue", apartmentId);
        }

        if(!Objects.isNull(serviceId)){
            searchBody.put("service", serviceId);
        }

        if(!Objects.isNull(startDate)){
            searchBody.put("startDate", startDate.toString());
        }

        if(!Objects.isNull(endDate)){
            searchBody.put("endDate", endDate.toString());
        }

        PagingResponse<?> response = PagingResponse.builder()
                .code(HttpStatus.OK.value())
                .currentPage(currentPage)
                .pageSize(pageSize)
                .result(staffList.toList())
                .totalItem(staffList.getTotalElements())
                .totalPage(staffList.getTotalPages())
                .search(searchBody)
                .build();
        return ResponseEntity
                .status(HttpStatus.OK.value())
                .body(response);
    }

    @GetMapping("/export-excel")
    public void exportStaffToExcel(HttpServletResponse response) throws IOException {
        incomeService.exportToExcel(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getIncome(@PathVariable("id") String id){
        ApiResponse<IncomeResponse> apiResponse = ApiResponse.<IncomeResponse>builder()
                .message("This is the data of income")
                .response(HttpStatus.OK.value())
                .result(incomeService.getIncomeById(id))
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping()
    public ResponseEntity<ApiResponse> createIncome(@RequestBody IncomeRequest incomeRequest){
        ApiResponse<IncomeResponse> apiResponse = ApiResponse.<IncomeResponse>builder()
                .message("Create success")
                .response(HttpStatus.CREATED.value())
                .result(incomeService.addIncome(incomeRequest))
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateIncome(@RequestBody IncomeRequest incomeRequest,@PathVariable("id") String id ){
        ApiResponse<IncomeResponse> apiResponse = ApiResponse.<IncomeResponse>builder()
                .message("Update success")
                .response(HttpStatus.OK.value())
                .result(incomeService.updateIncome(incomeRequest,id))
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteIncome(@PathVariable("id") String id ){
        incomeService.deleteIncome(id);
        ApiResponse<IncomeResponse> apiResponse = ApiResponse.<IncomeResponse>builder()
                .message("Delete success")
                .response(HttpStatus.OK.value())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

}
