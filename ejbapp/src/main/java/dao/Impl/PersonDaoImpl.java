package dao.Impl;

import dao.PersonDao;
import entity.Person;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by VP on 20.04.2017.
 */


@Stateless
public class PersonDaoImpl implements PersonDao {
    @PersistenceContext(unitName = "MEETING_PLACE")
    EntityManager em;

    @Override
    public Person findById(int id) {
        return em.find(Person.class, id);
    }

    @Override
    public List<Person> findAll() {
        return null;
    }

    @Override
    public Person save(Person person) {
        if(person.getId() == null){
            em.persist(person);
            return person;
        }
        else if (person.getId()>0){
            em.merge(person);
            return person;
        }
        return null;
    }

    @Override
    public void delete(Person person) {
        Person mergedPerson = em.merge(person);
        em.remove(mergedPerson);
    }
}
