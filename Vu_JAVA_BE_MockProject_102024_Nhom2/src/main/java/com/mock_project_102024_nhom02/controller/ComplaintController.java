package com.mock_project_102024_nhom02.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.mock_project_102024_nhom02.dto.request.ComplaintsRequest;
import com.mock_project_102024_nhom02.dto.response.ApiResponse;
import com.mock_project_102024_nhom02.dto.response.ComplaintsResponse;
import com.mock_project_102024_nhom02.dto.response.PagingResponse;
import com.mock_project_102024_nhom02.service.ComplaintsService;

@RestController
@RequestMapping("${api.prefix}"+"/complaints")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ComplaintController {
    ComplaintsService complaintsService;

    @GetMapping
    public ResponseEntity<PagingResponse> getAllStaff(
            @RequestParam(name = "search-value", required = false) String complaintId,
            @RequestParam(name = "status", required = false) String status,
            @RequestParam(name = "current-page", defaultValue = "1", required = false) int currentPage,
            @RequestParam(name = "page-size", defaultValue = "9", required = false) int pageSize
    ){

        Page<ComplaintsResponse> staffList = complaintsService.getAllComplaintsWithCondition(complaintId, status,
                 currentPage, pageSize);

        Map<String, String> searchBody = new HashMap<>();

        if(!Objects.isNull(complaintId)){
            searchBody.put("searchValue", complaintId);
        }

        if(!Objects.isNull(status)){
            searchBody.put("status", status);
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

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getComplaints(@PathVariable("id") String id){
        ApiResponse<ComplaintsResponse> apiResponse = ApiResponse.<ComplaintsResponse>builder()
                .message("This is the data of Complaints")
                .response(HttpStatus.OK.value())
                .result(complaintsService.getComplaintsById(id))
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping()
    public ResponseEntity<ApiResponse> createComplaints(@RequestBody ComplaintsRequest ComplaintsRequest){
        ApiResponse<ComplaintsResponse> apiResponse = ApiResponse.<ComplaintsResponse>builder()
                .message("Create success")
                .response(HttpStatus.CREATED.value())
                .result(complaintsService.addComplaints(ComplaintsRequest))
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateComplaints(@RequestBody ComplaintsRequest ComplaintsRequest,@PathVariable("id") String id ){
        ApiResponse<ComplaintsResponse> apiResponse = ApiResponse.<ComplaintsResponse>builder()
                .message("Update success")
                .response(HttpStatus.OK.value())
                .result(complaintsService.updateComplaints(ComplaintsRequest,id))
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteComplaints(@PathVariable("id") String id ){
        complaintsService.deleteComplaints(id);
        ApiResponse<ComplaintsResponse> apiResponse = ApiResponse.<ComplaintsResponse>builder()
                .message("Delete success")
                .response(HttpStatus.OK.value())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

}
