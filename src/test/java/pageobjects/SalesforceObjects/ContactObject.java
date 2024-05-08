package pageobjects.SalesforceObjects;

import org.openqa.selenium.By;

public class ContactObject {

    public static By contactButton = By.xpath("(//span[contains(text(),'Contacts')])[1]");

    public static By newContactButton = By.xpath("(//BUTTON[@class='slds-button slds-button_neutral'][text()='New'])[1]");
//  public static By newContactButton = By.xpath("(//a[@title='New'])[2]");
    public static By firstName = By.xpath("//input[@name='firstName']");
    public static By lastName = By.xpath("//input[@name='lastName']");

    public static By backToAccount = By.xpath("(//li[@class='slds-breadcrumb__item slds-line-height--reset'])[2]");
    public static By phoneField = By.xpath("//input[@name='Phone']");
    public static By saveButton = By.xpath("//BUTTON[@class='slds-button slds-button_brand'][text()='Save']");
    public static By salutationButton = By.xpath("//BUTTON[@name='salutation']");


    public static By emailField = By.xpath("//input[@name='Email']");
}
