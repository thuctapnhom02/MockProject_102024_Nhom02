package com.mock_project_102024_nhom02.service;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.data.domain.Page;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import com.mock_project_102024_nhom02.dto.request.ComplaintsRequest;
import com.mock_project_102024_nhom02.dto.response.ComplaintsResponse;

public interface ComplaintsService {
    ComplaintsResponse getComplaintsById(String ComplaintsId);

    Page<ComplaintsResponse> getAllComplaintsWithCondition(String complaintId, String status, int currentPage, int pageSize);

    ComplaintsResponse addComplaints(ComplaintsRequest ComplaintsRequest);

    ComplaintsResponse updateComplaints(ComplaintsRequest ComplaintsRequest, String id);

    void deleteComplaints(String id);

}
