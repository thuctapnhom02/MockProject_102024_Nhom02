package com.mock_project_102024_nhom02.service;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.data.domain.Page;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import com.mock_project_102024_nhom02.dto.request.OutcomeRequest;
import com.mock_project_102024_nhom02.dto.response.OutcomeResponse;

public interface OutcomeService {
    OutcomeResponse getOutcomeById(String outcomeId);

    List<OutcomeResponse> getAllOutcomes();

    Page<OutcomeResponse> getAllOutcomeWithCondition(String typeOutcome,
                                                     LocalDate startDate, LocalDate  endDate, int currentPage, int pageSize);

    OutcomeResponse addOutcome(OutcomeRequest outcomeRequest);

    OutcomeResponse updateOutcome(OutcomeRequest outcomeRequest, String id);

    void deleteOutcome(String id);

    void exportToExcel(HttpServletResponse response) throws IOException;
}
