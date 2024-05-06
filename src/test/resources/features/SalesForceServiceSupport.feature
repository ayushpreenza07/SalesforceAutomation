Feature: salesforce service support demo

  @salesforce_servicesupport
  Scenario Outline: salesforce service support demo
    Given Read the test data  "<TestData>" from Excel
    When Navigate to Salesforce as "System Admin"
    And  Login to Salesforce with "System Admin" credentials
    Then click on service support button
    Then create account for service support
    Then create new opportunity and change its status
    Then create new quote in service support
    And  create an order and activate in service support
#    Then edit account details
#    Then create contact for service support
#    Then edit contact details for service support
#    Then filter contact details for service support
#    Then remove all filters contact details for service support
#    Then click on casesTab for service support
#    Then create new cases for service support
#    Then create new case by searching contact and account
#    Then edit case details for service support
#    Then delete case for service support
#    Then search case for service support
#    Then delete account
#    Then delete contact details for service support
#    Then create new case by creating an new account
#    When create new case by creating a new contact

    Examples:
      | TestData |
      | TestData1 |