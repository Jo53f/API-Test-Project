package com.sparta.steps;

import com.sparta.utils.ApiBuilder;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

import java.util.HashMap;
import java.util.Map;

public class DeleteAccountSteps {

    private Response response;
    private Map<String, String> userDetails;
    private String email;
    private final String password = "Password123";

    @Given("I have a registered account")
    public void iHaveARegisteredAccount() {
        email = "rafid" + "hello"+ "@test.com";

        userDetails = new HashMap<>();
        userDetails.put("name", "Rafid Test");
        userDetails.put("email", email);
        userDetails.put("password", password);
        userDetails.put("title", "Mr");
        userDetails.put("birth_date", "10");
        userDetails.put("birth_month", "5");
        userDetails.put("birth_year", "2000");
        userDetails.put("firstname", "Rafid");
        userDetails.put("lastname", "Uddin");
        userDetails.put("company", "Sparta");
        userDetails.put("address1", "123 Test Street");
        userDetails.put("address2", "Flat 1");
        userDetails.put("country", "United Kingdom");
        userDetails.put("zipcode", "RM1 1AA");
        userDetails.put("state", "London");
        userDetails.put("city", "London");
        userDetails.put("mobile_number", "07123456789");

        RestAssured
                .given()
                .spec(ApiBuilder.signUp())
                .formParams(userDetails)
                .when()
                .post()
                .then()
                .extract()
                .response();
    }

    @When("I send a DELETE request to delete my account")
    public void iSendADeleteRequestToDeleteMyAccount() {
        response = RestAssured
                .given()
                .spec(ApiBuilder.deleteAccount())
                .formParam("email", email)
                .formParam("password", password)
                .when()
                .delete()
                .then()
                .extract()
                .response();

        response.prettyPrint();
    }

    @Then("the response status should be atleast {int}")
    public void theResponseStatusShouldBe(int expectedStatus) {
        int actualStatus = response.jsonPath().getInt("responseCode");
        MatcherAssert.assertThat(actualStatus, Matchers.is(expectedStatus));
    }

    @And("the account should be removed by the system")
    public void theAccountShouldBeRemovedByTheSystem() {
        String actualMessage = response.jsonPath().getString("message");
        MatcherAssert.assertThat(actualMessage, Matchers.is("Account deleted!"));
    }
}