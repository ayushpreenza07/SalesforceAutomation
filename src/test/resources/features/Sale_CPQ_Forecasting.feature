Feature: SalesForce_Forecasting

  @Web @salesforce @Forecast
  Scenario Outline: 2: Sale-CPQ-Forecasting
    Given navigate to salesforce
    And login to salesforce
    And navigate to setup screen
    And Check Forecast access for logged in User
    Then Create Users Hierarchy for Forecast
    And Assign a Role to the Forecast User
    And Check users shown in the Forecasts Hierarchy
    Then Check users shown in the Forecasts Hierarchy
    And Enable Forecast Settings for first-time user logging
    And Create  Forecast Type with Opportunities

    Examples:
      | TestData  |
      | TestData1 |

