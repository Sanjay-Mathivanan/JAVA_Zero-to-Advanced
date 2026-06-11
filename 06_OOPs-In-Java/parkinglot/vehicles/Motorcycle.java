package vehicles;

import parking.SpotSize;

public class Motorcycle extends Vehicle {

    public Motorcycle(
            String vehicleNumber) {

        super(vehicleNumber);
    }

    @Override
    public boolean canPark(
            SpotSize size) {

        return true;
    }

    @Override
    public double calculateFee(
            int hours) {

        return hours * 10;
    }
}
