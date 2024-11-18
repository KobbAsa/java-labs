package vehicles;

import passengers.Passenger;

public class Bus extends Vehicle<Passenger> {
    public Bus(int maxSeats) {
        super(maxSeats);
    }
}