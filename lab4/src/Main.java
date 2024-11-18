import passengers.*;
import vehicles.*;

public class Main {
    public static void main(String[] args) {
        try {
            Passenger passenger = new Passenger("Alex");
            Firefighter firefighter = new Firefighter("Ivan");
            PoliceOfficer policeOfficer = new PoliceOfficer("Olga");
            System.out.println(policeOfficer);

            Bus bus = new Bus(20);
            Taxi taxi = new Taxi(4);
            FireTruck fireTruck = new FireTruck(4);
            PoliceCar policeCar = new PoliceCar(4);

            bus.boardPassenger(passenger);
            bus.boardPassenger(firefighter);
            bus.boardPassenger(policeOfficer);

            System.out.println("Occupied seats in bus: " + bus.getOccupiedSeats());
            System.out.println("Max amount of seats in bus: " + bus.getMaxSeats());

            taxi.boardPassenger(passenger);
            taxi.boardPassenger(policeOfficer);

            System.out.println("\nOccupied seats in taxi: "+ taxi.getOccupiedSeats());
            System.out.println("Max amount of seats in taxi: " + taxi.getMaxSeats());

            fireTruck.boardPassenger(firefighter);
            System.out.println("\nOccupied seats in firetruck: " + fireTruck.getOccupiedSeats());

            policeCar.boardPassenger(policeOfficer);
            System.out.println("\nOccupied seats in police car: " + policeCar.getOccupiedSeats());

            Road generalRoad = new Road();

            generalRoad.addCarToRoad(bus);
            generalRoad.addCarToRoad(taxi);
            generalRoad.addCarToRoad(fireTruck);
            generalRoad.addCarToRoad(policeCar);

            System.out.println("\nNumber of all passengers: " + generalRoad.getCountOfHumans());
        } catch (Exception e) {
            System.err.println("Error caught: " + e.getMessage());
        }
    }
}
