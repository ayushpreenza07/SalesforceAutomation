@Web
Feature: Salesforce Marketing CRM


  @MarketingCRM_01
  Scenario Outline:Create and edit comapigns
    Given Read the testdata "<TestData>" and "<SheetName>" from excel file
    When Navigate to Salesforce as "Forecast Admin"
    And Login to Salesforce with "Forecast Admin" credentials
    And user clicks on the App launcher button
    And user selects the "Marketing CRM Classic"
   # And user clicks on Campaigns Tab
#    Then user create new Campaign
#    And user clicks on Campaigns Tab
#    Then user selects the edit button
#    Then user selects the Delete button
#    Then user create new Campaign
#    And user clicks on Campaigns Tab
#    Then user selects the parent Campaign
#    And user clicks on the Campaign
#    Then user create contact in Campaign
#    Then user Add the leads in campaign
#     And user clicks on the Contact tab
#    Then user selects the filter
#    Then user edit the contact
#    Then user Delete the contact
#    Then user remove the filter
#    Then user create new contact in Contact
#    Then user create new opportunity in Contact
#    Then user is able to see the opportunity
#    Then user added Contact to campaign
#    Then user is able to see the campaign History
#    Then user added case in the contact
#    Then user able to see the case history
#    And user click on the lead Tab
#    Then user create new lead
#    And user click on the lead Tab
#    Then user selects the filter in Lead
#    Then user edit the lead
#    Then user delete the lead
#    Then user remove the filter
    And user clicks on Opportunities Tab
    Then user create new Opportunity
    And user edit new Opportunity
    And user delete new Opportunity

    Examples:
      | TestData  | SheetName  |
      | TestData1 | Salesforce |






