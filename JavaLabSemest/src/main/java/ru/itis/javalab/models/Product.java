package ru.itis.javalab.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    private Long product_id;
    private String name;
    private String description;
    private int price;
    private int rating;
    private String photo;
}
