package com.example.demo.model.respone.bao;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpdateDeleteCreateRespone {
    String desription_;
    boolean check_;
}
