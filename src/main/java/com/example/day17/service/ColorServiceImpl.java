package com.example.day17.service;

import com.example.day17.domain.Color;
import com.example.day17.repository.ColorRepository;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ColorServiceImpl implements ColorService{

    private final Log logger = LogFactory.getLog(ColorServiceImpl.class);
    private final ColorRepository colorRepository;

    @Autowired
    public ColorServiceImpl(ColorRepository colorRepository) {
        this.colorRepository = colorRepository;
    }

    @Override
    public Color getColorByID(String id) {
        Color color = colorRepository.getColorById(id);
        if(color == null) {
            logger.error(1);
            throw new RuntimeException(id + ": color is null");
        }
        return color;
    }

    @Override
    public List<Color> getAllColors() {
        List<Color> colors = new ArrayList<>();
        colorRepository.findAll().forEach(colors::add);
        if(colors.isEmpty()) {
            logger.error(1);
            throw new RuntimeException( "Colors are null");
        }
        return colors;
    }

    @Override
    public Color save(Color color) {
        colorRepository.save(color);
        return color;
    }
}
