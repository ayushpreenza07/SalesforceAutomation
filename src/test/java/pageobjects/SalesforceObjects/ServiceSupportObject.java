package pageobjects.SalesforceObjects;

import org.openqa.selenium.By;

public class ServiceSupportObject {

    //Edit xpaths
    public static By clickServiceSupportButton = By.xpath("//p[@class='slds-truncate'][text()='Service']");
    public static By editButton = By.xpath ("//button[@class='slds-button slds-button_neutral' and @name='Edit']");
    public static By  phoneNumberUpdate= By.xpath ("//input[@class='slds-input' and @name='Phone']");
    public static By saveButton = By.xpath("//BUTTON[@class='slds-button slds-button_brand'][text()='Save']");

    //Delete xpaths
    public static By dropDown = By.xpath("//th[span[a[text()='TXTest']]]/following-sibling::td//a[@role='button']");
    public static By deleteButton = By.xpath("//a[@data-target-selection-name='sfdc:StandardButton.Account.Delete']");
    public static By clickdeleteButton = By.xpath("//button[@title='Delete']");
}
