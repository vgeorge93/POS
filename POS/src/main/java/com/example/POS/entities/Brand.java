package com.example.POS.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "brand")
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "brand_id", length = 11)
    private int brandId;

    @Column(name = "brand_name", length = 45)
    private String brandName;

    @Column(name = "active", columnDefinition = "TINYINT default 1")
    private boolean active;

    @OneToMany(mappedBy = "brand")
    private Set<Product> products;

    public Brand(String brandName, boolean active) {
        this.brandName = brandName;
        this.active = active;
    }
}
