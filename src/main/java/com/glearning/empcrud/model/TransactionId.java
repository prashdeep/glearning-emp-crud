package com.glearning.empcrud.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TransactionId implements Serializable {

    @Column(name="from_account_id")
    private long fromAccountId;

    @Column(name="to_account_id")
    private long toAccountId;

    private TransactionId(){}

    public TransactionId(long fromAccountId, long toAccountId){
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
    }

    public long getFromAccountId() {
        return fromAccountId;
    }

    public long getToAccountId() {
        return toAccountId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionId that = (TransactionId) o;
        return fromAccountId == that.fromAccountId &&
                toAccountId == that.toAccountId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fromAccountId, toAccountId);
    }
}