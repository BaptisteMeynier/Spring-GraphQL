package com.keywer.masterclass.spring.graphql.graphql.exception;

import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;
import graphql.execution.ExecutionPath;
import graphql.servlet.GraphQLErrorHandler;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FishExceptionHandler implements GraphQLErrorHandler {
    @Override
    public boolean errorsPresent(List<GraphQLError> errors) {
        return true;
    }

    @Override
    public List<GraphQLError> processErrors(List<GraphQLError> list) {
        return  list.stream()
                .filter(e-> e instanceof ExceptionWhileDataFetching)
                .map(e-> new SanitizedError(ExecutionPath.fromList(e.getPath()),((ExceptionWhileDataFetching)e).getException(), e.getLocations().get(0)))
                .collect(Collectors.toList());
        //return list;
    }
}
