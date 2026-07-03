package vehicles;

import parking.SpotSize;

public abstract class Vehicle {

    private String vehicleNumber;

    public Vehicle(String vehicleNumber) {

        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleNumber() {

        return vehicleNumber;
    }

    public abstract boolean canPark(
            SpotSize size);

    public abstract double calculateFee(
            int hours);
}
