package step_definitions;

import SalesforceModules.Leads;
import SalesforceModules.LoginSalesforceUtil;
import SalesforceModules.OppurtunitiesUtil;
import SalesforceModules.QuoteUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.SalesforceObjects.LeadsPage;
import utilities.ExcelDataUtil;
import utilities.KeywordUtil;

import java.io.IOException;
import java.util.HashMap;

import static SalesforceModules.OppurtunitiesUtil.*;
import static SalesforceModules.OrdersUtl.*;
import static SalesforceModules.QuoteUtil.*;
import static pageobjects.SalesforceObjects.OppurtunitiesObject.opportunityName;


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
    public void verify_leads_page() {
        Leads.verifyPageTitle();
    }

    @When("Click on New Button")
    public void click_on_new_button() throws InterruptedException {
        Leads.clickNewButton();
    }

    @When("Enter LastName and CompanyName")
    public void enterLastNameandCityName() throws InterruptedException {
        dataMap = ExcelDataUtil.getTestDataWithTestCaseID("Salesforce", "TestData2");
        KeywordUtil.inputText(LeadsPage.lastName, dataMap.get("LastName"), "Enter Last Name");
        KeywordUtil.inputText(LeadsPage.companyName, dataMap.get("CityName"), "Entered City Name");
    }

    @When("Click on Save Button")
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
    public void click_on_opportunity_tab_in_coverted_popup() {
        Leads.clickOnOpportunityName();
    }

    @Then("verify the Opportunity AccountName")
    public void verify_the_opportunity_accountName() throws InterruptedException {
        Leads.verifyOpportunityAccountName();
    }

    @When("Click on Proposal and markStage")
    public void click_on_proposal_and_mark_stage() throws InterruptedException {
        markAsStage();
    }

    @When("Click on Proposal and markStages")
    public void click_on_proposal_and_mark_stages() throws InterruptedException {
        markAsStages();
    }

    @When("Click on QuoteCard and Click on New")
    public void click_on_quote_card_and_click_on_new() throws Exception {
        clickQuoteCard("Clicked on QuoteCard");
        newButtonQuote("Clicked new button");
    }

    @When("Enter New quote details")
    public void enter_new_quote_details() throws Exception {
        dataMap = ExcelDataUtil.getTestDataWithTestCaseID("Salesforce", "TestData2");
        QuoteUtil.createNewQuotes(dataMap.get("OpportunityName"));
    }

    @When("Click on EditLines Tab")
    public void click_on_edit_lines_tab() throws InterruptedException {
        clickEditLinesForLeads("Edit Lines clicked");
    }

    @Then("verify product added in the Opportunity")
    public void verify_product_added_in_the_quote() {
        QuoteUtil.verifyProductTitle();
    }
    @When ("click on Generate Document")
    public void click_on_Generate_Document() throws InterruptedException {
        QuoteUtil.clickGenerateDocument("generated Document");
    }

    @When("Click on QuoteNumber from the RHS Card")
    public void click_on_quote_tab_fromRHS() throws InterruptedException {
        clickQuoteTabFromRHS("Clicked on Quote Tab from RHS");
    }


    @When("Click on QuoteNumber")
    public void click_on_QuoteNumber() throws InterruptedException {
        clickQuoteNumber("Clicked on Quote Number");
    }

    @When("Change the Quote status Draft to Review")
    public void change_the_status_draft_to_review() throws InterruptedException {
        dataMap = ExcelDataUtil.getTestDataWithTestCaseID("Salesforce", "TestData2");
        clickOnEditStatus(dataMap.get("QuoteType"),"Clicked on Change Status");
    }
    @When("Click on Edit Quote")
    public void click_on_edit() throws InterruptedException {
        clickOnEdit("Clicked on Edit Button");
    }
    @When("Change the Quote status Review to Approved")
    public void change_the_status_review_to_approved() throws InterruptedException {
        clickOnEditStatusReviewToApprove(dataMap.get("QuoteType"),"Changed Status Review to Approved");
    }
    @Then("verify the Quote Status should be Approved")
    public void verify_status_should_be_approved() {
        verifyApprovedStatus();
    }

    @Given("Click On SalesForceCPQ")
    public void clickn_on_sales_force_cpq() {
        clickOnSalesforceCPQ();
    }
     @When("Click on Opportunity Tab")
    public void clickOnOpportunityTab() throws InterruptedException {
        OppurtunitiesUtil.clickOnOpportunityTab();
     }

    @When("Click on Opporunity Name")
    public void clickOnOpportunityName(){

        OppurtunitiesUtil.clickOnOpportunityName();
    }
    @When("Select Close Tab and change the Status to Closed Won")
    public void select_close_tab_and_change_the_status_to_closed_won() {
        OppurtunitiesUtil.selectClosedStatus("Changing Opportunity status to closed won");
    }
    @Then("Verify Stage should be Closed Won")
    public void verify_stage_should_be_closed_won() throws InterruptedException {
        verifyOpportunityStage();
    }
    @When("Click on Quotes Tab")
    public void click_on_quotes_tab() throws InterruptedException {
        clickQuotesTab("Clicked on Quote Tab");
    }
    @Then("Click On Ordered")
    public void click_on_ordered() throws Exception {
        checkOrderedUnderEdit("Ordered checkbox checked");
    }
    @Then("Click On Orders from RHS")
    public void click_on_orders_from_rhs() {
        clickOnOrderTab("Clicked on Order Tab");
    }
    @Then("Click on Order Number")
    public void click_on_order_number() {
        clickOnOrderNumber("Clicked on Order Number");
    }
    @Then("Click on Activated")
    public void click_on_activated() {
        clickOnOrderActivated("Clicked on Order Activated");
    }
    @Then("Click on MarkAsCurrentStatus Button")
    public void click_on_mark_as_current_status_button() {
        clickOnMarkStatusAsComplete("ClickOnMarkStatus As Complete");
    }
}
