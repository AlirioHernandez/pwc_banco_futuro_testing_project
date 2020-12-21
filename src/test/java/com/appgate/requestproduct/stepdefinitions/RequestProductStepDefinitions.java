package com.appgate.requestproduct.stepdefinitions;

import com.appgate.requestproduct.logicStepdefinitions.RequestProductLogic;
import com.appgate.requestproduct.entities.Customer;
import com.appgate.requestproduct.entities.CustomerInfo;
import com.appgate.requestproduct.entities.RequestProduct;
import com.appgate.requestproduct.repositories.AccountsRepository;
import com.appgate.requestproduct.repositories.CreditCardsRepository;
import com.appgate.requestproduct.repositories.CustomerRepository;
import io.cucumber.datatable.DataTable;
import io.cucumber.java8.En;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class RequestProductStepDefinitions implements En {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    AccountsRepository accountsRepository;

    @Autowired
    CreditCardsRepository creditCardsRepository;

    @Autowired
    RequestProductLogic requestProductLogic;

    public RequestProductStepDefinitions() {
        Given("^tha bank has clients$", (DataTable dataTable) -> {
            List<CustomerInfo> customerInfoList = dataTable.asList(CustomerInfo.class);
            customerInfoList.stream().forEach(c -> {
                customerRepository.save(new Customer(c.getIdentityCard(), c.getName()));
                c.getProducts().forEach(p -> {
                    storeProduct(c.getName(), p);
                });
            });
        });
        Then("^the bank should assign a \"([^\"]*)\" to client \"([^\"]*)\"$", (String product, String client) -> {
            requestProductLogic.getDetailsProductOfUser(product, client);

        });
        And("^\"([^\"]*)\" should have the following products$", (String client, DataTable dataTable) -> {
            List<String> expected = dataTable.asList(String.class);
            List<String> actual = requestProductLogic.getProductsOfUser(client);
            Assert.assertEquals(actual, containsInAnyOrder(expected));
        });
        When("^the client \"([^\"]*)\" request a \"([^\"]*)\" type \"([^\"]*)\"$", (String client, String product, String type) -> {
            requestProductLogic.addProduct(new RequestProduct(client, product, type));
        });
        When("^the client \"([^\"]*)\" request the cancellation of a \"([^\"]*)\" type \"([^\"]*)\"$", (String client, String product, String type) -> {
            requestProductLogic.removeProduct(new RequestProduct(client, product, type));

        });
    }

    public void storeProduct(String customer, String productType) {
        switch (productType) {
            case "savings account":
            case "current account":
                accountsRepository.saveWithCustomerName(customer, productType, "" + UUID.randomUUID(), "0");
                break;
            case "credit card":
                creditCardsRepository.saveWithCustomerName(customer, productType, "" + UUID.randomUUID(), "0");
                break;
            default:
                Assert.fail("product doesn't exist");

        }
    }


}
