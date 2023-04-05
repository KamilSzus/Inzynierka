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
      | Product Name                      | Price |
      | Sauce Labs Backpack               | 29.99 |
      | Sauce Labs Bike Light             | 9.99  |
      | Sauce Labs Bolt T-Shirt           | 15.99 |
      | Sauce Labs Fleece Jacket          | 49.99 |
      | Sauce Labs Onesie                 | 7.99  |
      | Test.allTheThings() T-Shirt (Red) | 15.99 |