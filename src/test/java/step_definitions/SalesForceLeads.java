package step_definitions;

import SalesforceModules.Leads;
import SalesforceModules.LoginSalesforceUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.SalesforceObjects.LeadsPage;
import utilities.ExcelDataUtil;
import utilities.KeywordUtil;

import java.io.IOException;
import java.util.HashMap;


public class SalesForceLeads {

    public static HashMap<String, String> dataMap = new HashMap<String, String>();


    @When("^navigate to salesforce URL$")
    public void navigate_to_the_url() throws Exception {
        dataMap = ExcelDataUtil.getTestDataWithTestCaseID("Salesforce", "TestData2");
        KeywordUtil.navigateToUrl(dataMap.get("URL"));
    }
    @Given("login to salesforce URL")
    public void login_to_salesforce_url() {
        dataMap = ExcelDataUtil.getTestDataWithTestCaseID("Salesforce", "TestData2");
        LoginSalesforceUtil.loginToSalesforce(dataMap.get("Username"),dataMap.get("Password"));
    }

    @When("Click on Hamburger Menu")
    public void click_on_hamburger_menu() throws InterruptedException {
       Leads.clickOnHamburgerMenu("User Clicked on Hamburger Menu");
    }
    @When("click on Search <{string}>")
    public void click_on_search(String string) throws InterruptedException {
        Leads.enterText("Leads");
    }
    @Then("verify Leads Page")
    public void verify_leads_page()
    {
        Leads.verifyPageTitle();
    }
    @When("Click on New Button")
    public void click_on_new_button() throws InterruptedException {
        Leads.clickNewButton();
    }
    @When("Enter LastName and CompanyName")
    public void enterLastNameandCityName() throws InterruptedException {
        dataMap = ExcelDataUtil.getTestDataWithTestCaseID("Salesforce", "TestData2");
        KeywordUtil.inputText(LeadsPage.lastName,dataMap.get("LastName"),"Enter Last Name");
        KeywordUtil.inputText(LeadsPage.companyName,dataMap.get("CityName"),"Entered City Name");
    }
    @When("Click On Save Button")
    public void click_on_save_button() {
        Leads.clickOnSaveButton();
    }
    @Then("verify New with Open Status")
    public void verify_new_with_open_status() {
        Leads.verifyOpenNotContacted();
    }
    @When("Click on Converted Tab")
    public void click_on_converted_tab() throws InterruptedException {
        Leads.clickOnConvertedTab();
    }
    @When("Click on Select Convert Status")
    public void click_on_select_convert_status() throws InterruptedException {
        Leads.clickOnConvertedStatusButton();
    }
    @When("Click on Convert button")
    public void click_on_convert_button() throws IOException, InterruptedException {
        Leads.clickOnConvertedButton();
    }
    @Then("verify Your lead has been converted")
    public void verify_your_lead_has_been_converted() throws InterruptedException {
        Leads.verifyConvertStatusMessage();
    }

    @When("Click on Choose Existing Account Search")
    public void click_on_choose_existing_account_search() {
        Leads.clickOnExistingAccountRadioBtn();
    }
    @When("Click on Choose Existing Contact Search")
    public void click_on_choose_existing_contact_search() throws InterruptedException {
        Leads.clickOnExistingContactRadioBtn();
    }
    @When("Click on Choose Existing Opportunity Search")
    public void click_on_choose_existing_opportunity_search() throws InterruptedException {
        Leads.clickOnExistingOpportunityRadioBtn();
    }
    @When("Click on Opportunity Tab in converted popUp")
    public void click_on_opportunity_tab_in_coverted_popup(){
        Leads.clickOnOpportunityName();
    }
    @Then("verify the Opportunity AccountName")
    public void verify_the_opportunity_accountName() throws InterruptedException {
        Leads.verifyOpportunityAccountName();
    }
}
