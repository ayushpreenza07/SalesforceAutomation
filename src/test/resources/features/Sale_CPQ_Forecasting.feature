
Feature: SalesForce_Forecasting

  @Web @salesforce @Forecast
  Scenario: 2: Sale-CPQ-Forecasting
    Given navigate to salesforce
    And login to salesforce
    And navigate to setup screen
    And Check Forecast access for logged in User
    And Assign a Role to the Forecast User
    And Check users shown in the Forecasts Hierarchy
