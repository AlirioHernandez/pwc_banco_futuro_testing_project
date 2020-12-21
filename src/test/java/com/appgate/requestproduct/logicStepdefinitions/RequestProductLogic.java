package com.appgate.requestproduct.logicStepdefinitions;

import com.appgate.requestproduct.entities.RequestProduct;

import java.util.List;

public interface RequestProductLogic {

    void addProduct(RequestProduct requestProduct);
    void removeProduct(RequestProduct requestProduct);
    void getDetailsProductOfUser(String product, String user);
    List<String> getProductsOfUser(String user);
}
