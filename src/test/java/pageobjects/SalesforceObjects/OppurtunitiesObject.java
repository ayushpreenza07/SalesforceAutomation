package pageobjects.SalesforceObjects;

import org.openqa.selenium.By;
import utilities.GlobalUtil;

public class OppurtunitiesObject {

    public static By opportunitiesTab =By.xpath("//div[@class='slds-context-bar']//a[@title='Opportunities']");

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
    public static By proposalStages = By.xpath("(//SPAN[@class='title slds-path__title'][text()='Proposal/Price Quote'])[3]");

    public static By markStage = By.xpath("(//span[@class='uiOutputText'])[2]");

    public static By markStages = By.xpath("//div/div[2]/button/span");
    public static By markStages1 = By.xpath("(//div/div[2]/button/span)[2]");

    public static By markStageAsComplete = By.xpath("//div[2]/button/span[@class='uiOutputText']");

    public static By amountField = By.xpath("//input[@name='Amount']");

    public static By verifyProduct = By.xpath("(//SPAN[@title='(1)'][text()='(1)'])[2]");

    public static By verifyDocument = By.xpath("(//SPAN[@lwc-bbqdsgjtbq=''][text()='(1)'])[2]");

    public static By closedStatus = By.xpath("//SPAN[@class='title slds-path__title'][text()='Closed']");

    public static By selectClosedStage = By.xpath("(//BUTTON[@aria-live='off'])[4]");

    public static By selectClosedStageDropdown = By.xpath("//select[@class='stepAction required-field select']");

    public static By saveClosedWon = By.xpath("//button[@title='Save']");

    public static By quoteCard=By.xpath("//div[@class='slds-media__body slds-align-middle']//h2/a/span[@title='Quotes']");
    public static By opportunityNameInTable=By.xpath("//div[1]/div/div/table/tbody/tr[1]/th/span/a");
    public static By salesForceCPQ=By.xpath("//div[@class='al-menu-dropdown-list']//a[@data-label='Salesforce CPQ']");
    public static By opportunityStage=By.xpath("//*/div[1]/div/div/table/tbody/tr[1]/td[5]/span/span[1]");
}
