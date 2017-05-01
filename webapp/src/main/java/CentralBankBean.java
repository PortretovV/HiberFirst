import dao.BankDao;
import dao.CreditCardDao;
import dao.PersonDao;
import ejb.interfaces.TransactionEJBInterface;
import entity.*;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

/**
 * Created by VP on 25.04.2017.
 */

@ManagedBean(name="centralBank")
@SessionScoped
public class CentralBankBean {

    @EJB
    BankDao bankDao;
    @EJB
    PersonDao personDao;
    @EJB
    CreditCardDao creditCardDao;
    @EJB
    TransactionEJBInterface transactionEjb;

    private List<Bank> allBanks;
    private Bank currentBank;
    private Person person;
    private int personId;
    private CreditCard card;
    private CashTransfer transfer;

    public Person getPerson() {
        person = personDao.findById(personId);
        return  person;
    }
    public Bank getCurrentBank() {
        return currentBank;
    }
    public void setCurrentBank(Bank currentBank) {
        this.currentBank = currentBank;
    }
    public CreditCard getCard() {
        return card;
    }
    public void setCard(CreditCard card) {
        this.card = card;
    }
    public CashTransfer getTransfer() {
        return transfer;
    }
    public void setTransfer(CashTransfer transfer) {
        this.transfer = transfer;
    }

    public List<Bank> getAllBanks() {
        allBanks = bankDao.findAll();
        return allBanks;
    }

    public String addBank(){
        currentBank = new Bank();
        return "saveBank";
    }

    public String infoBank(int id){
        currentBank = bankDao.findById(id);
        return "infoBank";
    }

    public String updateBank(int id){
        currentBank = bankDao.findById(id);
        return "saveBank";
    }

    public Bank saveBank(){
        currentBank = bankDao.save(currentBank);
        return currentBank;
    }

    public String depriveLicence(Bank bank) {
        bankDao.depriveLicence(bank);
        return "index";
    }

    public String giveLicence(Bank bank) {
        bankDao.giveLicence(bank);
        return "index";
    }

    public String bankUser(int idUser){
        personId = idUser;
        return "bankUser";
    }

    public String addCard(){
        card = new CreditCard();
        return "saveCard";
    }

    public String updateCard(CreditCard card){
        this.card = card;
        return "saveCard";
    }

    public String saveCard(){
        if(card.getId() == null){
            card.setUser(person);
            card.setSumm_on_card(0);
        }
        card = creditCardDao.save(card);
        return "bankUser";
    }

    public String deleteCard(CreditCard card){
        creditCardDao.delete(card);
        return "bankUser";
    }

    public String cardTransaction(CreditCard card){
        transfer = new CashTransfer();
        this.card = card;
        return "cashTransfer";
    }

    public String cashTransaction(){
        CreditCard resiver = creditCardDao.findByCardNumber(transfer.getCardNumber());
        double cash = transfer.getSum();
        if(resiver != null){
            transactionEjb.cashTransfer(cash,card,resiver);
        }
        return "bankUser";
    }


    public String confirmTransaction(Transaction transaction){
        transactionEjb.confirmCashTransfer(transaction);
        return "bankUser";
    }

}
