public class User {
    private String userName;
    private int pin;
    private String accNo;
    private int cvv;
    private double balance;
    private int monthOfExpiry;
    private int yerOfExpiry;

    public User(String userName, int pin, String accNo, int cvv, double bal, int monthOfExpiry, int yerOfExpiry) {
        this.userName = userName;
        this.pin = pin;
        this.accNo = accNo;
        this.cvv = cvv;
        this.balance = bal;
        this.monthOfExpiry = monthOfExpiry;
        this.yerOfExpiry = yerOfExpiry;
    }

    public String getUserName() {
        return this.userName;
    }

    public int getPin() {
        return this.pin;
    }

    public String getAccountNumber() {
        return this.accNo;
    }

    public int getCvv() {
        return this.cvv;
    }

    public int getMonthOfExpiry() {
        return this.monthOfExpiry;
    }

    public int getYearOfExpiry() {
        return this.yerOfExpiry;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setUserName(String name) {
        this.userName = name;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public void setAccountNumber(String accNo) {
        this.accNo = accNo;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public void setMonthOfExpiry(int monthOfExpiry) {
        this.monthOfExpiry = monthOfExpiry;
    }

    public void setYearOfExpiry(int yerOfExpiry) {
        this.yerOfExpiry = yerOfExpiry;
    }

    public void setBalance(double bal) {
        this.balance = bal;
    }
}
