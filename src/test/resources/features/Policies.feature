Feature: As a user, I should be able to enable a policy

  @enable_policy
  Scenario Outline: Search Policies
    Given the user is on the login page
    When user login with valid credentials
    And user navigate to "policies" module to "Runtime Policies"
    And user search a "<policy>"
    And user enable to selected policy
    Then verify that searched "<policy>" is enabled

    Examples:
      | policy                        |
      | Sysdig Azure Threat Detection |