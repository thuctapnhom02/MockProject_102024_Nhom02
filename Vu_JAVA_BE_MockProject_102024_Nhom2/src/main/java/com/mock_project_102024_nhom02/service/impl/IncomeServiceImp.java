package com.mock_project_102024_nhom02.service.impl;


import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.mock_project_102024_nhom02.dto.request.IncomeRequest;
import com.mock_project_102024_nhom02.dto.response.IncomeResponse;
import com.mock_project_102024_nhom02.exception.AppException;
import com.mock_project_102024_nhom02.exception.ErrorCode;
import com.mock_project_102024_nhom02.mapper.IncomeMapper;
import com.mock_project_102024_nhom02.service.IncomeService;
import com.mock_project_102024_nhom02.repository.*;
import com.mock_project_102024_nhom02.dao.IncomeDAO;
import com.mock_project_102024_nhom02.entity.Income;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class IncomeServiceImp implements IncomeService {

    IncomeRepository incomeRepository;
    IncomeMapper incomeMapper;
    ServiceRepository serviceRepository;
    ApartmentRepository apartmentRepository;
    PaymentMethodRepository paymentMethodRepository;
    TypeIncomeRepository typeIncomeRepository;
    UserRepository userRepository;
    IncomeDAO incomeDAO;

    @Override
    public IncomeResponse getIncomeById(String incomeId) {
        return incomeMapper.toIncomeResponse(incomeRepository.findById(incomeId)
                .orElseThrow(() -> new AppException(ErrorCode.INCOME_NOT_EXISTED)));
    }

    @Override
    public List<IncomeResponse> getAllIncomes() {
        return incomeRepository.findAll()
                .stream().map(incomeMapper::toIncomeResponse).collect(Collectors.toList());
    }

    @Override
    public Page<IncomeResponse> getAllIncomesWithCondition(String apartmentId, String serviceId,
                                                           LocalDate startDate, LocalDate  endDate , int currentPage, int pageSize) {
        return incomeDAO.filterWithCondition(apartmentId, serviceId, startDate, endDate, currentPage, pageSize);
    }

    @Override
    public IncomeResponse addIncome(IncomeRequest incomeRequest) {
        var user = userRepository.findById(incomeRequest.getUser()).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));
        var apartment = apartmentRepository.findById(incomeRequest.getApartment()).orElseThrow(() -> new AppException(ErrorCode.APARTMENT_NOT_EXISTED));
        var service = serviceRepository.findById(incomeRequest.getService()).orElseThrow(() -> new AppException(ErrorCode.SERVICE_NOT_EXISTED));
        var paymentMethod = paymentMethodRepository.findById(incomeRequest.getPaymentMethod()).orElseThrow(() -> new AppException(ErrorCode.PAYMENT_METHOD_NOT_EXISTED));
        var typeIncome = typeIncomeRepository.findById(incomeRequest.getTypeIncome()).orElseThrow(() -> new AppException(ErrorCode.TYPE_INCOME_NOT_EXISTED));
        var income = incomeMapper.toIncome(incomeRequest);
        income.setUser(user);
        income.setApartment(apartment);
        income.setService(service);
        income.setPaymentMethod(paymentMethod);
        income.setTypeIncome(typeIncome);
        return incomeMapper.toIncomeResponse(incomeRepository.save(income));
    }

    @Override
    public IncomeResponse updateIncome(IncomeRequest incomeRequest, String id) {
        var income = incomeRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.INCOME_NOT_EXISTED));
        if(incomeRequest.getPaymentDeadline().isBefore(LocalDate.now())) {
            throw new AppException(ErrorCode.DATE_INVALID);
        }
        incomeMapper.updateIncome(income, incomeRequest);
        var user = userRepository.findById(incomeRequest.getUser()).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));
        var apartment = apartmentRepository.findById(incomeRequest.getApartment()).orElseThrow(() -> new AppException(ErrorCode.APARTMENT_NOT_EXISTED));
        var service = serviceRepository.findById(incomeRequest.getService()).orElseThrow(() -> new AppException(ErrorCode.SERVICE_NOT_EXISTED));
        var paymentMethod = paymentMethodRepository.findById(incomeRequest.getPaymentMethod()).orElseThrow(() -> new AppException(ErrorCode.PAYMENT_METHOD_NOT_EXISTED));
        var typeIncome = typeIncomeRepository.findById(incomeRequest.getTypeIncome()).orElseThrow(() -> new AppException(ErrorCode.TYPE_INCOME_NOT_EXISTED));
        income.setUser(user);
        income.setApartment(apartment);
        income.setService(service);
        income.setPaymentMethod(paymentMethod);
        income.setTypeIncome(typeIncome);
        return incomeMapper.toIncomeResponse(incomeRepository.save(income));
    }

    @Override
    public void deleteIncome(String id) {
        var income = incomeRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.INCOME_NOT_EXISTED));
        income.setDeleteStatus(0);
        income.setDayDelete(LocalDate.now());
        incomeRepository.save(income);
    }

    public void exportToExcel(HttpServletResponse response) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Income");
        var incomes = incomeRepository.findAll();
        // Tạo header row
        Row headerRow = sheet.createRow(0);
        String[] headers = {"ID", "Status", "Total", "Payment Deadline", "Status",
                "User Id", "User name", "Phone", "Apartment Id", "Apartment address",
                "Service name", "Payment method", "Type income"};

        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
        }

        // Điền dữ liệu
        int rowNum = 1;
        for (Income staff : incomes) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(staff.getId());
            row.createCell(1).setCellValue(staff.getStatus());
            row.createCell(2).setCellValue(staff.getTotal());
            row.createCell(3).setCellValue(staff.getPaymentDeadline().toString());
            row.createCell(4).setCellValue(staff.getStatus());
            row.createCell(5).setCellValue(staff.getUser().getId());
            row.createCell(6).setCellValue(staff.getUser().getName());
            row.createCell(7).setCellValue(staff.getUser().getPhone());
            row.createCell(8).setCellValue(staff.getApartment().getId());
            row.createCell(9).setCellValue(staff.getApartment().getAddress());
            row.createCell(10).setCellValue(staff.getService().getName());
            row.createCell(11).setCellValue(staff.getPaymentMethod().getNameMethod());
            row.createCell(12).setCellValue(staff.getTypeIncome().getNameType());
        }

        // Thiết lập header để tải file Excel
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=Income_Report.xlsx");

        // Ghi workbook vào output stream của response
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();

        outputStream.close();
    }
}
