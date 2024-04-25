Feature: salesforce service support demo

  @salesforce_servicesupport
  Scenario Outline: salesforce service support demo
    Given Read the test data  "<TestData>" from Excel
    When navigate to Salesforce as "System Admin"
    And login to Salesforce with "System Admin" credentials
    Then click on service support button
#    Then create account for service support
#    Then Edit Account Details
#    Then create contact for service support
#    Then Edit Contact Details for service support
#    Then Filter Contact Details for service support
#    Then Remove All Filters Contact Details for service support
#    Then Click on CasesTab for service support
#    Then Create New Cases for service support
#    Then Create New Case by searching contact and account
#    Then Edit Case Details for service support
#    Then Delete Case for service support
#    Then Search Case for service support
#    Then Delete Account
#    Then Delete Contact Details for service support
    Then Create New Case by Creating an New Account
    When Create New case By creating a New contact

    Examples:
      | TestData |
      | TestData1 |