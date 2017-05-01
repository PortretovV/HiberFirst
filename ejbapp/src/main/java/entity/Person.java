package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "persons", schema = "meeting_portal_2")
@NamedQueries({
        @NamedQuery(name = "Person.findByIdBank", query = "SELECT distinct p FROM Person p left join fetch p.creditCards c" +
                " left join fetch p.bank b where b.id = :id"),
        @NamedQuery(name = "Person.findById", query = "SELECT distinct p FROM Person p left join fetch p.creditCards c" +
                " left join fetch p.bank b where p.id = :id"),
        @NamedQuery(name = "Person.findAll", query = "select distinct p from Person p left join fetch p.creditCards c left join fetch p.bank b")
})
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

    @Column(name = "gender")
    private Boolean gender;

    @Transient
    private Integer age;

    @OneToMany(mappedBy = "user", cascade=CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<CreditCard> creditCards = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "id_bank")
    private Bank bank;


    public Person() {}

    public Person(String firstName, String lastName, Date birthday, Boolean gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.gender = gender;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<CreditCard> getCreditCards() {
        return creditCards;
    }

    public void setCreditCards(List<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

}
