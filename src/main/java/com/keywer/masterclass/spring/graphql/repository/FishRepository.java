package com.keywer.masterclass.spring.graphql.repository;

import com.keywer.masterclass.spring.graphql.model.Fish;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface FishRepository extends PagingAndSortingRepository<Fish, Long> {
    @Query("from Fish f where f.price = (select max(f2.price) from Fish f2)")
    Fish getMostExpensiveFish();
    Fish findByName(String name);
    Slice<Fish> findById(Long id, Pageable pageable);
    @Query(value ="SELECT * FROM Fish ORDER BY id ASC LIMIT :offset,1", nativeQuery = true)
    Fish findByOffset(@Param("offset")int offset);

}
