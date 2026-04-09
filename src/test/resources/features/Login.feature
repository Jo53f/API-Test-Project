Feature: User Login

  @Happy
  Scenario: Verify login with valid details (Happy Path)
    Given I have a registered account to login
    When I submit valid email and password
    Then the login response status should be 200
    And I should receive a login success message

  @Sad
  Scenario: Verify login with invalid details (Sad Path)
    Given I have a registered account to login
    When I submit invalid email or password
    Then the login response status should be 404
    And I should see an "User not found!" message