import parking.ParkingSpot;
import vehicles.Vehicle;

public class ParkingManager {

    public void parkVehicle(
            Vehicle vehicle,
            ParkingSpot spot) {

        if(spot.isOccupied()) {

            System.out.println(
                    "Spot Already Occupied");

            return;
        }

        if(vehicle.canPark(
                spot.getSpotSize())) {

            spot.parkVehicle();

            System.out.println(
                    vehicle.getVehicleNumber()
                    +
                    " Parked Successfully");
        }
        else {

            System.out.println(
                    "Parking Not Allowed");
        }
    }

    public void calculateBill(
            Vehicle vehicle,
            int hours) {

        System.out.println(
                vehicle.getVehicleNumber()
                +
                " Parking Fee : ₹"
                +
                vehicle.calculateFee(hours));
    }
}
