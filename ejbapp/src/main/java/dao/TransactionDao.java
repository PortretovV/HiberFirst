package dao;

import entity.Transaction;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by VP on 25.04.2017.
 */

@Local
public interface TransactionDao {
    Transaction findById(int id);
    List<Transaction> findAll();
    Transaction save(Transaction transaction);
    void delete(Transaction transaction);
}
