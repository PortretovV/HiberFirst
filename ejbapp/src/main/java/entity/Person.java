package entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private short birthYear;

    private byte height;
    private byte weight;
    private byte gender;
    private String colorHeir;
    private String colorEar;

}
