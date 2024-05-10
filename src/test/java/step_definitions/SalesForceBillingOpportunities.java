package step_definitions;

import SalesforceModules.Leads;
import SalesforceModules.OppurtunitiesUtil;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.ExcelDataUtil;

import java.util.HashMap;


public class SalesForceBillingOpportunities {

    public static HashMap<String, String> dataMap = new HashMap<String, String>();

    @When("Click on Search {string}")
    public void click_on_search(String string) throws InterruptedException {
        Leads.enterText("Salesforce Billing");
    }

    @When("Click on Opportunity New Button")
    public void click_on_opportunity_new_button() throws InterruptedException {
        OppurtunitiesUtil.clickNewButton("Clicked on New Button");
    }

    @When("Enter Opportunity Details")
    public void enter_opportunity_details() throws Exception {
        dataMap = ExcelDataUtil.getTestDataWithTestCaseID("Salesforce", "TestData2");
        OppurtunitiesUtil.createOpportunityDetails(dataMap.get("OpportunityName"),dataMap.get("Amount"), dataMap.get("Stage"));
    }

    @Then("Verify the Billing Opportunity Name")
    public void verify_billing_opportunity_name() {
        OppurtunitiesUtil.verifyOpportunityName();
    }

    @When("Click on DropDown Button in RHS")
    public void click_on_dropdown_button() throws InterruptedException {
        OppurtunitiesUtil.clickDropDown("Clicked on DropDwon");
    }

    @When("Click on Edit in DropDown")
    public void click_on_edit_dropdown() throws InterruptedException {
        OppurtunitiesUtil.clickOnDropDownEdit("Clicked on DropDown Edit button");
    }

    @When("Change the Stage")
    public void change_the_stage() throws InterruptedException {
        dataMap = ExcelDataUtil.getTestDataWithTestCaseID("Salesforce", "TestData3");
        OppurtunitiesUtil.changeOpportunityDetails(dataMap.get("OpportunityName"),dataMap.get("Stage"));

    }

    @Then("Verify the Stage")
    public void verify_the_stage() throws InterruptedException {
        OppurtunitiesUtil.verifyOpportunityStage();
    }
}
