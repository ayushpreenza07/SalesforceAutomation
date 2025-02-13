package pageobjects.SalesforceObjects;

import org.openqa.selenium.By;

public class ServiceSupportObject {

    //Edit xpaths
    public static By clickServiceSupportButton = By.xpath("//p[@class='slds-truncate'][text()='Service']");
    public static By editButton = By.xpath ("//button[@class='slds-button slds-button_neutral' and @name='Edit']");
    public static By phoneNumberUpdate= By.xpath ("//input[@class='slds-input' and @name='Phone']");
    public static By saveButton = By.xpath("//BUTTON[@class='slds-button slds-button_brand'][text()='Save']");

    //Delete xpaths
    public static By dropDown = By.xpath("//th[span[a[text()='TXTest']]]/following-sibling::td//a[@role='button']");
    public static By deleteButton = By.xpath("//a[@data-target-selection-name='sfdc:StandardButton.Account.Delete']");
    public static By clickdeleteButton = By.xpath("//button[@title='Delete']");

    //Contact xpaths
    public static By newContactButton_ss = By.xpath("//button[@class='slds-button slds-button_neutral middleButton actionListButton' and text()='New']");
    public static By dropdown_ss = By.xpath ("//tr[th/lightning-primitive-cell-factory/span/div/lightning-primitive-custom-cell/runtime_pipeline_inspector-name-field/force-lookup/div/a/slot[text()='Rahul']]/td//button[span[text()='Show Actions']]");
    public static By editButton_ss =By.xpath("(//a[@role='menuitem' and @aria-disabled='false'])[1]");

    //Delete xpaths for contact
    public static By dropDown_cnt= By.xpath("//tr[th/lightning-primitive-cell-factory/span/div/lightning-primitive-custom-cell/runtime_pipeline_inspector-name-field/force-lookup/div/a/slot[text()='Anjali']]/td//button[span[text()='Show Actions']]");
    public static By deleteButton_cnt = By.xpath("//a[@title='Delete']");
    public static By clickdeleteButton_cnt = By.xpath("//button//span[text()='Delete']");

    //Filter xpaths for contact
    public static By showFiltersInContacts_ss=By.xpath("//button[@title=\"Show filters\"]");

    public static By addFiltersInContacts_ss=By.xpath("//button[text()=\"Add Filter\"]");
    public static By clickFieldFilter_ss=By.xpath("(//button[@class=\"slds-combobox__input slds-input_faux fix-slds-input_faux slds-combobox__input-value\"])[1]");
    public static By allDropdownElementsInFieldFilter_ss=By.xpath("//span[@class=\"slds-media__body\"]");

    public static By enter_value_ss=By.xpath("//input[@type=\"text\"]");

    public static By doneButton_ss=By.xpath("//span[text()=\"Done\"]");

    public static By saveFilterButton_ss=By.xpath("//button[text()='Save']");
    public static By closeFilterButton_ss=By.xpath("//span[text()='Close Filters']");

    //xpaths for contactTab
    public static By contactTab_ss=By.xpath("//span[@class='slds-truncate'][text()='Contacts']");

    //xpaths for RemoveAll filter
    public static By removeFiltersInContacts_ss=By.xpath("//button[text()=\"Remove All\"]");

    //Xpaths for CasesTab
    public static By CasesTab=By.xpath("//span[@class='slds-truncate'][text()='Cases']");
    public static By newTab=By.xpath("//div[@title='New']");
    public static By status=By.xpath("//button[@data-value='New']");
    public static By origin = By.xpath("//button[@data-value='--None--']");

    //Xpaths for searching contact and account
    public static By searchAccounts_ss=By.xpath("//input[@placeholder='Search Accounts...']");
    public static By searchContacts_ss=By.xpath("//input[@placeholder='Search Contacts...']");
    public static By savebutton_ss=By.xpath("//button[@class='slds-button slds-button_brand' and @name='SaveEdit']");

    //Xpaths for editing the case section
    public static By editbutton_ss=By.xpath("(//button[@class='slds-button slds-button_neutral' and @name='Edit'])[2]");
    public static By contactEmailAddress=By.xpath("//input[@inputmode=\"email\"]");

    //Xpaths for Deleting the case
    public static By deletebutton_case=By.xpath("(//button[text()='Delete'])[2]");
    public static By clickdeletebutton_case =By.xpath("//span[text()='Delete']");

    //Xpaths for searching the case from the list
    public static By searchbutton_case=By.xpath("//input[@placeholder='Search this list...']");

    //Xpaths for creating new account
    public static By searchAccountsForAccountName= By.xpath("//input[@placeholder='Search Accounts...' and @class='slds-combobox__input slds-input']");
    public static By newAccountOption= By.xpath("//span[@class='slds-truncate' and text()='New Account']");

    //Xpaths for creating new account and Phone in case section
    public static By phoneNumber_ss = By.xpath("//label[span[text()='Phone']]/following-sibling::input[@type='tel']");
    public static By accountName_ss = By.xpath("//label[span[text()='Account Name']]/following-sibling::input[@type='text']");
    public static By saveBtnOfNewAccount= By.xpath("(//span[@class=' label bBody' and text()='Save'])[2]");
    public static By saveBtnOfNewCase= By.xpath("//button[@class='slds-button slds-button_brand' and @name='SaveEdit' and @type='button']");

    //Xpaths for creating new contact in case section
    public static By searchContacts= By.xpath("//input[@placeholder='Search Contacts...' and @class='slds-combobox__input slds-input']");
    public static By newContactOption= By.xpath("//span[@class='slds-truncate' and text()='New Contact']");
    public static By firstNameFieldForNewContact= By.xpath("//input[@class='firstName compoundBorderBottom form-element__row input' and @placeholder='First Name']");
    public static By lastNameFieldForNewContact= By.xpath("//input[@class='lastName compoundBLRadius compoundBRRadius form-element__row input' and @placeholder='Last Name']");

    //Xpaths for creating new opportunity
    public static By createNewOpportunities_ss= By.xpath("//button[@class='slds-button slds-button_neutral' and text()='New Opportunity']");
    public static By opportunityName_ss=By.xpath("(//input[@type='text' and @class=' input'])[1]");
    public static By setStage_ss=By.xpath ("//a[@role='button' and @class='select' and text()='--None--']");
    public static By saveButton_oppo = By.xpath("(//span[@class=' label bBody' and text()='Save'])[3]");

    //Xpaths for changing opportunity status
    public static By clickOpportunities_ss =By.xpath("//a[slot[contains(.,'Opportunities')]]");
    public static By selectOpportunities_ss =By.xpath("//a[slot[contains(.,'DemoOpportunity')]]");
    public static By proposalStage_ss =By.xpath("(//span[@class='title slds-path__title'])[7]");
    public static By markStage_ss =By.xpath("//span[@class='uiOutputText']");
    public static By getBackToAccount_ss =By.xpath("//span[@class='slds-truncate' and text()='Accounts']");

    //Xpaths for creating new quote
    public static By openaccount_ss =By.xpath("//span//a[@title='TXTest']");
    public static By clickQuotes_ss =By.xpath("(//a[contains(@href,'Quotes')])[1]");
    public static By newQuoteButton_ss =By.xpath("(//button[@class='slds-button slds-button_neutral' and text()='New'])[2]");
    public static By searchAccounts_quote_ss =By.xpath("(//input[@placeholder='Search Accounts...'])[1]");
    public static By searchOppo_quote_ss =By.xpath("//input[@placeholder='Search Opportunities...']");

    //Xpaths for reviewing quote
    public static By editQuote_ss=By.xpath("//button[@class='slds-button slds-button_neutral' and text()='Edit']");
    public static By selectStatus_ss  =By.xpath("//label[text()='Status']/following-sibling::div//button[@role='combobox']");

    //Xpaths for approving quote
    public static By editQuote_again_ss=By.xpath("//button[@class='slds-button slds-button_neutral slds-kx-is-animating-from-click' and text()='Edit']");

    //Xpaths for creating orders
    public static By checkbox_Orders_ss=By.xpath("(//span[@lwc-16hle61jt7i][text()='Ordered'])[2]");
    public static By openOrder=By.xpath("//a[slot[contains(.,'Orders')]]");
    public static By viewOrder=By.xpath("//a[@class='flex-wrap-ie11 slds-truncate']");

    //Xpaths for adding contact to campaign
    public static By openContact=By.xpath("//a[@class='displayLabel slds-truncate' and @title='Shruthi Dharnaik']");
    public static By addtoCampaign=By.xpath("//a//div[@title='Add to Campaign']");
}
