@us12 @completed @regression
Feature: As a user, I should be able to access to Contacts module.

  # bug
  Scenario:  verify user access to Contact module
    Given user on the dashboard page
    When the user clicks the "Contact" module
    Then verify the page title is "Contacts - Trycloud QA"


 # Scenario Outline:
  #  Given user use username "<username>" and passcode "<password>"
  #  When the user clicks the "Contact" module
  #   Then verify the page title is "Contacts - Trycloud QA"

  #  Examples:
    #  | username | password    |
    #  | user7    | Userpass123 |
    #  | user34   | Userpass123 |
    #  | user99   | Userpass123 |
