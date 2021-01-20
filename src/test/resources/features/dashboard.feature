Feature: Add Employee Functionality

  Background:
    When enter valid credentials
    And click on login button
    Then verify dashboard is displayed
    When click on PIM
    And click on add employee button

  @addEmployeeWithoutLogin
  Scenario: Add employee without login details
    Then enter first and last name
    And click on save button
    Then verify employee is added successfully

  @addEmployeeWithLogin
  Scenario: Add employee with login credentials and with middle name
    Then enter first and last name and middle name
    When click on login details checkbox
    Then enter login details
    And click on save button
    Then verify employee is added successfully

  @parameter
  Scenario: Add employee without login details but with middle name
    Then enter first name "Ali", middle name "Osman" and last name "Kursun"
    And click on save button
    Then verify that "Ali Osman Kursun" is added successfully

  @examples
  Scenario Outline: Adding multiple employees without login details
    When enter "<FirstName>", "<MiddleName>" and "<LastName>"
    And click on save button
    Then verify "<FirstName>", "<MiddleName>" and "<LastName>" is added successfully

    Examples:
      |FirstName|MiddleName|LastName|
      |Mark     |J         |Smith   |
      |John     |K         |Wick    |