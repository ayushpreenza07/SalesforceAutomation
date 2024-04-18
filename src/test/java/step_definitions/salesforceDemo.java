package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;
import pageobjects.SalesforceObjects.OppurtunitiesObject;
import pageobjects.SalesforceObjects.QuoteObject;
import utilities.ConfigReader;
import utilities.ExcelDataUtil;
import utilities.GlobalUtil;
import utilities.KeywordUtil;
import SalesforceModules.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import java.util.HashMap;

public class salesforceDemo {

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

        KeywordUtil.navigateToUrl("https://testing-f5-dev-ed.develop.my.salesforce.com");
//        dataMap = ExcelDataUtil.getTestDataWithTestCaseID("Salesforce", "TestData1");
//        KeywordUtil.navigateToUrl(dataMap.get("URL"));
    }

    @When("^login to salesforce$")
    public void login_Salesforce() throws Exception{
//        dataMap = ExcelDataUtil.getTestDataWithTestCaseID("Salesforce", "TestData1");
//        LoginSalesforceUtil.loginToSalesforce(dataMap.get("Username"),dataMap.get("Password"));
        LoginSalesforceUtil.loginToSalesforce(ConfigReader.getValue("salesforceUsername"),ConfigReader.getValue("salesforcePassword"));

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

    @When("^verify if product added$")
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

    @When("^create new contract$")
    public void create_new_contract() throws Exception{

        ContractUtil.createContract(dataMap.get("AccountName"));
    }

    @And("navigate to setup screen")
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
