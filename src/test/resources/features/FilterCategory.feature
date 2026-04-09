Feature: Select and Display Specific Category of Products

  As a user
  I want to filter the products shown by Category selected

  Scenario: Send a GET request for the Category WOMEN DRESS
    Given I get a list of all the products
    And I want to filter for the Category Women Dress
    Then I should receive a list of items from the Category Women Dress

  @Sad
  Scenario: Send a POST request for the Category WOMEN DRESS
    Given I want to send a POST request for the Category Women Dress
    Then I should get a response code of 405 as a result
    And I should get the message that This request is not supported