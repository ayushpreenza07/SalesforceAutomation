package step_definitions;

import SalesforceModules.AccountUtil;
import SalesforceModules.LoginSalesforceUtil;
import SalesforceModules.SalesForceBillingUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
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
}

