package ofouro.code.graphql.demo.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import ofouro.code.graphql.demo.model.Note;
import ofouro.code.graphql.demo.service.NotesService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class Query implements GraphQLQueryResolver {

    private NotesService notesService;

    public Query(NotesService notesService) {
        this.notesService = notesService;
    }

    public Optional<Note> note(final Long id) {
        return notesService.findById(id);
    }

    public List<Note> notes() {
        return notesService.findAll();
    }
}
