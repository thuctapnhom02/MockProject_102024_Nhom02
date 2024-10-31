package com.mock_project_102024_nhom02.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.mock_project_102024_nhom02.dto.request.ComplaintsRequest;
import com.mock_project_102024_nhom02.dto.response.ComplaintsResponse;
import com.mock_project_102024_nhom02.entity.Complaints;

@Mapper(componentModel = "spring")
public interface ComplaintsMapper {

    @Mapping(target = "apartment", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "staff", ignore = true)
    Complaints toComplaints(ComplaintsRequest ComplaintsRequest);

    ComplaintsResponse toComplaintsResponse(Complaints Complaints);

    @Mapping(target = "apartment", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "staff", ignore = true)
    void updateComplaints(@MappingTarget Complaints Complaints, ComplaintsRequest request);

}

