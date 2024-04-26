Feature: salesforce demo

  @BillOpportunity  @salesforce @Web
  Scenario: salesforce Billing

    Given navigate to Salesforce as "Billing Opportunity"
    And login to Salesforce with "Billing Opportunity" credentials
    And Click on Okay
    When Click on Hamburger Menu
    And Click on Search "Salesforce Billing"
    And Click on Opportunity Tab
    And Click on Opportunity New Button
    And Enter Opportunity Details
    And Click on Opportunity Tab
    Then Verify the Billing Opportunity Name
    And Click on DropDown Button in RHS
    And Click on Edit in DropDown
    And Change the Stage
    Then Verify the Stage











