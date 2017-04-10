package entity;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "credit_card", schema = "meeting_portal")
public class CreditCard {
    private int idCreditCard;
    private String cardNumber;
    private String userName;
    private Date dateOfFinish;
    private String securityCode;
    private int summ_on_card;

    @Id
    @Column(name = "id_credit_card")
    public int getIdCreditCard() {
        return idCreditCard;
    }

    public void setIdCreditCard(int idCreditCard) {
        this.idCreditCard = idCreditCard;
    }

    @Basic
    @Column(name = "card_number")
    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Basic
    @Column(name = "user_name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "date_of_finish")
    public Date getDateOfFinish() {
        return dateOfFinish;
    }

    public void setDateOfFinish(Date dateOfFinish) {
        this.dateOfFinish = dateOfFinish;
    }

    @Basic
    @Column(name = "security_code")
    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CreditCard that = (CreditCard) o;

        if (idCreditCard != that.idCreditCard) return false;
        if (cardNumber != null ? !cardNumber.equals(that.cardNumber) : that.cardNumber != null) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (dateOfFinish != null ? !dateOfFinish.equals(that.dateOfFinish) : that.dateOfFinish != null) return false;
        if (securityCode != null ? !securityCode.equals(that.securityCode) : that.securityCode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCreditCard;
        result = 31 * result + (cardNumber != null ? cardNumber.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (dateOfFinish != null ? dateOfFinish.hashCode() : 0);
        result = 31 * result + (securityCode != null ? securityCode.hashCode() : 0);
        return result;
    }
}
