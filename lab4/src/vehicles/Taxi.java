package vehicles;

import passengers.Passenger;

public class Taxi extends Car<Passenger> {
    public Taxi(int maxSeats) {
        super(maxSeats);
    }
}