package dao.Impl;

import dao.BankDao;
import entity.Bank;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class BankDaoImpl implements BankDao {

    @PersistenceContext(unitName = "MEETING_PLACE")
    EntityManager em;

    @Override
    public Bank findById(int id) {
        TypedQuery<Bank> query = em.createNamedQuery("Bank.findById",Bank.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public List<Bank> findAll() {
        List<Bank> resultList = em.createNamedQuery("Bank.findAll",Bank.class).getResultList();
        return resultList;
    }

    @Override
    public List<Bank> findAllWithDetail() {
        List<Bank> resultList = em.createNamedQuery("Bank.findAllWithDetail",Bank.class).getResultList();
        return resultList;
    }

    @Override
    public List<Bank> findAllWithLicence() {
        List<Bank> resultList = em.createNamedQuery("Bank.findAllWithLicence",Bank.class).getResultList();
        return resultList;
    }

    @Override
    public List<Bank> findAllWithOutLicence() {
        List<Bank> resultList = em.createNamedQuery("Bank.findAllWithOutLicence",Bank.class).getResultList();
        return resultList;
    }

    @Override
    public Bank save(Bank bank) {
        if(bank.getId() == null){
            em.persist(bank);
            return bank;
        }
        else if (bank.getId() > 0){
            em.merge(bank);
            return bank;
        }
        return null;
    }

    @Override
    public void delete(Bank bank) {
        Bank mergedBank = em.merge(bank);
        em.remove(mergedBank);
    }

    @Override
    public Bank depriveLicence(Bank bank) {
        bank.setLicence(false);
        return em.merge(bank);
    }

    @Override
    public Bank giveLicence(Bank bank) {
        bank.setLicence(true);
        return em.merge(bank);
    }


}
