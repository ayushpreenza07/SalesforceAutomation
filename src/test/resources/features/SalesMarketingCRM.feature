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
   Then User create contact in Campaign
   Then User Add the leads in campaign
   And User clicks on the Contact tab
   Then User selects the filter
   Then User edit the contact
   Then User remove the filter
   Then User create new contact in Contact
   Then User create new opportunity in Contact
   Then User is able to see the opportunity
   Then User added case in the contact
   Then User able to see the case history
   And User click on the lead Tab
   Then User create new lead
   And User click on the lead Tab
   And User clicks on Campaigns Tab
   And User clicks on Opportunities Tab
    Then User create new Opportunity
    And Change Opportunity Status

    Examples:
      | TestData  | SheetName  |
      | TestData1 | Salesforce |






