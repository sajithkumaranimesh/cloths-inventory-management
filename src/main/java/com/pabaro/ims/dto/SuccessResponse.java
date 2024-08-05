package com.pabaro.ims.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

@Builder
public class SuccessResponse {
    String status;
    Object data;
}
