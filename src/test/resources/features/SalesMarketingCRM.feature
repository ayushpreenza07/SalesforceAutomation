@Web
Feature: Salesforce Marketing CRM


  @MarketingCRM_01
  Scenario Outline:Create and edit comapigns
    Given Read the testdata "<TestData>" and "<SheetName>" from excel file
    When Navigate to Salesforce as "Forecast Admin"
    And Login to Salesforce with "Forecast Admin" credentials
    And User clicks on the App launcher button
    And User selects the "Marketing CRM Classic"
    And User clicks on Campaigns Tab
    Then User create new Campaign
    And User clicks on Campaigns Tab
    Then User selects the edit button
    Then User selects the Delete button
    Then User create new Campaign
    And User clicks on Campaigns Tab
    Then User selects the parent Campaign
    And User clicks on the Campaign
    Then User create contact in Campaign
    Then User Add the leads in campaign
    And User clicks on the Contact tab
    Then User selects the filter
    Then User edit the contact
    Then User delete the contact
    Then User remove the filter
    Then User create new contact in Contact
    Then User create new opportunity in Contact
    Then User is able to see the opportunity
    Then User added Contact to campaign
    Then User is able to see the campaign History
    Then User added case in the contact
    Then User able to see the case history
    And User click on the lead Tab
    Then User create new lead
    And User click on the lead Tab
    Then User selects the filter in Lead
    Then User edit the lead
    Then User delete the lead
    Then User remove the filter
    And User clicks on Campaigns Tab
    And Add Lead To Campaign
    And Change Lead Status
    When Click on Opportunity Tab in converted popUp
    Then Verify the Opportunity AccountName
    And User clicks on Opportunities Tab
    Then User create new Opportunity
    And User edit new Opportunity
    And User delete new Opportunity
    And Change Opportunity Status
    And User create Quotas an add Product
    Then Generate document
    Then Verify if product added
    And verify if document generated
    And  Create an order and activate in marketing crm
    And  Create new contract
    Then Change Opportunity Status to Close Won after Quote Approve


    Examples:
      | TestData  | SheetName  |
      | TestData1 | Salesforce |






