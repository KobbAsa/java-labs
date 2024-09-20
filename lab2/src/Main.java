import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) {
        // create a Person object
        Person person1 = new Person("Antonio", "Javenko", 33);

        // create Gson instance for JSON conversion
        Gson gson = new Gson();

        // convert the object to JSON
        String json = gson.toJson(person1);
        System.out.println("Converted to JSON: " + json);

        // convert JSON back to object
        Person personFromJson = gson.fromJson(json, Person.class);
        System.out.println("Object obtained from JSON: " + personFromJson.getFirstName() + " " + personFromJson.getLastName());

        // check equality
        System.out.println("Are objects equal: " + person1.equals(personFromJson)); // Expected to be true
    }
}
