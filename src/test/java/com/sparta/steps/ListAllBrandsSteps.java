package com.sparta.steps;

import com.sparta.pojobrands.Brands;
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

public class ListAllBrandsSteps {
    private static Response response;
    private static Brands brands;

    @BeforeAll
    public static void setup() {
        ApiBuilder.configure();
    }

    @Given("I send a get request for all brands")
    public void iSendAGetRequestForAllBrands() {
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
        brands = response.as(Brands.class);
    }

    @Then("the response code for the request should be correct")
    public void iTheResponseCodeForTheRequestShouldBeCorrect() {
        MatcherAssert.assertThat(response.getStatusCode(), Matchers.is(200));
    }

    @And("I should get a list of all the brands")
    public void iShouldGetAListOfAllTheBrands() {
        MatcherAssert.assertThat(brands.getBrands().size(), Matchers.is(34));
    }
}
