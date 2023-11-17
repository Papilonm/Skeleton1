Feature: Termination of Employee

  @Terminate
  Scenario: Admin Terminates specific Employee

    Given Admin user log in to the system using valid credentials.
    And User clicks login
    When user accesses the list of employees in the system.
    And select a specified employee from the list.
    And navigate to the employee's job page.
    And select the option to terminate the employment of the specified employee.
    Then specified employee is terminated