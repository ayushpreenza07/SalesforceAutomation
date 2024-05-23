package pageobjects.SalesforceObjects;

import org.openqa.selenium.By;

public class InvoiceObject {

    //Xpaths for generating the Invoices in billing module
    public static By ordersTab = By.xpath("//BUTTON[@class='slds-button slds-button_brand'][text()='Save']");
    public static By vieworder = By.xpath("//a[@title='00000112']");
    public static By detailsTab = By.xpath("(//a[@class='slds-tabs_default__link' and text()='Details'])");
    public static By billNowEditButton = By.xpath("//button[@class='test-id__inline-edit-trigger slds-shrink-none inline-edit-trigger slds-button slds-button_icon-bare' and @title='Edit Bill Now']");
    public static By billNowButton = By.xpath("//input[@name='blng__BillNow__c']");
    public static By relatedTab = By.xpath("(//a[@class='slds-tabs_default__link' and text()='Related'])");
    public static By invoices= By.xpath("//span[@class='slds-truncate slds-m-right--xx-small' and @title='Invoices']");
    public static By openInvoices = By.xpath("//table[@class='slds-table slds-table_header-fixed slds-table_bordered slds-table_edit slds-table_resizable-cols' and @role='grid' and @aria-label='Invoices']//tbody//tr//th//a");
    public static By checkboxForTaxInfo = By.xpath ("(//button[@class='test-id__inline-edit-trigger slds-shrink-none inline-edit-trigger slds-button slds-button_icon-bare' and @title='Edit Tax Status'])");
    public static By dropdownForTaxInfo = By.xpath ("//button[@class='slds-combobox__input slds-input_faux fix-slds-input_faux slds-combobox__input-value' and @aria-label='Tax Status - Current Selection: Error']");
    public static By selectTaxstatus= By.xpath ("//button[@data-value='Error']");
    public static By selectstatus= By.xpath ("//button[@data-value='Draft']");
    public static By taxMessage= By.xpath ("(//input[@class='slds-input' and @type='text'])[6]");
    public static By checkboxForStatus = By.xpath("(//button[@class='test-id__inline-edit-trigger slds-shrink-none inline-edit-trigger slds-button slds-button_icon-bare' and @title='Edit Status'])[2]");
    public static By clickOnPayments =By.xpath("//SPAN[@class='slds-truncate'][text()='Payments']");
    public static By clickOnNew=By.xpath("(//div[@title='New'])[1]");
    public static By amountField=By.xpath("//input[@name='blng__Amount__c']");
    public static By paymenttype= By.xpath ("(//button[@data-value='--None--'])[1]");
    public static By selectInvoices= By.xpath ("//input[@placeholder='Search Invoices...']");

    //xpaths for creating bundle
    public static By clickOnProducts =By.xpath("//SPAN[@class='slds-truncate'][text()='Products']");
    public static By clickOnSamsungPowerBank =By.xpath("//span[@class='slds-grid slds-grid--align-spread forceInlineEditCell']/a[@title = 'Samsung Power Bank']");
    public static By clickOnRelatedTab =By.xpath("//span[@class='title' and text()='Related']");

    //xpaths for adding feature
    public static By newFeatureButton =By.xpath("//li[@data-target-selection-name='sfdc:StandardButton.SBQQ__ProductFeature__c.New']/a[@title='New']");
    public static By featureName =By.xpath("//input[@class='slds-input' and @name='Name']");
    public static By numberValue =By.xpath("//input[@class='slds-input' and @name='SBQQ__Number__c']");

    //xpaths for adding option
    public static By optionsButton =By.xpath("//li[@data-target-selection-name='sfdc:StandardButton.SBQQ__ProductOption__c.New']/a[@title='New']");
    public static By selectOptionalSKU= By.xpath("//input[@placeholder='Search Products...']");
    public static By selectedCheckBox= By.xpath("//input[@name='SBQQ__Selected__c']");
    public static By requiredCheckBox= By.xpath("//input[@name='SBQQ__Required__c']");
    public static By bundledCheckBox= By.xpath("//input[@name='SBQQ__Bundled__c']");
}
