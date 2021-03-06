#Author: Instructor
@apiWorkFlow
Feature: Syntax HRMS API Workflow
  Description: This feature tests Syntax HRMS API WorkFlow
  Background:
    Given  a JWT is generated
  Scenario: Creating an employee
    Given a request is prepared to create an employee
    When a POST call is made to create an Employee
    Then the status code for creating an employee is 201
    And  the employee is created
    And  the employee id is stored in the global variable to be used for other calls
  @progression
  Scenario: Retrieving the created employee
    Given  request os prepared to retrieve to create employee
    When a get call is made to retrieve the created empl
    Then status code is 200;
    And retrieved empl id matches the globally stored empId
    And the reitrieved data matched the data used to create the employee.
