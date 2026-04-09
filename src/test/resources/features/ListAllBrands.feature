Feature: List All Brands

  As a user
  I want to see a list of all available brands

  @Happy
  Scenario: Send a GET request for all brands
    Given I send a get request for all brands
    Then the response code for the request should be correct
    And I should get a list of all the brands

  @Sad
  Scenario: Send a PUT request for all brands
    Given I send a put request for all brands
    Then the respons code should return 405
    And I should get the response message This request method is not supported