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
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = ApplicationBootConfiguration.class)
class FamilyRepositoryTest {

    @Autowired
    FamilyRepository familyRepository;

    @Autowired
    FishRepository fishRepository;

    @Test
    void it_should_return_fish_by_family() {
        //Given
        String familyName = "Coryphaena";

        Family family = Family.builder().name(familyName).waterType(WaterType.SEA).build();

        familyRepository.save(family);

        Fish fish1 = Fish.builder().name("Spondyliosoma emarginatum").price(0.3f).temperature(18).family(family).build();
        Fish fish2 = Fish.builder().name("Pagrus major").price(0.4f).temperature(17).family(family).build();

        fishRepository.save(fish1);
        fishRepository.save(fish2);

        Family otherFamily = Family.builder().name("other family").waterType(WaterType.SEA).build();
        familyRepository.save(otherFamily);
        Fish otherFish = Fish.builder().name("other fish").price(0.6f).temperature(20).family(otherFamily).build();
        fishRepository.save(otherFish);

        //Then
        Family familyFind = familyRepository.findByName(familyName);

        //When
        assertThat(familyFind.getFishs().size(), is(2));
    }

}