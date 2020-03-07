package com.keywer.masterclass.spring.graphql.rest;

import com.keywer.masterclass.spring.graphql.model.Fish;
import com.keywer.masterclass.spring.graphql.repository.FishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("fish")
public class FishController {

    private FishRepository fishRepository;

    @Autowired
    public FishController(FishRepository fishRepository) {
        this.fishRepository = fishRepository;
    }

    @GetMapping("/{name}")
    public Fish get(@PathVariable(value = "name") String name) {
        return fishRepository.findByName(name);
    }

}
