package com.mock_project_102024_nhom02.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.mock_project_102024_nhom02.dto.request.UserRequest;
import com.mock_project_102024_nhom02.dto.response.UserResponse;
import com.mock_project_102024_nhom02.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toUser(UserRequest userRequest);

    UserResponse toUserResponse(User user);

    void updateUser(@MappingTarget User user, UserRequest userRequest);

}

