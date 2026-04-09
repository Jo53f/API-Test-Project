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

    @Given("I send a put request for all brands")
    public void iSendAPutRequestForAllBrands() {
        response =
                RestAssured
                        .given()
                        .accept(ContentType.JSON)
                        .contentType(ContentType.JSON)
                        .spec(ApiBuilder.putBrandsList())
                        .when()
                        .put()
                        .then()
                        .log().all()
                        .extract().response();
    }

    @Then("the respons code should return 405")
    public void theResponsCodeShouldReturn() {
        MatcherAssert.assertThat(response.jsonPath().getString("responseCode"), Matchers.is("405"));
    }

    @And("I should get the response message This request method is not supported")
    public void iShouldGetTheResponseMessageThisRequestMethodIsNotSupported() {
        MatcherAssert.assertThat(response.jsonPath().getString("message"), Matchers.is("This request method is not supported."));
    }
}
