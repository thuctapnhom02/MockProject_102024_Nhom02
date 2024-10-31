package com.mock_project_102024_nhom02.mapper;

import org.mapstruct.Mapper;

import com.mock_project_102024_nhom02.dto.response.RoleResponse;
import com.mock_project_102024_nhom02.entity.Role;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    RoleResponse toRoleResponse(Role role);
}
