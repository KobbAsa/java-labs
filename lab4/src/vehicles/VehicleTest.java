package vehicles;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import passengers.*;

public class VehicleTest {
    private Bus bus;
    private Taxi taxi;
    private FireTruck fireTruck;
    private PoliceCar policeCar;
    private Passenger passenger;
    private Firefighter firefighter;
    private PoliceOfficer policeOfficer;

    @BeforeEach
    public void setUp() {
        bus = new Bus(33);
        taxi = new Taxi(2);
        fireTruck = new FireTruck(1);
        policeCar = new PoliceCar(1);

        passenger = new Passenger("Alex");
        firefighter = new Firefighter("Kolya");
        policeOfficer = new PoliceOfficer("Cop Antonio");
    }

    @Test
    public void testBoardPassengerInBus() throws Exception {
        bus.boardPassenger(passenger);
        bus.boardPassenger(firefighter);
        bus.boardPassenger(policeOfficer);

        assertEquals(3, bus.getOccupiedSeats());
        assertEquals(33, bus.getMaxSeats());
    }

    @Test
    public void testBoardPassengerInTaxi() throws Exception {
        taxi.boardPassenger(passenger);
        taxi.boardPassenger(policeOfficer);

        assertEquals(2, taxi.getOccupiedSeats());
        assertEquals(2, taxi.getMaxSeats());
    }

    @Test
    public void testBoardFirefighterInFireTruck() throws Exception {
        fireTruck.boardPassenger(firefighter);

        assertEquals(1, fireTruck.getOccupiedSeats());
        assertEquals(1, fireTruck.getMaxSeats());
    }

    @Test
    public void testBoardPoliceOfficerInPoliceCar() throws Exception {
        policeCar.boardPassenger(policeOfficer);

        assertEquals(1, policeCar.getOccupiedSeats());
        assertEquals(1, policeCar.getMaxSeats());
    }

    @Test
    public void testExceedingSeatLimit() {
        assertThrows(Exception.class, () -> {
            taxi.boardPassenger(passenger);
            taxi.boardPassenger(policeOfficer);
            taxi.boardPassenger(new Passenger("Max"));
        });
    }

    @Test
    public void testBoardPassengerWhenBusIsFull() {
        // Filling all seats
        assertDoesNotThrow(() -> {
            taxi.boardPassenger(new Passenger("Andrew"));
            taxi.boardPassenger(new Passenger("Andrew`s brother"));
        });

        // Trying to throw one more passenger in bus
        Exception exception = assertThrows(Exception.class, () -> taxi.boardPassenger(new Passenger("Andrew`s sister")));
        assertEquals("All seats are occupied.", exception.getMessage());
    }

    @Test
    public void testDisembarkPassengerNotInVehicle() throws Exception {
        taxi.boardPassenger(passenger); // adding passenger
        taxi.disembarkPassenger(passenger); // removing passenger

        // trying to remove passenger that had been removed already
        Exception exception = assertThrows(Exception.class, () -> taxi.disembarkPassenger(passenger));
        assertEquals("Passenger not in the vehicle.", exception.getMessage());
    }


}
