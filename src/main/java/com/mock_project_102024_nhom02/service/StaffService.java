package com.mock_project_102024_nhom02.service;

import org.springframework.data.domain.Page;

import com.mock_project_102024_nhom02.dto.request.StaffRequest;
import com.mock_project_102024_nhom02.dto.response.StaffResponse;

import java.util.List;


public interface StaffService {
    StaffResponse getStaffById(String staffId);
    Page<StaffResponse> getAllStaffWithCondition(String searchValue, String status, String accountType, int currentPage, int pageSize);
    List<StaffResponse> getAllStaff();
    StaffResponse addStaff(StaffRequest staffRequest);
    StaffResponse updateStaff(StaffRequest staffRequest, String id);
    void deleteStaff(String staffId);
}
