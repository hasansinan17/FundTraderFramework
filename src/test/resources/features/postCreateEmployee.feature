Feature: Validating syntax Hrms API's
 Background:
 Given user generates token
 @APITEST
 Scenario: This test will check to see if an Employee is created
 Given user calls to createEmployee API
 When user retrieves response
 Then status code code is 201
 Then user validates employee is created





