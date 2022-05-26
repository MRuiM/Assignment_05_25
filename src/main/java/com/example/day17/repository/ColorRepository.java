package com.example.day17.repository;

import com.example.day17.domain.Color;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ColorRepository extends CrudRepository<Color, String> {
    Color getColorById(String id);

}