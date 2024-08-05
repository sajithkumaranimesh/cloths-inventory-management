package com.pabaro.ims.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter


public class SupplierEntity {
    private Long id;
    private String name;
    private String company;
    private String createdAt;
    private String modifiedAt;
}
