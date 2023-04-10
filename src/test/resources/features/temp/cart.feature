Feature: Cart

  Scenario: User add all products to cart
    Given User is login on the main page
    When User adding all products to cart
    Then User click on cart icon
    And All products should be in cart
    And Number of products should be visible on cart icon

  Scenario: User add product to cart from main page page
    Given User is login on the main page
    When User add "Sauce Labs Backpack" to cart from main page
    Then User click on cart icon
    And Cart should contains "Sauce Labs Backpack"

  Scenario: User add product to cart from product details page
    Given User is login on the main page
    When Click on "Sauce Labs Backpack"
    And User add "Sauce Labs Backpack" to cart from product details page
    And Back to all products
    Then User click on cart icon
    And Cart should contains "Sauce Labs Backpack"

  Scenario: User add product to cart then delete it from main page
    Given User is login on the main page
    When User add "Sauce Labs Backpack" to cart from main page
    And User delete this product from cart using button in main page
    Then User click on cart icon
    Then Cart should be empty

  Scenario: User add product to cart from product details page then delete it from main page
    Given User is login on the main page
    When Click on "Sauce Labs Backpack"
    And User add "Sauce Labs Backpack" to cart from product details page
    And Back to all products
    And User delete this product from cart using button in main page
    Then User click on cart icon
    Then Cart should be empty

  Scenario: User add product to cart from main page then delete it from product details page
    Given User is login on the main page
    When Click on "Sauce Labs Backpack"
    And User add "Sauce Labs Backpack" to cart from product details page
    And User delete this product from cart using button in product details page
    Then User click on cart icon
    Then Cart should be empty

  Scenario: User add product A from main page then add product B from details page
    Given User is login on the main page
    When User add "Sauce Labs Backpack" to cart from main page
    And Click on "Sauce Labs Bike Light"
    And User add "Sauce Labs Bike Light" to cart from product details page
    Then User click on cart icon
    And Cart should contains "Sauce Labs Backpack"
    And Cart should contains "Sauce Labs Bike Light"
