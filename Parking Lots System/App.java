public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to Parking Lots System!!!!");

        ParkingLot parkingLot = new ParkingLot(1,2,3);

        Vehicle vehicle1 = new Vehicle(VehicleType.TRUCK);
        parkingLot.parkTheVehicle(vehicle1);

        Vehicle vehicle2 = new Vehicle(VehicleType.BIKE);
        parkingLot.parkTheVehicle(vehicle2);
    }

    //payment --> hours   --> cash / card/upi
    //multi floor parking
    //entry and exit gate  -->ticket
}
