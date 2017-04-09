package entity;

import entity.enums.EyeColor;
import entity.enums.HairColor;
import entity.enums.HairLength;
import entity.enums.HairStyle;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table
@Access(AccessType.FIELD)
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_person")
    private Integer id;

    @Column(name = "first_name", length = 50)
    private String firstName;

    @Column(name = "last_name", length = 50)
    private String lastName;

    @Temporal(TemporalType.DATE)
    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "height")
    private Byte height;

    @Column(name = "weight")
    private Byte weight;

    @Column(name = "gender")
    private Byte gender;

    @Transient
    private Integer age;

    @Column(name = "hair_color")
    @Enumerated(EnumType.STRING)
    private HairColor colorHeir;

    @Column(name = "hair_style")
    @Enumerated(EnumType.STRING)
    private HairStyle styleHair;

    @Column(name = "hair_length")
    @Enumerated(EnumType.STRING)
    private HairLength lengthHeir;

    @Column(name = "eye_color")
    @Enumerated(EnumType.STRING)
    private EyeColor colorEar;

    @ManyToMany(targetEntity = Hobby.class, fetch = FetchType.LAZY)
    @JoinTable(name = "pers_hobbys",
            joinColumns = @JoinColumn(name = "id_person"),
            inverseJoinColumns = @JoinColumn(name = "id_hobby"))
    List<Hobby> hobbies = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public byte getHeight() {
        return height;
    }

    public void setHeight(byte height) {
        this.height = height;
    }

    public byte getWeight() {
        return weight;
    }

    public void setWeight(byte weight) {
        this.weight = weight;
    }

    public byte getGender() {
        return gender;
    }

    public void setGender(byte gender) {
        this.gender = gender;
    }

    public HairColor getColorHeir() {
        return colorHeir;
    }

    public void setColorHeir(HairColor colorHeir) {
        this.colorHeir = colorHeir;
    }

    public HairStyle getStyleHair() {
        return styleHair;
    }

    public void setStyleHair(HairStyle styleHair) {
        this.styleHair = styleHair;
    }

    public HairLength getLengthHeir() {
        return lengthHeir;
    }

    public void setLengthHeir(HairLength lengthHeir) {
        this.lengthHeir = lengthHeir;
    }

    public EyeColor getColorEar() {
        return colorEar;
    }

    public void setColorEar(EyeColor colorEar) {
        this.colorEar = colorEar;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
