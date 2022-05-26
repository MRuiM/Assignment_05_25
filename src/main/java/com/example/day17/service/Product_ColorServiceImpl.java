package com.example.day17.service;

import com.example.day17.domain.Product_Color;
import com.example.day17.repository.Product_ColorRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Product_ColorServiceImpl implements Product_ColorService{

    private final Log logger = LogFactory.getLog(Product_ColorServiceImpl.class);
    private final Product_ColorRepository product_colorRepository;

    @Autowired
    public Product_ColorServiceImpl(Product_ColorRepository product_colorRepository) {
        this.product_colorRepository = product_colorRepository;
    }


    @Override
    public Product_Color getProduct_ColorByID(String id) {
        Product_Color product_color= product_colorRepository.getProduct_ColorById(id);
        if(product_color == null) {
            logger.error(1);
            throw new RuntimeException(id + ": product_Color is null");
        }
        return product_color;
    }

    @Override
    public List<Product_Color> getAllProduct_Color() {
        List<Product_Color> product_colors = new ArrayList<>();
        product_colorRepository.findAll().forEach(product_colors::add);
        if(product_colors.isEmpty()) {
            logger.error(1);
            throw new RuntimeException("Product_Colors are null");
        }
        return product_colors;
    }

}
