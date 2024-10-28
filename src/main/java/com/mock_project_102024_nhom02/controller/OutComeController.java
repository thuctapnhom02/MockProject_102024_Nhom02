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

import com.mock_project_102024_nhom02.dto.response.ApiResponse;
import com.mock_project_102024_nhom02.dto.response.PagingResponse;
import com.mock_project_102024_nhom02.service.OutcomeService;
import com.mock_project_102024_nhom02.dto.request.OutcomeRequest;
import com.mock_project_102024_nhom02.dto.response.OutcomeResponse;

@RestController
@RequestMapping("${api.prefix}"+"/outcomes")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OutComeController {

    OutcomeService outcomeService;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse> getAll(){
        ApiResponse<List<OutcomeResponse>> apiResponse = ApiResponse.<List<OutcomeResponse>>builder()
                .message("This is the data of outcome")
                .response(HttpStatus.OK.value())
                .result(outcomeService.getAllOutcomes())
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<PagingResponse> getAllStaff(
            @RequestParam(name = "search-value", required = false) String typeOutcomeId,
            @RequestParam(name = "start-date", required = false) LocalDate startDate,
            @RequestParam(name = "end-date", required = false) LocalDate endDate,
            @RequestParam(name = "current-page", defaultValue = "1", required = false) int currentPage,
            @RequestParam(name = "page-size", defaultValue = "9", required = false) int pageSize
    ){

        Page<OutcomeResponse> staffList = outcomeService.getAllOutcomeWithCondition(typeOutcomeId,
                startDate, endDate, currentPage, pageSize);

        Map<String, String> searchBody = new HashMap<>();

        if(!Objects.isNull(typeOutcomeId)){
            searchBody.put("searchValue", typeOutcomeId);
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
        outcomeService.exportToExcel(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getIncome(@PathVariable("id") String id){
        ApiResponse<OutcomeResponse> apiResponse = ApiResponse.<OutcomeResponse>builder()
                .message("This is the data of income")
                .response(HttpStatus.OK.value())
                .result(outcomeService.getOutcomeById(id))
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping()
    public ResponseEntity<ApiResponse> createIncome(@RequestBody OutcomeRequest outcomeRequest){
        ApiResponse<OutcomeResponse> apiResponse = ApiResponse.<OutcomeResponse>builder()
                .message("Create success")
                .response(HttpStatus.CREATED.value())
                .result(outcomeService.addOutcome(outcomeRequest))
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateIncome(@RequestBody OutcomeRequest outcomeRequest, @PathVariable("id") String id ){
        ApiResponse<OutcomeResponse> apiResponse = ApiResponse.<OutcomeResponse>builder()
                .message("Update success")
                .response(HttpStatus.OK.value())
                .result(outcomeService.updateOutcome(outcomeRequest,id))
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteIncome(@PathVariable("id") String id ){
        outcomeService.deleteOutcome(id);
        ApiResponse<OutcomeResponse> apiResponse = ApiResponse.<OutcomeResponse>builder()
                .message("Delete success")
                .response(HttpStatus.OK.value())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

}
