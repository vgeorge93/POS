package com.example.POS.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id", length = 11)
    private int productId;

    @Column(name = "product_name", length = 45)
    private String productName;

    @ManyToOne
    @JoinColumn(name = "categoryId", nullable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "brandId", nullable = false)
    private Brand brand;

    @Column(name = "price", length = 11)
    private double price;

    @Column(name = "active", columnDefinition = "TINYINT default 1")
    private boolean active;

    public Product(String productName, boolean active, double price, Category category, Brand brand) {
        this.productName = productName;
        this.active = active;
        this.price = price;
        this.category = category;
        this.brand = brand;
    }
}
