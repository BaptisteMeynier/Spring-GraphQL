package com.keywer.masterclass.spring.graphql.graphql.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jdk.internal.util.xml.impl.Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;

public class GraphqlTemplate {

    private GraphqlTemplate() {
        //Nothing to do
    }


    public static String convertToGraphqlString(String graphql, ObjectNode variables) throws JsonProcessingException {
        ObjectMapper oMapper = new ObjectMapper();
        ObjectNode objectNode = oMapper.createObjectNode();
        objectNode.put("query",graphql);
        objectNode.put("variable", variables);
        return oMapper.writeValueAsString(objectNode);
    }

    public static String convertIntpuStreamToString(InputStream inputStream) throws IOException{
        StringBuilder sb = new StringBuilder();
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))){
            String line;
            while(Objects.nonNull(line = bufferedReader.readLine())){
                sb.append(line).append("\n");
            }
        }
        return sb.toString();
    }

}
