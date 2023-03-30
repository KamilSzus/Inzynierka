Feature: Authentication

  Scenario: Login to the shop page
    Given User open the shop page
    When User insert correct credential and try login
    Then User should see main page

  Scenario: User pass incorrect username
    Given User open the shop page
    When User insert incorrect "username" and try login
    Then User see error message on login page that contains this message "Epic sadface: Username and password do not match any user in this service"

  Example:
  | data     | errorMessage                                                              |
  | username | Epic sadface: Username and password do not match any user in this service |
  | password | Epic sadface: Username and password do not match any user in this service |
  | allData  | Epic sadface: Username and password do not match any user in this service |

  Scenario: User try login without username
    Given User open the shop page
    When User insert "password"
    And Clicks login button
    Then User see error message on login page that contains this message "Epic sadface: Username is required"

  Scenario: User try login without password
    Given User open the shop page
    When User insert "username"
    And Clicks login button
    Then User see error message on login page that contains this message "Epic sadface: Password is required"

  Scenario: When user get error message he/she could close it
    Given User open the shop page
    When User insert incorrect credential
    And Clicks login button
    And Get error message
    And Try close this message
    Then Error message should disappear

  Scenario: After logout active session should expire
    Given User is login on the main page
    And Click on hamburger menu
    Then Click on logout
    And Refresh browser
    And Clicks login button
    Then User see error message on login page that contains this message "Epic sadface: Username and password do not match any user in this service"
