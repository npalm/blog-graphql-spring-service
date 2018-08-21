package ofouro.code.graphql.demo.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import ofouro.code.graphql.demo.model.Note;
import ofouro.code.graphql.demo.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {

    @Autowired
    private NotesService notesService;

    public Note addNote(final InputNote note, final InputPerson author) {
        return notesService.save(InputNote.convert(note, author));
    }

}
