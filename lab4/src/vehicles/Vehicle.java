package vehicles;

import passengers.Passenger;
import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle<T extends Passenger> {
    private final int maxSeats;
    private final List<T> passengers;

    public Vehicle(int maxSeats) {
        this.maxSeats = maxSeats;
        this.passengers = new ArrayList<>();
    }

    public int getMaxSeats() {
        return maxSeats;
    }

    public int getOccupiedSeats() {
        return passengers.size();
    }

    public void boardPassenger(T passenger) throws Exception {
        if (passengers.size() >= maxSeats) {
            throw new Exception("All seats are occupied.");
        }
        passengers.add(passenger);
    }

    public void disembarkPassenger(T passenger) throws Exception {
        if (!passengers.contains(passenger)) {
            throw new Exception("Passenger not in the vehicle.");
        }
        passengers.remove(passenger);
    }

    public List<T> getPassengers() {
        return new ArrayList<>(passengers);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{maxSeats=" + maxSeats + ", occupiedSeats=" + getOccupiedSeats() + "}";
    }
}