
Feature: SalesForce_Forecasting

  @Web @salesforce @Forecast
  Scenario: salesforce creating User, assign Role and allow Forecasting
    Given navigate to salesforce
    And login to salesforce
    And navigate to setup screen
    When Check Forecast access for logged in User
