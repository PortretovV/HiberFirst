package dao;

import entity.Bank;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by VP on 25.04.2017.
 */

@Local
public interface BankDao {
    Bank findById(int id);
    List<Bank> findAll();
    List<Bank> findAllWithDetail();
    List<Bank> findAllWithLicence();
    List<Bank> findAllWithOutLicence();
    Bank save(Bank bank);
    void delete(Bank bank);
    Bank depriveLicence(Bank bank);
    Bank giveLicence(Bank bank);
}
