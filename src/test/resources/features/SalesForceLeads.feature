Feature: Salesforce Leads

  @Leads
  @salesforce @Leads @Web
  Scenario: Create Leads with Open Status
  and Change Lead Status to Contacted or
  Close Leads if not required to Convert

#    Given navigate to salesforce URL
#    And login to salesforce URL
    Given navigate to Salesforce as "Leads Admin"
    And login to Salesforce with "Leads Admin" credentials
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

  @salesforce @Leads  @Web
  Scenario: Convert Leads to Opportunities
  Convert Leads to Opportunities: Create New or
  Select Existing Accounts, Contacts, and Opportunities

#    Given navigate to salesforce URL
#    And login to salesforce URL
    Given navigate to Salesforce as "Leads Admin"
    And login to Salesforce with "Leads Admin" credentials
    When Click on Hamburger Menu
    And click on Search <"Leads">
    Then verify Leads Page
    When Click on New Button
    And Enter LastName and CompanyName
    When Click On Save Button
    Then verify New with Open Status
    When Click on Converted Tab
    And Click on Select Convert Status
    And Click on Choose Existing Account Search
    And Click on Choose Existing Contact Search
    And Click on Choose Existing Opportunity Search
    And Click on Convert button
    Then verify Your lead has been converted
    When Click on Opportunity Tab in converted popUp
    Then verify the Opportunity AccountName