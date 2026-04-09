Feature: Product Search API
  As a user, I want to search for products by keyword so that I can quickly find the exact product I’m looking for.

  Scenario Outline: Successfully search for products with a valid keyword
    Given the API is available for searching
    When I search for products using the keyword "<keyword>"
    Then the HTTP status code should be 200
    And the response should contain products related to "<keyword>"

    Examples:
      | keyword    |
      | Tshirt     |
      | Jean       |

  Scenario: Search with a keyword that matches no products
    Given the API is available for searching
    When I search for products using the keyword "NonExistentProduct123"
    Then the HTTP status code should be 200
    And the response should return an empty product list