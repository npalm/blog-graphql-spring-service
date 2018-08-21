package ofouro.code.graphql.demo.resolvers;

import ofouro.code.graphql.demo.model.Note;
import org.junit.Assert;
import org.junit.Test;

public class InputNoteTest {

    @Test
    public void converterTest() {
        InputNote inputNote = new InputNote("test");
        Note note = InputNote.convert(inputNote, null);

        Assert.assertEquals(inputNote.getNote(), note.getNote());
    }

    @Test
    public void converterTestNull() {
        Note note = InputNote.convert(null, null);

        Assert.assertNull(note);
    }
}
