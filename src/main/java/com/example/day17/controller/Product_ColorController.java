package com.example.day17.controller;

import com.example.day17.domain.Product;
import com.example.day17.domain.Product_Color;
import com.example.day17.service.ColorService;
import com.example.day17.service.ProductService;
import com.example.day17.service.Product_ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Product_ColorController {

    private final Product_ColorService product_colorService;
    private final ProductService productService;
    private final ColorService colorService;

    @Autowired
    public Product_ColorController(Product_ColorService product_colorService, ProductService productService, ColorService colorService) {
        this.product_colorService = product_colorService;
        this.productService = productService;
        this.colorService = colorService;
    }

    @GetMapping("/product_color")
    public ResponseEntity<List<Product_Color>> getAllProduct_Colors() {
        return new ResponseEntity<>(product_colorService.getAllProduct_Color(), HttpStatus.OK);
    }

    @GetMapping("/product_color/{id}")
    public ResponseEntity<Product_Color> getProduct_ColorById(@PathVariable String id) {
        return new ResponseEntity<>(product_colorService.getProduct_ColorByID(id), HttpStatus.OK);
    }

    @GetMapping("/product_color/color={id}")
    public ResponseEntity<List<Product_Color>> getProduct_ColorsByColorId(@PathVariable String id) {
        return new ResponseEntity<>(colorService.getColorByID(id).getProduct_colors(), HttpStatus.OK);
    }

    @GetMapping("/product_color/product={id}")
    public ResponseEntity<List<Product_Color>> getProduct_ColorsByProductId(@PathVariable String id) {
        return new ResponseEntity<>(productService.getProductById(id).getProduct_colors(), HttpStatus.OK);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity handleRuntimeException() {
        return new ResponseEntity("This is 404 response", HttpStatus.NOT_FOUND);
    }
}
