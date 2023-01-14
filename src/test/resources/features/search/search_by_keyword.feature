Feature: Search by keyword

  Scenario: Searching for a term
    Given Open shop page
    When she looks up "Cucumber"
    Then she should see information about "Cucumber"

