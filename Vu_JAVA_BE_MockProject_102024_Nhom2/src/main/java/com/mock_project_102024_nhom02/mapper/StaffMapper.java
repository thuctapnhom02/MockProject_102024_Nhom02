package com.mock_project_102024_nhom02.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.mock_project_102024_nhom02.dto.request.StaffRequest;
import com.mock_project_102024_nhom02.dto.response.StaffResponse;
import com.mock_project_102024_nhom02.entity.Staff;

@Mapper(componentModel = "spring")
public interface StaffMapper {

    @Mapping(target = "role", ignore = true)
    Staff toStaff(StaffRequest staffRequest);

    StaffResponse toStaffResponse(Staff staff);

    @Mapping(target = "role", ignore = true)
    void updateStaff(@MappingTarget Staff staff, StaffRequest request);

}

