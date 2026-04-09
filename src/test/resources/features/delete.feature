Feature: Delete User Account

  @Happy
  Scenario: Successful account deletion (Happy Path)
    Given I have a registered account
    When I send a DELETE request to delete my account
    Then the response status should be atleast 200
    And the account should be removed by the system