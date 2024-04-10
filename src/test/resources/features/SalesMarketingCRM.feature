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
#    Then user clicks on Compaigns Tab
#    Then user selects the edit button
#    Then user selects the Delete button
#    //Then user create contact in comapign


    Examples:
      | TestData  | SheetName  |
      | TestData1 | Salesforce |

  @MarketitingCRM
  Scenario Outline: Link parent compaign
    Given Read the testdata "<TestData>" and "<SheetName>" from excel file
    Given user navigate to the salesforce application
    When user login into the application
    And user clicks on the App launcher button
    And user selects the "Marketing CRM Classic"
    Then user clicks on Compaigns Tab
    And user selects the parent compaign
    Examples:
      | TestData  | SheetName  |
      | TestData1 | Salesforce |




  @MarketitingCRM_04
  Scenario Outline: Delete the comapign
    Given Read the testdata "<TestData>" and "<SheetName>" from excel file
    Given user navigate to the salesforce application
    When user login into the application
    And user clicks on the App launcher button
    And user selects the "Marketing CRM Classic"
    Then user clicks on Compaigns Tab
    Then user selects the Delete button

    Examples:
      | TestData  | SheetName  |
      | TestData1 | Salesforce |
