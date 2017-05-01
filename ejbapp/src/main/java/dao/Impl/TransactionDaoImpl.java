package dao.Impl;

import dao.TransactionDao;
import entity.CreditCard;
import entity.Transaction;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by VP on 25.04.2017.
 */

@Stateless
public class TransactionDaoImpl implements TransactionDao {
    @PersistenceContext(unitName = "MEETING_PLACE")
    EntityManager em;

    @Override
    public Transaction findById(int id) {
        return null;
    }

    @Override
    public List<Transaction> findAll() {
        return null;
    }

    @Override
    public Transaction save(Transaction transaction) {
        if(transaction.getId() == null){
            em.persist(transaction);
            return transaction;
        }
        else if (transaction.getId()>0){
            em.merge(transaction);
            return transaction;
        }
        return null;
    }

    public Transaction cashTransfer(Transaction transaction){
        CreditCard sender = transaction.getSenderCard();
        CreditCard receiver = transaction.getReceiverCard();

        double newSenderSum = sender.getSumm_on_card() - transaction.getSum();
        double newReceiverSum = receiver.getSumm_on_card() + transaction.getSum();

        sender.setSumm_on_card(newSenderSum);
        receiver.setSumm_on_card(newReceiverSum);
        em.merge(sender);
        em.merge(receiver);

        transaction.setConfirmed(true);
        transaction = em.merge(transaction);
        return transaction;
    }

    @Override
    public void delete(Transaction transaction) {
        Transaction mergedTransaction = em.merge(transaction);
        em.remove(transaction);
    }
}
