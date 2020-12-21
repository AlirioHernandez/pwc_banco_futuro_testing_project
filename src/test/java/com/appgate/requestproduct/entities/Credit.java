package com.appgate.requestproduct.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("credits")
public class Credit {

    @Id
    private Long id;
    private int customer_id;
    private String credit_type_id;
    private String credit_number;
    private String credit_balance;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getCredit_type_id() {
        return credit_type_id;
    }

    public void setCredit_type_id(String credit_type_id) {
        this.credit_type_id = credit_type_id;
    }

    public String getCredit_number() {
        return credit_number;
    }

    public void setCredit_number(String credit_number) {
        this.credit_number = credit_number;
    }

    public String getCredit_balance() {
        return credit_balance;
    }

    public void setCredit_balance(String credit_balance) {
        this.credit_balance = credit_balance;
    }
}
