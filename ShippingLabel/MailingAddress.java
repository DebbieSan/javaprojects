public class MailingAddress {

    public FullName fullName;
    private String streetAddress;
    private String city;
    private String province;
    private String postalCode;

    public MailingAddress(FullName fullName, String streetAddress, String city, String province, String postalCode) {
        this.fullName = fullName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.province = province;
        this.postalCode = postalCode;

    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress() {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity() {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince() {
        this.province = province;
    }

    public String setPostalCode() {
        return postalCode;
    }

    public void getPostalCode() {
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return fullName + " " + streetAddress + " " + city + " " + postalCode + "\n";
    }

}