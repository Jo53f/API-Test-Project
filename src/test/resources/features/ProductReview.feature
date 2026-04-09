Feature: Product Review API

  Scenario: Submit a product review successfully
    Given I have valid product review details
    When I send a POST request for product review
    Then the response status code should be 200
    And the message should be "Thank you for your review."

  Scenario: Fail to submit product review due to missing fields
    Given I have incomplete product review details
    When I send a POST request for product review
    Then the response status code should be 400
    And the message should contain "required"