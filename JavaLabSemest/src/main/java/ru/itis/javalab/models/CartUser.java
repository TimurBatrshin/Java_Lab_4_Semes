package ru.itis.javalab.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartUser {
    private Integer cart_id;
    private String name;
    private String description;
    private int price;
    private String photo;
}