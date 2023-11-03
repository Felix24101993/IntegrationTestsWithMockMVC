package com.integrationtests.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false)
    private Long id;

    @Column(name = "product_name", nullable = false, unique = true)
    private String name;

    @Column(name = "product_price", nullable = false, unique = true)
    private int price;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<TechnicalDetails> technicalDetails = new HashSet<>();

    public Product(String name, Integer price){
        this.name = name;
        this.price = price;
    }



}
