package pageobjects.SalesforceObjects;

import org.openqa.selenium.By;
import utilities.GlobalUtil;

public class OppurtunitiesObject {

    public static By clickOnOpportunities =By.xpath("//span[@id='window' and contains(text(),'Opportunities')]");

    public static By createNewOpportunities = By.xpath("//button[@name='New']");

    public static By opportunityName = By.xpath("//input[@name='Name']");

    public static By Stage = By.xpath("//button[@data-value='--None--']");

    public static By opportunitiesBtn = By.xpath("(//a[@class='flex-wrap-ie11'])[5]");

    public static By backToAccount = By.xpath("(//li[@class='slds-breadcrumb__item slds-line-height--reset'])[4]");
    public static By CloseDate = By.xpath("//input[@name='CloseDate']");

    public static By clickOnSave = By.name("SaveEdit");

    public static By selectOpportunity = By.xpath("(//span[@lwc-47ngqe6rvah])[7]");

    public static By getBackToAccount = By.xpath("(//SPAN[@lwc-47ngqe6rvah])[8]");

    public static By proposalStage = By.xpath("//SPAN[@class='title slds-path__title'][text()='Proposal/Price Quote']");

    public static By markStage = By.xpath("//span[@class='uiOutputText' and text()='Mark as Current Stage']");
    public static By amountField = By.xpath("//input[@name='Amount']");

    public static By verifyProduct = By.xpath("(//SPAN[@title='(1)'][text()='(1)'])[2]");

    public static By verifyDocument = By.xpath("(//SPAN[@lwc-bbqdsgjtbq=''][text()='(1)'])[2]");

    public static By closedStatus = By.xpath("//SPAN[@class='title slds-path__title'][text()='Closed']");

    public static By selectClosedStage = By.xpath("(//BUTTON[@aria-live='off'])[4]");

    public static By selectClosedStageDropdown = By.xpath("//select[@class='stepAction required-field select']");

    public static By saveClosedWon = By.xpath("//button[@title='Save']");
}
