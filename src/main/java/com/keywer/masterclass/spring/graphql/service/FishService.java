package com.keywer.masterclass.spring.graphql.service;

import com.keywer.masterclass.spring.graphql.model.Fish;
import com.keywer.masterclass.spring.graphql.repository.FishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FishService {

    private final FishRepository fishRepository;

    @Autowired
    public FishService(FishRepository fishRepository) {
        this.fishRepository = fishRepository;
    }

    public Fish getMostExpensiveFish() {
        return fishRepository.getMostExpensiveFish();
    }
}
