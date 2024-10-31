package com.mock_project_102024_nhom02.service.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import org.springframework.data.domain.Page;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.mock_project_102024_nhom02.dto.request.UserRequest;
import com.mock_project_102024_nhom02.dto.response.UserResponse;
import com.mock_project_102024_nhom02.repository.UserRepository;
import com.mock_project_102024_nhom02.service.UserService;
import com.mock_project_102024_nhom02.mapper.UserMapper;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserServiceImpl implements UserService {

    UserRepository userRepository;
    UserMapper userMapper;

    @Override
    public UserResponse getUserById(String id) {
        return null;
    }

    @Override
    public UserResponse getUserByEmail(String email) {
        return null;
    }

    @Override
    public UserResponse getUserByUsername(String username) {
        return null;
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll()
                .stream().map(userMapper::toUserResponse).collect(Collectors.toList());
    }

    @Override
    public Page<UserResponse> getAllUsersWithCondition(String searchValue, String status, int currentPage, int pageSize) {
        Pageable pageable = PageRequest.of(currentPage - 1, pageSize);
        Page<UserResponse> responses = null;
        if (Objects.isNull(searchValue)) {
            responses = userRepository.findAllByStatus(status, pageable)
                    .map(userMapper::toUserResponse);
        } else {
            responses = userRepository.findAllByPhoneAndStatus(searchValue, status, pageable)
                    .map(userMapper::toUserResponse);
        }
        return responses;
    }

    @Override
    public UserResponse updateUser(UserRequest userRequest, String id) {
        return null;
    }

    @Override
    public UserResponse addUser(UserRequest userRequest) {
        return null;
    }

    @Override
    public void deleteUserById(String id) {

    }
}
