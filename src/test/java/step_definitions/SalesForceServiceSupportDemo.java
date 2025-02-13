package step_definitions;

import SalesforceModules.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import SalesforceModules.AccountUtil;
import SalesforceModules.EditandDeleteUtil;
import SalesforceModules.ServiceSupportUtil;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.codehaus.groovy.ast.stmt.CaseStatement;
import org.testng.Assert;
import pageobjects.SalesforceObjects.QuoteObject;
import pageobjects.SalesforceObjects.ServiceSupportObject;
import utilities.ConfigReader;
import utilities.ExcelDataUtil;
import utilities.GlobalUtil;
import utilities.KeywordUtil;

import java.util.HashMap;

public class SalesForceServiceSupportDemo {

    public static HashMap<String, String> dataMap = new HashMap<String, String>();

    @When("^Click on service support button$")
    public void click_on_service_support_button() throws Exception {
        AccountUtil.clickSlideShowButton("Clicked menu button");
        ServiceSupportUtil.clickServiceSupportButton("click service support button");
        }

    @When("^Create account for service support$")
    public void create_account_service_support() throws Exception {
        dataMap = ExcelDataUtil.getTestDataWithTestCaseID("Salesforce", "TestData1");
        AccountUtil.createNewAccount_ss(dataMap.get("AccountName"), dataMap.get("Phone"));
    }

    @When("^Edit account details")
    public void edit_account_details() throws Exception{
        dataMap = ExcelDataUtil.getTestDataWithTestCaseID("Salesforce", "TestData1");
        EditandDeleteUtil.editAccountDetails(dataMap.get("Phone"));
    }

    @When("^Delete account")
    public void delete_account_details() throws Exception{
        EditandDeleteUtil.deleteAccount("deleted the account");
    }

    @When("^Create contact for service support$")
    public void create_contact() throws Exception{
        dataMap = ExcelDataUtil.getTestDataWithTestCaseID("Salesforce", "TestData1");
        ContactUtil.createContactforServiceSupport(dataMap.get("Salutation"), dataMap.get("ContactLastName"),dataMap.get("ContactEmail"),dataMap.get("Phone"));
    }

    @When("^Edit contact details for service support")
    public void edit_contact_details() throws Exception{
        dataMap = ExcelDataUtil.getTestDataWithTestCaseID("Salesforce", "TestData1");
        EditandDeleteUtil.editContactDetails(dataMap.get("ContactName"));
    }

    @When("^Filter contact details for service support")
    public void filter_contact_details() throws Exception{
        EditandDeleteUtil.clickContactTab_cnt();
        dataMap = ExcelDataUtil.getTestDataWithTestCaseID("Salesforce", "TestData1");
        EditandDeleteUtil.selectFilterInContacts_cnt("Name",dataMap.get("ContactLastName"));

    }

    @When("^Remove all filters contact details for service support")
    public void removeAll_filter_contact_details() throws Exception{
        EditandDeleteUtil.removeFilter_cnt();

    }

    @When("^Delete contact details for service support")
    public void delete_contact_details() throws Exception {
        EditandDeleteUtil.deleteContact("Deleted the contact");
    }

    @When("^Click on casesTab for service support")
    public void click_CasesTab() throws Exception {
       CasesUtil.clickCasesTab("Clicked on CasesTab");
    }

    @When("^Create new cases for service support")
    public void create_new_Cases() throws Exception {
        dataMap = ExcelDataUtil.getTestDataWithTestCaseID("Salesforce", "TestData1");
        CasesUtil.createNewCase (dataMap.get("status"), dataMap.get("origin"));

    }

    @When("^Create new case by searching contact and account")
    public void create_new_Cases_bysearching_account_contact() throws Exception {
        dataMap = ExcelDataUtil.getTestDataWithTestCaseID("Salesforce", "TestData1");
        CasesUtil.createNewCasebySearchingContact_Account(dataMap.get("ContactName"), dataMap.get("AccountName"), dataMap.get("status"), dataMap.get("origin"));

    }

    @When("^Edit case details for service support")
    public void edit_case_details() throws Exception{
        dataMap = ExcelDataUtil.getTestDataWithTestCaseID("Salesforce", "TestData1");
        CasesUtil.editCaseDetails(dataMap.get("ContactEmail"));
    }

    @When("^Delete case for service support")
    public void delete_case() throws Exception{
        CasesUtil.deleteCase("Deleted the contact");
    }

    @When("^Search case for service support")
    public void search_case() throws Exception{
        CasesUtil.searchCase("search the case from the list");
    }

    @When("Create new case by creating an new account")
    public void create_new_caseby_newAccount() throws Exception {
        dataMap = ExcelDataUtil.getTestDataWithTestCaseID("Salesforce", "TestData1");
        CasesUtil.newCaseByCreatingNewAccount(dataMap.get("AccountName1"),dataMap.get("PhoneNumber1"),dataMap.get("origin"),"create new account by passing name and phone");
    }

    @When("Create new case by creating a new contact")
    public void create_new_caseby_newContact() throws Exception {
        dataMap = ExcelDataUtil.getTestDataWithTestCaseID("Salesforce", "TestData1");
        CasesUtil.newCaseByCreatingNewContact(dataMap.get("FirstName1"),dataMap.get("LastName1"),dataMap.get("origin"),"create new contact by passing firstname, lastname, origin");
    }

    @When("^Create new opportunity and change its status$")
    public void create_opportunity() throws Exception{
        dataMap = ExcelDataUtil.getTestDataWithTestCaseID("Salesforce", "TestData1");
        OppurtunitiesUtil.createOpportunity_ss(dataMap.get("OpportunityName"),dataMap.get("Amount"), dataMap.get("Stage"));
    }

    @When("^Create new quote in service support$")
    public void create_new_quote() throws Exception{
        QuoteUtil.createNewQuote_servicesupport(dataMap.get("AccountName"), dataMap.get("OpportunityName"), dataMap.get("QuoteType"));
    }

    @And("Create an order and activate in service support")
    public void createAnOrderAndActivate_ss() throws InterruptedException {
        dataMap = ExcelDataUtil.getTestDataWithTestCaseID("Salesforce", "TestData1");
        QuoteUtil.goToQuoteAndChangeStatus_InReview_ss((dataMap.get("InReviewStatus")),"Quote status is changed to In Review");
        QuoteUtil.goToQuoteAndChangeStatus_Approved_ss((dataMap.get("ApprovedStatus")),"Quote status is changed to Approved");
        QuoteUtil.goToQuoteAndCreateOrder_ss("Order generated and activated");
        QuoteUtil.activateOrder_ss();
        QuoteUtil.changeStatusAsDraft_ss((dataMap.get("changeStatusAsDraft")),"change order status as Draft ");

    }

    @Then("User added contact to campaign in service support")
    public  void addContactToCampaign_ss() throws InterruptedException {
        dataMap = ExcelDataUtil.getTestDataWithTestCaseID("Salesforce", "TestData1");
        CampaignUtil.addContactToCampaign_ss(dataMap.get("ParentCampaign"));
    }

}
