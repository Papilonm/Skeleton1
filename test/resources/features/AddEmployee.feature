Feature: Admin Adds an Employee
  Background:
    Given Admin user log in to the system using valid credentials.
    And User clicks login
    And User clicks pimtab


  @Add
  Scenario: Add as Admin

    Then user clicks on add and enters new employee information
    And user clicks on save
    Then verify employee is stored in database



