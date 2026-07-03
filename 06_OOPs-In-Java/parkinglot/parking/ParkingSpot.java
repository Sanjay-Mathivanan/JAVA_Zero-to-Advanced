package parking;

public class ParkingSpot {

    private int spotId;
    private SpotSize spotSize;
    private boolean occupied;

    public ParkingSpot(
            int spotId,
            SpotSize spotSize) {

        this.spotId = spotId;
        this.spotSize = spotSize;
    }

    public int getSpotId() {

        return spotId;
    }

    public SpotSize getSpotSize() {

        return spotSize;
    }

    public boolean isOccupied() {

        return occupied;
    }

    public void parkVehicle() {

        occupied = true;
    }
}
