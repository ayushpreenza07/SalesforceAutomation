package pageobjects.SalesforceObjects;

import org.openqa.selenium.By;

public class BillingObject {

    public static By productsTab = By.xpath("//a[@title='Products']");

    public static By productName = By.xpath("//input[@data-interactive-lib-uid='4']");

    public static By productFamily = By.xpath("//a[@data-interactive-lib-uid='5'][text()='--None--']");

    public static By productCode = By.xpath("//input[@data-interactive-lib-uid='6']");

    public static By activeCheckBox = By.xpath("//input[@data-interactive-lib-uid='8']");
    public static By selectFamily = By.xpath("//a[@title='Hardware']");

    public static By saveProduct = By.xpath("//button[@title='Save']");

    public static By relatedHeader = By.xpath("//a[@title='Related']");

    public static By addStandardPrice = By.xpath("//a[@title='Add Standard Price']");

    public static By addListPrice = By.xpath("//input[@data-interactive-lib-uid='68']");
    public static By editViewButtonHolder = By.xpath("//a[@class='rowActionsPlaceHolder slds-button slds-button--icon-x-small slds-button--icon-border-filled keyboardMode--trigger']");
    public static By editButton = By.xpath("//a[@title='Edit']");

    public static By editListPrice = By.xpath("//input[@data-interactive-lib-uid='70']");

    public static By searchProduct = By.xpath("//input[@placeholder='Search this list...']");

    public static By viewAll= By.xpath("//button[@class='slds-button' and @type='button' and text()='View All']");
    public static By salesforceBilling= By.xpath("//p[@class='slds-truncate' and text()='Salesforce Billing']");
    public static By accountNameLink= By.xpath("//a[@title='TXTest' and text()='TXTest']");
    public static By newBtnContactsOfAccount= By.xpath("//button[@class='slds-button slds-button_neutral' and @name='NewContact' and text()='New']");
    public static By newContactBtnOnExistAccount= By.xpath("//button[@class='slds-button slds-button_neutral' and text()='New Contact']");
    public static By salutationOfNewContactOnExistAccount= By.xpath("//div[@class='windowViewMode-normal active lafPageHost']//a[@class='select']");
    public static By lastNameOfNewContactOnExistAccount= By.xpath("//input[@class='lastName compoundBLRadius compoundBRRadius form-element__row input' and @placeholder='Last Name' and @type='text']");
    public static By phoneNumberOfNewContactOnExistAccount= By.xpath("//input[@class=' input' and @type='tel']");
    public static By emailOfNewContactOnExistAccount= By.xpath("//input[@class=' input' and @type='text' and @inputmode='email']");
    public static By saveButtonOfNewContact= By.xpath("//button[@class='slds-button slds-button_brand cuf-publisherShareButton undefined uiButton']//span[@class=' label bBody' and text()='Save']");
    public static By newBtnOfContactsTab= By.xpath("(//div[@title='New'])[1]");

    //xpaths for adding new cases
    public static By newBtnOfCases= By.xpath("//div[@class='listWrapper']//article[@aria-label='Cases']//div[@class='slds-media slds-media--center slds-has-flexi-truncate']//button[@name='NewCase']");
    public static By dropdownOfCases= By.xpath("//article[@class='slds-card slds-card_boundary' and @aria-label='Cases']//button[@class='slds-button slds-button_icon-border slds-button_icon-x-small']");
    public static By dropdownEditOption= By.xpath("//div[@class='forceActionLink' and @role='button' and text()='Edit']");
    public static By editOrigin = By.xpath("//button[@data-value='Phone']");
    public static By dropdownDeleteOption= By.xpath("//div[@class='forceActionLink' and text()='Delete']");
    public static By webCompany= By.xpath("//input[@class='slds-input' and @name='SuppliedCompany']");
    public static By caseDropDown= By.xpath("//li[@class='oneActionsDropDown']//span[@class='slds-assistive-text' and text()='Show more actions']");

}
