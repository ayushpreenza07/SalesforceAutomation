package pageobjects.SalesforceObjects;

import org.openqa.selenium.By;

public class AccountObject {

    public static By accountsTab = By.xpath("//SPAN[@class='slds-truncate'][text()='Accounts']");
    public static By newAccountButton = By.xpath("//DIV[@title='New'][text()='New']");
    public static By accountNameField = By.xpath("//INPUT[@name='Name']");
    public static By phoneNumberField = By.xpath("//INPUT[@name='Phone']");
    public static By accountNumberField = By.xpath("//INPUT[@name='AccountNumber']");
    public static By saveButton = By.xpath("//BUTTON[@class='slds-button slds-button_brand'][text()='Save']");

    public static By slideButton = By.xpath("(//BUTTON[@aria-expanded='false'])[6]");
    public static By cpqButton = By.xpath("//P[@class='slds-truncate'][text()='Salesforce CPQ']");
    public static By billingAddress = By.xpath("(//textarea[@name='street'])[1]");
    public static By shippingAddress = By.xpath("(//textarea[@name='street'])[2]");
}
