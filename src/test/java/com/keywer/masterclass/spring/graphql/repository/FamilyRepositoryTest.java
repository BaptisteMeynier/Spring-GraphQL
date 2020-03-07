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

import java.util.Arrays;
import java.util.Collections;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = ApplicationBootConfiguration.class)
class FamilyRepositoryTest {

    @Autowired
    FamilyRepository familyRepository;

    @Test
    void it_should_return_fish_by_family() {
        //Given
        String familyName = "Coryphaena";
        Fish fish1 = Fish.builder().name("Spondyliosoma emarginatum").price(0.3f).temperature(18).build();
        Fish fish2 = Fish.builder().name("Pagrus major").price(0.4f).temperature(17).build();
        Family family = Family.builder().name(familyName).waterType(WaterType.SEA).fishs(Arrays.asList(fish1,fish2)).build();
        fish1.setFamily(family);
        fish2.setFamily(family);
        familyRepository.save(family);

        Fish otherFish = Fish.builder().name("other fish").price(0.6f).temperature(20).build();
        Family otherFamily = Family.builder().name("other family").waterType(WaterType.SEA).fishs(Collections.singletonList(otherFish)).build();
        otherFish.setFamily(otherFamily);
        familyRepository.save(otherFamily);

        //Then
        Family familyFind = familyRepository.findByName(familyName);

        //When
        assertThat(familyFind.getFishs().size(), is(2));
    }

}