package com.keywer.masterclass.spring.graphql.service;

import com.keywer.masterclass.spring.graphql.model.Family;
import com.keywer.masterclass.spring.graphql.model.Fish;
import com.keywer.masterclass.spring.graphql.repository.FamilyRepository;
import com.keywer.masterclass.spring.graphql.repository.FishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FishDatabaseService {

    private final FishRepository fishRepository;

    private final FamilyRepository familyRepository;

    @Autowired
    public FishDatabaseService(FishRepository fishRepository, FamilyRepository familyRepository) {
        this.fishRepository = fishRepository;
        this.familyRepository = familyRepository;
    }

    public Fish getMostExpensiveFish() {
        return fishRepository.getMostExpensiveFish();
    }

    public Family findFamilyByName(String name) {
        return familyRepository.findByName(name);
    }

}
