package SalesforceModules;

import org.openqa.selenium.By;
import org.testng.Assert;
import pageobjects.SalesforceObjects.InvoiceObject;
import pageobjects.SalesforceObjects.OppurtunitiesObject;
import pageobjects.SalesforceObjects.QuoteObject;
import pageobjects.SalesforceObjects.ServiceSupportObject;
import utilities.KeywordUtil;

public class InvoiceUtil {


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
        KeywordUtil.delay(2000);
        KeywordUtil.clickJS_component(InvoiceObject.vieworder,"Open Order");

    }

    /**
     * Select the contact for new case
     *
     * @param logStep the log
     * @param status the status
     */
    public static void setTaxInfo(String status, String logStep) throws InterruptedException {
        boolean flag = false;
        int size = 0;
        KeywordUtil.waitForVisible(InvoiceObject.selectTaxstatus);
        KeywordUtil.click(InvoiceObject.selectTaxstatus, logStep);
        KeywordUtil.delay(3000);
        Thread.sleep(000);
        String changeStatus_ss = "//div[label[text()='Tax Status']]/div//span[@class='slds-truncate'][contains(text(),'"+status+"')]";
        try {
            size = KeywordUtil.getDriver().findElements(By.xpath(changeStatus_ss)).size();

        } catch (Exception e) {
        }

        if (size == 0) {
            KeywordUtil.takeScreenshotAndAttachInReport();
            System.out.println("no such status present");
            System.out.println(size);
        } else {
            KeywordUtil.click(By.xpath(changeStatus_ss), "status changed as draft");
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
        KeywordUtil.delay(4000);
        KeywordUtil.waitForVisible(InvoiceObject.selectstatus);
        KeywordUtil.click(InvoiceObject.selectstatus,logStep);
        KeywordUtil.delay(3000);
        String xpath   ="(//lightning-base-combobox-item[@class='slds-media slds-listbox__option slds-media_center slds-media_small slds-listbox__option_plain'][contains(@data-value,'"+status+"')])[1]";
        try {
            size = KeywordUtil.getDriver().findElements(By.xpath(xpath)).size();

        } catch (Exception e) {
        }

        if (size == 0) {
            KeywordUtil.takeScreenshotAndAttachInReport();
            System.out.println("no such status present");
            System.out.println(size);
        } else {
            KeywordUtil.click(By.xpath(xpath), "status changed as posted");
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
        KeywordUtil.clickJS_component(InvoiceObject.openInvoices,"Click on Invoice");

        //code for tax info boxes
        KeywordUtil.delay(3000);
        KeywordUtil.clickJS_component(InvoiceObject.checkboxForTaxInfo,"edit button on tax info");
        KeywordUtil.delay(3000);
        setTaxInfo(taxStatus,"select tax status as None");
        KeywordUtil.delay(3000);
        KeywordUtil.clearInput(InvoiceObject.taxMessage);

        //select status as posted
        KeywordUtil.delay(2000);
        setPostedStatus(postedStatus,"select status as posted");
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
        KeywordUtil.delay(5000);
        Thread.sleep(5000);
        String accname = "//lightning-base-combobox-formatted-text[contains(@title,'Bill')]";

        try {
            flag = KeywordUtil.getDriver().findElement(By.xpath(accname)).isDisplayed();

        } catch (Exception e) {
        }

        if (!flag) {
            System.out.println("no such account present");
        } else {
            KeywordUtil.click(By.xpath(accname), "account selected");
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
        KeywordUtil.delay(3000);
        String xpath ="//lightning-base-combobox-item[contains(@data-value,'"+paymentType+"')]";
        try {
            size = KeywordUtil.getDriver().findElements(By.xpath(xpath)).size();

        } catch (Exception e) {
        }

        if (size == 0) {
            KeywordUtil.takeScreenshotAndAttachInReport();
            System.out.println("no such status present");
            System.out.println(size);
        } else {
            KeywordUtil.click(By.xpath(xpath), "status changed as posted");
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
        KeywordUtil.delay(5000);
        Thread.sleep(5000);
        String accname = "(//lightning-base-combobox-formatted-text[contains(@title,'INV')])[1]";

        try {
            flag = KeywordUtil.getDriver().findElement(By.xpath(accname)).isDisplayed();

        } catch (Exception e) {
        }

        if (!flag) {
            System.out.println("no such account present");
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

}
