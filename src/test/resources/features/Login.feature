@login @smoke
Feature:As a user, I should be able to login

  Background:
    Given the user is on the login page


   @positive
  Scenario Outline: verify login
    When user login with valid "<email>" and enter "<password>"
    Then verify user logged in the page

    Examples:
      | email                    | password   |
      | buyukgozebetul@gmail.com | 4413040Zb. |


   @negative
  Scenario Outline: Enter with invalid credentials
    Given the user is on the login page
    When Users login with invalid "<email>" and "<password>"
    Then Error "<message>" display
    Examples:
      | email                    | password   | message                                     |
      | buyukgozebetul@gmail.com | ABC123     | Credentials are not valid                   |
      | email@email              | 4413040Zb. | Credentials are not valid                   |
      | ABC                      |            | Please include an '@' in the email address. |
      |                          | c4vlSAqZ   | Please fill out this field.                 |
      | student91@library        |            | Please fill out this field.                 |
      |                          |            | Please fill out this field.                 |