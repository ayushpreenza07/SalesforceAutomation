Feature: Salesforce Leads

  @Leads
    @salesforce @Leads @Web
  Scenario: Create Leads with Open Status
  and Change Lead Status to Contacted or
  Close Leads if not required to Convert

    Given navigate to salesforce URL
    And login to salesforce URL
    When Click on Hamburger Menu
    And click on Search <"Leads">
    Then verify Leads Page
    When Click on New Button
    And Enter LastName and CompanyName
    When Click On Save Button
    Then verify New with Open Status
    When Click on Converted Tab
    And Click on Select Convert Status
    And Click on Convert button
    Then verify Your lead has been converted

