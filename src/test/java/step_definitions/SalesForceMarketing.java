package step_definitions;

import SalesforceModules.AccountUtil;
import SalesforceModules.CampaignUtil;
import SalesforceModules.LoginSalesforceUtil;
import SalesforceModules.OppurtunitiesUtil;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import utilities.ExcelDataUtil;
import utilities.GlobalUtil;
import utilities.HTMLReportUtil;
import utilities.KeywordUtil;

import java.security.Key;
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
    public void user_navigate_to_application() {
        KeywordUtil.navigateToUrl(dataMap.get("URL"));
    }

    @When("user login into the application")
    public void login_into_application() {
        LoginSalesforceUtil.loginToSalesforce(dataMap.get("Username"), dataMap.get("Password"));
    }

    @And("user clicks on the App launcher button")
    public void user_clicks_on_app_launcher() {
        AccountUtil.clickSlideShowButton("user clicked on the App launcher");

    }

    @And("user selects the {string}")
    public void select_option(String option) {
        CampaignUtil.selectOption(option);
    }

    @And("user clicks on Campaigns Tab")
    public void clicks_Campaigns() throws InterruptedException {
        CampaignUtil.clickCampaignTab("click on the campaign tab");
    }

    @Then("user create new Campaign")
    public void create_New_Campaign() {
        try {
            CampaignUtil.createCampaign(dataMap.get("CampaignName"));
            CampaignUtil.verificationMessage();
            KeywordUtil.takeScreenshotAndAttachInReport();
        } catch (Exception e) {
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("user has got the message  : " + e.getMessage()));
        }
    }

    @And("user selects the parent Campaign")
    public void Select_Parent_Campaign() throws InterruptedException {
        CampaignUtil.addParentCampaign(dataMap.get("CampaignName"), dataMap.get("ParentCampaign"));
        KeywordUtil.takeScreenshotAndAttachInReport();
        CampaignUtil.verificationMessage();


    }

    @Then("user selects the edit button")
    public void campaign_Edit() throws InterruptedException {
        CampaignUtil.editCampaignName(dataMap.get("CampaignName"), dataMap.get("EditCampaignName"));
        CampaignUtil.verificationMessage();
        KeywordUtil.takeScreenshotAndAttachInReport();
    }

    @Then("user selects the Delete button")
    public void campaign_Delete() throws InterruptedException {
        CampaignUtil.deleteCampaign(dataMap.get("EditCampaignName"));
        CampaignUtil.verificationMessage();
        KeywordUtil.takeScreenshotAndAttachInReport();
    }

    @Then("user selects the parent comapaign")
    public void select_ParentCampaign() throws InterruptedException {
        System.out.println(dataMap.get("ParentCampaign"));
        CampaignUtil.addParentCampaign(dataMap.get("CampaignName"), dataMap.get("ParentCampaign"));
    }

    @And("user clicks on the Campaign")
    public void click_Campaign() throws InterruptedException {
        CampaignUtil.clickCampaignName(dataMap.get("CampaignName"));
        KeywordUtil.delay(6000);
        KeywordUtil.takeScreenshotAndAttachInReport();
    }

    @Then("user create contact in Campaign")
    public void create_Contact() throws InterruptedException {
        CampaignUtil.addContactInCampaign(dataMap.get("Salutation"), dataMap.get("ContactLastName"), KeywordUtil.generateRandomString(4) + "@gmail.com", dataMap.get("Phone"));
        CampaignUtil.verificationMessage();
        KeywordUtil.takeScreenshotAndAttachInReport();
    }

    @And("user Add the leads in campaign")
    public void click_addLeads() throws InterruptedException {
        CampaignUtil.addLeads(dataMap.get("LeadName"));

    }

    @Then("user clicks on the Contact tab")
    public void click_contactTab() throws InterruptedException {
        CampaignUtil.clickContactTab();

    }

    @Then("user selects the filter")
    public void selectFilter() throws InterruptedException {
        CampaignUtil.selectFilterInContacts(dataMap.get("FieldValue"),dataMap.get("ContactLastName"));
        KeywordUtil.takeScreenshotAndAttachInReport();
    }

    @Then("user edit the contact")
    public void edit_Contact() throws InterruptedException {
        CampaignUtil.editContact(KeywordUtil.generateRandomString(4) + "@gmail.com",dataMap.get("ContactLastName"));
        CampaignUtil.verificationMessage();
        KeywordUtil.takeScreenshotAndAttachInReport();
    }

    @Then("user Delete the contact")
    public void deleteContact() throws InterruptedException {
       CampaignUtil.deleteContact(dataMap.get("ContactLastName"));
       KeywordUtil.takeScreenshotAndAttachInReport();
    }

    @Then("user remove the filter")
    public void removeFilter() throws InterruptedException {
         CampaignUtil.removeFilter();
    }

    @Then("user create new contact in Contact")
    public void createNewContact() throws InterruptedException {
        CampaignUtil.createContactInContactTab( dataMap.get("ContactLastName"), KeywordUtil.generateRandomString(4) + "@gmail.com");
        CampaignUtil.verificationMessage();
        KeywordUtil.takeScreenshotAndAttachInReport();
    }

    @Then("user create new opportunity in Contact")
    public void createOpportunityInContact() throws InterruptedException {
         CampaignUtil.createOpportunityInContact(dataMap.get("OpportunityName"),dataMap.get("Amount"), dataMap.get("Stage"));
        CampaignUtil.verificationMessage();
        KeywordUtil.takeScreenshotAndAttachInReport();

    }

    @Then("user is able to see the opportunity")
    public void seeOpportunityInContact() throws InterruptedException {
        CampaignUtil.seeOpportunityInContact();
        KeywordUtil.takeScreenshotAndAttachInReport();
        GlobalUtil.getDriver().navigate().back();
    }

    @Then("user added Contact to campaign")
    public  void addContactToCampaign(){
        CampaignUtil.addContactToCampaign(dataMap.get("ParentCampaign"));
        KeywordUtil.takeScreenshotAndAttachInReport();
    }

    @Then("user is able to see the campaign History")
    public  void seeCampaignHistory(){
        CampaignUtil.seeCampaignHistory();
        KeywordUtil.takeScreenshotAndAttachInReport();
        GlobalUtil.getDriver().navigate().back();
    }

    @Then("user added case in the contact")
    public void addCase() throws InterruptedException {
        CampaignUtil.addCaseInContact();
        CampaignUtil.verificationMessage();
        KeywordUtil.takeScreenshotAndAttachInReport();
    }

    @Then("user able to see the case history")
    public void seeCaseHistory(){
        CampaignUtil.seeCaseHistory();
        KeywordUtil.takeScreenshotAndAttachInReport();
        GlobalUtil.getDriver().navigate().back();

    }

    @Then("user click on the lead Tab")
    public void clickOnLeadTab(){
     CampaignUtil.clickLeadsTab();
    }

    @Then("user create new lead")
    public static void createLead() throws InterruptedException {
        dataMap = ExcelDataUtil.getTestDataWithTestCaseID("Salesforce", "TestData2");
        CampaignUtil.createLead(dataMap.get("LastName"),dataMap.get("CityName"));
        KeywordUtil.takeScreenshotAndAttachInReport();
    }

    @Then("user selects the filter in Lead")
    public void searchLeadUsingFilter() throws InterruptedException {
        dataMap = ExcelDataUtil.getTestDataWithTestCaseID("Salesforce", "TestData2");
        CampaignUtil.selectFilterInContacts(dataMap.get("FieldValue"),dataMap.get("LastName"));
        KeywordUtil.takeScreenshotAndAttachInReport();
    }

    @Then("user edit the lead")
    public void editLead() throws InterruptedException {
        CampaignUtil.editLead(dataMap.get("LastName"),dataMap.get("LastName"),dataMap.get("CityName"));
        KeywordUtil.takeScreenshotAndAttachInReport();
    }

    @Then("user delete the lead")
    public void deleteLead() throws InterruptedException {
        CampaignUtil.deleteLead(dataMap.get("LastName"));
        KeywordUtil.takeScreenshotAndAttachInReport();
    }


    @And("user clicks on Opportunities Tab")
    public void userClicksOnOpportunitiesTab() throws InterruptedException {
        OppurtunitiesUtil.clickOpportunityTab("clicks on Opportunities Tab");
    }

    @Then("user create new Opportunity")
    public void userCreateNewOpportunity() throws InterruptedException {
        OppurtunitiesUtil.createOpportunityFromOpportunityTab(dataMap.get("OpportunityName"),dataMap.get("Amount"), dataMap.get("Stage"));
    }

    @And("user edit new Opportunity")
    public void userEditNewOpportunity() throws InterruptedException {
        OppurtunitiesUtil.editOpportunityFromOpportunityTab("DemoOpportunityUpdated","3004");

    }

    @And("user delete new Opportunity")
    public void userDeleteNewOpportunity() throws InterruptedException {
        OppurtunitiesUtil.deleteOpportunityFromOpportunityTab();

    }
}
