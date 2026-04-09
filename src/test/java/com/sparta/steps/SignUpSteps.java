package com.sparta.steps;

import com.sparta.utils.ApiBuilder;
import io.cucumber.java.PendingException;
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

public class SignUpSteps {

    private Response response;
    private Map<String, String> userDetails;
    private final String existingEmail = "existinguser12345@test.com";

    @Given("I provide valid user details")
    public void iProvideValidUserDetails() {
        userDetails = new HashMap<>();
        userDetails.put("name", "Rafid Test");
        userDetails.put("email", "rafid" + System.currentTimeMillis() + "@test.com");
        userDetails.put("password", "Password123");
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
    }

    @When("I send a POST request to create an account")
    public void iSendAPOSTRequestToCreateAnAccount() {
        response = RestAssured
                .given()
                .spec(ApiBuilder.signUp())
                .formParams(userDetails)
                .when()
                .post()
                .then()
                .extract()
                .response();
    }

    @Then("the response status should be bad {int}")
    public void theResponseStatusShouldBe(int expectedResponseCode) {
        int actualResponseCode = response.jsonPath().getInt("responseCode");
        MatcherAssert.assertThat(actualResponseCode, Matchers.is(expectedResponseCode));
    }

    @And("the account should be created successfully")
    public void theAccountShouldBeCreatedSuccessfully() {
        String message = response.jsonPath().getString("message");
        MatcherAssert.assertThat(message, Matchers.is("User created!"));
    }

    @Given("an account already exists with the email")
    public void anAccountAlreadyExistsWithTheEmail() {
        userDetails = new HashMap<>();
        userDetails.put("name", "Existing User");
        userDetails.put("email", existingEmail);
        userDetails.put("password", "Password123");
        userDetails.put("title", "Mr");
        userDetails.put("birth_date", "10");
        userDetails.put("birth_month", "5");
        userDetails.put("birth_year", "2000");
        userDetails.put("firstname", "Existing");
        userDetails.put("lastname", "User");
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
                .post();
    }

    @When("I attempt to register with the same email")
    public void iAttemptToRegisterWithTheSameEmail() {
        response = RestAssured
                .given()
                .spec(ApiBuilder.signUp())
                .formParams(userDetails)
                .when()
                .post()
                .then()
                .extract()
                .response();
    }

    @And("I should see a {string} message")
    public void iShouldSeeAMessage(String expectedMessage) {
        String actualMessage = response.jsonPath().getString("message");
        MatcherAssert.assertThat(actualMessage, Matchers.is(expectedMessage));
    }

    @Then("the response status should be Good {int}")
    public void theResponseStatusShouldBeGood(int arg0) {
        int actualResponseCode = response.jsonPath().getInt("responseCode");
        MatcherAssert.assertThat(actualResponseCode, Matchers.is(arg0));
    }
}