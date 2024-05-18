package com.productWishlist.Model.dto;

// Dto class representing employee data transfered between client and server

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseItemDto {
    private Long id;
    private String name;
    private Double price;

    public ResponseItemDto(Long id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
