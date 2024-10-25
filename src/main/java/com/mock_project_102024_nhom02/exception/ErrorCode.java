package com.mock_project_102024_nhom02.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import lombok.Getter;

@Getter
public enum ErrorCode {

    INVALID_PASSWORD(1004, "Password must be at least {min} characters", HttpStatus.BAD_REQUEST),
    USER_NOT_EXISTED(1005, "User is not existed", HttpStatus.NOT_FOUND),
    UNAUTHENTICATED(1006, "Unauthenticated", HttpStatus.UNAUTHORIZED),
    UNAUTHORIZED(1007, "You do not have permission", HttpStatus.FORBIDDEN),

    STAFF_NOT_EXISTED(1005, "Staff is not existed", HttpStatus.NOT_FOUND),
    STAFF_EXISTED(1105, "Staff existed", HttpStatus.BAD_REQUEST),
    ROLE_NOT_EXISTED(1006, "Role is not existed", HttpStatus.NOT_FOUND),
    ROLE_EXISTED(1106, "Role existed", HttpStatus.BAD_REQUEST),
    INCOME_NOT_EXISTED(1007, "Income is not existed", HttpStatus.NOT_FOUND),
    INCOME_EXISTED(1107, "Income existed", HttpStatus.BAD_REQUEST),
    SERVICE_NOT_EXISTED(1008, "Service is not existed", HttpStatus.NOT_FOUND),
    SERVICE_EXISTED(1108, "Service existed", HttpStatus.BAD_REQUEST),
    APARTMENT_NOT_EXISTED(1009, "Apartment is not existed", HttpStatus.NOT_FOUND),
    APARTMENT_EXISTED(1109, "Apartment existed", HttpStatus.BAD_REQUEST),
    PAYMENT_METHOD_NOT_EXISTED(1010, "Payment method is not existed", HttpStatus.NOT_FOUND),
    PAYMENT_METHOD_EXISTED(1110, "Payment method existed", HttpStatus.BAD_REQUEST),
    TYPE_INCOME_NOT_EXISTED(1011, "Type income is not existed", HttpStatus.NOT_FOUND),
    TYPE_INCOME_EXISTED(1111, "Type income existed", HttpStatus.BAD_REQUEST),
    OUTCOME_NOT_EXISTED(1012, "Outcome is not existed", HttpStatus.NOT_FOUND),
    OUTCOME_EXISTED(1112, "Outcome existed", HttpStatus.BAD_REQUEST),
    REPAIR_HISTORY_NOT_EXISTED(1013, "Repair history is not existed", HttpStatus.NOT_FOUND),
    REPAIR_HISTORY_EXISTED(1113, "Repair history existed", HttpStatus.BAD_REQUEST),
    SUPPLIER_NOT_EXISTED(1014, "Supplier is not existed", HttpStatus.NOT_FOUND),
    SUPPLIER_INCOME_EXISTED(1114, "Supplier existed", HttpStatus.BAD_REQUEST),
    TYPE_OUTCOME_NOT_EXISTED(1015, "Type outcome is not existed", HttpStatus.NOT_FOUND),
    TYPE_OUTCOME_EXISTED(1115, "Type outcome existed", HttpStatus.BAD_REQUEST),
    COMPLAIN_NOT_EXISTED(1016, "Complain is not existed", HttpStatus.NOT_FOUND),
    COMPLAIN_EXISTED(1116, "Complain outcome existed", HttpStatus.BAD_REQUEST),

    DATE_INVALID(1910, "Date invalid", HttpStatus.BAD_REQUEST),


    ;

    ErrorCode(int code, String message, HttpStatusCode status) {
        this.code = code;
        this.message = message;
        this.status = status;
    }

    private final int code;
    private final String message;
    private final HttpStatusCode status;
}
