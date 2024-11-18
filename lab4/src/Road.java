import vehicles.Vehicle;
import passengers.Passenger;
import java.util.ArrayList;
import java.util.List;

public class Road {
    private final List<Vehicle<? extends Passenger>> carsInRoad = new ArrayList<>();

    public int getCountOfHumans() {
        int totalPassengers = 0;
        for (Vehicle<? extends Passenger> vehicle : carsInRoad) {
            totalPassengers += vehicle.getOccupiedSeats();
        }
        return totalPassengers;
    }

    public void addCarToRoad(Vehicle<? extends Passenger> vehicle) {
        carsInRoad.add(vehicle);
    }
}
