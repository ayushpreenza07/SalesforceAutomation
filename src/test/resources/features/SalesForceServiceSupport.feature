Feature: salesforce service support demo

  @salesforce_servicesupport
  Scenario Outline: salesforce service support demo
    Given Read the test data  "<TestData>" from Excel
    When Navigate to Salesforce as "System Admin"
    And  Login to Salesforce with "System Admin" credentials
    Then Click on service support button
    Then Create account for service support
    Then Create new opportunity and change its status
    Then Create new quote in service support
    And  Create an order and activate in service support
    Then User added contact to campaign in service support
    Then Edit account details
    Then Create contact for service support
    Then Edit contact details for service support
    Then Filter contact details for service support
    Then Remove all filters contact details for service support
    Then Click on casesTab for service support
    Then Create new cases for service support
    Then Create new case by searching contact and account
    Then Edit case details for service support
    Then Delete case for service support
    Then Search case for service support
    Then Delete account
    Then Delete contact details for service support
    Then Create new case by creating an new account
    Then Create new case by creating a new contact

    Examples:
      | TestData |
      | TestData1 |