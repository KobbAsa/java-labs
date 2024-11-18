package vehicles;

import passengers.Passenger;

public abstract class Car<T extends Passenger> extends Vehicle<T> {
    public Car(int maxSeats) {
        super(maxSeats);
    }
}