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

public class LoginSteps {

    private Response response;
    private final String email = "test@tester6976.com";
    private final String password = "password123";

    @Given("I have a registered account to login")
    public void iHaveARegisteredAccountToLogin() {
        // Nothing needed now since account already exists
    }

    @When("I submit valid email and password")
    public void iSubmitValidEmailAndPassword() {
        response = RestAssured
                .given()
                .spec(ApiBuilder.verifyLogin())
                .formParam("email", email)
                .formParam("password", password)
                .when()
                .post()
                .then()
                .extract()
                .response();

        response.prettyPrint(); // helpful for debugging
    }

    @Then("the login response status should be {int}")
    public void theLoginResponseStatusShouldBe(int expectedStatus) {
        int actualStatus = response.jsonPath().getInt("responseCode");
        MatcherAssert.assertThat(actualStatus, Matchers.is(expectedStatus));
    }

    @And("I should receive a login success message")
    public void iShouldReceiveALoginSuccessMessage() {
        String actualMessage = response.jsonPath().getString("message");
        MatcherAssert.assertThat(actualMessage, Matchers.is("User exists!"));
    }

    @When("I submit invalid email or password")
    public void iSubmitInvalidEmailOrPassword() {
        response = RestAssured
                .given()
                .spec(ApiBuilder.verifyLogin())
                .formParam("email", email)
                .formParam("password", "wrongpassword")
                .when()
                .post()
                .then()
                .extract()
                .response();

        response.prettyPrint();
    }

    @And("I should see an {string} message")
    public void iShouldSeeAnMessage(String expectedMessage) {
        String actualMessage = response.jsonPath().getString("message");
        MatcherAssert.assertThat(actualMessage, Matchers.is(expectedMessage));
    }
}