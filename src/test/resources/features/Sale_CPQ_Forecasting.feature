
Feature: SalesForce_Forecasting

  @Web @salesforce @Forecast
  Scenario Outline: 2: Sale-CPQ-Forecasting
    Given Read the test data  "<TestData>" from Excel
    When navigate to Salesforce as "Forecast Admin"
    And login to Salesforce with "Forecast Admin" credentials
    When navigate to setup screen
    And Check Forecast access for logged in User
    Then Create Users Hierarchy for Forecast
    And Assign a Role to the Forecast User
    And Check users shown in the Forecasts Hierarchy
    And Enable Forecast Settings for first-time user logging
    And Create Forecast Type with Opportunities
    And Create Forecast Type with Opportunities and Product
    And Activate Created Forecast
    And Choose forecast range and show or hide quotas from the forecast
    And Assign Forecast Quotes To User
    And Verify Forecast on Manager Users Dashboard
    And Verify Forecast on Teams Users Dashboard

    Examples:
      | TestData |
      | TestData1 |
