package com.sparta.utils;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.parsing.Parser;
import io.restassured.specification.RequestSpecification;

import java.util.Map;
import java.util.ResourceBundle;

public class ApiBuilder {
    public static final ResourceBundle resource = ResourceBundle.getBundle("config");
    public static final String BASE_URI = resource.getString("automation.base_url");

    public static final String GET_PRODUCTS_LIST = resource.getString("automation.get_products_list");
    public static final String GET_BRANDS_LIST = resource.getString("automation.get_brands_list");
    public static final String GET_USER = resource.getString("automation.get_user_acc_email");

    public static final String POST_ALL_PRODUCTS = resource.getString("automation.post_all_products");
    public static final String POST_SEARCH_PRODUCT = resource.getString("automation.post_search_product");
    public static final String POST_VERIFY_LOGIN = resource.getString("automation.post_verify_login");
    public static final String POST_CREATE_ACCOUNT = resource.getString("automation.post_create_account");
    public static final String POST_BRANDS_LIST = resource.getString("automation.post_brands_list");

    public static final String PUT_ALL_BRANDS = resource.getString("automation.put_all_brands");
    public static final String PUT_UPDATE_ACCOUNT = resource.getString("automation.put_update_account");

    public static final String DELETE_VERIFY_LOGIN = resource.getString("automation.delete_verify_login");
    public static final String DELETE_ACCOUNT = resource.getString("automation.delete_account");

    private static RequestSpecBuilder getBaseSpecBuilder(String path) {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setBasePath(path)
                .addHeaders(Map.of(
                        "Accept", "*/*"
                ));
    }
    public static RequestSpecification verifyLogin() {
        return getBaseSpecBuilder(POST_VERIFY_LOGIN)
                .build();
    }

    public static RequestSpecification signUp() {
        return getBaseSpecBuilder(POST_CREATE_ACCOUNT)
                .build();
    }
      
    public static RequestSpecification getProductsList() {
        return getBaseSpecBuilder(GET_PRODUCTS_LIST)
                .build();
    }

    public static RequestSpecification deleteAccount() {
        return getBaseSpecBuilder(DELETE_ACCOUNT)
                .build();
    }

    public static RequestSpecification postProductsList() {
        return getBaseSpecBuilder(POST_ALL_PRODUCTS)
                .build();
    }

    public static RequestSpecification getBrandsList() {
        return getBaseSpecBuilder(GET_BRANDS_LIST)
                .build();
    }

    public static RequestSpecification putBrandsList() {
        return getBaseSpecBuilder(PUT_ALL_BRANDS)
                .build();
    }

    public static RequestSpecification postBrandsList() {
        return getBaseSpecBuilder(POST_BRANDS_LIST)
                .build();
    }


    public static void configure() {
        // Treat text/html responses as JSON
        RestAssured.registerParser("text/html", Parser.JSON);
    }
}
