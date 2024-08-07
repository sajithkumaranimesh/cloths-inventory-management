package com.pabaro.ims.dto;


import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Product {
    private Long id;
    private String name;
    private BigDecimal size;
    private BigDecimal price;
    private Integer stockQuantity;
    private String description;
    private Boolean isAvailable;
    private String createdAt;
    private String modifiedAt;

    private Long category_id;
    private Long supplier_id;
}
