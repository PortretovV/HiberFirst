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
    private double sum;

    @Column(name = "confirmed")
    private boolean confirmed;

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

    public Transaction(double sum, boolean confirmed, CreditCard senderCard, CreditCard receiverCard) {
        this.sum = sum;
        this.confirmed = confirmed;
        this.senderCard = senderCard;
        this.receiverCard = receiverCard;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
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
