
Feature: SalesForce_Forecasting

  @Web @salesforce @Forecast
  Scenario: 2: Sale-CPQ-Forecasting
    Given navigate to salesforce
    And login to salesforce
    And navigate to setup screen
    And Check Forecast access for logged in User
    And Assign a Role to the Forecast User
    And Check users shown in the Forecasts Hierarchy

  @Web @salesforce @ForecastActivation
  Scenario: Create ForecastOppurtunities
    Given navigate to salesforce
    And login to salesforce
    And navigate to setup screen
    And Navigate to forecast settings page
    And Activate Forecast
    And Search For Forecasts application and Navigate To Forecasts page
    And Validate Activated Forecast Is Visible