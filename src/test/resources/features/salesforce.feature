Feature: salesforce demo

  @salesforce
  Scenario Outline: salesforce demo
#    Given Read the test data  "<TestData>" from Excel
    Given navigate to salesforce
    And login to salesforce
    Then create new account
    And create contact
    Then create opportunity and change its status
    And create new quote and add product
    Then Generate document
    Then verify if product added
    And verify if document generated
    Examples:
      | TestData |
      | TestData1 |
