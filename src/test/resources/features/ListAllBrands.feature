Feature: List All Brands

  As a user
  I want to see a list of all available brands

  Scenario: Send a GET request for all brands
    Given I send a get request for all brands
    Then the response code for the request should be correct
    And I should get a list of all the brands