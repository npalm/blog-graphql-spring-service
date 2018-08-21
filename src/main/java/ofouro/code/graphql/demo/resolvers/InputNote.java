package ofouro.code.graphql.demo.resolvers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ofouro.code.graphql.demo.model.Note;
import ofouro.code.graphql.demo.model.Person;

import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InputNote {

    private String note;

    static Note convert(InputNote comment, InputPerson person) {
        Person author = InputPerson.convert(person);
        return comment != null ? new Note(comment.getNote(), ZonedDateTime.now(), author) : null;
    }
}
