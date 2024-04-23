Feature: salesforce demo

  @salesforceBill
  Scenario Outline: salesforce demo
    Given Read the test data  "<TestData>" from Excel
    Given navigate to Salesforce as "Billing Admin"
    And login to Salesforce with "Billing Admin" credentials
    And click okay
    And go to salesforce cpq
    And go to products tab
    And Create new product
    And add price book and standard price
    Examples:
      | TestData |
      | TestData1 |
