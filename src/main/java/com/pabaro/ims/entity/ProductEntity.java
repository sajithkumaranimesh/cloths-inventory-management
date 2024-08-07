package com.pabaro.ims.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

@Entity
@Table(name = "product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private BigDecimal size;
    private BigDecimal price;
    private Integer stockQuantity;
    private String description;
    private Boolean isAvailable;
    private String createdAt;
    private String modifiedAt;

    @Column(name = "category_id")
    private Long category_id;

    @Column(name = "supplier_id")
    private Long supplier_id;
}
