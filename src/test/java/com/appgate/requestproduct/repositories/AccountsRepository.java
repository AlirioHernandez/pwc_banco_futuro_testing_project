package com.appgate.requestproduct.repositories;

import com.appgate.requestproduct.entities.Account;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AccountsRepository extends CrudRepository<Account, Long> {


    @Query("insert into accounts (customer_id,account_type_id,account_number,account_balance) values(select customer_id from customers where name=:name," +
            "select account_type_id from account_type where account_type=:account_type,':account_number',':account_balance')")
    void saveWithCustomerName(@Param("name") String name,@Param("account_type") String account_type,@Param("account_number") String account_number,
                              @Param("account_balance") String account_balance);
}
