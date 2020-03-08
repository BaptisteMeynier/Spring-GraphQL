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

    public List<Fish> findFishWithPagination(PaginationInput paginationInput) {
        List<Fish> fish = Collections.EMPTY_LIST;
        PageRequest pageRequest = PageRequest.of(1, paginationInput.getOffset(), Sort.by("id").ascending());
        Optional<Fish> first = fishDatabaseService.findFish(pageRequest).stream().findFirst();
        if(first.isPresent()) {
            fish = fishDatabaseService.findFish(first.get().getId(), paginationInput.getFirst());
        }
        return fish;
    }

    public List<Fish> findFishWithCursor(CursorInput cursorInput) {
        return fishDatabaseService.findFish(cursorInput.getAfter(), cursorInput.getFirst());
    }

}
