package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;
import pageobjects.SalesforceObjects.QuoteObject;
import utilities.ConfigReader;
import utilities.ExcelDataUtil;
import utilities.GlobalUtil;
import utilities.KeywordUtil;
import Salesforce.*;

import java.util.HashMap;

public class salesforceDemo {

    public static HashMap<String, String> dataMap = new HashMap<String, String>();

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

    @When("^login to salesforce$")
    public void login_Salesforce() throws Exception{
        LoginSalesforceUtil.loginToSalesforce(ConfigReader.getValue("salesforceUsername"),ConfigReader.getValue("salesforcePassword"));
    }

    @When("^create new account$")
    public void create_new_account() throws Exception{

        AccountUtil.createNewAccount("TX_demoAccount","400378643", "9717254678");
    }

    @When("^create contact$")
    public void create_contact() throws Exception{
        ContactUtil.createContact("Mr","Ayush","google@sdf.com","9717254678");
    }

    @When("^create opportunity and change its status$")
    public void create_opportunity() throws Exception{
        OppurtunitiesUtil.createOppurtunity("DemoOpportunity","34545", "Prospecting");

    }

    @When("^create new quote and add product$")
    public void create_new_quote() throws Exception{
        QuoteUtil.createNewQuote("TX_demoAccount", "DemoOpportunity", "Quote");
    }

    @When("^Generate document$")
    public void generateDocument() throws Exception{
        QuoteUtil.clickGenerateDocument("generated document");
    }

    @When("^verify if product added$")
    public void verify_product_added() throws Exception{

        OppurtunitiesUtil.verifyProduct("verify product");
    }
}
