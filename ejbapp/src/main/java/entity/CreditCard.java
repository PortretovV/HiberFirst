package entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "credit_card", schema = "meeting_portal_2")
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_credit_card")
    private Integer id;

    @Column(name = "card_number")
    private String cardNumber;
//    private String userName;
//    private Date dateOfFinish;

    @Column(name = "security_code")
    private String securityCode;

    @Column(name = "summ_on_card")
    private int summ_on_card;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user")//, referencedColumnName = "id")
    private Person user;

    @OneToMany(mappedBy = "senderCard",
            cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Transaction> transactions = new ArrayList<>();;

    public CreditCard() {}

    public CreditCard(String cardNumber, String securityCode, int summ_on_card) {
        this.cardNumber = cardNumber;
        this.securityCode = securityCode;
        this.summ_on_card = summ_on_card;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

//    @Basic
//    @Column(name = "user_name")
//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//
//    @Basic
//    @Column(name = "date_of_finish")
//    @Temporal(TemporalType.DATE)
//    public Date getDateOfFinish() {
//        return dateOfFinish;
//    }
//
//    public void setDateOfFinish(Date dateOfFinish) {
//        this.dateOfFinish = dateOfFinish;
//    }


    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    public int getSumm_on_card() {
        return summ_on_card;
    }

    public void setSumm_on_card(int summ_on_card) {
        this.summ_on_card = summ_on_card;
    }

    public Person getUser() {
        return user;
    }

    public void setUser(Person user) {
        this.user = user;
    }


    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        CreditCard that = (CreditCard) o;
//
//        if (idCreditCard != that.idCreditCard) return false;
//        if (cardNumber != null ? !cardNumber.equals(that.cardNumber) : that.cardNumber != null) return false;
//        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
//        if (dateOfFinish != null ? !dateOfFinish.equals(that.dateOfFinish) : that.dateOfFinish != null) return false;
//        if (securityCode != null ? !securityCode.equals(that.securityCode) : that.securityCode != null) return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = idCreditCard;
//        result = 31 * result + (cardNumber != null ? cardNumber.hashCode() : 0);
//        result = 31 * result + (userName != null ? userName.hashCode() : 0);
//        result = 31 * result + (dateOfFinish != null ? dateOfFinish.hashCode() : 0);
//        result = 31 * result + (securityCode != null ? securityCode.hashCode() : 0);
//        return result;
//    }
}
