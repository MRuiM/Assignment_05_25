package com.example.day17.service;

import com.example.day17.domain.Product;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {
    Product getProductById(String id);

    List<Product> getAllProducts();
}
