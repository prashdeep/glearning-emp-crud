package com.glearning.empcrud.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @OneToMany(mappedBy = "fromCustomer")
    private Set<Transaction> transactionSet = new HashSet<>();

   @OneToMany(mappedBy = "toCustomer")
    private Set<Transaction> tpTransactionSet = new HashSet<>();


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Transaction> getTransactionSet() {
        return transactionSet;
    }

    public void setTransactionSet(Set<Transaction> transactionSet) {
        this.transactionSet = transactionSet;
    }

    public void doTransaction(Transaction transaction, Customer toCustomer){
        this.getTransactionSet().add(transaction);
        transaction.setFromCustomer(this);
        transaction.setToCustomer(toCustomer);
    }

    public Set<Transaction> getTpTransactionSet() {
        return tpTransactionSet;
    }

    public void setTpTransactionSet(Set<Transaction> tpTransactionSet) {
        this.tpTransactionSet = tpTransactionSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id &&
                Objects.equals(name, customer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}