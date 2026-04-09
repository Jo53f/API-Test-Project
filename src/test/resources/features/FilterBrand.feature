Feature: Select and Display Specific Brand of Products

  As a user
  I want to filter the products shown by brands selected

  @Happy
  Scenario: Send a GET request for the brand POLO
    Given I get a list of all the brands
    And I want to filter for the brand Polo
    Then I should receive a list of items IDs from the brand Polo

  @Sad
  Scenario: Send a POST request for the brand POLO
    Given I want to send a POST request for the brand POLO
    Then I should get a response code of 405
    And I should get the message This request is not supported