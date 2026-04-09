package com.sparta.steps;

import com.sparta.utils.ApiBuilder;
import com.sparta.pojos.ProductReview;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.*;
import io.restassured.response.Response;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ProductReviewSteps {

    private ProductReview requestBody;
    private Response response;

    @Given("I have valid product review details")
    public void i_have_valid_product_review_details() {
        requestBody = new ProductReview();
        requestBody.setName("John Doe");
        requestBody.setEmail("john@example.com");
        requestBody.setReview("Excellent product");
        requestBody.setRating(5);
        requestBody.setProduct_id(1);
    }

    @Given("I have incomplete product review details")
    public void i_have_incomplete_product_review_details() {
        requestBody = new ProductReview();
        requestBody.setName("John Doe");
        requestBody.setEmail(""); // invalid case
        requestBody.setReview("Good");
        requestBody.setRating(4);
        requestBody.setProduct_id(1);
    }

    @When("I send a POST request for product review")
    public void i_send_a_post_request_for_product_review() {
        response = ApiBuilder.postRequest(ApiBuilder.POST_PRODUCT_REVIEW, requestBody);
    }

    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(Integer expectedStatus) {
        assertThat(response.getStatusCode(), equalTo(expectedStatus));
    }

    @Then("the message should be {string}")
    public void the_message_should_be(String expectedMessage) {
        String actualMessage = response.jsonPath().getString("message");
        assertThat(actualMessage, equalTo(expectedMessage));
    }

    @Then("the message should contain {string}")
    public void the_message_should_contain(String expectedText) {
        String message = response.jsonPath().getString("message");
        assertThat(message.toLowerCase(), containsString(expectedText.toLowerCase()));
    }

}