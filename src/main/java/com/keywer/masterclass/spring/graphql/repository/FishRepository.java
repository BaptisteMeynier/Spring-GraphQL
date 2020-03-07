package com.keywer.masterclass.spring.graphql.repository;

import com.keywer.masterclass.spring.graphql.model.Fish;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FishRepository extends PagingAndSortingRepository<Fish, Long> {
    @Query("from Fish f where f.price = (select max(f2.price) from Fish f2)")
    Fish getMostExpensiveFish();

    Fish findByName(String name);
}
