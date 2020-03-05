package com.keywer.masterclass.spring.graphql.repository;

import com.keywer.masterclass.spring.graphql.model.Family;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface FamilyRepository extends PagingAndSortingRepository<Family, Long> {
    Family findByName(String name);
}
