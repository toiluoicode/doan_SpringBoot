package com.example.doan.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotEmpty(message = " ten ko the trong")
    private String name;


    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
    private List<Product> products;

}
