package ofouro.code.graphql.demo.graphql;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.graphql.spring.boot.test.GraphQLResponse;
import com.graphql.spring.boot.test.GraphQLTestTemplate;
import lombok.extern.slf4j.Slf4j;
import ofouro.code.graphql.demo.resolvers.InputNote;
import ofouro.code.graphql.demo.resolvers.InputPerson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static graphql.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GraphQLNoteTest extends GraphQLBaseTest {

    @Autowired
    private GraphQLTestTemplate graphQLTestTemplate;


    @Test
    public void findNotes() throws IOException {

        GraphQLResponse findResponse = graphQLTestTemplate.perform("queries/find-notes.graphql", null);

        log.info(String.format("Response: %s", findResponse.getRawResponse().toString()));

        assertNotNull(findResponse);
        assertTrue(findResponse.isOk());
    }


    @Test
    public void createAndFInd() throws IOException {
        final ObjectMapper mapper = new ObjectMapper();

        InputNote inputNote = new InputNote("A note");
        InputPerson inputPerson = new InputPerson("Niek", "noreply@me.com");
        GraphQLResponse noteCreateResponse = createNote(inputNote, inputPerson);
        String id = noteCreateResponse.get("$.data.addNote.id");

        assertNotNull(noteCreateResponse);
        assertTrue(noteCreateResponse.isOk());

        // Find the created person
        final ObjectNode rootNode = mapper.createObjectNode();
        rootNode.put("id", id);

        GraphQLResponse findResponse = graphQLTestTemplate.perform("queries/find-note-by-id.graphql", rootNode);
        log.info(String.format("Response: %s", findResponse.getRawResponse().toString()));

        assertNotNull(findResponse);
        assertTrue(findResponse.isOk());
        assertEquals(inputNote.getNote(), findResponse.get("$.data.note.note"));


        InputNote inputNote2 = new InputNote("A second note");
        GraphQLResponse noteCreateResponse2 = createNote(inputNote2, inputPerson);

        assertNotNull(noteCreateResponse);
        assertTrue(noteCreateResponse.isOk());

    }


}
