package com.mock_project_102024_nhom02.service.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Objects;

import com.mock_project_102024_nhom02.dto.request.ComplaintsRequest;
import com.mock_project_102024_nhom02.dto.response.ComplaintsResponse;
import com.mock_project_102024_nhom02.exception.AppException;
import com.mock_project_102024_nhom02.exception.ErrorCode;
import com.mock_project_102024_nhom02.mapper.ComplaintsMapper;
import com.mock_project_102024_nhom02.repository.ComplaintsRepository;
import com.mock_project_102024_nhom02.service.ComplaintsService;
import com.mock_project_102024_nhom02.repository.ApartmentRepository;
import com.mock_project_102024_nhom02.repository.StaffRepository;
import com.mock_project_102024_nhom02.repository.UserRepository;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ComplaintsServiceImp implements ComplaintsService {

    ComplaintsRepository complaintsRepository;
    ApartmentRepository apartmentRepository;
    UserRepository userRepository;
    StaffRepository staffRepository;

    ComplaintsMapper complaintsMapper;

    @Override
    public ComplaintsResponse getComplaintsById(String ComplaintsId) {
        return complaintsMapper.toComplaintsResponse(complaintsRepository.findById(ComplaintsId)
                .orElseThrow(() -> new AppException(ErrorCode.COMPLAIN_NOT_EXISTED)));
    }

    @Override
    public Page<ComplaintsResponse> getAllComplaintsWithCondition(String complaintId, String status, int currentPage, int pageSize) {
        Pageable pageable = PageRequest.of(currentPage - 1, pageSize);
        if (!Objects.isNull(status) && !Objects.isNull(complaintId)) {
            return complaintsRepository.findAllByIdLikeAndStatus("%" + complaintId + "%", status, pageable).map(complaintsMapper::toComplaintsResponse);
        } else if (!Objects.isNull(complaintId)) {
            return complaintsRepository.findAllByIdLike("%" + complaintId + "%", pageable).map(complaintsMapper::toComplaintsResponse);
        } else if (!Objects.isNull(status)) {
            return complaintsRepository.findAllByStatus(status, pageable).map(complaintsMapper::toComplaintsResponse);
        }
        return complaintsRepository.findAll(pageable).map(complaintsMapper::toComplaintsResponse);
    }


    @Override
    public ComplaintsResponse addComplaints(ComplaintsRequest complaintsRequest) {

        var apartment = apartmentRepository.findById(complaintsRequest.getApartment())
                .orElseThrow(() -> new AppException(ErrorCode.APARTMENT_NOT_EXISTED));

        var user = userRepository.findById(complaintsRequest.getUser())
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));

        var staff = staffRepository.findById(complaintsRequest.getStaff())
                .orElseThrow(() -> new AppException(ErrorCode.STAFF_NOT_EXISTED));

        var complaints = complaintsMapper.toComplaints(complaintsRequest);
        complaints.setApartment(apartment);
        complaints.setUser(user);
        complaints.setStaff(staff);

        return complaintsMapper.toComplaintsResponse(complaintsRepository.save(complaints));
    }

    @Override
    public ComplaintsResponse updateComplaints(ComplaintsRequest complaintsRequest, String id) {
        var complaints = complaintsRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.COMPLAIN_NOT_EXISTED));

        var apartment = apartmentRepository.findById(complaintsRequest.getApartment())
                .orElseThrow(() -> new AppException(ErrorCode.APARTMENT_NOT_EXISTED));

        var user = userRepository.findById(complaintsRequest.getUser())
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));

        var staff = staffRepository.findById(complaintsRequest.getStaff())
                .orElseThrow(() -> new AppException(ErrorCode.STAFF_NOT_EXISTED));

        complaintsMapper.updateComplaints(complaints, complaintsRequest);
        complaints.setApartment(apartment);
        complaints.setUser(user);
        complaints.setStaff(staff);

        return complaintsMapper.toComplaintsResponse(complaintsRepository.save(complaints));

    }

    @Override
    public void deleteComplaints(String id) {
        var complaints = complaintsRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.COMPLAIN_NOT_EXISTED));
        complaints.setDeleteStatus(0);
        complaints.setDayDelete(LocalDate.now());
        complaintsRepository.save(complaints);
    }

}
