package com.appgate.requestproduct.entities;

public class RequestProduct {
    private String client;
    private String product;
    private String type;

    public RequestProduct(String client, String product, String type) {
        this.client = client;
        this.product = product;
        this.type = type;
    }

    public RequestProduct() {
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
