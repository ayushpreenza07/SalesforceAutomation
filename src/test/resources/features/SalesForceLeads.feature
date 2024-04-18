Feature: Salesforce Leads


  @salesforce @Leads @Web
  Scenario: Create Leads with Open Status
  and Change Lead Status to Contacted or
  Close Leads if not required to Convert
  Create New or  Select Existing Accounts, Contacts, and Opportunities
  Change Opportunity Status Qualifcation to Proposal/Quote
  Create and Link Quote with Opportunity, Account, Contact
  Quote  Edit Lines (Select Add Discount), (Add Product)
  Verify Product Added in the Opportunity

    Given navigate to salesforce URL
    And login to salesforce URL
    When Click on Hamburger Menu
    And click on Search <"Leads">
    Then verify Leads Page
    When Click on New Button
    And Enter LastName and CompanyName
    When Click on Save Button
    Then verify New with Open Status
    When Click on Converted Tab
    And Click on Select Convert Status
    And Click on Convert button
    Then verify Your lead has been converted

    When Click on Opportunity Tab in converted popUp
    Then verify the Opportunity AccountName
    When Click on Proposal and markStage
    And Click on QuoteCard and Click on New
    And Enter New quote details
    And Click on EditLines Tab
    Then verify product added in the Opportunity
    When Generate document
    Then verify if product added

  @salesforce @LeadsTest  @Web
  Scenario: Convert Leads to Opportunities
  Convert Leads to Opportunities: Create New or
  Select Existing Accounts, Contacts, and Opportunities

    Given navigate to salesforce URL
    And login to salesforce URL
    When Click on Hamburger Menu
    And click on Search <"Leads">
    Then verify Leads Page
    When Click on New Button
    And Enter LastName and CompanyName
    When Click on Save Button
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