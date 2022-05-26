package com.example.day17.service;

import com.example.day17.domain.Product;
import com.example.day17.repository.ProductRepository;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final Log logger = LogFactory.getLog(ProductServiceImpl.class);
    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public Product getProductById(String id) {
        Product product = productRepository.getProductById(id);
        if(product==null) {
            logger.error(1);
            throw new RuntimeException(id + ": product is null");
        }
        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(products::add);
        if(products.isEmpty()) {
            logger.error(1);
            throw  new RuntimeException("Products are null");
        }
        return products;
    }
}
