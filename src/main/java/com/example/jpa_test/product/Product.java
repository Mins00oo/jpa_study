package com.example.jpa_test.product;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name; // 상품명
    private double price; // 가격

    @Builder
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }


}
