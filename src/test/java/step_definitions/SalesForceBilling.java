package step_definitions;

import SalesforceModules.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.SalesforceObjects.QuoteObject;
import utilities.ConfigReader;
import utilities.ExcelDataUtil;
import utilities.KeywordUtil;

import java.util.HashMap;

public class SalesForceBilling {

    public static HashMap<String, String> dataMap = new HashMap<String, String>();
    @And("go to salesforce cpq")
    public void goToSalesforceCpq() {
        AccountUtil.clickSlideShowButton("Clicked menu button");
        AccountUtil.clickCpqButton("CPQ selected");
    }

    @And("go to products tab")
    public void goToProducts() {
        SalesForceBillingUtil.productsTab("Products tab clicked");
    }

    @And("Create new product")
    public void createNewProduct() throws Exception {
        SalesForceBillingUtil.newProduct();
    }

    @And("add price book and standard price")
    public void addPriceBookAndStandardPrice() throws InterruptedException {
        SalesForceBillingUtil.clickRelated("Related tab selected");
        SalesForceBillingUtil.addStandardPrice("Added standard price");
    }

    @And("Click on Okay")
    public void click_Okay() {
        LoginSalesforceUtil.okayLogin();
    }

    @And("edit standard price book")
    public void editStandardPriceBook() throws InterruptedException {

        SalesForceBillingUtil.editStandardPrice("Standard price edit");
    }

    @And("search product in products tab")
    public void searchProductInProductsTab() {
        SalesForceBillingUtil.searchProduct("INTP");
    }



    @And("Click on view all")
    public void clickOnViewAll() throws InterruptedException {
        SalesForceBillingUtil.viewAll("Clicked on view all option");
    }
    @And("Click on salesforce Billing")
    public void clickOnSalesforceBilling() throws InterruptedException {
        SalesForceBillingUtil.salesforceBilling("Clicked on salesforce Billing option");
    }
    @And("Create customer account")
    public void createNewCustomerAccount() throws InterruptedException {
        dataMap = ExcelDataUtil.getTestDataWithTestCaseID("Salesforce", "TestData1");
        SalesForceBillingUtil.createCustomerAccount(dataMap.get("AccountName"), dataMap.get("Phone"));
    }
    @And("Create contact link existing and New Contact")
    public void createContactLinkExistingAndNewAccount() throws InterruptedException {
        dataMap = ExcelDataUtil.getTestDataWithTestCaseID("Salesforce", "TestData1");
        SalesForceBillingUtil.createContactLinkExisting(dataMap.get("Salutation"), dataMap.get("ContactLastName"), dataMap.get("ContactEmail"), dataMap.get("Phone"));
        SalesForceBillingUtil.createAnotherContactFromLinkExisting(dataMap.get("Salutation"), dataMap.get("ContactLastname1"), dataMap.get("ContactEmail1"), dataMap.get("ContactPhone1"));
        SalesForceBillingUtil.createNewContactOfContacts(dataMap.get("Salutation1"), dataMap.get("ContactLastName2"), dataMap.get("AccountName1"), dataMap.get("ContactPhone2"));
    }

    @When("^Create new quote and add product in billing section$")
    public void create_new_quote_billing() throws Exception{
        dataMap = ExcelDataUtil.getTestDataWithTestCaseID("Salesforce", "TestData1");
        QuoteUtil.createNewQuote_billing(dataMap.get("AccountName"), dataMap.get("OpportunityName"), dataMap.get("QuoteType"));
    }

    @And("^Delete Quote in billing section$")
    public void delete_quote_billing() throws Exception{
        QuoteUtil.deleteQuote_billing("Deleted the Quote in billing section");
    }

    @And("^Search Opportunity to change status and verify the added quotes$")
    public void search_oppo_billing() throws Exception{
        OppurtunitiesUtil.searchOppoAndVerifyAddedProductsInQuotes_billing("Deleted the Quote in billing section");
    }

    @And("^Search quote to edit$")
    public void search_edit_quote_billing() throws Exception{
        dataMap = ExcelDataUtil.getTestDataWithTestCaseID("Salesforce", "TestData1");
        QuoteUtil.searchEditQuote_billing(dataMap.get("AccountName"), dataMap.get("OpportunityName"), dataMap.get("QuoteType"));
    }

    @And("Create an order and activate in billing section")
    public void create_An_Order_And_Activate_billing() throws InterruptedException {
        dataMap = ExcelDataUtil.getTestDataWithTestCaseID("Salesforce", "TestData1");
        QuoteUtil.goToQuoteAndChangeStatus_InReview_billing((dataMap.get("InReviewStatus")), "Quote status is changed to In Review");
        QuoteUtil.goToQuoteAndChangeStatus_Approved_billing((dataMap.get("ApprovedStatus")), "Quote status is changed to Approved");
        QuoteUtil.goToQuoteAndCreateOrder_billing("Order generated and activated");
        QuoteUtil.activateOrder_billing();
        QuoteUtil.changeStatusAsDraft_billing((dataMap.get("changeStatusAsDraft")), "change order status as Draft ");
            }

    @When("^Create new contract in billing section$")
    public void createNewContract() throws Exception{
        dataMap = ExcelDataUtil.getTestDataWithTestCaseID("Salesforce", "TestData1");
        ContractUtil.createContract_billing(dataMap.get("AccountName"));
    }

    @Then("Change Opportunity Status to Close Won")
    public void changeOpportunityStatusToCloseWon() throws InterruptedException {
        OppurtunitiesUtil.openOpportunity_billing("Open opportunity");
        OppurtunitiesUtil.selectClosedStatus("Changing Opportunity status to closed won");
    }

    @Then("Generate invoice in billing section")
    public void generate_Invoices_In_Billing() throws InterruptedException {
        dataMap = ExcelDataUtil.getTestDataWithTestCaseID("Salesforce", "TestData1");
        InvoiceUtil.openOrdersBilling("Open the order for generating invoice");
        InvoiceUtil.generateInvoiceBilling(dataMap.get("TaxStatus"),dataMap.get("PostedStatus"),"Generate Invoice");
    }

    @Then("Payments using cards")
    public void payments_Using_Cards() throws InterruptedException {
        dataMap = ExcelDataUtil.getTestDataWithTestCaseID("Salesforce", "TestData1");
        InvoiceUtil.paymentsBilling(dataMap.get("PaymentsAccount"),"5000",dataMap.get("PaymentType"),dataMap.get("InvoiceNumber"),"Make payments");

    }

    @Then("Create bundle product and add feature and Options")
    public void create_Bundle_Features_Options() throws InterruptedException {
        dataMap = ExcelDataUtil.getTestDataWithTestCaseID("Salesforce", "TestData1");
        InvoiceUtil.createBundleFeaturesOptions("Create Bundle Products, add features");
    }

}

