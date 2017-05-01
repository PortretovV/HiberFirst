package entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "credit_card", schema = "meeting_portal_2")
@NamedQuery(name = "CreditCard.findByCardNumber", query = "select c from CreditCard c left join fetch c.transactions t where c.cardNumber = :cardNumber")
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_credit_card")
    private Integer id;

    @Column(name = "card_number")
    private String cardNumber;
//    private String userName;
//    @Column(name = "date_of_finish")
//    @Temporal(TemporalType.DATE)
//    private Date dateOfFinish;

    @Column(name = "security_code")
    private String securityCode;

    @Column(name = "summ_on_card")
    private double summ_on_card;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user")//, referencedColumnName = "id")
    private Person user;

    @OneToMany(mappedBy = "senderCard",
            cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Transaction> transactions = new ArrayList<>();

    @OneToMany(mappedBy = "receiverCard",
            cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Transaction> transactions1 = new ArrayList<>();

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
//
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

    public double getSumm_on_card() {
        return summ_on_card;
    }

    public void setSumm_on_card(double summ_on_card) {
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

    public List<Transaction> getTransactions1() {
        return transactions1;
    }

    public void setTransactions1(List<Transaction> transactions1) {
        this.transactions1 = transactions1;
    }


}
