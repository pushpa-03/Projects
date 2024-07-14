import java.time.LocalDate;
import java.util.List;

import Model.Car;
import Model.Customer;
import Model.Reservation;

public class App {
    public static void main(String[] args) throws Exception {
        RentalSystem rentalSystem = new RentalSystem();

        // Create cars
        Car car1 = new Car("Toyota", "Galnza", 2022, "ABCX2134", 600, true);
        Car car2 = new Car("Honda", "Civik", 2021, "DEFG5678", 700, true);
        Car car3 = new Car("Port", "Manstain", 2023, "HIJK9813", 1200, true);

        rentalSystem.addCar(car1);
        rentalSystem.addCar(car2);
        rentalSystem.addCar(car3);

        // create customer
        Customer customer = new Customer("Pushpa", "1203404222", "DL1234");

        // make reservation
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.plusDays(3);

        List<Car> availableCars = rentalSystem.searchCars("Toyota", "Galnza", startDate, endDate);

        if (!availableCars.isEmpty()) {
            Car selectedCar = availableCars.get(0);
            Reservation reservation = rentalSystem.makeReservation(customer, selectedCar, startDate, endDate);
            if (reservation != null) {
                boolean isPaymentSucessful = rentalSystem.processPayment(reservation);
                if (isPaymentSucessful == true) {
                    System.out.println("Reservation sucessful with reservation Id " + reservation.getReservatioId());
                } else {
                    System.out.println("Payment failed, Reservation Cancelled " + reservation.getReservatioId());
                    rentalSystem.cancelReservation(reservation.getReservatioId());
                }
            } else {
                System.out.println("Selected car not available for given Dates");
            }
        } else {
            System.out.println("No car available with given specifications");
        }

    }
}
