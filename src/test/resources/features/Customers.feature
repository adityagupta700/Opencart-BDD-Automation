Feature: Customer Feature of OpenCart Admin

  Scenario: Test the successful creation of new customer
    Given User launches the chrome browser
    And User opens OpenCart Ecommerce - Admin Application using "http://localhost:8080/opencart/upload/admin/"
    When User enters username as "admin" and password as "admin"
    And User clicks on login button
    Then Title of the page should be "Dashboard"
    When User click on Customer DropDown
    And User clicks on Customers option from dropdown
    Then Title of the page should be "Customers"
    When User clicks on Add Customer button
    And User enters new customer details
    And User clicks on save button
    Then User can see confirmation message "Success: You have modified customers!"
    And Close the browser

  Scenario: Test the customer filter functionality using customer name field
    Given User launches the chrome browser
    And User opens OpenCart Ecommerce - Admin Application using "http://localhost:8080/opencart/upload/admin/"
    When User enters username as "admin" and password as "admin"
    And User clicks on login button
    When User click on Customer DropDown
    And User clicks on Customers option from dropdown
    When User enters fullname in Customer Name field
    And Clicks on filter button
    Then Customer should be available in customer details table.
    And Close the browser
