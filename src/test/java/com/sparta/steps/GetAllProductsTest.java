package com.sparta.steps;

import com.sparta.utils.ApiBuilder;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.Map;


public class GetAllProductsTest {

    private RequestSpecification request;
    private Response response;


    @Given("the API is available")
    public void theAPIIsAvailable() {
        request = RestAssured
                .given()
                .spec(ApiBuilder.getAllProducts());
    }

    @When("I send a GET request to retrieve all products")
    public void iSendAGETRequestToRetrieveAllProducts() {
        response = request
                .when()
                .get();
    }

    @Then("the response status should be {int}")
    public void theResponseStatusShouldBe(int statusCode) {
        Assertions.assertEquals(statusCode, response.getStatusCode());;
    }

    @And("the response should contain a list of products")
    public void theResponseShouldContainAListOfProducts() {
        List<Map<String, Object>> products = response.jsonPath().getList("products");
        Assertions.assertNotNull(products);
        Assertions.assertFalse(products.isEmpty(), "Product list is empty");
    }
}
