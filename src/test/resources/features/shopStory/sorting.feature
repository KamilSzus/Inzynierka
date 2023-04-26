@Sort
Feature: Sort product

  Scenario: Sorting product by name
    Given User is login on the main page
    And Click on dropdown list
    When Select "Name (Z to A)"
    Then All products should be sorted reverse alphabetical order

  Scenario: Sorting product by lowest price
    Given User is login on the main page
    And Click on dropdown list
    When Select "Price (low to high)"
    Then All products should be sorted by lowest price

  Scenario: Sorting product by highest price
    Given User is login on the main page
    And Click on dropdown list
    When Select "Price (high to low)"
    Then All products should be sorted by highest price

  Scenario: User changing sorting type then back to previous one
    Given User is login on the main page
    And Click on dropdown list
    And Select "Price (high to low)"
    When Select "Name (A to Z)"
    Then All products should be sorted alphabetical