package pageobjects.SalesforceObjects;

import org.openqa.selenium.By;

public class QuoteObject {

    //Creating New Quotes
    public static By clickOnQuotes =By.xpath("//SPAN[@class='slds-truncate'][text()='Quotes']");
    public static By newQuoteButton = By.xpath("(//BUTTON[@class='slds-button slds-button_neutral'][text()='New'])[1]");
    public static By searchOpportunities =By.xpath("//input[@class='slds-combobox__input slds-input' and @placeholder='Search Opportunities...']");
    public static By selectOppurtunity = By.xpath("//lightning-base-combobox-formatted-text[contains(@title,'asz')]");
    public static By selectAccount = By. xpath("//lightning-base-combobox-formatted-text[contains(@title,'asd')]");
    public static By quoteBtn = By.xpath("(//a[@class='flex-wrap-ie11'])[6]");
    public static By searchAccounts =By.xpath("(//input[@placeholder='Search Accounts...'])[1]");
    public static By selectTypes =By.xpath("//button[@class='slds-combobox__input slds-input_faux fix-slds-input_faux slds-combobox__input-value' and span[text()='Quote']]");

    public static By selectType = By.xpath("//lightning-base-combobox-item[contains(@data-value,'Quote')]");
    public static By saveButton = By.xpath("//button[@class='slds-button slds-button_brand' and text()='Save']");

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

}
