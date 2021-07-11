package com.casestudy.furama.service.impl;

import com.casestudy.furama.model.Position;
import com.casestudy.furama.repository.PositionRepository;
import com.casestudy.furama.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {
    @Autowired
    private PositionRepository positionRepository;

    @Override
    public List<Position> findAll() {
        return positionRepository.findAll();
    }

    @Override
    public Position findPositionById(int positionId) {
        return positionRepository.findById(positionId).orElse(null);
    }
}
