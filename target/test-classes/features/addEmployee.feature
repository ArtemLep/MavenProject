@sprint2 @addemployee
Feature: Add Employee

When we have common steps applied to all scenarios in the feature file we can group these steps
under the Background keyword.

  Background:
    Given I logged into HRMS
    When I naviate to AddEmployee Page

  @smoke
  Scenario: Adding a new employee
    And I add first "Jon", middle "Simit", and "Simit"
    Then I click save btn
    And I verify I sucessfully added the employee


  @smoke
  Scenario: Negative Sceneario Add employee without name and lastname
    Then I click save btn
    Then I see required error message


  # test parameterization through scenarioOUtline and Examples keyword

  #Parameterization through Scenario Outline
  @regression
  Scenario Outline: Adding multiple Employees

    When I add first "<FirstName>" middle "<MiddleName>" and "<LastName>"
    And I click save btn
    Then I see Employee with "<FirstName>" "<MiddleName>" and "<LastName>" is displayed

    Examples:
      | FirstName | MiddleName | LastName |
      | Jon       | Simit      | Simit    |
      | AliVeli   | Deliz      | Zeli     |
      | Keli      | Deli       | Zoli     |
      | Concona   | Middle     | Zeyno    |

  @regression
  Scenario Outline: search Employee by Id
    When I navigate to EmployeeList
    Then I enter  employee "<ID>"
    And I click search button
    Then I should be able to see "<ID>" on the table

    Examples:
      | ID    |
      | 11689 |
      | 11691 |
#      | 11705 |
#      | 11991 |
#      | 12011 |

  @regression
  Scenario Outline: search Employee by Name
    When I navigate to EmployeeList
    Then I enter  employee name "<Name>"
    And I click search button
    Then I should be able to see the "<Name>" on the table

    Examples:
      | Name             |
      | Ahmad J Salih    |
      | Mehmet MU        |
      | Ayse MU          |
      | Can CC           |
      | Alicano Velicano |

#    #Parameterization through CucumberData Table
#  @regression
#  Scenario: Add an employee and modify Employee details
#    When I add employee details
#      | FirstName | MiddleName | LastName |
#      | Jobby     | Jane       | Simit    |
#      | Janny     | Miko       | Simit    |
#      | Janny     | Miko       | Simit    |
#    Then I click save btn
#    And  I click on Edit
#    Then I am able to modify Employee details
#
#      | DriversLicence | DOB            | SSN         | SIN    | Gender | MaritalStatus |Nationality|
#      | N8978888       | 2020-01-01     | 123-45-1234 | 777777 | Female | Other         |Guinean    |
#      | N887776655     | 2021-09-11     | 123-22-3333 | 888888 | Male   | Other         |Turkish    |
#      | N887776625     | 2021-08-11     | 123-22-2233 | 338888 | Male   | Other         |Swiss      |