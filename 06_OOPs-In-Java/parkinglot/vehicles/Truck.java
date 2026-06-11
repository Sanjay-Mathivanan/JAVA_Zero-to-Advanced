package vehicles;

import parking.SpotSize;

public class Truck extends Vehicle {

    public Truck(String vehicleNumber) {

        super(vehicleNumber);
    }

    @Override
    public boolean canPark(
            SpotSize size) {

        return size == SpotSize.LARGE;
    }

    @Override
    public double calculateFee(
            int hours) {

        return hours * 50;
    }
}
