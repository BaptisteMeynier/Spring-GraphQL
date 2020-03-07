package com.keywer.masterclass.spring.graphql;

import com.keywer.masterclass.spring.graphql.model.Family;
import com.keywer.masterclass.spring.graphql.model.WaterType;
import com.keywer.masterclass.spring.graphql.repository.FamilyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = ApplicationBootConfiguration.class)
class FamilyRepositoryTest {

    @Autowired
    FamilyRepository familyRepository;

    @Test
    void it_should_return_family() {
        //Given
        String familyName = "Coryphaena";
        Family family = Family.builder().name(familyName).waterType(WaterType.SEA).build();
        familyRepository.save(family);

        Family otherFamily = Family.builder().name("other family").waterType(WaterType.SEA).build();
        familyRepository.save(otherFamily);

        //Then
        Family familyFind = familyRepository.findByName(familyName);

        //When
        assertThat(familyFind.getName(), is(familyName));
    }

}