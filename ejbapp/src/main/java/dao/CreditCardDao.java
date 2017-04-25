package dao;

import entity.CreditCard;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by VP on 25.04.2017.
 */

@Local
public interface CreditCardDao {
    CreditCard findById(int id);
    List<CreditCard> findAll();
    CreditCard save(CreditCard card);
    void delete(CreditCard card);
}
