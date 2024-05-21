Feature: salesforce demo

  @salesforce
  Scenario Outline: salesforce demo
    Given Read the test data  "<TestData>" from Excel
    When Navigate to Salesforce as "System Admin"
    And Login to Salesforce with "System Admin" credentials
    Then create new account
    And create contact
    Then create opportunity and change its status
    And create new quote and add product in account details page
    And  Create an order and activate in account details page
    And create new quote and add product
    Then Generate document
    Then Verify if product added
    And verify if document generated
    Then Go to quote and change its status to approve
    And Create new contract
    Then Change Opportunity Status to Close Won after Quote Approve
    And create an order and activate
    Examples:
      | TestData |
      | TestData1 |
