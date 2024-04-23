Feature: salesforce demo

  @salesforce
  Scenario Outline: salesforce demo
    Given Read the test data  "<TestData>" from Excel
    When navigate to Salesforce as "System Admin"
    And login to Salesforce with "System Admin" credentials
    Then create new account
    And create contact
    Then create opportunity and change its status
    And create new quote and add product
    Then Generate document
    Then verify if product added
    And verify if document generated
    Then Go to quote and change its status to approve
    And create new contract
    Then Change Opportunity Status to Close Won after Quote Approve
    And create an order and activate
    Examples:
      | TestData |
      | TestData1 |
