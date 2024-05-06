import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    int largeSpotSize;
    int compactSpotSize;
    int bikeSpotSize;

    List<ParkingSpot> largeParkingSpotList;
    List<ParkingSpot> compactParkingSpotList;
    List<ParkingSpot> bikeParkingSpotList;

    public ParkingLot(int largeSpotSize, int compactSpotSize, int bikeSpotSize) {
        this.bikeSpotSize = bikeSpotSize;
        this.largeSpotSize = largeSpotSize;
        this.compactSpotSize = compactSpotSize;

        largeParkingSpotList = new ArrayList<>();
        compactParkingSpotList = new ArrayList<>();
        bikeParkingSpotList = new ArrayList<>();
    }

    public void parkTheVehicle(Vehicle vehicle) {
        System.out.println("We are parking the vehicle" + vehicle.getVehicleType());
        if (VehicleType.TRUCK.equals(vehicle.getVehicleType())) {
            if (largeSpotSize > 0)
                partLargeVehicle(vehicle);
            else
                System.out.println("Large parking spots are full");
        } else if (VehicleType.CAR.equals(vehicle.getVehicleType())) {
            if (compactSpotSize > 0) {
                parkTCompactVehicle(vehicle);
            } else {
                System.out.println("Compact parking spots are full");
            }
        } else if (VehicleType.BIKE.equals(vehicle.getVehicleType())) {
            if (compactSpotSize > 0) {
                parkTBikeVehicle(vehicle);
            } else {
                System.out.println("Bike parking spots are full");
            }
        } else {
            System.out.println("Given vehicle parking not available");
        }

    }

    private void partLargeVehicle(Vehicle vehicle) {
        ParkingSpot largeParkingSpot = new ParkingSpot(ParkingSpotType.LARGE);
        largeParkingSpot.setIsFree(false);
        largeParkingSpot.setVehicle(vehicle);
        vehicle.setParkingSpot(largeParkingSpot);

        largeParkingSpotList.add(largeParkingSpot);
        largeSpotSize--;
        System.out.println("Truck parked successfully");
    }

    private void parkTCompactVehicle(Vehicle vehicle) {
        ParkingSpot compactParkingSpot = new ParkingSpot(ParkingSpotType.COMPACT);

        compactParkingSpot.setIsFree(false);
        compactParkingSpot.setVehicle(vehicle);
        vehicle.setParkingSpot(compactParkingSpot);

        compactParkingSpotList.add(compactParkingSpot);
        compactSpotSize--;
        System.out.println("Car parked successfully");
    }

    private void parkTBikeVehicle(Vehicle vehicle) {
        ParkingSpot BikeParkingSpot = new ParkingSpot(ParkingSpotType.BIKE);

        BikeParkingSpot.setIsFree(false);
        BikeParkingSpot.setVehicle(vehicle);
        vehicle.setParkingSpot(BikeParkingSpot);

        bikeParkingSpotList.add(BikeParkingSpot);
        compactSpotSize--;
        System.out.println("Bike parked successfully");
    }

    public void unparkTheVehicle(Vehicle vehicle) {
        System.out.println("We are unparking the vehicle" + vehicle.getVehicleType());

        ParkingSpot parkingSpot = vehicle.getParkingSpot();
        parkingSpot.setIsFree(true);

        if (VehicleType.BIKE.equals(vehicle.getVehicleType())) {
            bikeSpotSize++;
        } else if (VehicleType.TRUCK.equals(vehicle.getVehicleType())) {
            largeSpotSize++;
        } else {
            compactSpotSize++;
        }

        System.out.println("Unparking the vehicle successfully");
    }
}
