Feature:  Dashboard Tab Functionality

  @dashboardTabs
  Scenario: Dashboard Tab verification
    When  enter valid credentials
    And click on login buton
    Then verify dashboard is displayed
    Then verfy the following tabs on dashboard

      | Admin | PIM | Leave | Time | Recruitment | Perfomance | Dashboard | Directory |