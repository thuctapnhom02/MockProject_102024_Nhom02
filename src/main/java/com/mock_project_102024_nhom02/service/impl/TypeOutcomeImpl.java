package com.mock_project_102024_nhom02.service.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import com.mock_project_102024_nhom02.service.TypeOutcomeService;
import com.mock_project_102024_nhom02.dto.response.TypeOutcomeResponse;
import com.mock_project_102024_nhom02.mapper.TypeOutcomeMapper;
import com.mock_project_102024_nhom02.repository.TypeOutcomeRepository;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TypeOutcomeImpl implements TypeOutcomeService {

    TypeOutcomeRepository typeOutcomeRepository;
    TypeOutcomeMapper typeOutcomeMapper;

    @Override
    public List<TypeOutcomeResponse> getAllTypeOutcome() {
        return typeOutcomeRepository.findAll()
                .stream().map(typeOutcomeMapper::toTypeOutomeResponse).collect(Collectors.toList());
    }
}
