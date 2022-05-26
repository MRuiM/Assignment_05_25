package com.example.day17.service;

import com.example.day17.domain.Color;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ColorService {
    Color getColorByID(String id);

    List<Color> getAllColors();
}
