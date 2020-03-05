package com.keywer.masterclass.spring.graphql.repository;

import com.keywer.masterclass.spring.graphql.ApplicationBootConfiguration;
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
        float expensivePrice = 60000f;

        Family cyprinidaeFamily = Family.builder().name("Cyprinidae").waterType(WaterType.FRESH).build();
        Family rhincodontidaeFamily = Family.builder().name("Rhincodontidae").waterType(WaterType.SEA).build();
        Family characidaeFamily = Family.builder().name("Characidae").waterType(WaterType.FRESH).build();

        Fish cheaperFish = Fish.builder().name("Carassius auratus").price(0.3f).temperature(18).family(cyprinidaeFamily).build();
        Fish expensiveFish = Fish.builder().name("Rhincodon typus").price(expensivePrice).temperature(12).family(rhincodontidaeFamily).build();
        Fish accessibleFish = Fish.builder().name("Piranha").price(8f).temperature(24).family(characidaeFamily).build();

        fishRepository.save(cheaperFish);
        fishRepository.save(expensiveFish);
        fishRepository.save(accessibleFish);

        //Then
        Fish mostExpensiveFish = fishRepository.getMostExpensiveFish();

        //When
        assertThat(mostExpensiveFish.getPrice(), is(expensivePrice));
    }

    @Test
    void it_should_return_fish_by_family() {
        //Given
        float expensivePrice = 60000f;

        //Then
        Fish mostExpensiveFish = fishRepository.getMostExpensiveFish();

        //When
        assertThat(mostExpensiveFish.getPrice(), is(expensivePrice));
    }

}