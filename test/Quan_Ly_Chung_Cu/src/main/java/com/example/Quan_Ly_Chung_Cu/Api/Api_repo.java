package com.example.Quan_Ly_Chung_Cu.Api;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Api_repo <T>{
    int ping_;
    String name_seviece_;
    String deription_;
    List<T> datas;
    T data;
}
