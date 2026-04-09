package com.sparta.utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import java.util.Map;
import java.util.ResourceBundle;

public class ApiBuilder {
    private static final ResourceBundle resource = ResourceBundle.getBundle("config");

    public static final String BASE_URI = resource.getString("automation.base_url");
    public static final String SEARCH_PATH = resource.getString("automation.post_search_product");

    public static RequestSpecification searchProductSpec(String productName) {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setBasePath(SEARCH_PATH)
                .setContentType("application/x-www-form-urlencoded")
                .addFormParam("search_product", productName)
                .addHeaders(Map.of("Accept", "*/*"))
                .build();
    }
}