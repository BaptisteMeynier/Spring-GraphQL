package com.keywer.masterclass.spring.graphql.graphql;

import com.coxautodev.graphql.tools.GraphQLSubscriptionResolver;
import com.keywer.masterclass.spring.graphql.model.Family;
import com.keywer.masterclass.spring.graphql.service.FamilyPublisher;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;

public class FishSubscriptionResolver implements GraphQLSubscriptionResolver {

    private final FamilyPublisher familyPublisher;

    @Autowired
    public FishSubscriptionResolver(FamilyPublisher familyPublisher) {
        this.familyPublisher = familyPublisher;
    }

    public Publisher<Family> lastFamily(){
        return familyPublisher.getPublisher();
    }
}
