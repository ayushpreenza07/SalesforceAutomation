Feature: salesforce demo

  @salesforceBill
  Scenario Outline: salesforce demo
    Given Read the test data  "<TestData>" from Excel
    When Navigate to Salesforce as "Billing Admin"
    And Login to Salesforce with "Billing Opp" credentials
    And Click on Okay
    And go to salesforce cpq
    And go to products tab
    And Create new product
    And add price book and standard price
    Examples:
      | TestData |
      | TestData1 |
