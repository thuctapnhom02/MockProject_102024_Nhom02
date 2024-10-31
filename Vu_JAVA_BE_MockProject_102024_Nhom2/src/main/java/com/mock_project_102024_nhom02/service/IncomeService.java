package com.mock_project_102024_nhom02.service;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.data.domain.Page;

import com.mock_project_102024_nhom02.dto.request.IncomeRequest;
import com.mock_project_102024_nhom02.dto.response.IncomeResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public interface IncomeService {
    IncomeResponse getIncomeById(String incomeId);

    List<IncomeResponse> getAllIncomes();

    Page<IncomeResponse> getAllIncomesWithCondition(String apartmentId, String serviceId,
                                                    LocalDate startDate, LocalDate  endDate, int currentPage, int pageSize);

    IncomeResponse addIncome(IncomeRequest incomeRequest);

    IncomeResponse updateIncome(IncomeRequest incomeRequest, String id);

    void deleteIncome(String id);

    void exportToExcel(HttpServletResponse response) throws IOException;
}
