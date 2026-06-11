import parking.*;
import vehicles.*;

public class Main {

    public static void main(String[] args) {

        Vehicle bike =
                new Motorcycle(
                        "TN38BIKE01");

        Vehicle car =
                new Car(
                        "TN38CAR01");

        Vehicle truck =
                new Truck(
                        "TN38TRUCK01");

        ParkingSpot smallSpot =
                new ParkingSpot(
                        1,
                        SpotSize.SMALL);

        ParkingSpot mediumSpot =
                new ParkingSpot(
                        2,
                        SpotSize.MEDIUM);

        ParkingSpot largeSpot =
                new ParkingSpot(
                        3,
                        SpotSize.LARGE);

        ParkingManager manager =
                new ParkingManager();

        manager.parkVehicle(
                bike,
                smallSpot);

        manager.parkVehicle(
                car,
                mediumSpot);

        manager.parkVehicle(
                truck,
                largeSpot);

        System.out.println();

        manager.calculateBill(
                bike,
                5);

        manager.calculateBill(
                car,
                5);

        manager.calculateBill(
                truck,
                5);
    }
}
