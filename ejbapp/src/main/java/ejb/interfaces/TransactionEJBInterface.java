package ejb.interfaces;

import entity.CreditCard;
import entity.Transaction;

import javax.ejb.Local;
import javax.enterprise.event.Observes;

/**
 * Created by VP on 25.04.2017.
 */

@Local
public interface TransactionEJBInterface {
    void cashTransfer(double sumCash, CreditCard senderCard, CreditCard receiverCard);
    void confirmCashTransfer(Transaction transaction);
    void handleInsertEvent(@Observes String info);
    String getInfoTransact();
}
