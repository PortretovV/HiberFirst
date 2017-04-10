package entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "hobbes", schema = "meeting_portal")
//@Access(AccessType.PROPERTY)
public class Hobby implements Serializable {

    private int idHobby;
    private String name;
    private List<Person> persons = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_hobby")
    public int getIdHobby() {
        return idHobby;
    }

    public void setIdHobby(int idHobby) {
        this.idHobby = idHobby;
    }

    @Column(name = "name", length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @ManyToMany(targetEntity = Person.class,fetch = FetchType.LAZY, mappedBy = "hobbies")
    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
}
