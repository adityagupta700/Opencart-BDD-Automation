Feature: Customer Feature of OpenCart Admin

  Scenario: Test the successful creation of new customer
    Given User launches chrome browser
    And User login with username as "admin" and password as "admin"
    And User clicks on login button
    Then User should be on Dashboard page with title as "Dashboard"
    When User click on Customer DropDown
    And User clicks on Customers option from dropdown
    Then Title of Cusotmers page should be "Customers"
    When User clicks on Add Customer button
    Then User can view Add new Customer page
    When User enters new customer details
    And User clicks save button
    Then User can see confirmation message "Success: You have modified customers!"
    And closes browser
