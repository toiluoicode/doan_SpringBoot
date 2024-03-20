package com.example.doan.repository;

import com.example.doan.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p JOIN p.category ca WHERE p.name LIKE %:keyword% OR CONCAT(p.price, '') LIKE %:keyword% OR ca.name lIKE %:keyword%")
    Page<Product> searchProduct(@Param("keyword") String keyword, Pageable pageable);

    Page<Product> findAll(Pageable pageable);


    @Query("SELECT p FROM Product p JOIN p.category ca WHERE p.name LIKE %:keyword% OR CONCAT(p.price, '') LIKE %:keyword% OR ca.name lIKE %:keyword%")
    List<Product> searchProductHome(@Param("keyword") String keyword);

    @Query("select p from Product p join p.category ca where p.category.name=:key ")
    List<Product> filterProducts(String key);
}
