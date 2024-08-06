package com.pabaro.ims.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Category {
    private Long id;
    private String name;
    private String description;
    private String createdAt;
    private String modifiedAt;
}
