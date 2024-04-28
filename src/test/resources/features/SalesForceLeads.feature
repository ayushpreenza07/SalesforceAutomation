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
  Change Opportunity Status to Close  Won after Quote Approval
  Edit Approved Quote to check mark as Ordered & Create Contract
  Verify Ordered and Contract created after Quote checked as Ordered
  Activate Order (Change Status Draft to Activate )


    Given Navigate to Salesforce as "System Admin"
    And Login to Salesforce with "System Admin" credentials
    When Click on Hamburger Menu
    And Click on Search <"Leads">
    Then Verify Leads Page
    When Click on New Button
    And Enter LastName and CompanyName
    And Click on Save Button
    Then Verify New with Open Status
    When Click on Converted Tab
    And Click on Select Convert Status
    And Click on Convert button
    Then Verify Your lead has been converted
    When Click on Opportunity Tab in converted popUp
    Then Verify the Opportunity AccountName
    When Click on Proposal and markStage
    And Click on QuoteCard and Click on New
    And Enter New quote details
    And Click on EditLines Tab
    Then Verify product added in the Opportunity
    When Generate document
    Then Verify if product added
    And Click on Hamburger Menu
    And Click On SalesForceCPQ
    And Click on Quotes Tab
    And Click on QuoteNumber
    And Change the Quote status Draft to Review
    And Click on Save Button
    And Click on Edit Quote
    And Change the Quote status Review to Approved
    And Click on Save Button
    Then Verify the Quote Status should be Approved
    And Click on Opportunity Tab
    And Click on Opporunity Name
    And Select Close Tab and change the Status to Closed Won
    And Create new contract
    And Click on Edit Quote
    And Click On Ordered
    And Click on Save Button
    And Click On Orders from RHS
    And Click on Order Number
    And Click on Activated
    And Click on MarkAsCurrentStatus Button


  @salesforce @LeadsTest  @Web
  Scenario: Convert Leads to Opportunities
  Convert Leads to Opportunities: Create New or
  Select Existing Accounts, Contacts, and Opportunities
    Given Navigate to Salesforce as "Leads Admin"
    And Login to Salesforce with "Leads Admin" credentials
    When Click on Hamburger Menu
    And Click on Search <"Leads">
    Then Verify Leads Page
    When Click on New Button
    And Enter LastName and CompanyName
    When Click on Save Button
    Then Verify New with Open Status
    When Click on Converted Tab
    And Click on Select Convert Status
    And Click on Choose Existing Account Search
    And Click on Choose Existing Contact Search
    And Click on Choose Existing Opportunity Search
    And Click on Convert button
    Then Verify Your lead has been converted
    When Click on Opportunity Tab in converted popUp
    Then Verify the Opportunity AccountName