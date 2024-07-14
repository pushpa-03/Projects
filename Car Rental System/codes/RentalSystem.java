import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.List;

import Model.Payment.CreditCardPaymentProcessor;
import Model.Payment.PaymentProcessor;
import Model.Car;
import Model.Customer;
import Model.Reservation;

public class RentalSystem {

    private Map<String,Car> cars;
    private Map<String,Reservation> reservations;
    private PaymentProcessor paymentProcessor;

    public RentalSystem()
    {
        cars = new HashMap<>();
        reservations = new HashMap<>();
        paymentProcessor = new CreditCardPaymentProcessor();
    }

    public void addCar(Car car)
    {
        cars.put(car.getLicensePlate(), car);
        System.out.println("Car Added sucessfully");
    }

    public void removeCar(String licensePlate)
    {
        cars.remove(licensePlate);
    }

    private boolean isCarAvailable(Car car, LocalDate starDate, LocalDate enDate)
    {
        for(Reservation reservation: reservations.values())
        {
            if(reservation.getCar().equals(car))
            {
                if(starDate.isBefore(reservation.getEndDate()) && enDate.isAfter(reservation.getStarDate()))
                {
                    return false;
                }
            }
        }
        return true;
    }

    public List<Car> searchCars(String maker, String model, LocalDate starDate, LocalDate enDate)
    {
        List<Car>availableCars = new ArrayList<>();
        for(Car car:cars.values())
        {
            if(car.getMaker().equals(maker) && car.getModel().equals(model) && car.getIsAvailable())
            {
                if(isCarAvailable(car, starDate, enDate))
                {
                    availableCars.add(car);
                }
            }
        }
        return availableCars;
    }

    public Reservation makeReservation(Customer customer, Car car, LocalDate starDate, LocalDate enDate)
    {
        if(isCarAvailable(car, starDate, enDate))
        {
            String reservationId = generateReservatonId();
            Reservation reservation = new Reservation(reservationId, car, customer, enDate, enDate, 1500.0);
            reservations.put(reservationId, reservation);
            car.setAvailable(false);
            return reservation;
        }
        return null;
    }

    public void cancelReservation(String reservationId)
    {
        Reservation reservation = reservations.remove(reservationId);
        reservation.getCar().setAvailable(true);        
    }

    private String generateReservatonId()
    {
        return "RES" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    public boolean processPayment(Reservation reservation)
    {
        return paymentProcessor.processPayment(reservation.getTotalPrice());
    }

}
