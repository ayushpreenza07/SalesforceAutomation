package SalesforceModules;

import org.openqa.selenium.By;
import org.testng.Assert;
import pageobjects.SalesforceObjects.InvoiceObject;
import pageobjects.SalesforceObjects.OppurtunitiesObject;
import pageobjects.SalesforceObjects.QuoteObject;
import pageobjects.SalesforceObjects.ServiceSupportObject;
import utilities.ExcelDataUtil;
import utilities.KeywordUtil;

import java.util.HashMap;

public class InvoiceUtil {
    static HashMap<String, String> map = new HashMap<>();


   static String optionalskus = "//lightning-base-combobox-formatted-text[contains(@title,'Samsung')]";
   static String accPayments = "//lightning-base-combobox-formatted-text[contains(@title,'Bill')]";

    /**Pre-requisite- Order has to be placed with product whose type is one-time off.
     * Pre-requisite- Order has to be placed with product whose type is Recurring.
     * To generate the invoices
     * Open the orders in billing module
     *
     *
     * @param logStep the log
     */
    public static void openOrdersBilling(String logStep) throws InterruptedException {
        KeywordUtil.clickJS_component(QuoteObject.clickOnOrders,"Click on Orders tab");
        KeywordUtil.clickJS_component(QuoteObject.dropDownOrders,"Click on dropdownOption");
        KeywordUtil.clickJS_component(QuoteObject.allOrders,"Select All Orders");
        KeywordUtil.waitForElementPresence(InvoiceObject.vieworder);
        KeywordUtil.clickJS_component(InvoiceObject.vieworder,"Open Order");

    }

    /**
     * Setting the tax status for generated invoice
     *
     * @param logStep the log
     * @param status the status
     */
    public static void setTaxInfo(String status, String logStep) throws InterruptedException {
        boolean flag = false;
        int size = 0;
        KeywordUtil.waitForElementPresence(InvoiceObject.selectTaxstatus);
        KeywordUtil.click(InvoiceObject.selectTaxstatus, logStep);

        String changeStatus_ss = "//div[label[text()='Tax Status']]/div//span[@class='slds-truncate'][contains(text(),'"+status+"')]";
        try {
            size = KeywordUtil.getDriver().findElements(By.xpath(changeStatus_ss)).size();

        } catch (Exception e) {
        }

        if (size == 0) {
            KeywordUtil.takeScreenshotAndAttachInReport();
            Assert.fail("no such status present");

        } else {
            KeywordUtil.click(By.xpath(changeStatus_ss), "status changed as --None--");
        }
    }
        /**
         * Setting the status as posted for generated invoice
         *
         * @param status the stage
         * @param logStep the log
         */
    public static void setPostedStatus(String status, String logStep) throws InterruptedException {
        boolean flag = false;
        int size = 0;
        KeywordUtil.waitForElementPresence(InvoiceObject.selectstatus);
        KeywordUtil.click(InvoiceObject.selectstatus,logStep);
        String xpath   ="(//lightning-base-combobox-item[@class='slds-media slds-listbox__option slds-media_center slds-media_small slds-listbox__option_plain'][contains(@data-value,'"+status+"')])[1]";
        try {
            size = KeywordUtil.getDriver().findElements(By.xpath(xpath)).size();

        } catch (Exception e) {
        }

        if (size == 0) {
            KeywordUtil.takeScreenshotAndAttachInReport();
           Assert.fail("no such status present");

        } else {
            KeywordUtil.click(By.xpath(xpath), "status changed as Posted");
        }

    }

    /**
     *Generate invoices in billing module
     *
     *
     * @param logStep the log
     */
    public static void generateInvoiceBilling(String taxStatus,String postedStatus, String logStep) throws InterruptedException {
        KeywordUtil.clickJS_component(InvoiceObject.detailsTab,"Open Order");
        KeywordUtil.clickJS_component(InvoiceObject.billNowEditButton,"Open Order");
        KeywordUtil.clickJS_component(InvoiceObject.billNowButton,"Open Order");
        QuoteUtil.clickSaveButton("clicked save button");
        KeywordUtil.clickJS_component(InvoiceObject.relatedTab,"Open Order");
        KeywordUtil.clickJS_component(InvoiceObject.invoices,"Click on Invoice");
        KeywordUtil.clickJS_component(InvoiceObject.openInvoices,"Open the Invoice");

        //code for tax info boxes
        KeywordUtil.waitForElementPresence(InvoiceObject.checkboxForTaxInfo);
        KeywordUtil.clickJS_component(InvoiceObject.checkboxForTaxInfo,"edit button on tax info");
        setTaxInfo(taxStatus,"select tax status as None");
        KeywordUtil.waitForElementPresence(InvoiceObject.taxMessage);
        KeywordUtil.clearInput(InvoiceObject.taxMessage);

        //select status as posted

        setPostedStatus(postedStatus,"select status as Posted");
        QuoteUtil.clickSaveButton("clicked save button");
    }


    /**
     * Select the Account field for new payments
     *
     * @param logStep the log
     * @param account the account name
     */
    public static void selectAccountPayments(String account, String logStep) throws InterruptedException {
        boolean flag = false;
        KeywordUtil.waitForVisible(ServiceSupportObject.searchAccounts_quote_ss);
        KeywordUtil.click(ServiceSupportObject.searchAccounts_quote_ss, logStep);
        KeywordUtil.inputText(ServiceSupportObject.searchAccounts_quote_ss, "Bill", logStep);

        try {
            flag = KeywordUtil.getDriver().findElement(By.xpath(accPayments)).isDisplayed();

        } catch (Exception e) {
        }

        if (!flag) {
            Assert.fail("no such account present");
        } else {
            KeywordUtil.click(By.xpath(accPayments), "account selected");
        }
    }

    /**
     * Enter enterAmount for new payment
     *
     * @param amount the amount
     * @param logStep the logStep
     */
    public static void enterAmountPayments(String amount, String logStep){
        KeywordUtil.waitForVisible(InvoiceObject.amountField);
        KeywordUtil.inputText(InvoiceObject.amountField, amount,logStep);
    }

    /**
     * Setting the payment type as posted for generated invoice
     *
     * @param paymentType the payment type
     * @param logStep the log
     */
    public static void setPaymentType(String paymentType, String logStep) throws InterruptedException {
        boolean flag = false;
        int size = 0;
        KeywordUtil.waitForVisible(InvoiceObject.paymenttype);
        KeywordUtil.click(InvoiceObject.paymenttype,logStep);
        String xpath ="//lightning-base-combobox-item[contains(@data-value,'"+paymentType+"')]";
        try {
            size = KeywordUtil.getDriver().findElements(By.xpath(xpath)).size();

        } catch (Exception e) {
        }

        if (size == 0) {
            KeywordUtil.takeScreenshotAndAttachInReport();
            Assert.fail("no such status present");

        } else {
            KeywordUtil.click(By.xpath(xpath), "status changed as Credit Cards");
        }

    }

    /**
     * Select the invoice field for new payments
     *
     * @param logStep the log
     * @param invoice the invoice number
     */
    public static void selectInvoices(String invoice, String logStep) throws InterruptedException {
        boolean flag = false;
        KeywordUtil.waitForVisible(InvoiceObject.selectInvoices);
        KeywordUtil.click(InvoiceObject.selectInvoices, logStep);
        KeywordUtil.inputText(InvoiceObject.selectInvoices, "INV", logStep);
        String accname = "(//lightning-base-combobox-formatted-text[contains(@title,'INV')])[1]";

        try {
            flag = KeywordUtil.getDriver().findElement(By.xpath(accname)).isDisplayed();

        } catch (Exception e) {
        }

        if (!flag) {
            Assert.fail("no such account present");
        } else {
            KeywordUtil.click(By.xpath(accname), "account selected");
        }
    }

    /**Pre-requisite- Order has to be placed with product whose type is one-time off.
     * Pre-requisite- Order has to be placed with product whose type is Recurring.
     * To make payments
     *
     *
     * @param logStep the log
     */
    public static void paymentsBilling(String account,String amount,String paymenttype,String invoice,String logStep) throws InterruptedException {
        KeywordUtil.clickJS_component(InvoiceObject.clickOnPayments,"Click on Payments tab");
        KeywordUtil.clickJS_component(InvoiceObject.clickOnNew,"Click on New tab");
        selectAccountPayments(account,"select account");
        enterAmountPayments(amount, "entered amount");
        setPaymentType(paymenttype, "Select type as credit card");
        KeywordUtil.takeScreenshotAndAttachInReport();
        selectInvoices(invoice,"select invoice");
        KeywordUtil.takeScreenshotAndAttachInReport();
        QuoteUtil.clickSaveButton("clicked save button");
    }

    /**
     * Select the SKU for the options
     *
     * @param logStep the log
     * @param optionalSKU the optionalSKU
     */
    public static void selectOptionalSKU(String optionalSKU, String logStep) throws InterruptedException {
        boolean flag = false;
        KeywordUtil.waitForElementPresence(InvoiceObject.selectOptionalSKU);
        KeywordUtil.click(InvoiceObject.selectOptionalSKU, logStep);
        KeywordUtil.inputText(InvoiceObject.selectOptionalSKU, "Sam", logStep);

        try {
            flag = KeywordUtil.getDriver().findElement(By.xpath(optionalskus)).isDisplayed();

        } catch (Exception e) {
        }

        if (!flag) {
         Assert.fail("no such account present");
        } else {
            KeywordUtil.click(By.xpath(optionalskus), "account selected");
        }
    }

    /**
     * To create Bundle Products, add features and Options to products
     *
     *
     * @param logStep the log
     */
    public static void createBundleFeaturesOptions(String sku, String logStep) throws InterruptedException {
        KeywordUtil.clickJS_component(InvoiceObject.clickOnProducts, "Click on Products tab");
        KeywordUtil.clickJS_component(InvoiceObject.clickOnSamsungPowerBank, "Click on Samsung Power Bank");
        KeywordUtil.clickJS_component(InvoiceObject.clickOnRelatedTab, "Click on Samsung Power Bank");

        //adding new features
        KeywordUtil.clickJS_component(InvoiceObject.newFeatureButton, "Click on New button on Features");
        KeywordUtil.click(InvoiceObject.featureName, logStep);
        KeywordUtil.inputText(InvoiceObject.featureName, "StorageComponent", "Add feature name");
        KeywordUtil.click(InvoiceObject.numberValue, "Add the number");
        map = ExcelDataUtil.getTestDataWithTestCaseID("Salesforce", "TestData1");
        KeywordUtil.inputText(InvoiceObject.numberValue, map.get("Number"), "Added number");
        KeywordUtil.takeScreenshotAndAttachInReport();
        CasesUtil.clickSaveButton_ss("Saving features");

        //adding new options
        KeywordUtil.clickJS_component(InvoiceObject.optionsButton, "Click on New button on Options");
        KeywordUtil.waitForElementPresence(InvoiceObject.numberValue);
        KeywordUtil.click(InvoiceObject.numberValue, logStep);
        KeywordUtil.inputText(InvoiceObject.numberValue, map.get("Number"), logStep);
        selectOptionalSKU(sku, "select the Optional SKU");
        KeywordUtil.clickJS_component(InvoiceObject.selectedCheckBox, "Tick the selected checkbox");
        KeywordUtil.clickJS_component(InvoiceObject.requiredCheckBox, "Tick the required checkbox");
        KeywordUtil.clickJS_component(InvoiceObject.bundledCheckBox, "Tick the bundled checkbox");
        KeywordUtil.takeScreenshotAndAttachInReport();
        CasesUtil.clickSaveButton_ss("Saving Options");
    }

}
