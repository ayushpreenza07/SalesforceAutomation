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

    Examples:
      | TestData |
      | TestData1 |