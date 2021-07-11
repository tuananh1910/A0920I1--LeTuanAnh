package com.example.demo.service;


import com.example.demo.model.Position;

import java.util.List;

public interface PositionService {
    List<Position> findAll();
    Position findPositionById(int positionId);
}
