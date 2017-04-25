package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by VP on 25.04.2017.
 */



@Entity
@Table(name = "bank", schema = "meeting_portal_2")
@NamedQueries({
        @NamedQuery(name = "Bank.findAll",query = "select b from Bank b"),
        @NamedQuery(name = "Bank.findById",query = "select distinct b from Bank b left join fetch b.clients p where b.id = :id"),
        @NamedQuery(name = "Bank.findAllWithDetail",query = "select distinct b from Bank b left join fetch b.clients p"),
        @NamedQuery(name = "Bank.findAllWithLicence",query = "select distinct b from Bank b left join fetch b.clients p where b.licence = true"),
        @NamedQuery(name = "Bank.findAllWithOutLicence",query = "select distinct b from Bank b left join fetch b.clients p where b.licence = false")
})
public class Bank implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bank")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "label")
    private String label;

    @Column(name = "licence")
    private Boolean licence;

    @OneToMany(mappedBy = "bank", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Person> clients = new HashSet<>();

    public Bank() {}

    public Bank(String name, Boolean licence) {
        this.name = name;
        this.licence = licence;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Person> getClients() {
        return clients;
    }

    public void setClients(Set<Person> clients) {
        this.clients = clients;
    }

    public Boolean getLicence() {
        return licence;
    }

    public void setLicence(Boolean licence) {
        this.licence = licence;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

}
