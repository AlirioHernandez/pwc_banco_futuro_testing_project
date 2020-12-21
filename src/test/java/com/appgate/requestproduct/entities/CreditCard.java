package com.appgate.requestproduct.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("credit_card")
public class CreditCard {
    @Id
    private Long id;
    private int customer_id;
    private String credit_card_type_id;
    private String credit_card_number;
    private String credit_card_balance;

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

    public String getCredit_card_type_id() {
        return credit_card_type_id;
    }

    public void setCredit_card_type_id(String credit_card_type_id) {
        this.credit_card_type_id = credit_card_type_id;
    }

    public String getCredit_card_number() {
        return credit_card_number;
    }

    public void setCredit_card_number(String credit_card_number) {
        this.credit_card_number = credit_card_number;
    }

    public String getCredit_card_balance() {
        return credit_card_balance;
    }

    public void setCredit_card_balance(String credit_card_balance) {
        this.credit_card_balance = credit_card_balance;
    }
}
