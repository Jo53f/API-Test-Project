Feature: User Registration

  @Happy
  Scenario: Successful account creation (Happy Path)
    Given I provide valid user details
    When I send a POST request to create an account
    Then the response status should be Good 201
    And the account should be created successfully

  @Sad
  Scenario: Duplicate account registration (Sad Path)
    Given an account already exists with the email
    When I attempt to register with the same email
    Then the response status should be bad 400
    And I should see a "Email already exists!" message