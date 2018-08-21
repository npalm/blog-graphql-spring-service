package ofouro.code.graphql.demo.resolvers;

import ofouro.code.graphql.demo.model.Person;
import org.junit.Assert;
import org.junit.Test;

public class InputPersonTest {

    @Test
    public void converterTest() {
        InputPerson inputPerson = new InputPerson("me", "noreply@me.com");
        Person person = InputPerson.convert(inputPerson);

        Assert.assertEquals(inputPerson.getName(), person.getName());
        Assert.assertEquals(inputPerson.getEmail(), person.getEmail());
    }

    @Test
    public void converterTestNull() {
        Person person = InputPerson.convert(null);

        Assert.assertNull(person);
    }
}
