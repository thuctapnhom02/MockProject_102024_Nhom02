package com.mock_project_102024_nhom02.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.mock_project_102024_nhom02.dto.request.OutcomeRequest;
import com.mock_project_102024_nhom02.dto.response.OutcomeResponse;
import com.mock_project_102024_nhom02.entity.Outcome;

@Mapper(componentModel = "spring")
public interface OutcomeMapper {

    @Mapping(target = "typeOutcome", ignore = true)
    @Mapping(target = "repairHistory", ignore = true)
    @Mapping(target = "supplier", ignore = true)
    Outcome toOutcome(OutcomeRequest outcomeRequest);

    OutcomeResponse toOutcomeResponse(Outcome outcome);

    @Mapping(target = "typeOutcome", ignore = true)
    @Mapping(target = "repairHistory", ignore = true)
    @Mapping(target = "supplier", ignore = true)
    void updateOutcome(@MappingTarget Outcome outcome, OutcomeRequest request);

}

