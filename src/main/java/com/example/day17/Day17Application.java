package com.example.day17;

import com.example.day17.domain.Color;
import com.example.day17.domain.Product_Color;
import com.example.day17.repository.*;
import org.hibernate.Hibernate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootApplication
public class Day17Application {
    public static void main(String[] args) {
        SpringApplication.run(Day17Application.class, args);
    }

//    @Bean
//    @Transactional
//    public CommandLineRunner run(ColorRepository repository) {
//        return (args -> {
//            Color color = repository.getColorById("1");
////            Hibernate.initialize(color.getProduct_color());
//            System.out.println(color.getProduct_color());
//        });
//    }
}
