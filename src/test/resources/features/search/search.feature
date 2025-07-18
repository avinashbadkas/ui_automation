Feature: Search

  Background:
    Given navigate to the application url

  @search @regression
  Scenario Outline:
    And user search the "<keyword>" on the homepage
    Then user verify the search screen for the "<keyword>"

    Examples:
      | keyword |
      | market place                  |