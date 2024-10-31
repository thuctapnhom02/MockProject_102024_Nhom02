package com.mock_project_102024_nhom02.service.impl;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.mock_project_102024_nhom02.dto.request.OutcomeRequest;
import com.mock_project_102024_nhom02.dto.response.OutcomeResponse;
import com.mock_project_102024_nhom02.exception.AppException;
import com.mock_project_102024_nhom02.exception.ErrorCode;
import com.mock_project_102024_nhom02.mapper.OutcomeMapper;
import com.mock_project_102024_nhom02.repository.OutcomeRepository;
import com.mock_project_102024_nhom02.repository.RepairHistoryRepository;
import com.mock_project_102024_nhom02.repository.SuppliersRepository;
import com.mock_project_102024_nhom02.repository.TypeOutcomeRepository;
import com.mock_project_102024_nhom02.service.OutcomeService;
import com.mock_project_102024_nhom02.dao.OutcomeDAO;
import com.mock_project_102024_nhom02.entity.Outcome;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OutcomeServiceImp implements OutcomeService {

    OutcomeRepository outcomeRepository;
    OutcomeMapper outcomeMapper;
    TypeOutcomeRepository typeOutcomeRepository;
    RepairHistoryRepository repairHistoryRepository;
    SuppliersRepository suppliersRepository;
    OutcomeDAO outcomeDAO;

    @Override
    public OutcomeResponse getOutcomeById(String outcomeId) {
        return outcomeMapper.toOutcomeResponse(outcomeRepository.findById(outcomeId)
                .orElseThrow(() -> new AppException(ErrorCode.OUTCOME_NOT_EXISTED))) ;
    }

    @Override
    public List<OutcomeResponse> getAllOutcomes() {
        return outcomeRepository.findAll()
                .stream().map(outcomeMapper::toOutcomeResponse).collect(Collectors.toList());
    }

    @Override
    public Page<OutcomeResponse> getAllOutcomeWithCondition(String typeOutcomeId, LocalDate startDate, LocalDate endDate, int currentPage, int pageSize) {
        return outcomeDAO.filterWithCondition(typeOutcomeId, startDate, endDate, currentPage, pageSize);
    }

    @Override
    public OutcomeResponse addOutcome(OutcomeRequest outcomeRequest) {
        var typeOutcome = typeOutcomeRepository.findById(outcomeRequest.getTypeOutcome())
                .orElseThrow(() -> new AppException(ErrorCode.TYPE_OUTCOME_NOT_EXISTED));
        var repairHistory = repairHistoryRepository.findById(outcomeRequest.getRepairHistory())
                .orElseThrow(() -> new AppException(ErrorCode.REPAIR_HISTORY_NOT_EXISTED));
        var supplier = suppliersRepository.findById(outcomeRequest.getSupplier())
                .orElseThrow(() -> new AppException(ErrorCode.SUPPLIER_NOT_EXISTED));

        if(outcomeRequest.getDayOutcome().isBefore(LocalDate.now())) {
            throw new AppException(ErrorCode.DATE_INVALID);
        }

        var outcome = outcomeMapper.toOutcome(outcomeRequest);
        outcome.setTypeOutcome(typeOutcome);
        outcome.setRepairHistory(repairHistory);
        outcome.setSupplier(supplier);

        return outcomeMapper.toOutcomeResponse(outcomeRepository.save(outcome));
    }

    @Override
    public OutcomeResponse updateOutcome(OutcomeRequest outcomeRequest, String id) {
        var outcome = outcomeRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.OUTCOME_NOT_EXISTED));

        if(outcomeRequest.getDayOutcome().isBefore(LocalDate.now())) {
            throw new AppException(ErrorCode.DATE_INVALID);
        }

        outcomeMapper.updateOutcome(outcome, outcomeRequest);

        return outcomeMapper.toOutcomeResponse(outcomeRepository.save(outcome));
    }

    @Override
    public void deleteOutcome(String id) {
        var outcome = outcomeRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.OUTCOME_NOT_EXISTED));
        outcome.setDeleteStatus(0);
        outcome.setDayDelete(LocalDate.now());
        outcomeRepository.save(outcome);
    }

    @Override
    public void exportToExcel(HttpServletResponse response) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Outcome");
        var outcomes = outcomeRepository.findAll();
        // Tạo header row
        Row headerRow = sheet.createRow(0);
        String[] headers = {"ID", "Status", "Service name", "Description", "Price",
                "Date outcome", "Detail", "Type of Outcome", "Repair History", "Supplier" };

        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
        }

        // Điền dữ liệu
        int rowNum = 1;
        for (Outcome outcome : outcomes) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(outcome.getId());
            row.createCell(1).setCellValue(outcome.getStatus());
            row.createCell(2).setCellValue(outcome.getNameService());
            row.createCell(3).setCellValue(outcome.getDescription());
            row.createCell(4).setCellValue(outcome.getPrice().toString());
            row.createCell(5).setCellValue(outcome.getDayOutcome().toString());
            row.createCell(6).setCellValue(outcome.getDetails());
            row.createCell(7).setCellValue(outcome.getTypeOutcome().getNameType());
            row.createCell(8).setCellValue(outcome.getRepairHistory().getDescription());
            row.createCell(9).setCellValue(outcome.getSupplier().getName());
        }

        // Thiết lập header để tải file Excel
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=Outcome_Report.xlsx");

        // Ghi workbook vào output stream của response
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();

        outputStream.close();
    }
}
