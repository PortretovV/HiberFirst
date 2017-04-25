package dao.Impl;

import dao.CreditCardDao;
import entity.CreditCard;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by VP on 25.04.2017.
 */

@Stateless
public class CreditCardDaoImpl implements CreditCardDao {

    @PersistenceContext(unitName = "MEETING_PLACE")
    EntityManager em;

    @Override
    public CreditCard findById(int id) {
        return null;
    }

    @Override
    public List<CreditCard> findAll() {
        return null;
    }

    @Override
    public CreditCard save(CreditCard card) {
        if(card.getId() == null){
            em.persist(card);
            return card;
        }
        else if (card.getId()>0){
            em.merge(card);
            return card;
        }
        return null;
    }

    @Override
    public void delete(CreditCard card) {
        CreditCard mergedCreditCard = em.merge(card);
        em.remove(mergedCreditCard);
    }
}
