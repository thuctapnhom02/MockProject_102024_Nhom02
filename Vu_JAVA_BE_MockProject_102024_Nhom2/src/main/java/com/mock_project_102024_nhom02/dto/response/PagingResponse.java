package com.mock_project_102024_nhom02.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Map;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PagingResponse<T> {

    int code;
    int currentPage;
    int pageSize;
    Map<String, String> search;
    long totalItem;
    int totalPage;
    T result;
}
