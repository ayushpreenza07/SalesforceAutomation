package pageobjects.SalesforceObjects;

import org.openqa.selenium.By;

public class LeadsPage {
    public static By hamburgerMenu=By.xpath("//div[@class='appLauncher slds-context-bar__icon-action']//button");
    public static By searchText= By.xpath("//input[@class='slds-input']");
    public static By leadsPageTitle=By.xpath("//div[@class='slds-media__body']//p");
    public static By leadesNewButton=By.xpath("(//button[@name=\"New\"])[3]");
    public static By lastName=By.xpath("//input[@class='slds-input' and @name='lastName']");
    public static By companyName=By.xpath("//input[@class='slds-input' and @name='Company']");
    public static By saveButton=By.xpath("//button[@name='SaveEdit']");
    public static By openNotContacted=By.xpath("//a[@title='Open - Not Contacted']");
    public static By converted=By.xpath("//div[@class='slds-path__scroller_inner scroller']//li//a[@title='Converted']//span[2]");
    public static By selectConvertedStatusButton=By.xpath("//div/div/button[@data-aura-class='uiButton']/span");
    public static By convertButton=By.xpath("//div[@class='modal-footer slds-modal__footer']/span//button");
    public static By convertStatusMessage=By.xpath("//div[@class='title']//h2");
    public static By gotoLeadsButton=By.xpath("//div[@class='modal-footer slds-modal__footer']/button[2]");

    public static By existingAccountSearch=By.xpath("(//div[@class='header']/span[@class='slds-radio'])[1]");
    public static By existingContactSearch=By.xpath("(//span[@class='slds-radio_faux'])[4]");
    public static By existingOpportunitySearch=By.xpath("(//span[@class='slds-radio_faux'])[6]");
    public static By existingAccountList=By.xpath("(//div[@class='autocompleteWrapper slds-grow']//div[@class='listContent']//ul//li)[1]");
    public static By existingContactList=By.xpath("(//div[@class='autocompleteWrapper slds-grow']//div[@role='listbox']//ul//li/a)[6]");
    public static By existingAccountTextBox=By.xpath("(//div[@class='autocompleteWrapper slds-grow'])[1]");
    public static By existingContactSearchTextBox=By.xpath("(//div[@class='autocompleteWrapper slds-grow'])[2]");
    public static By convertOpportunity=By.xpath("(//div[@class='containerBodyPadding']//div[@class='primaryField truncate']//a)[3]");

    public static By opportunityAccountName=By.xpath("(//div[contains(@class,'slds-form-element__control')])[3]");

    public static By opportunityExistingRadioButton=By.xpath("(//div[@class='topSection']//span[@class='slds-radio'])[1]");

}
