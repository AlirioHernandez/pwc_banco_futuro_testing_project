package com.appgate.requestproduct.repositories;

import com.appgate.requestproduct.entities.CreditCard;
import com.appgate.requestproduct.entities.Customer;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CreditCardsRepository extends CrudRepository<CreditCard, Long> {

    @Query("insert into credit_card (customer_id,credit_card_type_id,credit_card_number,credit_card_balance) values(select customer_id from customers where name=:name," +
            "select credit_card_type_id from credit_card_type where credit_card_type=:credit_card_type,':credit_card_number',':credit_card_balance')")
    void saveWithCustomerName(@Param("name") String name, @Param("credit_card_type") String credit_card_type, @Param("credit_card_number") String credit_card_number,
                              @Param("credit_card_balance") String credit_card_balance);
}
