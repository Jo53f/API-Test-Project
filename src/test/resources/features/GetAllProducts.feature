
Feature: GetAllProducts


  Scenario: Retrieve all products successfully
    Given the API is available
    When I send a GET request to retrieve all products
    Then the response status should be 200
    And the response should contain a list of products