package Model.Payment;

public class CreditCardPaymentProcessor implements PaymentProcessor{

    public boolean processPayment(double amount)
    {
        System.out.println("Amount " + amount + " Payment Process Sucessfully through credit card");
        return true;
    }

}
