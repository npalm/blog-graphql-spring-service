package ofouro.code.graphql.demo.graphql;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.graphql.spring.boot.test.GraphQLResponse;
import com.graphql.spring.boot.test.GraphQLTestTemplate;
import lombok.extern.slf4j.Slf4j;
import ofouro.code.graphql.demo.resolvers.InputNote;
import ofouro.code.graphql.demo.resolvers.InputPerson;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

@Slf4j
abstract class GraphQLBaseTest {

    @Autowired
    private GraphQLTestTemplate graphQLTestTemplate;

    GraphQLResponse createNote(InputNote inputNote, InputPerson inputPerson) throws IOException {
        final ObjectMapper mapper = new ObjectMapper();

        final ObjectNode rootNOde = mapper.createObjectNode();
        rootNOde.set("inputNote", mapper.convertValue(inputNote, JsonNode.class));
        rootNOde.set("inputAuthor", mapper.convertValue(inputPerson, JsonNode.class));

        return create(rootNOde, "queries/create-note.graphql");
    }

    GraphQLResponse create(ObjectNode input, String grapQLQuery) throws IOException {
        GraphQLResponse createResonse = graphQLTestTemplate.perform(grapQLQuery, input);
        log.info(String.format("Response: %s", createResonse.getRawResponse().toString()));

        return createResonse;
    }


}
