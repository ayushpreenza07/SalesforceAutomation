package step_definitions;

import SalesforceModules.AccountUtil;
import SalesforceModules.Leads;
import SalesforceModules.LoginSalesforceUtil;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageobjects.SalesforceObjects.LeadsPage;
import utilities.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static SalesforceModules.Leads.ClickOnHamburgerMenu;
import static SalesforceModules.Leads.dataMap;
import static org.testng.Assert.assertEquals;

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
        ClickOnHamburgerMenu("User Clicked on Hamburger Menu");
    }
    @When("click on Search <{string}>")
    public void click_on_search(String string) throws InterruptedException {
        Leads.EnterText("Leads");
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
        Leads.clickOnCovertedTab();
       }
    @When("Click on Select Convert Status")
    public void click_on_select_convert_status() throws InterruptedException {
        Leads.clickOnCovertedStatusButton();
      }
    @When("Click on Convert button")
    public void click_on_convert_button() throws IOException {
        Leads.clickOnCovertedButton();
       }
    @Then("verify Your lead has been converted")
    public void verify_your_lead_has_been_converted() throws InterruptedException {
        Leads.verifyConvertStatusMessage();
     }

}
