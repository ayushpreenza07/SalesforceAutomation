@Web
Feature: Salesforce Marketing CRM


  @MarketingCRM_01
  Scenario Outline:Create and edit comapigns
    Given Read the testdata "<TestData>" and "<SheetName>" from excel file
    When navigate to Salesforce as "System Admin"
    And login to Salesforce with "System Admin" credentials
    And user clicks on the App launcher button
    And user selects the "Marketing CRM Classic"
    Then user clicks on Campaigns Tab
#    Then user create new Campaign
#    Then user clicks on Campaigns Tab
#    Then user selects the edit button
#    Then user selects the Delete button
#    Then user create new Campaign
#    Then user clicks on Campaigns Tab
#    Then user selects the parent Campaign
#    And user clicks on the Campaign
#    Then user create contact in Campaign
#    Then user Add the leads in campaign
#    Then user clicks on the Contact tab
#    Then user selects the filter
#    Then user edit the contact
#    Then user Delete the contact
#    Then user remove the filter
#    Then user create new contact in Contact
#    Then user create new opportunity in Contact
#    Then user is able to see the opportunity
#    Then user added Contact to campaign
    And Add Lead To Campaign
    And Change Lead Status





    Examples:
      | TestData  | SheetName  |
      | TestData1 | Salesforce |






