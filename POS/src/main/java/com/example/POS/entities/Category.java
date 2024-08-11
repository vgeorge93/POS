package com.example.POS.entities;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.Set;

@Getter
@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "category_id", length = 11)
    private int categoryId;

    @Column(name = "category_name", length = 45)
    private String categoryName;

    @Column(name = "active", columnDefinition = "TINYINT default 1")
    private boolean active;

    @OneToMany(mappedBy = "category") //name used in product.java class when defining the relation between product and category
    private Set<Product> products;

    public Category(int categoryId, String categoryName, boolean active) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.active = active;
    }

    public Category(String categoryName, boolean active) {
        this.categoryName = categoryName;
        this.active = active;
    }

    public Category() {
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", active=" + active +
                '}';
    }
}
