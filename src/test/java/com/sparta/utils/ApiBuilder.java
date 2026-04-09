package com.sparta.utils;

import com.sparta.pojos.ProductReview;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;
import java.util.ResourceBundle;

public class ApiBuilder {

    public static final ResourceBundle resource = ResourceBundle.getBundle("config");

    // Base URI
    public static final String BASE_URI = resource.getString("automation.base_url");

    // GET endpoints
    public static final String GET_PRODUCTS_LIST = resource.getString("automation.get_products_list");
    public static final String GET_BRANDS_LIST = resource.getString("automation.get_brands_list");
    public static final String GET_USER = resource.getString("automation.get_user_acc_email");

    // POST endpoints
    public static final String POST_ALL_PRODUCTS = resource.getString("automation.post_all_products");
    public static final String POST_SEARCH_PRODUCT = resource.getString("automation.post_search_product");
    public static final String POST_VERIFY_LOGIN = resource.getString("automation.post_verify_login");
    public static final String POST_CREATE_ACCOUNT = resource.getString("automation.post_create_account");
    public static final String POST_PRODUCT_REVIEW = resource.getString("automation.post_product_review");

    // PUT endpoints
    public static final String PUT_ALL_BRANDS = resource.getString("automation.put_all_brands");
    public static final String PUT_UPDATE_ACCOUNT = resource.getString("automation.put_update_account");

    // DELETE endpoints
    public static final String DELETE_VERIFY_LOGIN = resource.getString("automation.delete_verify_login");
    public static final String DELETE_ACCOUNT = resource.getString("automation.delete_account");

    private static RequestSpecification getBaseRequest() {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setContentType(ContentType.JSON)
                .addHeaders(Map.of(
                        "Accept", "*/*"
                ))
                .build();
    }

    public static Response getRequest(String endpoint) {
        return RestAssured
                .given()
                .spec(getBaseRequest())
                .log().all()
                .when()
                .get(endpoint)
                .then()
                .log().all()
                .extract()
                .response();
    }

    public static Response postRequest(String endpoint, ProductReview requestBody) {
        return RestAssured
                .given()
                .baseUri(BASE_URI)
                .contentType("application/x-www-form-urlencoded")
                .formParam("name", requestBody.getName())
                .formParam("email", requestBody.getEmail())
                .formParam("review", requestBody.getReview())
                .formParam("rating", requestBody.getRating())
                .formParam("product_id", requestBody.getProduct_id())
                .log().all()
                .when()
                .post(endpoint)
                .then()
                .log().all()
                .extract()
                .response();
    }
    }
