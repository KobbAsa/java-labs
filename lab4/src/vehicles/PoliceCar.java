package vehicles;

import passengers.PoliceOfficer;

public class PoliceCar extends Car<PoliceOfficer> {
    public PoliceCar(int maxSeats) {
        super(maxSeats);
    }
}