package pl.sdacademy.registration;

public class AddressDTO {


    private Long Id;
    private String city;
    private String street;
    private String houseNo;


    public Long getId() {
        return Id;
    }


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }
}
