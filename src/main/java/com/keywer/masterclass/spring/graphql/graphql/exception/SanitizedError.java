package com.keywer.masterclass.spring.graphql.graphql.exception;

import com.fasterxml.jackson.annotation.JsonIgnore;
import graphql.ExceptionWhileDataFetching;
import graphql.execution.ExecutionPath;
import graphql.language.SourceLocation;

import java.util.List;

public class SanitizedError extends ExceptionWhileDataFetching {

    public SanitizedError(ExecutionPath path, Throwable exception, SourceLocation sourceLocation) {
        super(path, exception, sourceLocation);
    }

    @Override
    @JsonIgnore
    public Throwable getException() {
        return super.getException();
    }

    @Override
    @JsonIgnore
    public List<SourceLocation> getLocations() {
        return super.getLocations();
    }

    @Override
    @JsonIgnore
    public List<Object> getPath() {
        return super.getPath();
    }
}
