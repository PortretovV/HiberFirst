import dao.BankDao;
import entity.Bank;

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

    private List<Bank> allBanks;
    private Bank currentBank;

    public Bank getCurrentBank() {
        return currentBank;
    }
    public void setCurrentBank(Bank currentBank) {
        this.currentBank = currentBank;
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

}
