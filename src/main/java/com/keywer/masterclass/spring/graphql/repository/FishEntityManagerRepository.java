package com.keywer.masterclass.spring.graphql.repository;

import com.keywer.masterclass.spring.graphql.model.Fish;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class FishEntityManagerRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Fish> findFish(long fishId, int limit){
        return entityManager.createQuery("SELECT f FROM Fish f WHERE f.id >= :fishId ORDER BY f.id asc", Fish.class)
                .setParameter("fishId",fishId)
                .setMaxResults(limit)
                .getResultList();
    }
}
