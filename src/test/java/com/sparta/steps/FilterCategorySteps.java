package com.sparta.steps;

import com.sparta.utils.ApiBuilder;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

import java.util.List;
import java.util.Map;

public class FilterCategorySteps {
    private static Response response;
    private static List<Map<String, Object>> dress;

    @BeforeAll
    public static void setup() {
        ApiBuilder.configure();
    }

    @Given("I get a list of all the products")
    public void iGetAListOfAllTheProducts() {
        response =
                RestAssured
                        .given()
                        .accept(ContentType.JSON)
                        .contentType(ContentType.JSON)
                        .spec(ApiBuilder.getProductsList())
                        .when()
                        .get()
                        .then()
                        .log().all()
                        .extract().response();
    }

    @And("I want to filter for the Category Women Dress")
    public void iWantToFilterForTheCategoryDress() {
        dress = response.jsonPath().getList("products.findAll { it.category.category == 'Dress' && it.category.usertype.usertype == 'Women'  }");
    }

    @Then("I should receive a list of items from the Category Women Dress")
    public void iShouldReceiveAListOfItemsFromTheCategoryDress() {
        MatcherAssert.assertThat(dress.size(), Matchers.is(3));
    }

    @Given("I want to send a POST request for the Category Women Dress")
    public void iWantToSendAPOSTRequestForTheCategoryWomenDress() {
        response =
                RestAssured
                        .given()
                        .accept(ContentType.JSON)
                        .contentType(ContentType.JSON)
                        .spec(ApiBuilder.postProductsList())
                        .when()
                        .post()
                        .then()
                        .log().all()
                        .extract().response();
    }

    @Then("I should get a response code of 405 as a result")
    public void iShouldGetAResponseCodeOfAsAResult() {
        MatcherAssert.assertThat(response.jsonPath().getString("responseCode"), Matchers.is("405"));
    }

    @And("I should get the message that This request is not supported")
    public void iShouldGetTheMessageThatThisRequestIsNotSupported() {
        MatcherAssert.assertThat(response.jsonPath().getString("message"), Matchers.is("This request method is not supported."));
    }
}
