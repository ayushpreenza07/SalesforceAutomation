package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import utilities.ConfigReader;
import utilities.ExcelDataUtil;
import utilities.GlobalUtil;
import utilities.KeywordUtil;
import SalesforceModules.*;

import java.util.HashMap;
import java.util.Map;


import java.util.HashMap;

import static SalesforceModules.QuoteUtil.clickQuoteNumber;
import static SalesforceModules.QuoteUtil.clickQuoteTab;



public class SalesForceCPQ {

    public static HashMap<String, String> dataMap = new HashMap<String, String>();

    public static void main(String[] args) {

        dataMap = ExcelDataUtil.getTestDataWithTestCaseID("Salesforce", "TestData1");

        for (Map.Entry<String, String> entry : dataMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }

    @Given("^Read the test data  \"([^\"]*)\" from Excel$")
    public void read_the_test_data_from_Excel(String arg1) {
        try {
            KeywordUtil.cucumberTagName = "Web";
            dataMap = ExcelDataUtil.getTestDataWithTestCaseID("Salesforce", arg1);
        } catch (Throwable e) {
            GlobalUtil.e = e;
            GlobalUtil.errorMsg = e.getMessage();
            Assert.fail(e.getMessage());
        }

    }

    @When("^navigate to salesforce$")
    public void navigate_to_the_url() throws Exception {

        KeywordUtil.navigateToUrl(ConfigReader.getValue("BASE_URL"));

    }


    @When("^navigate to Salesforce as \"([^\"]*)\"$")
    public void navigateToUrlAccordingToUserType(String userType) throws Exception {

        String baseUrl = "";
        switch (userType) {
            case "System Admin":
                baseUrl = ConfigReader.getValue("BASE_URL");
                break;
            case "Forecast Admin":
                baseUrl = ConfigReader.getValue("Forecast_URL");
                break;
            case "Leads Admin":
                baseUrl = ConfigReader.getValue("Leads_URL");
                break;
            case "Billing Admin":
                baseUrl = ConfigReader.getValue("Billing_URL");
                break;

            case "Billing Opportunity":
                baseUrl = ConfigReader.getValue("Billing_URL_OPP");
                break;

            // Add cases for other user types as needed
            default:
                throw new IllegalArgumentException("Invalid user type: " + userType);
        }

        KeywordUtil.navigateToUrl(baseUrl);
    }

    @When("^login to salesforce$")
    public void login_Salesforce() throws Exception{
        LoginSalesforceUtil.loginToSalesforce(ConfigReader.getValue("salesforceUsername"),ConfigReader.getValue("salesforcePassword"));

    }

    @When("^login to Salesforce with \"([^\"]*)\" credentials$")
    public void loginToSalesforceAccordingToUserType(String userType) throws Exception {
        String username = "";
        String password = "";
        switch (userType) {
            case "System Admin":
                username = ConfigReader.getValue("adminUsername");
                password = ConfigReader.getValue("adminPassword");
                break;
            case "Forecast Admin":
                username = ConfigReader.getValue("forecastUsername");
                password = ConfigReader.getValue("forecastPassword");
                break;
            case "Leads Admin":
                username = ConfigReader.getValue("leadsUsername");
                password = ConfigReader.getValue("leadsPassword");
                break;
            case "Billing Admin":
                username = ConfigReader.getValue("salesforceUsernameBilling");
                password = ConfigReader.getValue("salesforcePasswordBilling");
                break;
            case "Billing Opportunity":
                username = ConfigReader.getValue("BillingUsername");
                password = ConfigReader.getValue("BillingPassword");
                break;

            // Add cases for other user types as needed
            default:
                throw new IllegalArgumentException("Invalid user type: " + userType);
        }
        LoginSalesforceUtil.loginToSalesforce(username, password);
    }

    @When("^create new account$")
    public void create_new_account() throws Exception{
        AccountUtil.createNewAccount(dataMap.get("AccountName"), dataMap.get("Phone"));
    }

    @When("^create contact$")
    public void create_contact() throws Exception{
        ContactUtil.createContact(dataMap.get("Salutation"), dataMap.get("ContactLastName"),dataMap.get("ContactEmail"),dataMap.get("Phone"));
        ContactUtil.backToAccount("Navigated back to account");
    }

    @When("^create opportunity and change its status$")
    public void create_opportunity() throws Exception{
        OppurtunitiesUtil.createOpportunity(dataMap.get("OpportunityName"),dataMap.get("Amount"), dataMap.get("Stage"));

    }

    @When("^create new quote and add product$")
    public void create_new_quote() throws Exception{
        QuoteUtil.createNewQuote(dataMap.get("AccountName"), dataMap.get("OpportunityName"), dataMap.get("QuoteType"));
    }

    @When("^Generate document$")
    public void generateDocument() throws Exception{
        QuoteUtil.clickGenerateDocument("generated document");
    }

    @When("^Verify if product added$")
    public void verify_product_added() throws Exception{

        OppurtunitiesUtil.verifyProduct("verify product");
    }

    @When("^verify if document generated$")
    public void verify_doc_generated() throws Exception{

        OppurtunitiesUtil.verifyDocumentGenerated("verify document generated");
    }

    @When("^Go to quote and change its status to approve$")
    public void change_quote_status() throws Exception{

        QuoteUtil.changeQuoteStatusAndGoToOpportunity("Quote status changed to approved and navigated back to opportunity");
    }

    @When("^Create new contract$")
    public void create_new_contract() throws Exception{
        dataMap = ExcelDataUtil.getTestDataWithTestCaseID("Salesforce", "TestData1");
        ContractUtil.createContract(dataMap.get("AccountName"));
    }

    @When("navigate to setup screen")
    public void navigateToSetupScreen() {
        try {
            KeywordUtil.takeScreenshotAndAttachInReport();
            ForecastingModule.clickOnSetup("Setup page is opened");
        } catch (Exception e) {
            KeywordUtil.catchAssertError(e);
        }
    }

    @Then("Change Opportunity Status to Close Won after Quote Approve")
    public void changeOpportunityStatusToCloseWonAfterQuoteApprove() throws InterruptedException {
        ContractUtil.navigateToOpportunity(dataMap.get("OpportunityName"), "Clicked on opportunity after creating contract");
        OppurtunitiesUtil.selectClosedStatus("Changing Opportunity status to closed won");
    }

    @And("create an order and activate")
    public void createAnOrderAndActivate() throws InterruptedException {
        QuoteUtil.goToQuoteAndCreateOrder("Order generated and activated");
        QuoteUtil.activateOrder();
    }
}
