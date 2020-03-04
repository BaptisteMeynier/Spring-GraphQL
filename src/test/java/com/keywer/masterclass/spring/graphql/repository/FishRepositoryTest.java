package com.keywer.masterclass.spring.graphql.repository;

import com.keywer.masterclass.spring.graphql.application.ApplicationBootConfiguration;
import com.keywer.masterclass.spring.graphql.model.Family;
import com.keywer.masterclass.spring.graphql.model.Fish;
import com.keywer.masterclass.spring.graphql.model.WaterType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = ApplicationBootConfiguration.class)
class FishRepositoryTest {

    @Autowired
    FishRepository fishRepository;

    @Test
    void it_should_return_most_expensive_fish() {
        //Given
        Family cyprinidaeFamily = Family.builder().name("Cyprinidae").waterType(WaterType.FRESH).build();
        Family thunnusFamily = Family.builder().name("Thunnus").waterType(WaterType.SEA).build();
        Family characidaeFamily = Family.builder().name("Characidae").waterType(WaterType.FRESH).build();
        Fish cheaperFish = Fish.builder().name("Carassius auratus").price(0.2f).temperature(18).family(cyprinidaeFamily).build();
        Fish expensiveFish = Fish.builder().name("Thunnus thynnus").price(120f).temperature(12).family(thunnusFamily).build();
        Fish accessibleFish = Fish.builder().name("Piranha").price(8f).temperature(24).family(characidaeFamily).build();
        fishRepository.save(cheaperFish);
        fishRepository.save(expensiveFish);
        fishRepository.save(accessibleFish);
        //Then
        Fish mostExpensiveFish = fishRepository.getMostExpensiveFish();
        //When
        assertThat(mostExpensiveFish, is(120f));
    }

}