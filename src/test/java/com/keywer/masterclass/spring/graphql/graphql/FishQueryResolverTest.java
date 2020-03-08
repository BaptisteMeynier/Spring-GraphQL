package com.keywer.masterclass.spring.graphql.graphql;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.keywer.masterclass.spring.graphql.ApplicationBootConfiguration;
import com.keywer.masterclass.spring.graphql.graphql.client.GraphqlTemplate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@ExtendWith(SpringExtension.class)
class FishQueryResolverTest {

    private final String graphqlUri = "http://localhost:8080/graphql";

    private final String queryFish = "query { mostExpensiveFish { id name family { id waterType } } }";

    private Response prepareResponse(String graphqlPayload) {
        return ClientBuilder.newBuilder().build().target(graphqlUri).request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(graphqlPayload,MediaType.APPLICATION_JSON));
    }

    @Test
    void it_should_call_most_expensive_fish_service() throws JsonProcessingException {
        String payload = GraphqlTemplate.convertToGraphqlString(queryFish, null);
        Response response = prepareResponse(payload);

        assertThat(response.getStatus(), is(200));

        String jsonData = response.readEntity(String.class);
        assertThat(jsonData, containsString("Requin"));
    }
}