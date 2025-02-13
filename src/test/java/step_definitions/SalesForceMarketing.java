package step_definitions;

import SalesforceModules.*;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobjects.SalesforceObjects.QuoteObject;
import utilities.ExcelDataUtil;
import utilities.GlobalUtil;
import utilities.HTMLReportUtil;
import utilities.KeywordUtil;

import java.security.Key;
import java.util.HashMap;

public class SalesForceMarketing {
    public static HashMap<String, String> dataMap = new HashMap<String, String>();
    public static String leadName = KeywordUtil.generateRandomName();
    public static String leadCompanyName = "TX";
    public static String opportunityName="";


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


    @And("User clicks on the App launcher button")
    public void userClicksOnAppLauncher() {
        AccountUtil.clickSlideShowButton("User clicked on the App launcher");

    }

    @And("User selects the {string}")
    public void selectOption(String option) {
        CampaignUtil.selectOption(option);
    }

    @And("User clicks on Campaigns Tab")
    public void clicksCampaigns() throws InterruptedException {
        CampaignUtil.clickCampaignTab("click on the campaign tab");
    }

    @Then("User create new Campaign")
    public void createNewCampaign() throws InterruptedException {
        KeywordUtil.delay(5000);
        try {
            CampaignUtil.createCampaign(dataMap.get("CampaignName"));
            CampaignUtil.verificationMessage();
            KeywordUtil.takeScreenshotAndAttachInReport();
        } catch (Exception e) {
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("User has got the message  : " + e.getMessage()));
        }

    }

    @Then("User create new ParentCampaign")
    public void createNewparentCampaign() {
        try {
            CampaignUtil.createCampaign(dataMap.get("ParentCampaign"));
            CampaignUtil.verificationMessage();
            KeywordUtil.takeScreenshotAndAttachInReport();
        } catch (Exception e) {
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("User has got the message  : " + e.getMessage()));
        }

    }


    @And("User selects the parent Campaign")
    public void SelectParentCampaign() throws InterruptedException {
        CampaignUtil.addParentCampaign(dataMap.get("CampaignName"), dataMap.get("ParentCampaign"));
        KeywordUtil.takeScreenshotAndAttachInReport();
        CampaignUtil.verificationMessage();

    }


    @Then("User selects the edit button")
    public void campaignEdit() throws InterruptedException {
        CampaignUtil.editCampaignName(dataMap.get("CampaignName"), dataMap.get("EditCampaignName"));
        CampaignUtil.verificationMessage();
        KeywordUtil.takeScreenshotAndAttachInReport();
    }

    @Then("User selects the Delete button")
    public void campaignDelete() throws InterruptedException {
        CampaignUtil.deleteCampaign(dataMap.get("EditCampaignName"));
        CampaignUtil.verificationMessage();
        KeywordUtil.takeScreenshotAndAttachInReport();
    }

    @Then("User selects the parent comapaign")
    public void selectParentCampaign() throws InterruptedException {
        System.out.println(dataMap.get("ParentCampaign"));
        CampaignUtil.addParentCampaign(dataMap.get("CampaignName"), dataMap.get("ParentCampaign"));
    }

    @And("User clicks on the Campaign")
    public void clickCampaign() throws InterruptedException {
        CampaignUtil.clickCampaignName(dataMap.get("CampaignName"));
        KeywordUtil.delay(6000);
        KeywordUtil.takeScreenshotAndAttachInReport();
    }

    @Then("User create contact in Campaign")
    public void createContact() throws InterruptedException {
        KeywordUtil.delay(6000);
        CampaignUtil.addContactInCampaign(dataMap.get("Salutation"), dataMap.get("ContactLastName"), KeywordUtil.generateRandomString(4) + "@gmail.com", dataMap.get("Phone"));
        CampaignUtil.verificationMessage();
        KeywordUtil.takeScreenshotAndAttachInReport();
    }

    @And("User Add the leads in campaign")
    public void clickaddLeads() throws InterruptedException {
        CampaignUtil.addLeads(dataMap.get("LeadName"));

    }

    @Then("User clicks on the Contact tab")
    public void clickcontactTab() throws InterruptedException {
        CampaignUtil.clickContactTab();

    }

    @Then("User selects the filter")
    public void selectFilter() throws InterruptedException {
        CampaignUtil.selectFilterInContacts(dataMap.get("FieldValue"),dataMap.get("ContactLastName"));
        KeywordUtil.takeScreenshotAndAttachInReport();
    }

    @Then("User edit the contact")
    public void editContact() throws InterruptedException {
        CampaignUtil.editContact(KeywordUtil.generateRandomString(4) + "@gmail.com",dataMap.get("ContactLastName"));
        CampaignUtil.verificationMessage();
        KeywordUtil.takeScreenshotAndAttachInReport();
    }

    @Then("User delete the contact")
    public void deleteContact() throws InterruptedException {
       CampaignUtil.deleteContact(dataMap.get("ContactLastName"));
       KeywordUtil.takeScreenshotAndAttachInReport();
    }

    @Then("User remove the filter")
    public void removeFilter() throws InterruptedException {
         CampaignUtil.removeFilter();
    }

    @Then("User create new contact in Contact")
    public void createNewContact() throws InterruptedException {
        CampaignUtil.createContactInContactTab( dataMap.get("ContactLastName"), KeywordUtil.generateRandomString(4) + "@gmail.com");
        CampaignUtil.verificationMessage();
        KeywordUtil.takeScreenshotAndAttachInReport();
    }

    @Then("User create new opportunity in Contact")
    public void createOpportunityInContact() throws InterruptedException {
         CampaignUtil.createOpportunityInContact(dataMap.get("OpportunityName"),dataMap.get("Amount"), dataMap.get("Stage"));
        CampaignUtil.verificationMessage();
        KeywordUtil.takeScreenshotAndAttachInReport();

    }

    @Then("User is able to see the opportunity")
    public void seeOpportunityInContact() throws InterruptedException {
        CampaignUtil.seeOpportunityInContact();
        KeywordUtil.takeScreenshotAndAttachInReport();
        GlobalUtil.getDriver().navigate().back();

    }

    @Then("User added Contact to campaign")
    public  void addContactToCampaign(){
        CampaignUtil.addContactToCampaign(dataMap.get("CampaignName"));
        KeywordUtil.takeScreenshotAndAttachInReport();
    }

    @Then("User is able to see the campaign History")
    public  void seeCampaignHistory(){
        CampaignUtil.seeCampaignHistory();
        KeywordUtil.takeScreenshotAndAttachInReport();
        GlobalUtil.getDriver().navigate().back();
    }

    @Then("User added case in the contact")
    public void addCase() throws InterruptedException {
        CampaignUtil.addCaseInContact();
        CampaignUtil.verificationMessage();
        KeywordUtil.takeScreenshotAndAttachInReport();
    }

    @Then("User able to see the case history")
    public void seeCaseHistory(){
        CampaignUtil.seeCaseHistory();
        KeywordUtil.takeScreenshotAndAttachInReport();
        GlobalUtil.getDriver().navigate().back();


    }

    @Then("User click on the lead Tab")
    public void clickOnLeadTab(){
     CampaignUtil.clickLeadsTab();
    }

    @Then("User create new lead")
    public static void createLead() throws InterruptedException {
        dataMap = ExcelDataUtil.getTestDataWithTestCaseID("Salesforce", "TestData2");
        CampaignUtil.createLead(dataMap.get("LastName"),dataMap.get("CityName"));
        KeywordUtil.takeScreenshotAndAttachInReport();
    }

    @Then("User selects the filter in Lead")
    public void searchLeadUsingFilter() throws InterruptedException {
        dataMap = ExcelDataUtil.getTestDataWithTestCaseID("Salesforce", "TestData2");
        CampaignUtil.selectFilterInContacts(dataMap.get("FieldValue"),dataMap.get("LastName"));
        KeywordUtil.takeScreenshotAndAttachInReport();
    }

    @Then("User edit the lead")
    public void editLead() throws InterruptedException {
        CampaignUtil.editLead(dataMap.get("LastName"),dataMap.get("LastName"),dataMap.get("CityName"));
        KeywordUtil.takeScreenshotAndAttachInReport();
    }

    @Then("User delete the lead")
    public void deleteLead() throws InterruptedException {
        CampaignUtil.deleteLead(dataMap.get("LastName"));
        KeywordUtil.takeScreenshotAndAttachInReport();
    }


    @And("User clicks on Opportunities Tab")
    public void userClicksOnOpportunitiesTab() throws InterruptedException {
        OppurtunitiesUtil.clickOpportunityTab("clicks on Opportunities Tab");
    }

    @Then("User create new Opportunity")
    public void userCreateNewOpportunity() throws InterruptedException {
        dataMap = ExcelDataUtil.getTestDataWithTestCaseID("Salesforce", "TestData1");
        OppurtunitiesUtil.createOpportunityFromOpportunityTab(dataMap.get("OpportunityName"),dataMap.get("Amount"), dataMap.get("Stage"));
    }

    @And("User edit new Opportunity")
    public void userEditNewOpportunity() throws InterruptedException {
        OppurtunitiesUtil.editOpportunityFromOpportunityTab("DemoOpportunityUpdated","3004");

    }

    @And("User delete new Opportunity")
    public void userDeleteNewOpportunity() throws InterruptedException {
        OppurtunitiesUtil.deleteOpportunityFromOpportunityTab();

    }

    @And("Change Opportunity Status")
    public void changeOpportunityStatus() throws InterruptedException{
        OppurtunitiesUtil.selectStageProposalQuote("proposal stage selected");
        KeywordUtil.takeScreenshotAndAttachInReport();
        OppurtunitiesUtil.setMarkAsCurrentStages("stage marked");
        KeywordUtil.takeScreenshotAndAttachInReport();
    }

    @And("User create Quotas an add Product")
    public void userCreateQuotas() throws Exception {
        KeywordUtil.waitForVisible(QuoteObject.quotesBtn);
        KeywordUtil.click(QuoteObject.quotesBtn,"Click on quotas");
        QuoteUtil.createNewQuoteForMarketing(dataMap.get("AccountName"), opportunityName, dataMap.get("QuoteType"));
    }

    @And("Add Lead To Campaign")
    public static void addLeadToCampaign() {
        try {
            dataMap = ExcelDataUtil.getTestDataWithTestCaseID("Salesforce", "TestData1");
            CampaignUtil.addLeadToCampaign(dataMap.get("CampaignName"), leadName, leadCompanyName);
        } catch (Exception e) {
            CampaignUtil.verificationMessage();
        }
    }

    @And("Change Lead Status")
    public static void changeLeadStatus() {
        try {
            CampaignUtil.changeLeadStatusToConverted(leadName);
        } catch (Exception e) {
            CampaignUtil.verificationMessage();
        }
    }

    @And("Create an order and activate in marketing crm")
    public void createOrderAndActivate() {
        try {

            CampaignUtil.goToQuoteAndChangeStatus_Approved_ss(("Approved"), "Quote status is changed to Approved");
            CampaignUtil.goToQuoteAndCreateOrder_ss("Order generated and activated");
            CampaignUtil.activateOrder_ss();
            KeywordUtil.takeScreenshotAndAttachInReport();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


}