@logout @smoke
Feature: As a user, I should be able to logout from the library app


  Scenario: Verify logout
    Given the user is on the login page
    When user login with valid credentials
    And user logged out
    Then verify user is on the login page