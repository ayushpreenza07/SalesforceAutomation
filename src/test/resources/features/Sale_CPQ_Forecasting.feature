
Feature: SalesForce_Forecasting

  @Web @salesforce @Forecast
  Scenario Outline: 2: Sale-CPQ-Forecasting
#    Given navigate to salesforce
#    And login to salesforce
    Given navigate to Salesforce as "Forecast Admin"
    And login to Salesforce with "Forecast Admin" credentials
    And navigate to setup screen
    And Check Forecast access for logged in User
    Then Create Users Hierarchy for Forecast
    And Assign a Role to the Forecast User
    And Check users shown in the Forecasts Hierarchy
    And Enable Forecast Settings for first-time user logging

    Examples:
      | TestData |
      | TestData1 |

