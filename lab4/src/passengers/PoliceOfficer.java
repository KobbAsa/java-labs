package passengers;

public class PoliceOfficer extends Passenger {
    public PoliceOfficer(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "PoliceOfficer{name='" + getName() + "'}";
    }
}
