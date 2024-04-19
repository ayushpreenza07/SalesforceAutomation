
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
    And Enable Forecast Settings for first-time user logging

    Examples:
      | TestData |
      | TestData1 |

  @Web @salesforce @ForecastActivation
  Scenario: Activate Created Forecast
    Given navigate to salesforce
    When login to salesforce
    And navigate to setup screen
    And Navigate to forecast settings page
    Then Validate Forecast settings page is loaded
    When Activate Forecast
    And Search For Forecasts application and Navigate To Forecasts page
    Then Validate Activated Forecast Is Visible
    When navigate to setup screen
    And Navigate to forecast settings page In New Window
    Then Validate Forecast settings page is loaded
    And Deactivate Forecast

