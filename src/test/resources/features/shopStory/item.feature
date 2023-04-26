@Item
Feature: Item

  Scenario: Click on product image
    Given User is login on the main page
    When Click on image of "Sauce Labs Backpack"
    Then All data included "Sauce Labs Backpack" should be the same as on main page

  Scenario: Click on product name
    Given User is login on the main page
    When Click on "Sauce Labs Backpack"
    Then All data included "Sauce Labs Backpack" should be the same as on main page

  Scenario Outline: Opened product should contain the same data
    Given User is login on the main page
    When Click on "<Product Name>"
    Then All data included "<Product Name>" should be the same as on main page
    Examples:
      | Product Name                      |
      | Sauce Labs Backpack               |
      | Sauce Labs Bike Light             |
      | Sauce Labs Bolt T-Shirt           |
      | Sauce Labs Fleece Jacket          |
      | Sauce Labs Onesie                 |
      | Test.allTheThings() T-Shirt (Red) |

  Scenario: User open product A then back and open product B
    Given User is login on the main page
    When Click on "Sauce Labs Backpack"
    And All data included "Sauce Labs Backpack" should be the same as on main page
    And Back to all products
    And Click on "Sauce Labs Onesie"
    Then All data included "Sauce Labs Onesie" should be the same as on main page