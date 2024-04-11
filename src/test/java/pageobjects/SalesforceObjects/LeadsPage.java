package pageobjects.SalesforceObjects;

import org.openqa.selenium.By;

public class LeadsPage {
    public static By hamburgerMenu=By.xpath("//div[@class='appLauncher slds-context-bar__icon-action']//button");
    public static By searchText= By.xpath("//input[@class='slds-input']");
    public static By leadsPageTitle=By.xpath("//div[@class='slds-media__body']//p");
    public static By leadesNewButton=By.xpath("//div//button[contains(@class,'slds-button slds-button_neutral middle')]");
    public static By lastName=By.xpath("//input[@class='slds-input' and @name='lastName']");
    public static By companyName=By.xpath("//input[@class='slds-input' and @name='Company']");
    public static By saveButton=By.xpath("//button[@name='SaveEdit']");
    public static By openNotContacted=By.xpath("//a[@title='Open - Not Contacted']");
    public static By converted=By.xpath("//div[@class='slds-path__scroller_inner scroller']//li//a[@title='Converted']//span[2]");
    public static By selectConvertedStatusButton=By.xpath("//div/div/button[@data-aura-class='uiButton']/span");
    public static By convertButton=By.xpath("//div[@class='modal-footer slds-modal__footer']/span/button");
    public static By convertStatusMessage=By.xpath("//div[@class='title']//h2");
    public static By gotoLeadsButton=By.xpath("//div[@class='modal-footer slds-modal__footer']/button[2]");

}
