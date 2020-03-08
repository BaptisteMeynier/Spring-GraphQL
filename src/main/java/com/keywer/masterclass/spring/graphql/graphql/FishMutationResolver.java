package com.keywer.masterclass.spring.graphql.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.keywer.masterclass.spring.graphql.model.Family;
import com.keywer.masterclass.spring.graphql.model.WaterType;
import com.keywer.masterclass.spring.graphql.repository.FamilyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class FishMutationResolver implements GraphQLMutationResolver {

    private final FamilyRepository familyRepository;

    @Autowired
    public FishMutationResolver(FamilyRepository familyRepository) {
        this.familyRepository = familyRepository;
    }

    @Transactional
    public Family createFamily(String name, WaterType waterType) {
        return this.familyRepository.save(Family.builder().name(name).waterType(waterType).build());
    }
}
