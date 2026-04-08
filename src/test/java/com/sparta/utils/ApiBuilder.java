package com.sparta.utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import java.util.Map;
import java.util.ResourceBundle;

public class ApiBuilder {
    public static final ResourceBundle resource = ResourceBundle.getBundle("config");
    public static final String BASE_URI = resource.getString("automation.base_url");

    public static final String GET_BRANDS_LIST = resource.getString("automation.get_brands_list");
    public static final String GET_USER = resource.getString("automation.get_user_acc_email");

    public static final String POST_ALL_PRODUCTS = resource.getString("/productsList");
    public static final String POST_SEARCH_PRODUCT = resource.getString("/searchProduct");
    public static final String POST_VERIFY_LOGIN = resource.getString("/verifyLogin");
    public static final String POST_CREATE_ACCOUNT = resource.getString("/createAccount");

    public static final String PUT_ALL_BRANDS = resource.getString("/brandsList");
    public static final String PUT_UPDATE_ACCOUNT = resource.getString("/updateAccount");

    public static final String DELETE_VERIFY_LOGIN = resource.getString("/verifyLogin");
    public static final String DELETE_ACCOUNT = resource.getString("/deleteAccount");

    private static RequestSpecBuilder getBaseSpecBuilder(String path) {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setBasePath(path)
                .addHeaders(Map.of(
                        "Accept", "*/*"
                ));
    }

    public static RequestSpecification getBrandsList() {
        return getBaseSpecBuilder(GET_BRANDS_LIST)
                .build();
    }

    public static RequestSpecification putBrandsList() {
        return getBaseSpecBuilder(PUT_ALL_BRANDS)
                .build();
    }

    public static RequestSpecification postSearchProduct() {
        return getBaseSpecBuilder(POST_SEARCH_PRODUCT)
                .build();
    }
}
