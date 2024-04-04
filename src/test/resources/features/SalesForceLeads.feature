# new feature
# Tags: optional

Feature: SalesForce_Leads

    @salesforce @Leads
    Scenario : salesforce creating Leads
        Given navigate to salesforce
        And login to salesforce
        When Click on Hamburger Menu
        And Click view all
        And click on Search <"Leads">
        And click on Leads
        Then verify Leads Page
        When Click on New Button
