package Model;

import java.time.LocalDate;

public class Reservation {
    private String reservationId;
    private Car car;
    private Customer customer;
    private LocalDate startDate;
    private LocalDate endDate;
    private double totalPrice;

    public Reservation(String reservationId, Car car, Customer customer, LocalDate startDate, LocalDate enDate, double totalPrice)
    {
        this.reservationId = reservationId;
        this.car = car;
        this.customer = customer;
        this.startDate = startDate;
        this.totalPrice = totalPrice;
        this.endDate = enDate;
    }

    public String getReservatioId(){return this.reservationId;}

    public Car getCar(){return this.car;}

    public Customer getCustomer(){return this.customer;}

    public LocalDate getStarDate(){return this.startDate;}
    
    public LocalDate getEndDate(){return this.endDate;}

    public double getTotalPrice(){return this.totalPrice;}

}
