Feature: salesforce demo

  @salesforceBill
  Scenario Outline: salesforce demo
    Given Read the test data  "<TestData>" from Excel
    When navigate to Salesforce as "Billing Admin"
    And login to Salesforce with "Billing Admin" credentials
    And click okay
    And go to salesforce cpq
    And go to products tab
    And Create new product
    And add price book and standard price
    And edit standard price book
    And go to products tab
    And search product in products tab

    Examples:
      | TestData |
      | TestData1 |
