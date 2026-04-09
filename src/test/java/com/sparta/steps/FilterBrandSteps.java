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

public class FilterBrandSteps {
    private static Response response;
    private static List<Map<String, Object>> polo;

    @BeforeAll
    public static void setup() {
        ApiBuilder.configure();
    }

    @Given("I get a list of all the brands")
    public void iGetAListOfAllTheBrands() {
        response =
                RestAssured
                        .given()
                        .accept(ContentType.JSON)
                        .contentType(ContentType.JSON)
                        .spec(ApiBuilder.getBrandsList())
                        .when()
                        .get()
                        .then()
                        .log().all()
                        .extract().response();
    }

    @And("I want to filter for the brand Polo")
    public void iWantToFilterForTheBrandPolo() {
        polo = response.jsonPath().getList("brands.findAll { it.brand == 'Polo' }");
    }

    @Then("I should receive a list of items IDs from the brand Polo")
    public void iShouldReceiveAListOfItemsIDsFromTheBrandPolo() {
        MatcherAssert.assertThat(polo.size(), Matchers.is(6));
    }

    @Given("I want to send a POST request for the brand POLO")
    public void iWantToSendAPOSTRequestForTheBrandPOLO() {
        response =
                RestAssured
                        .given()
                        .accept(ContentType.JSON)
                        .contentType(ContentType.JSON)
                        .spec(ApiBuilder.postBrandsList())
                        .when()
                        .post()
                        .then()
                        .log().all()
                        .extract().response();
    }

    @Then("I should get a response code of 405")
    public void iShouldGetAResponseCodeOf() {
        MatcherAssert.assertThat(response.jsonPath().getString("responseCode"), Matchers.is("405"));
    }

    @And("I should get the message This request is not supported")
    public void iShouldGetTheMessageThisRequestIsNotSupported() {
      MatcherAssert.assertThat(response.jsonPath().getString("message"), Matchers.is("This request method is not supported."));
    }
}
