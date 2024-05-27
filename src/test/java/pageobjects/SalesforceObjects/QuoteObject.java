package pageobjects.SalesforceObjects;

import org.openqa.selenium.By;

public class QuoteObject {

    //Creating New Quotes
        public static By clickOnQuotes =By.xpath("//SPAN[@class='slds-truncate'][text()='Quotes']");
    public static By clickOnQuotesTab =By.xpath("//div[@class='slds-context-bar']//a[@title='Quotes']");
        public static By    newQuoteButton = By.xpath("(//BUTTON[@class='slds-button slds-button_neutral'][text()='New'])[1] | //*[@class='slds-truncate' and text()='New']");
    public static By searchOpportunities =By.xpath("//input[@class='slds-combobox__input slds-input' and @placeholder='Search Opportunities...']");
    public static By selectOppurtunity = By.xpath("//lightning-base-combobox-formatted-text[contains(@title,'asz')]");
    public static By selectOppurtunityLeads = By.xpath("//div[@role='listbox']//ul/li[2]//span[2]/span[2]/span");

    public static By selectAccount = By. xpath("//lightning-base-combobox-formatted-text[contains(@title,'asd')]");
    public static By quoteBtn = By.xpath("(//a[@class='flex-wrap-ie11'])[6]");
    public static By quotesBtn = By.xpath("(//*[@class=\"menu-button-item slds-dropdown-trigger slds-dropdown-trigger_click\"])[2]/button");
    public static By quoteCardBtn = By.xpath("//h2[@class='slds-card__header-title']/a/span[@title='Quotes']");

    public static By searchAccounts =By.xpath("(//input[@placeholder='Search Accounts...'])[1]");
    public static By selectTypes =By.xpath("//button[@class='slds-combobox__input slds-input_faux fix-slds-input_faux slds-combobox__input-value' and span[text()='Quote']]");

    public static By selectType = By.xpath("//lightning-base-combobox-item[contains(@data-value,'Quote')]");
    public static By saveButton = By.xpath("//button[@class='slds-button slds-button_brand' and text()='Save'] | //*[@class='style-scope sb-pricebook-dialog' and text()='Save']");
    public static By priceSaveButton=By.xpath("(//div[@class='sbDialog style-scope sb-dialog']/footer[@id='footer']//paper-button)[17]");

    //Change Owner
    public static By primaryCheckbox = By.xpath("//input[@name='SBQQ__Primary__c']");

    public static By orderedCheckbox = By.xpath("(//input[@name='SBQQ__Ordered__c'])[2]");
    public static By editLines =By.xpath("//button[@class='slds-button slds-button_neutral' and text()='Edit Lines']");

    public static By joinedOpportunity = By.xpath("(//a[@class='flex-wrap-ie11'])[14]");

    public static By opportunityAfterQuote = By.xpath("(//a[@class='flex-wrap-ie11'])[1]");

    public static By generateDocument = By.xpath("//button[@class='slds-button slds-button_neutral' and text()='Generate Document']");

    public static By saveDocument = By.xpath("//button[@class='sbBtn'][@ng-click='onSave()']");

    public static By editButton = By.xpath("(//button[@class='slds-button slds-button_neutral' and text()='Edit'])[1]");

    public static By quoteConnected = By.xpath("(//a[@class='flex-wrap-ie11 slds-truncate'])[3]");

    public static By statusButton = By.xpath("//button[@class='slds-combobox__input slds-input_faux fix-slds-input_faux slds-combobox__input-value' and span[text()='Draft']]");

    public static By orders = By.xpath("//span[@lwc-oj46kgc6r3=''][contains(text(),'Orders')]");

    public static By openOrder = By.xpath("(//a[@class='flex-wrap-ie11 slds-truncate'])[5]");

    public static By activatedTab = By.xpath("//span[@class='title slds-path__title'][contains(text(),'Activated')]");

    public static By markCurrentStatus = By.xpath("//span[@class='uiOutputText'][contains(text(),'Mark as Current Status')]");

    public static By quoteTitle=By.xpath("(//div[1]/div/div[1]/div[2]/h1/slot/lightning-formatted-text[@slot='primaryField'])[1]");
    public static By quoteNumber=By.xpath("//*[@id='brandBand_1']//div/div/table/tbody/tr[1]/th/span/a");


    public static By quoteNumberFromQuote=By.xpath("(//span[@class='slds-grid slds-grid_align-spread']//a[@class='flex-wrap-ie11 slds-truncate'])");

    public static By changeEditStatus=By.xpath("(//div[@class='slds-form-element__control']//button[contains(@title,'Edit Status')]//span)[1]");
    public static By clickOnStatus=By.xpath("(//*[@data-value='Draft'])[1]");

    public static By selectReviewOption=By.xpath("//*[contains(@id,'combobox-button')]/span[2]/span[@title='In Review']");
    public static By quoteEditButton = By.xpath("//ul[@class='slds-button-group-list']//li[@class='visible']//button[@name='Edit']");
    public static By selectApproveOption=By.xpath("//*[contains(@id,'combobox-button')]/span[2]/span[@title='Approved']");
    public static  By clickReviewStatusDropDown=By.xpath("(//*[@data-value='In Review'])[1]");

    public static By statusApproved=By.xpath("(//*[@data-value='Approved'])[1]");

    //Creating xpaths for billing section
    public static By clickOnNew=By.xpath("//a[@title='New']");
    public static By dropdownInQuotesTab=By.xpath("(//span[@class='slds-assistive-text' and text()='Show more actions'])");
    public static By dropdownInQuotesTab_b=By.xpath("//span[@class='slds-assistive-text' and text()='Show Actions']");
    public static By editLines_b=By.xpath("//a//span[@class='slds-truncate' and text()='Edit Lines']");
    public static By dropdownToDelete=By.xpath("//span[@class='slds-assistive-text' and text()='Show Actions']");
    public static By deleteButton=By.xpath("//a[@title='Delete']");
    public static By deleteButtonClicked=By.xpath("//span[text()='Delete']");
    public static By openQuote=By.xpath("//th//span//a[@target='_blank']");
    public static By editQuote=By.xpath("//span[@class='slds-truncate' and text()='Edit']");

    public static By editQuoteBilling=By.xpath("//a[@title='Edit']");
    public static By editQuoteBillingSection=By.xpath ("(//div[@class='forceActionLink' and @role='button' and text()='Edit'])[2]");
    public static By editQuoteAgainInBilling=By.xpath ("(//a[@title='Edit'])[3]");
    public static By clickOnOrders =By.xpath("//SPAN[@class='slds-truncate'][text()='Orders']");
    public static By dropDownOrders =By.xpath("//button[@title='Select a List View: Orders']");
    public static By allOrders =By.xpath("//span[@class=' virtualAutocompleteOptionText' and text()='All Orders']");
    public static By openOrders_b =By.xpath("(//span[@class='slds-grid slds-grid--align-spread forceInlineEditCell'])/a[1]");
    public static By dropdownInOrdersTab=By.xpath("(//span[@class='slds-assistive-text' and text()='Show more actions'])[2]");
    public static By editOrdersTab=By.xpath("//ul//a//div[@title='Edit']");

    //xpaths for Acc_to_order gen flow
    public static By dropdownInQuotesTab_o=By.xpath("//table[@aria-label='Quotes']//td[7]//span[text()='Show Actions']");
    public static By editQuote_o=By.xpath("//a[@title='Edit']");
    public static By orders_o = By.xpath("(//a[slot[contains(.,'Orders')]])[2]");
    public static By dropdownInOrdersTab_o=By.xpath("//table[@aria-label='Orders']//td[7]//span[text()='Show Actions']");
    public static By viewOrder = By.xpath("(//a[@class='flex-wrap-ie11 slds-truncate'])[3]");
    public static By editButton_o = By.xpath("(//button[@class='slds-button slds-button_neutral' and @name='Edit'])[2]");

}