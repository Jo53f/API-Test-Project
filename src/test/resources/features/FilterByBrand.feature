Feature: Filter Products By Brand

  As a user
  I want to search filter a product by brand
  so that it shows me list of the updated products list

  Scenario: Filter products by brand
    Given products exist for a specific brand
    When I filter products by that brand
    Then the response status should be 200
    And the response should contain a list of products from that brand
