import org.junit.jupiter.api.Test;
import com.google.gson.Gson;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    @Test
    public void testEquals() {
        // create Person objects
        Person person1 = new Person("Antonio", "Javenko", 33);
        Person person2 = new Person("Antonio", "Javenko", 33);
        Person person3 = new Person("Antoine", "Jasenko", 19);
        Person person4 = new Person("Antoine", "Jasenko", 103);

        // test equals method
        assertEquals(person1, person2); // equal
        assertNotEquals(person1, person3); // not equal
        assertNotEquals(person1, person4); // not equal
        assertNotEquals(null, person1);    // not equal
        assertNotEquals("string", person1); // not equal (different type)
    }

    @Test
    public void testGsonConversion() {
        // create Gson instance
        Gson gson = new Gson();

        // create a Person object
        Person person = new Person("Antonio", "Javenko", 33);

        // convert to JSON
        String json = gson.toJson(person);

        assertEquals(
                "{" +
                        "\"firstName\":\"Antonio\"," +
                        "\"lastName\":\"Javenko\"," +
                        "\"age\":33" + "}"
                , json);

        // convert back from JSON
        Person personFromJson = gson.fromJson(json, Person.class);

        // compare person before JSON and after JSON conversion
        assertEquals(person, personFromJson); // not equal
    }
}
