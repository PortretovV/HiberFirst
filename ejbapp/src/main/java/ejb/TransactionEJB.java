package ejb;

import dao.BankDao;
import dao.CreditCardDao;
import dao.PersonDao;
import dao.TransactionDao;
import ejb.interfaces.TransactionEJBInterface;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by VP on 25.04.2017.
 */

@Stateful
@ConversationScoped
@Named(value = "Transaction")
public class TransactionEJB implements Serializable, TransactionEJBInterface {

    @EJB BankDao bankDao;
    @EJB CreditCardDao cardDao;
    @EJB PersonDao personDao;
    @EJB TransactionDao transactionDao;





}
