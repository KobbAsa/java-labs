package passengers;

public class Firefighter extends Passenger {
    public Firefighter(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Firefighter{name='" + getName() + "'}";
    }
}
