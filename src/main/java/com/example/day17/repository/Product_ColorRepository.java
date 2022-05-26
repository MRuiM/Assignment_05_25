package com.example.day17.repository;

import com.example.day17.domain.Product_Color;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Product_ColorRepository extends CrudRepository<Product_Color, String> {

    Product_Color getProduct_ColorById(String id);
}