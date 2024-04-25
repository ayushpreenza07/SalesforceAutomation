package step_definitions;

import SalesforceModules.*;
import io.cucumber.java.en.Given;
import SalesforceModules.AccountUtil;
import SalesforceModules.EditandDeleteUtil;
import SalesforceModules.ServiceSupportUtil;
import io.cucumber.java.en.When;
import org.codehaus.groovy.ast.stmt.CaseStatement;
import org.testng.Assert;
import utilities.ConfigReader;
import utilities.ExcelDataUtil;
import utilities.GlobalUtil;
import utilities.KeywordUtil;

import java.util.HashMap;

public class SalesForceServiceSupportDemo {

    public static HashMap<String, String> dataMap = new HashMap<String, String>();

    @When("^click on service support button$")
    public void click_on_service_support_button() throws Exception {
        AccountUtil.clickSlideShowButton("Clicked menu button");
        ServiceSupportUtil.clickServiceSupportButton("click service support button");
        }

    @When("^create account for service support$")
    public void create_account_service_support() throws Exception {
        dataMap = ExcelDataUtil.getTestDataWithTestCaseID("Salesforce", "TestData1");
        AccountUtil.createNewAccount_ss(dataMap.get("AccountName"), dataMap.get("Phone"));
    }

    @When("^edit account details")
    public void edit_account_details() throws Exception{
        dataMap= SalesForceCPQ.dataMap;
        EditandDeleteUtil.editAccountDetails(dataMap.get("Phone"));
    }

    @When("^delete account")
    public void delete_account_details() throws Exception{
        EditandDeleteUtil.deleteAccount("deleted the account");
    }

    @When("^create contact for service support$")
    public void create_contact() throws Exception{
        dataMap = ExcelDataUtil.getTestDataWithTestCaseID("Salesforce", "TestData1");
        ContactUtil.createContactforServiceSupport(dataMap.get("Salutation"), dataMap.get("ContactLastName"),dataMap.get("ContactEmail"),dataMap.get("Phone"));
    }

    @When("^edit contact details for service support")
    public void edit_contact_details() throws Exception{
        EditandDeleteUtil.editContactDetails("Anjali");
    }

    @When("^filter contact details for service support")
    public void filter_contact_details() throws Exception{
        EditandDeleteUtil.clickContactTab_cnt();
        EditandDeleteUtil.selectFilterInContacts_cnt("Name","Rahul");

    }

    @When("^remove all filters contact details for service support")
    public void removeAll_filter_contact_details() throws Exception{
        EditandDeleteUtil.removeFilter_cnt();

    }

    @When("^delete contact details for service support")
    public void delete_contact_details() throws Exception {
        EditandDeleteUtil.deleteContact("Deleted the contact");
    }

    @When("^click on casesTab for service support")
    public void click_CasesTab() throws Exception {
       CasesUtil.clickCasesTab("Clicked on CasesTab");
    }

    @When("^create new cases for service support")
    public void create_new_Cases() throws Exception {
        dataMap = ExcelDataUtil.getTestDataWithTestCaseID("Salesforce", "TestData1");
        CasesUtil.createNewCase (dataMap.get("status"), dataMap.get("origin"));

    }

    @When("^create new case by searching contact and account")
    public void create_new_Cases_bysearching_account_contact() throws Exception {
        dataMap = ExcelDataUtil.getTestDataWithTestCaseID("Salesforce", "TestData1");
        CasesUtil.createNewCasebySearchingContact_Account(("Anjali"), dataMap.get("AccountName"), dataMap.get("status"), dataMap.get("origin"));

    }

    @When("^edit case details for service support")
    public void edit_case_details() throws Exception{
        dataMap = ExcelDataUtil.getTestDataWithTestCaseID("Salesforce", "TestData1");
        CasesUtil.editCaseDetails(dataMap.get("ContactEmail"));
    }

    @When("^delete case for service support")
    public void delete_case() throws Exception{
        CasesUtil.deleteCase("Deleted the contact");
    }

    @When("^search case for service support")
    public void search_case() throws Exception{
        CasesUtil.searchCase("search the case from the list");
    }

    @When("create new case by creating an new account")
    public void create_new_caseby_newAccount() throws Exception {
        dataMap = ExcelDataUtil.getTestDataWithTestCaseID("Salesforce", "TestData1");
        CasesUtil.newCaseByCreatingNewAccount(dataMap.get("AccountName1"),dataMap.get("PhoneNumber1"),dataMap.get("origin"),"create new account by passing name and phone");
    }

    @When("create new case by creating a new contact")
    public void create_new_caseby_newContact() throws Exception {
        dataMap = ExcelDataUtil.getTestDataWithTestCaseID("Salesforce", "TestData1");
        CasesUtil.newCaseByCreatingNewContact(dataMap.get("FirstName1"),dataMap.get("LastName1"),dataMap.get("origin"),"create new contact by passing firstname, lastname, origin");
    }

    @When("^create new opportunity and change its status$")
    public void create_opportunity() throws Exception{
        dataMap = ExcelDataUtil.getTestDataWithTestCaseID("Salesforce", "TestData1");
        OppurtunitiesUtil.createOpportunity_ss(dataMap.get("OpportunityName"),dataMap.get("Amount"), dataMap.get("Stage"));

    }
}
