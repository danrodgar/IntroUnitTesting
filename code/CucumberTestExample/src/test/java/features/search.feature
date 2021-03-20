Feature: Search
  Scenario: Search UAH degrees
    Given the user is located in the index page
    When the user enters studies section
    And the user clicks in the degree section
    Then the page with the degrees is show
