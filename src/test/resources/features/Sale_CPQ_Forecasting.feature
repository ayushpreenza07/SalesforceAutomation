
Feature: SalesForce_Forecasting

  @Web @salesforce @Forecast
  Scenario Outline: 2: Sale_CPQ_Forecasting
    Given Read the test data  "<TestData>" from Excel for Forecasting
    Given navigate to salesforce
    And login to salesforce
    And navigate to setup screen
    And Check Forecast access for logged in User
    Then Create Users Hierarchy for Forecast
    And Assign a Role to the Forecast User
    Then Check users shown in the Forecasts Hierarchy
    And Enable Forecast Settings for first-time user logging

    Examples:
      | TestData |
      | TestData1 |

