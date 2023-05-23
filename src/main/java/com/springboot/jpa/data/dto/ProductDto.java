package com.springboot.jpa.data.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class ProductDto {
    private String name;
    private int price;
    private  int stock;
}
