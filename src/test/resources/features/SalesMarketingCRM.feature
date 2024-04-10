@Web
Feature: Salesforce Marketing CRM


  @MarketitingCRM_01
  Scenario Outline:Create and edit comapigns
    Given Read the testdata "<TestData>" and "<SheetName>" from excel file
    Given user navigate to the salesforce application
    When user login into the application
    And user clicks on the App launcher button
    And user selects the "Marketing CRM Classic"
    Then user clicks on Compaigns Tab
    Then user create new compiagn
    Then user clicks on Compaigns Tab
    Then user selects the edit button
    Then user selects the Delete button
   


    Examples:
      | TestData  | SheetName  |
      | TestData1 | Salesforce |






