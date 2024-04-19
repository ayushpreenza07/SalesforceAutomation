package SalesforceModules;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageobjects.SalesforceObjects.AccountObject;
import pageobjects.SalesforceObjects.OppurtunitiesObject;
import pageobjects.SalesforceObjects.QuoteObject;
import pageobjects.SalesforceObjects.ServiceSupportObject;
import utilities.KeywordUtil;

import static pageobjects.SalesforceObjects.ServiceSupportObject.origin;

public class CasesUtil {

    public static void clickCasesTab(String logStep) throws InterruptedException {
        KeywordUtil.delay(3000);
        KeywordUtil.waitForVisible(ServiceSupportObject.CasesTab);
        WebElement element = KeywordUtil.getDriver().findElement(ServiceSupportObject.CasesTab);
        JavascriptExecutor executor = (JavascriptExecutor) KeywordUtil.getDriver();
        executor.executeScript("arguments[0].click();", element);
    }

    /**
     * click New button for Cases section.
     *
     * @param logStep the log
     */
    public static void clickNewButton(String logStep) throws InterruptedException {
//        KeywordUtil.delay(5000);
//        KeywordUtil.waitForVisible(ServiceSupportObject.newTab);
//        KeywordUtil.click(ServiceSupportObject.newTab,logStep);

        try {
            KeywordUtil.delay(3000);
            KeywordUtil.waitForVisible(ServiceSupportObject.newTab);
            WebElement element = KeywordUtil.getDriver().findElement(ServiceSupportObject.newTab);
            JavascriptExecutor executor = (JavascriptExecutor) KeywordUtil.getDriver();
            executor.executeScript("arguments[0].click();", element);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * click save button.
     *
     * @param logStep the log
     */
    public static void clickSaveButton(String logStep){
        KeywordUtil.waitForVisible(AccountObject.saveButton);
        KeywordUtil.click(AccountObject.saveButton,logStep);

    }

    /**
     * Setting the case origin for service support
     *
     * @param origin the stage
     * @param logStep the log
     */
    public static void setCaseOrigin(String origin, String logStep){
        boolean flag = false;
        KeywordUtil.waitForVisible(ServiceSupportObject.origin);
        KeywordUtil.click(ServiceSupportObject.origin,logStep);
        String xpath = "//lightning-base-combobox-item[contains(@data-value,'"+origin+"')]";
        try{
            flag = KeywordUtil.getDriver().findElement(By.xpath(xpath)).isDisplayed();
        }catch (Exception e){}

        if(!flag){
            Assert.fail("No such case origin is present");
        }else {
            KeywordUtil.click(By.xpath(xpath), "case origin selected");
        }
    }

    /**
     * Setting the status for service support
     *
     * @param status the status
     * @param logStep the log
     */
    public static void setStatus(String status, String logStep){
        boolean flag = false;
        KeywordUtil.waitForVisible(ServiceSupportObject.status);
        KeywordUtil.click(ServiceSupportObject.status,logStep);
        String xpath = "//lightning-base-combobox-item[contains(@data-value,'"+status+"')]";
        try{
            flag = KeywordUtil.getDriver().findElement(By.xpath(xpath)).isDisplayed();
        }catch (Exception e){}

        if(!flag){
            Assert.fail("No such status is present");
        }else {
            KeywordUtil.click(By.xpath(xpath), "status selected");
        }
    }

    /**
     * Create New Cases
     *
     *  @param status the status
     *  @param origin the origin
     */
    public static void createNewCase(String status, String origin) throws InterruptedException {
        clickNewButton("Clicked new button for Cases");
        setStatus(status,status+" entered status");
        setCaseOrigin(origin,origin+" entered origin");
        clickSaveButton("clicked save button");
    }

    /**
     * Select the Account field for new case
     *
     * @param logStep the log
     * @param account the account name
     */
    public static void selectAccount_ss(String account, String logStep) throws InterruptedException {
        boolean flag = false;
        KeywordUtil.waitForVisible(ServiceSupportObject.searchAccounts_ss);
        KeywordUtil.inputText(ServiceSupportObject.searchAccounts_ss,account,logStep);
        KeywordUtil.delay(3000);
        String xpath = "//lightning-base-combobox-formatted-text[contains(@title,'"+account+"')]";
        try{
            flag = KeywordUtil.getDriver().findElement(By.xpath(xpath)).isDisplayed();

        }catch (Exception e){}

        if(!flag){
            System.out.println("no such account present");
        }else {
            KeywordUtil.click(By.xpath(xpath), "account selected");
        }
    }

    /**
     * Select the contact for new case
     *
     * @param logStep the log
     * @param contact the contact name
     */
    public static void selectContact_ss(String contact, String logStep) throws InterruptedException {
        boolean flag = false;
        KeywordUtil.waitForVisible(ServiceSupportObject.searchContacts_ss);
        KeywordUtil.inputText(ServiceSupportObject.searchContacts_ss,contact,logStep);
        KeywordUtil.delay(3000);
        String xpath = "//lightning-base-combobox-formatted-text[contains(@title,'"+contact+"')]";
        try{
            flag = KeywordUtil.getDriver().findElement(By.xpath(xpath)).isDisplayed();

        }catch (Exception e){}

        if(!flag){
            System.out.println("no such contact present");
        }else {
            KeywordUtil.click(By.xpath(xpath), "contact selected");
        }
    }

    /**
     * Create New Cases by searching contact and account.
     *
     *  @param contact the contact
     *  @param account the account
     */
    public static void createNewCasebySearchingContact_Account(String contact, String account, String status, String origin) throws InterruptedException {
        clickNewButton("Clicked new button for Cases");
        setStatus(status,status+" entered status");
        setCaseOrigin(origin,origin+" entered origin");
        selectContact_ss(contact,contact+ " entered account name");
        selectAccount_ss(account,account+ " entered account name");
        clickSaveButton("clicked save button");
    }

}
