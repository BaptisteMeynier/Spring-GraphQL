package com.keywer.masterclass.spring.graphql.rest;

import com.keywer.masterclass.spring.graphql.model.Family;
import com.keywer.masterclass.spring.graphql.repository.FamilyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("family")
public class FamilyController {

    private FamilyRepository familyRepository;

    @Autowired
    public FamilyController(FamilyRepository familyRepository) {
        this.familyRepository = familyRepository;
    }

    @GetMapping("{name}")
    public Family get(@PathVariable(value = "name") String name) {
        return familyRepository.findByName(name);
    }
}
