package Model;

public class Customer {

    String name;
    String contactNumber;
    String drivingLicenseNumber;

    public Customer(String name, String contactNumber, String drivingLicenseNumber)
    {
        this.name = name;
        this.contactNumber = contactNumber;
        this.drivingLicenseNumber = drivingLicenseNumber;
    }

    public String getName()
    {
        return this.name;
    }

    public String getContactNumber()
    {
        return this.contactNumber;
    }

    public String getDrivingLicenseNumber()
    {
        return this.drivingLicenseNumber;
    }

}
