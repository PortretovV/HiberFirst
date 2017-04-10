package entity;

import entity.enums.MeetPlace;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by VP on 09.04.2017.
 */

@Entity
@Table(name = "meet_place", schema = "meeting_portal")
//@Access(AccessType.FIELD)
public class MeetingPlace implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_meet_place")
    private Integer id;

    private boolean finded;

//    Address аннотирован не как сущность, а как встраиваемый объект. Аннотация @Embeddable определяет, что Address
//    может быть встроен в иной класс-сущность (или иной встраиваемый объект).
//    С другой стороны, для сущности Customer приходится использовать аннотацию
//    @Embedded, чтобы определить, что Address является постоянным атрибутом, который
//    будет сохранен как внутренняя часть и станет совместно использовать его идентификатор
    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private MeetPlace meetPlace;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public MeetPlace getMeetPlace() {
        return meetPlace;
    }

    public void setMeetPlace(MeetPlace meetPlace) {
        this.meetPlace = meetPlace;
    }
}
