package be.cegeka.bibliothouris.domain.users;

public class Member implements RegisteredUser{

    private String inss;
    private String lastName;
    private String firstName;
    private String streetName;
    private String streetNumber;
    private String postalCode;
    private String cityName;

    public Member(String inss, String lastName, String firstName, String streetName, String streetNumber, String postalCode, String cityName) {
        this.inss = inss;
        this.lastName = lastName;
        this.firstName = firstName;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.postalCode = postalCode;
        this.cityName = cityName;
    }

    public String getInss() {
        return inss;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCityName() {
        return cityName;
    }

    @Override
    public void userDetails(long id, String name) {
        System.out.println(id + "," + name);
    }

    @Override
    public void requestBookDetails() {
        
    }

    public String getDetails() {
        return "[" + getInss() + "] " + getLastName() + " " + getFirstName() + ", " + getStreetName() + " " + getStreetNumber() + ", " + getPostalCode() + " " + getCityName() ;
    }
}

