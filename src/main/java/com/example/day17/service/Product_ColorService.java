package com.example.day17.service;

import com.example.day17.domain.Product;
import com.example.day17.domain.Product_Color;
import org.springframework.stereotype.Service;

import java.util.List;


public interface Product_ColorService {
    Product_Color getProduct_ColorByID(String id);
    List<Product_Color> getAllProduct_Color();

}
