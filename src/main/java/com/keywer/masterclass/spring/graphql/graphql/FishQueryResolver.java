package com.keywer.masterclass.spring.graphql.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.keywer.masterclass.spring.graphql.model.Fish;
import com.keywer.masterclass.spring.graphql.service.FishDatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FishQueryResolver implements GraphQLQueryResolver {

    private FishDatabaseService fishDatabaseService;

    @Autowired
    public FishQueryResolver(FishDatabaseService fishDatabaseService) {
        this.fishDatabaseService = fishDatabaseService;
    }

    public Fish getMostExpensiveFish(){
        return fishDatabaseService.getMostExpensiveFish();
    }

}
