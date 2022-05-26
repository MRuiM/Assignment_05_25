package com.example.day17.controller;

import com.example.day17.domain.Color;
import com.example.day17.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ColorController {

    private final ColorService colorService;

    @Autowired
    public ColorController(ColorService colorService) {
        this.colorService = colorService;
    }

    @GetMapping("/color")
    public ResponseEntity<List<Color>> getAllColors() {
        return new ResponseEntity<>(colorService.getAllColors(), HttpStatus.OK);
    }

    @GetMapping("/color/{id}")
    public ResponseEntity<Color> getColorById(@PathVariable String id) {
        return new ResponseEntity<>(colorService.getColorByID(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> newPost(@Valid @RequestBody Color product) {
        Color newColor = new Color();
        newColor.setName(product.getName());
        Color saveResponse = colorService.save(newColor);

        if (saveResponse != null) {
            return new ResponseEntity<>("PRODUCT ENTITY SUCCESSFULLY CREATED AND SAVED:)", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("PRODUCT ENTITY ALREADY PRESENTS:(", HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/exception")
    public ResponseEntity<Color> testException() throws Exception{
        throw new Exception("..");
    }


    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity handleRuntimeException() {
        return new ResponseEntity("This is 404 response", HttpStatus.NOT_FOUND);
    }
}
