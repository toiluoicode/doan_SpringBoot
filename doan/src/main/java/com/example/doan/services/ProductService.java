package com.example.doan.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.doan.entity.Product;
import com.example.doan.repository.IProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private IProductRepository productRepository;

    public List<Product> getAllProducts()
    {
        return productRepository.findAll();
    }
    public Product getProductById(Long id){
        Optional<Product> optional = productRepository.findById(id);
        return  optional.orElse(null);
    }
    public void addProduct(Product product)
    {
        productRepository.save(product);
    }
    public void updateProduct(Product product){
        productRepository.save(product);
    }
    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }
}
