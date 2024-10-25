@RegistrationForm
Feature: Using DataTable for Registration

  @Registration
  Scenario: Fill and submit the Registration Form
    Given Registration Form is Open
    When i enter valid Data on RegistrationPage
      | Fields      | Value                   |
      | First Name  | smita                   |
      | Middle Name | Nishant                 |
      | Last Name   | Kawishwar               |
      | Course      | B.Tech                  |
      | Gender      | female                  |
      | Phone       |              9999999999 |
      | Address     | 8116,JP Nagar,Bangalore |
      | Email       | smita@mail.com          |
      | Password    | password                |
    And Click on Submit
    Then Submit Page Opens
