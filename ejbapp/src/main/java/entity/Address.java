package entity;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Access(AccessType.FIELD)
public class Address {

    @Column(length = 70)
    private String country;
    @Column(length = 250)
    private String district;
    @Column(length = 50)
    private String city;
    @Column(length = 200)
    private String street;
    @Column(length = 50)
    private String building;

}
