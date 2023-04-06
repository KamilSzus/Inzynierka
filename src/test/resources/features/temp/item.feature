Feature: Item

  Scenario: Click on product image
    Given User is login on the main page

  Scenario: Click on product name
    Given User is login on the main page

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