Feature: Authentication

  Scenario: Login to the shop page
    Given User open the shop page
    When User insert correct credential and try login
    Then User should see main page

  Scenario: User try login without password
    Given User open the shop page

  Scenario: User pass incorrect username
    Given User open the shop page
    When User insert incorrect "username" and try login
    Then User see error message on login page that contains this message "Epic sadface: Username and password do not match any user in this service"

  Example:
  | data     | errorMessage                                                              |
  | username | Epic sadface: Username and password do not match any user in this service |
  | password | Epic sadface: Username and password do not match any user in this service |
  | allData | Epic sadface: Username and password do not match any user in this service |

  Scenario: User successfully login then logout and try login without credentials
    Given User open the shop page