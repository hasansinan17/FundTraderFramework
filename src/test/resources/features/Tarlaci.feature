Feature: Personal Details
  @hrmsb6
  Scenario: Modify Employee Personal Details
    Given I logged in HRMS application
    And I navigated to Employee List page
    And I navigated to Personal Details page
    When I click on edit button
    And I click on Smoker
    And I modify other employee details
      | licExpDate | SSN       | SIN      | Gender | Marital Status | Nationality | DOB        | NickName | Military Service |
      | 2023-12-06 | 123456789 | 09887765 | Male   | Other          | Turkish     | 1984-12-12 | Sparrow  | Completed        |
    And I click on save button
    Then I validate that employee details has been modified