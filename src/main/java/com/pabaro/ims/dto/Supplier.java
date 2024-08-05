package com.pabaro.ims.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Supplier {
    private Long id;
    private String name;
    private String email;
    private String company;
    private String createdAt;
    private String modifiedAt;
}
