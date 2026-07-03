package vehicles;

import parking.SpotSize;

public class Car extends Vehicle {

    public Car(String vehicleNumber) {

        super(vehicleNumber);
    }

    @Override
    public boolean canPark(
            SpotSize size) {

        return size == SpotSize.MEDIUM
                ||
                size == SpotSize.LARGE;
    }

    @Override
    public double calculateFee(
            int hours) {

        return hours * 20;
    }
}
