Feature: Payment

  Scenario: User add product to cart then try buy it without passing first name
    Given User is login on the main page
    When User add "Sauce Labs Backpack" to cart from main page
    And User click on cart icon
    When User click on checkout button in cart page
    And User click on continue button
    Then User should see this error "Error: First Name is required"

  Scenario: User add product to cart then try buy it without passing last name
    Given User is login on the main page
    When User add "Sauce Labs Backpack" to cart from main page
    And User click on cart icon
    And User click on checkout button in cart page
    And User insert own name "Edward"
    And User click on continue button
    Then User should see this error "Error: Last Name is required"

  Scenario: User add product to cart then try buy it without passing Zip/postal code
    Given User is login on the main page
    When User add "Sauce Labs Backpack" to cart from main page
    And User click on cart icon
    And User click on checkout button in cart page
    And User insert own name "Edward"
    And User insert own last name "Stark"
    And User click on continue button
    Then User should see this error "Error: Postal Code is required"

  Scenario: User add product and pass all required data
    Given User is login on the main page
    When User add "Sauce Labs Backpack" to cart from main page
    And User click on cart icon
    And User click on checkout button in cart page
    And Insert own data Name: "Test", Last Name: "Test", Postal: "32-123"
    And User click on continue button
    Then Checkout: Overview should contain "Sauce Labs Backpack"
    And Price of product should be correctly displayed

  Scenario: User add multiple products and pass all required data
    Given User is login on the main page
    When User adding all products to cart
    And User click on cart icon
    And User click on checkout button in cart page
    And Insert own data Name: "Test", Last Name: "Test", Postal: "32-123"
    And User click on continue button
    Then Checkout: Overview should contain all products
    And Price of product should be correctly displayed

    Scenario: User successfully buy product
      Given User is login on the main page
      When User add "Sauce Labs Backpack" to cart from main page
      And User click on cart icon
      And User click on checkout button in cart page
      And Insert own data Name: "Test", Last Name: "Test", Postal: "32-123"
      And User click on continue button
      And Click on finish button
      Then User should see information about completing order
