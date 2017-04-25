package entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by VP on 25.04.2017.
 */
@Entity
@Table(name = "transaction", schema = "meeting_portal_2")
public class Transaction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transaction")
    private Integer id;

    @Column(name = "sum")
    private int sum;

    @ManyToOne
    @JoinColumn(name = "senderCard")
    private CreditCard senderCard;

    @ManyToOne
    @JoinColumn(name = "receiverCard")
    private CreditCard receiverCard;

    public Transaction() {}

    public Transaction(int sum) {
        this.sum = sum;
    }

    public Transaction(int sum, CreditCard senderCard, CreditCard receiverCard) {
        this.sum = sum;
        this.senderCard = senderCard;
        this.receiverCard = receiverCard;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public CreditCard getSenderCard() {
        return senderCard;
    }

    public void setSenderCard(CreditCard senderCard) {
        this.senderCard = senderCard;
    }

    public CreditCard getReceiverCard() {
        return receiverCard;
    }

    public void setReceiverCard(CreditCard receiverCard) {
        this.receiverCard = receiverCard;
    }
}
