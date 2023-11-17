Feature: User is able to Login
@Login
  Scenario: User logs in as an admin

    When User enters correct credentials
    And User clicks login
    Then Dashboard should be displayed

