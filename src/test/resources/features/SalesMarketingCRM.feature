@Web
Feature: Salesforce Marketing CRM


  @MarketingCRM_01
  Scenario Outline:Create and edit comapigns
    Given Read the testdata "<TestData>" and "<SheetName>" from excel file
    Given user navigate to the salesforce application
    When user login into the application
    And user clicks on the App launcher button
    And user selects the "Marketing CRM Classic"
   Then user clicks on Campaigns Tab
    Then user create new Campaign
    Then user clicks on Campaigns Tab
    Then user selects the edit button
    Then user selects the Delete button
    Then user create new Campaign
    Then user clicks on Campaigns Tab
    Then user selects the parent Campaign
    And user clicks on the Campaign
    Then user create contact in Campaign
    Then user Add the leads in campaign


    Examples:
      | TestData  | SheetName  |
      | TestData1 | Salesforce |






