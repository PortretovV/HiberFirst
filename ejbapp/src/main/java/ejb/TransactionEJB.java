package ejb;

import dao.BankDao;
import dao.CreditCardDao;
import dao.PersonDao;
import dao.TransactionDao;
import ejb.interfaces.TransactionEJBInterface;
import entity.CreditCard;
import entity.Transaction;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by VP on 25.04.2017.
 */

@Stateful
@ConversationScoped
@Named(value = "transactionEJB")
public class TransactionEJB implements Serializable, TransactionEJBInterface {

    @Inject
    private Conversation conversation;
    @Inject
    private Event<String> transfer;
    @EJB
    TransactionDao transactionDao;

    private String infoTransact;

    public String getInfoTransact() {
        return infoTransact;
    }

    public void handleInsertEvent(@Observes String info) {
        infoTransact = info;
    }

    @PostConstruct
    private void init(){
        if(conversation.isTransient())
            conversation.begin();
    }

//    @PreDestroy
//    private void destroy(){
//
//    }

    @Override
    public void cashTransfer(double sumCash, CreditCard senderCard, CreditCard receiverCard) {
        if(senderCard == null){
            transfer.fire("Не указан отправитель");
            return;
        }
        if(receiverCard == null){
            transfer.fire("Номер получателя указан неверно");
            return;
        }
        if(sumCash < 1){
            transfer.fire("Невозможно перевести сумму меньше 1 рубля");
            return;
        }
        if( senderCard.getSumm_on_card() < sumCash ){
            transfer.fire("У вас недостаточно средств на карте,cумма перевода = "+sumCash+", сумма на карте = "+ senderCard.getSumm_on_card());
            return;
        }
        if(sumCash > 150000){
            Transaction transaction = new Transaction(sumCash,false,senderCard,receiverCard);
            transactionDao.save(transaction);
            transfer.fire("Для перевода денег необходимо подтвердить операцию!!!");
            return;
        }
        Transaction transaction = new Transaction(sumCash,false,senderCard,receiverCard);
        transaction = transactionDao.save(transaction);
        confirmCashTransfer(transaction);
    }

    @Override
    public void confirmCashTransfer(Transaction transaction){
        transactionDao.cashTransfer(transaction);
        transfer.fire("Деньги успешно переведены!");
        conversation.end();
    }

}
