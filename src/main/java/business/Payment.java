/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import business.enumaration.EnumPaymentStatus;
import business.enumaration.EnumPaymentMethod;
import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 *
 * @author phatn
 */
@Entity
public class Payment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String transactionNo;
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private EnumPaymentMethod method;

    @Enumerated(EnumType.STRING)
    private EnumPaymentStatus status;

    private LocalDateTime paidAt;

    public Payment() {
    }

    public Payment(int id, String transactionNo, BigDecimal amount,
                   EnumPaymentMethod method, EnumPaymentStatus status,
                   LocalDateTime paidAt) {

        this.id = id;
        this.transactionNo = transactionNo;
        this.amount = amount;
        this.method = method;
        this.status = status;
        this.paidAt = paidAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTransactionNo() {
        return transactionNo;
    }

    public void setTransactionNo(String transactionNo) {
        this.transactionNo = transactionNo;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public EnumPaymentMethod getMethod() {
        return method;
    }

    public void setMethod(EnumPaymentMethod method) {
        this.method = method;
    }

    public EnumPaymentStatus getStatus() {
        return status;
    }

    public void setStatus(EnumPaymentStatus status) {
        this.status = status;
    }

    public LocalDateTime getPaidAt() {
        return paidAt;
    }

    public void setPaidAt(LocalDateTime paidAt) {
        this.paidAt = paidAt;
    }

    @Override
    public int hashCode() {
        return (int) id;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Payment)) {
            return false;
        }

        Payment other = (Payment) object;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "entity.Payment[ id=" + id + " ]";
    }
}
