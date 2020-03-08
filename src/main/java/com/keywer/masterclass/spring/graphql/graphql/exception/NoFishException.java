package com.keywer.masterclass.spring.graphql.graphql.exception;

import graphql.GraphQLException;

public class NoFishException extends GraphQLException {
    public NoFishException(String message) {
        super(message);
    }
}
