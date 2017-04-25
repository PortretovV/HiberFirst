package dao;

import entity.Person;

import javax.ejb.Local;
import java.util.List;

@Local
public interface PersonDao {
    Person findById(int id);
    List<Person> findAll();
    Person save(Person person);
    void delete(Person person);

}
