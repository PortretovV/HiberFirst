package entity;


import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
//@Access(AccessType.FIELD)
public class Address {

//    @Column(length = 70)
//    private String country;
//    @Column(length = 250)
//    private String district;

    @Column(name = "city", length = 50)
    private String city;

    @Column(name = "street", length = 50)
    private String street;

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

//    @Column(length = 50)
//    private String building;

}
