package step_definitions;

import SalesforceModules.AccountUtil;
import SalesforceModules.Compaignutil;
import SalesforceModules.ContactUtil;
import SalesforceModules.LoginSalesforceUtil;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobjects.SalesforceObjects.AccountObject;
import pageobjects.SalesforceObjects.Comapign_object;
import utilities.ExcelDataUtil;
import utilities.GlobalUtil;
import utilities.HTMLReportUtil;
import utilities.KeywordUtil;

import java.util.HashMap;

public class SalesForceMarketing {
    public static HashMap<String, String> dataMap = new HashMap<String, String>();


    @Given("Read the testdata {string} and {string} from excel file")
    public void readTheTestdataFromExcelFile(String arg1, String arg2) {
        try {
            KeywordUtil.cucumberTagName = "Web";
            dataMap = ExcelDataUtil.getTestDataWithTestCaseID(arg2, arg1);
        } catch (Throwable e) {
            GlobalUtil.e = e;
            GlobalUtil.errorMsg = e.getMessage();
            Assert.fail(e.getMessage());
        }

    }

    @Given("user navigate to the salesforce application")
    public void user_navigate_to_application(){
        KeywordUtil.navigateToUrl(dataMap.get("URL"));
    }

    @When("user login into the application")
    public void login_into_application(){
        LoginSalesforceUtil.loginToSalesforce(dataMap.get("Username"),dataMap.get("Password"));
    }

    @And("user clicks on the App launcher button")
    public void user_clicks_on_app_launcher(){
        AccountUtil.clickSlideShowButton("user clicked on the App launcher");

    }

    @And("user selects the {string}")
    public void select_option(String option) {
        KeywordUtil.click(Comapign_object.select_option(option), "user has succesfully selected the " +option);
        KeywordUtil.takeScreenshotAndAttachInReport();
    }

    @Then("user clicks on Compaigns Tab")
    public void clicks_comapigns() throws InterruptedException {
      Compaignutil.clickComapignTab("click on the compaign tab");
    }

    @Then("user create new compiagn")
    public void create_new_compaign(){

        try{
            Compaignutil.createcompaign(dataMap.get("ComapaignName"));
        }catch (Exception e){
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("user has got the message  : " +e.getMessage()));

        }

    }

    @And("user selects the parent compaign")
    public void Select_aprent_compaign() throws InterruptedException {
        Compaignutil.addparentcomapign();
       Compaignutil.verificationmessage();
        KeywordUtil.takeScreenshotAndAttachInReport();
    }

    @Then("user create contact in comapign")
    public void create_contact() throws InterruptedException {
        Compaignutil.addContactInComapign(dataMap.get("Salutation"), dataMap.get("ContactLastName"),Compaignutil.generateRandomString(5)+"@gmail.com",dataMap.get("Phone"));
        Compaignutil.verificationmessage();
        KeywordUtil.takeScreenshotAndAttachInReport();
    }

    @Then("user selects the edit button")
    public void compaign_edit() throws InterruptedException {

           Compaignutil.editcompaignname(dataMap.get("ComapaignName"),dataMap.get("EditCompaignName"));

           Compaignutil.verificationmessage();
        KeywordUtil.takeScreenshotAndAttachInReport();
    }

@Then("user selects the Delete button")
    public void comapign_delete() throws InterruptedException {
    Compaignutil.deletecompaign(dataMap.get("EditCompaignName"));
    Compaignutil.verificationmessage();
    KeywordUtil.takeScreenshotAndAttachInReport();
}



}
