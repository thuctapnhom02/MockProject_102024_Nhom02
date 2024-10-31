package com.mock_project_102024_nhom02.mapper;

import org.mapstruct.Mapper;

import com.mock_project_102024_nhom02.dto.response.TypeOutcomeResponse;
import com.mock_project_102024_nhom02.entity.TypeOutcome;

@Mapper(componentModel = "spring")
public interface TypeOutcomeMapper {
    TypeOutcomeResponse toTypeOutomeResponse(TypeOutcome typeOutome);
}
