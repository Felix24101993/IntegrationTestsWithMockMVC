package com.integrationtests.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Entity
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "technical_details")
public class TechnicalDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "technical_details_id")
    private long id;

    @Column(name = "technical_details_title", nullable = false, length = 250)
    private String title;

    @Column(name = "technical_details_description", nullable = false, length = 250)
    private String description;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonIgnore
    private Product product;

}

