package com.integrationtests.demo.service;


import com.integrationtests.demo.exception.ProductNotFound;
import com.integrationtests.demo.model.Product;
import com.integrationtests.demo.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
@Component
public class ProductService {

    private final ProductRepository productRepository;


    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public Product findById(long id){
        return productRepository.findById(id).orElseThrow(()-> new ProductNotFound("Product: " + id + " not found"));
    }
}
