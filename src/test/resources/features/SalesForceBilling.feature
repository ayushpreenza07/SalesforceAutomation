Feature: salesforce demo

  @salesforceBill
  Scenario Outline: salesforce demo
    Given Read the test data  "<TestData>" from Excel

    When Navigate to Salesforce as "Billing Admin"
    And Login to Salesforce with "Billing Admin" credentials
    And Click on Okay
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

  @salesforceBill
  Scenario Outline: salesforce demo
    Given Read the test data  "<TestData>" from Excel
    When Navigate to Salesforce as "BillingAnother Admin"
    And Login to Salesforce with "BillingAnother Admin" credentials
    And Click on Okay
    And User clicks on the App launcher button
    And Click on view all
    And Click on salesforce Billing
    And Create customer account
    And Create contact link existing and New Contact
    And Create new case
    And Edit new case
    And Update new case
    And Delete new case
    Then Edit account details
    Then Delete account
    And Create new quote and add product in billing section
    And Delete Quote in billing section
    And Search Opportunity to change status and verify the added quotes
    And Search quote to edit
    And Create an order and activate in billing section
    And Create new contract in billing section
    Then Change Opportunity Status to Close Won
    Then Generate invoice in billing section
    Then Payments using cards
    Then Create bundle product and add feature and Options

    Examples:
      | TestData |
      | TestData1 |
