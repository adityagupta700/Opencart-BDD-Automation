Feature: Customer Feature of OpenCart Admin

  Background: Common Steps for each scenario
    Given User launches the chrome browser
    And User opens OpenCart Ecommerce - Admin Application using "http://localhost:8080/opencart/upload/admin/"
    When User enters username as "admin" and password as "admin"
    And User clicks on login button
    Then Title of the page should be "Dashboard"
    When User click on Customer DropDown
    And User clicks on Customers option from dropdown
    Then Title of the page should be "Customers"

  @positive
  Scenario: Test the successful creation of new customer
    When User clicks on Add Customer button
    And User enters new customer details
    And User clicks on save button
    Then User can see confirmation message "Success: You have modified customers!"

  @positive
  Scenario: Test the customer filter functionality using customer name field
    When User enters fullname in Customer Name field
    And Clicks on filter button
    Then Customer name should be same as provided to filter the customer

  @positive
  Scenario: Test the customer filter functionality using customer email field
    When User enters email in the E-mail field
    And Clicks on filter button
    Then Customer email should be same as email provided to filter the customer

  @positive
  Scenario: Test the successful deletion of customer
    When User selects the customer to be deleted
    And Click on delete button
    Then User can see confirmation message "Success: You have modified customers!"
    And User should be deleted from the list of Customers
