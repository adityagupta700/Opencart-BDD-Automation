Feature: Login Functionality

  @positive
  Scenario: Test the successful login of user to the application
    Given User launches the chrome browser
    And User opens OpenCart Ecommerce - Admin Application using "http://localhost:8080/opencart/upload/admin/"
    When User enters username as "admin" and password as "admin"
    And User clicks on login button
    Then Title of the page should be "Dashboard"
    When User clicks on logout button
    Then Title of the page should be "Administration"

  @positive @negative
  Scenario Outline: Test the login functionality with sets of user
    Given User launches the chrome browser
    And User opens OpenCart Ecommerce - Admin Application using "http://localhost:8080/opencart/upload/admin/"
    When User enters username as <username> and password as <password>
    And User clicks on login button
    Then Title of the page should be "Dashboard"
    When User clicks on logout button
    Then Title of the page should be "Administration"

    ##Always give the examples in double quotes if the values passed are string values otherwise don't
    Examples: 
      | username   | password   |
      | "admin1"   | "admin1"   |
      | "admin123" | "admin123" |
      | "admin"    | "admin"    |
