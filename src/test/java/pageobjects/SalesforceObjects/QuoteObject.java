package pageobjects.SalesforceObjects;

import org.openqa.selenium.By;

public class QuoteObject {

    //Creating New Quotes
    public static By clickOnQuotes =By.xpath("//SPAN[@class='slds-truncate'][text()='Quotes']");
    public static By clickOnQuotesTab =By.xpath("//div[@class='slds-context-bar']//a[@title='Quotes']");

    public static By rhsQuote=By.xpath("(//div[@class='slds-media__body slds-align-middle']/h2[@class='slds-card__header-title']/a/span[@title='Quotes'])[3]");
    public static By newQuoteButton = By.xpath("(//BUTTON[@class='slds-button slds-button_neutral'][text()='New'])[1]");
    public static By searchOpportunities =By.xpath("//input[@class='slds-combobox__input slds-input' and @placeholder='Search Opportunities...']");
    public static By selectOppurtunity = By.xpath("//lightning-base-combobox-formatted-text[contains(@title,'asz')]");
    public static By selectOppurtunityLeads = By.xpath("//div[@role='listbox']//ul/li[2]//span[2]/span[2]/span");

    public static By selectAccount = By. xpath("//lightning-base-combobox-formatted-text[contains(@title,'asd')]");
    public static By quoteBtn = By.xpath("(//a[@class='flex-wrap-ie11'])[6]");
    public static By quoteCardBtn = By.xpath("//h2[@class='slds-card__header-title']/a/span[@title='Quotes']");

    public static By searchAccounts =By.xpath("(//input[@placeholder='Search Accounts...'])[1]");
    public static By selectTypes =By.xpath("//button[@class='slds-combobox__input slds-input_faux fix-slds-input_faux slds-combobox__input-value' and span[text()='Quote']]");

    public static By selectType = By.xpath("//lightning-base-combobox-item[contains(@data-value,'Quote')]");
    public static By saveButton = By.xpath("//button[@class='slds-button slds-button_brand' and text()='Save']");
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
}