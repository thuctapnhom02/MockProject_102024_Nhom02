package com.mock_project_102024_nhom02.service.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.mock_project_102024_nhom02.dto.request.StaffRequest;
import com.mock_project_102024_nhom02.dto.response.StaffResponse;
import com.mock_project_102024_nhom02.repository.StaffRepository;
import com.mock_project_102024_nhom02.service.StaffService;
import com.mock_project_102024_nhom02.entity.Role;
import com.mock_project_102024_nhom02.entity.Staff;
import com.mock_project_102024_nhom02.exception.AppException;
import com.mock_project_102024_nhom02.exception.ErrorCode;
import com.mock_project_102024_nhom02.mapper.StaffMapper;
import com.mock_project_102024_nhom02.repository.RoleRepository;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StaffServiceImpl implements StaffService {

    StaffRepository staffRepository;
    StaffMapper staffMapper;
    RoleRepository roleRepository;

    @Override
    public StaffResponse getStaffById(String staffId) {
        return staffMapper
                .toStaffResponse(staffRepository
                        .findById(staffId).orElseThrow(
                                () -> new AppException(ErrorCode.STAFF_NOT_EXISTED)
                        )
                );
    }

    @Override
    public Page<StaffResponse> getAllStaffWithCondition(String searchValue, String status, String accountType, int currentPage, int pageSize) {
        Pageable pageable = PageRequest.of(currentPage -1, pageSize);
        Page<StaffResponse> responses = null;
        if(Objects.isNull(searchValue)){
            responses = staffRepository.findAllByStatus(status, pageable)
                    .map(staffMapper::toStaffResponse);
        } else {
            Role role = roleRepository.findByNameRole(accountType).orElseThrow(() -> new AppException(ErrorCode.ROLE_NOT_EXISTED));
            responses = staffRepository.findAllByPhoneAndStatusAndRole(searchValue, status, role, pageable)
                    .map(staffMapper::toStaffResponse);
        }
        return responses;
    }

    @Override
    public List<StaffResponse> getAllStaff() {
        return staffRepository.findAll()
                .stream().map(staffMapper::toStaffResponse).collect(Collectors.toList());
    }

    @Override
    public StaffResponse addStaff(StaffRequest staffRequest) {
        if(staffRepository.existsByPhone(staffRequest.getPhone())) {
            throw new AppException(ErrorCode.STAFF_EXISTED);
        }
        Role role = roleRepository.findById(staffRequest.getRole())
                .orElseThrow(() -> new AppException(ErrorCode.ROLE_NOT_EXISTED));
        Staff staff = staffMapper.toStaff(staffRequest);
        staff.setRole(role);
        return staffMapper.toStaffResponse(staffRepository.save(staff));
    }

    @Override
    public StaffResponse updateStaff(StaffRequest staffRequest, String id) {
        Staff staff = staffRepository.findById(id)
                            .orElseThrow(
                                    () -> new AppException(ErrorCode.STAFF_NOT_EXISTED));
        staffMapper.updateStaff(staff, staffRequest);
        return staffMapper.toStaffResponse(staffRepository.save(staff));
    }

    @Override
    public void deleteStaff(String staffId) {
        var staff = staffRepository.findById(staffId)
                .orElseThrow(() -> new AppException(ErrorCode.STAFF_NOT_EXISTED));
        staff.setDeleteStatus(0);
        staff.setDayDelete(LocalDate.now());
        staffRepository.save(staff);
    }
}
