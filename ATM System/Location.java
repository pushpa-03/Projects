public class Location {
    private String country;
    private String state;
    private int zipCode;
    private String city;
    private String zone;
    private String address;

    public Location(String country, int zipCode, String state, String city, String address, String zone) {
        this.country = country;
        this.state = state;
        this.zipCode = zipCode;
        this.city = city;
        this.zone = zone;
        this.address = address;
    }

    public String getCountry() {
        return this.country;
    }

    public int getZipCode() {
        return this.zipCode;
    }

    public String getState() {
        return this.state;
    }

    public String getCity() {
        return this.city;
    }

    public String getZone() {
        return this.zone;
    }

    public String getAddress() {
        return this.address;
    }
}
