package com.keywer.masterclass.spring.graphql.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.keywer.masterclass.spring.graphql.graphql.exception.NoFishException;
import com.keywer.masterclass.spring.graphql.graphql.input.CursorInput;
import com.keywer.masterclass.spring.graphql.graphql.input.PaginationInput;
import com.keywer.masterclass.spring.graphql.model.Fish;
import com.keywer.masterclass.spring.graphql.service.FishDatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class FishQueryResolver implements GraphQLQueryResolver {

    private FishDatabaseService fishDatabaseService;

    @Autowired
    public FishQueryResolver(FishDatabaseService fishDatabaseService) {
        this.fishDatabaseService = fishDatabaseService;
    }

    public Fish getMostExpensiveFish() {
        return fishDatabaseService.getMostExpensiveFish();
    }

    public Fish getFishByName(String name) {
        Fish fishByName = fishDatabaseService.findFishByName(name);
        if(Objects.isNull(fishByName)){
            throw new NoFishException(String.format("Fish %s inexisting",name));
        }
        return fishByName;
    }

    public List<Fish> fishWithPagination(PaginationInput paginationInput) {
        Fish first = fishDatabaseService.findByOffset(paginationInput.getOffset());

        List<Fish> fish = fishDatabaseService.findFish(first.getId(), paginationInput.getFirst());

        return fish;
    }

    public List<Fish> fishWithCursor(CursorInput cursorInput) {
        return fishDatabaseService.findFish(cursorInput.getAfter(), cursorInput.getFirst());
    }

}
