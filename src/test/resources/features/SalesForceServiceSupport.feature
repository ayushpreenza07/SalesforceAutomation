Feature: salesforce service support demo

  @salesforce
  Scenario Outline: salesforce service support demo
    Given Read the test data  "<TestData>" from Excel
    Given navigate to salesforce
    And login to salesforce
    Then click on service support button
    Then create new account
    Then Edit Account Details
    Then Delete Account
    Then create contact for service support
    Then Edit Contact Details for service support
    Then Filter Contact Details for service support
    Then Remove All Filters Contact Details for service support
    Then Delete Contact Details for service support



    Examples:
      | TestData |
      | TestData1 |