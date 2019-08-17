package com.glearning.empcrud.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table
public class Transaction {

    @EmbeddedId
    private TransactionId transactionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("fromAccountId")
    private Customer fromCustomer;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("toAccountId")
    private Customer toCustomer;

    @Column(name="amount")
    private double amount;

    private Transaction(){}

    public Transaction(Customer fromCustomer, Customer toCustomer){
        this.fromCustomer = fromCustomer;
        this.toCustomer = toCustomer;
    }

    public Customer getFromCustomer() {
        return fromCustomer;
    }

    public void setFromCustomer(Customer fromCustomer) {
        this.fromCustomer = fromCustomer;
    }

    public Customer getToCustomer() {
        return toCustomer;
    }

    public void setToCustomer(Customer toCustomer) {
        this.toCustomer = toCustomer;
    }

    public TransactionId getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(TransactionId transactionId) {
        this.transactionId = transactionId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Double.compare(that.amount, amount) == 0 &&
                Objects.equals(transactionId, that.transactionId) &&
                Objects.equals(fromCustomer, that.fromCustomer) &&
                Objects.equals(toCustomer, that.toCustomer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionId, fromCustomer, toCustomer, amount);
    }


}