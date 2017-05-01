package dao.Impl;

import dao.CreditCardDao;
import entity.CreditCard;
import entity.Person;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by VP on 25.04.2017.
 */

@Stateless
public class CreditCardDaoImpl implements CreditCardDao {

    @PersistenceContext(unitName = "MEETING_PLACE")
    EntityManager em;

    @Override
    public CreditCard findByCardNumber(String cardNumber) {
        TypedQuery<CreditCard> query = em.createNamedQuery("CreditCard.findByCardNumber",CreditCard.class);
        query.setParameter("cardNumber",cardNumber);
        return query.getSingleResult();
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
