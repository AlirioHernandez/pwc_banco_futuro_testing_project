package com.appgate.requestproduct.logicStepdefinitions;

import com.appgate.requestproduct.entities.RequestProduct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

import static io.restassured.RestAssured.config;
import static io.restassured.RestAssured.given;

@Component
public class InRestServiceRequestProductLogic implements RequestProductLogic{

    @Value("${request-product.service}")
    String requestProductService;

    @Value("${request-product.context}")
    String requestProductContext;
    @Value("${request-product.services.add-product}")
    String addProduct;
    @Value("${request-product.services.delete-product}")
    String deleteProduct;
    @Value("${request-product.services.get-product-user}")
    String getDetailsProductUser;
    @Value("${request-product.services.get-detail-product-user}")
    String getProductsUser;

    @Override
    public void addProduct(RequestProduct requestProduct) {
        given().log().all()
                .baseUri(requestProductService).basePath(requestProductContext)
                .body(requestProduct)
                .when().post(addProduct);
    }

    @Override
    public void removeProduct(RequestProduct requestProduct) {
        given().log().all()
                .baseUri(requestProductService).basePath(requestProductContext)
                .body(requestProduct)
                .when().delete(deleteProduct);
    }

    @Override
    public void getDetailsProductOfUser(String product, String user) {
        given().log().all()
                .baseUri(requestProductService).basePath(requestProductContext).pathParam("product",product)
                .queryParams("user", user)
                .when().get(getDetailsProductUser).then().statusCode(200);
    }

    @Override
    public List<String> getProductsOfUser(String user) {
      return given().log().all()
                .baseUri(requestProductService).basePath(requestProductContext)
                .queryParams("user", user)
                .when().get(getProductsUser).jsonPath().getList("",String.class);

    }
}
