package SalesforceModules;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageobjects.SalesforceObjects.*;
import utilities.KeywordUtil;

import java.security.Key;

import static pageobjects.SalesforceObjects.ServiceSupportObject.origin;
import static utilities.KeywordUtil.catchAssertError;

public class CasesUtil {

    /**
     * click cases tab for Cases section.
     *
     * @param logStep the log
     */
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
     * click save button for case section in search flow
     *
     * @param logStep the log
     */
    public static void clickSaveButton_ss(String logStep){
        KeywordUtil.waitForVisible(ServiceSupportObject.savebutton_ss);
        KeywordUtil.click(ServiceSupportObject.savebutton_ss,logStep);

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
        selectContact_ss(contact,contact+ " entered contact name");
        selectAccount_ss(account,account+ " entered account name");
        clickSaveButton_ss("clicked save button");
    }

    /**
     * click edit Button in case section.
     *
     * @param logStep the log
     */
    public static void clickEditButton(String logStep) throws InterruptedException {
        KeywordUtil.delay(8000);
        KeywordUtil.waitForVisible(ServiceSupportObject.editbutton_ss);
        KeywordUtil.click(ServiceSupportObject.editbutton_ss,logStep);
    }

    /**
     * Edit email field for new case.
     *
     * @param logStep the log
     * @param email the edit
     */
    public static void enterEmail(String email, String logStep) {
        KeywordUtil.waitForVisible(ServiceSupportObject.contactEmailAddress);
        if (email.contains("@") && email.contains(".")) {
            KeywordUtil.inputText(ServiceSupportObject.contactEmailAddress, email, logStep);
        } else {
            Assert.fail("invalid email format");
        }
    }

    /**
     * Edit Case Details
     *
     *
     *  @param email the email field
     */
    public static void editCaseDetails(String email) throws InterruptedException {
        clickEditButton("Clicked edit button for case");
        enterEmail(email, email+" entered email");
        clickSaveButton("clicked save button");
    }


    /**
     * select delete button in case section
     *
     * @param logStep the log
     */
    public static void selectDeleteButton_case(String logStep) throws InterruptedException {
        KeywordUtil.waitForVisible(ServiceSupportObject.deletebutton_case);
        KeywordUtil.delay(2000);
        KeywordUtil.click(ServiceSupportObject.deletebutton_case,logStep);
    }

    /**
     * click delete in case section.
     *
     * @param logStep the log
     */
    public static void clickDeleteButton_case(String logStep){
        KeywordUtil.waitForVisible(ServiceSupportObject.clickdeletebutton_case);
        KeywordUtil.click(ServiceSupportObject.clickdeletebutton_case,logStep);
    }

    /**
     * Delete Case
     *
     *
     *  @param logStep the log
     */
    public static void deleteCase(String logStep) throws InterruptedException {
        selectDeleteButton_case("Selected delete button");
        clickDeleteButton_case("Clicked delete button");

    }

    /**
     * click search in case section.
     *
     * @param logStep the log
     */
    public static void clickSearch_case(String logStep) throws InterruptedException {
        KeywordUtil.waitForVisible(ServiceSupportObject.searchbutton_case);
        KeywordUtil.delay(3000);
        KeywordUtil.click(ServiceSupportObject.searchbutton_case,logStep);
        KeywordUtil.delay(3000);
        KeywordUtil.inputText(ServiceSupportObject.searchbutton_case, "00001058", logStep);

    }

    /**
     * Search Case
     *
     *
     *  @param logStep the log
     */
    public static void searchCase(String logStep) throws InterruptedException {
        KeywordUtil.delay(2000);
        clickCasesTab("Click on case Tab");
        clickSearch_case("Clicked search button");

    }

    /**
     * Enter phone number field for new account.
     *
     * @param logStep the log
     * @param PhoneNumber1 the phoneNumber1
     */
    public static void enterPhoneNumber1(String PhoneNumber1, String logStep){
        KeywordUtil.waitForVisible(ServiceSupportObject.PhoneNumber1);
        KeywordUtil.inputText(ServiceSupportObject.PhoneNumber1, PhoneNumber1,logStep);
    }

    /**
     * Enter account name field for new account.
     *
     * @param logStep the log
     * @param name the account name
     */
    public static void enterAccountName(String name, String logStep){
        KeywordUtil.waitForVisible(ServiceSupportObject.AccountName1);
        KeywordUtil.inputText(ServiceSupportObject.AccountName1, name,logStep);
    }

    /**
     * click save button for case section in search flow
     *
     * @param logStep the log
     */
    public static void saveBtnOfNewAccount_ss(String logStep){
        KeywordUtil.waitForVisible(ServiceSupportObject.saveBtnOfNewAccount);
        KeywordUtil.click(ServiceSupportObject.saveBtnOfNewAccount,logStep);

    }

    /**
     * click save button for case section in search flow
     *
     * @param logStep the log
     */
    public static void saveBtnOfNewCase_ss(String logStep){
        KeywordUtil.waitForVisible(ServiceSupportObject.saveBtnOfNewCase);
        KeywordUtil.click(ServiceSupportObject.saveBtnOfNewCase,logStep);
    }

    /**
     * Enter account name field for new account.
     *
     * @param logStep the log
     * @param AccountName1 the account name
     * @param PhoneNumber1 the PhoneNumber1
     */
    public static void newCaseByCreatingNewAccount(String AccountName1, String PhoneNumber1,String origin,String logStep) throws InterruptedException {
        try {
            clickCasesTab("Clicked on CasesTab");
            clickNewButton("Clicked on New Button for Cases");
            KeywordUtil.waitForVisible(ServiceSupportObject.searchAccountsForAccountName);
            KeywordUtil.click(ServiceSupportObject.searchAccountsForAccountName, "Click on search accounts");
            KeywordUtil.delay(3000);
            KeywordUtil.waitForVisible(ServiceSupportObject.newAccountOption);
            KeywordUtil.click(ServiceSupportObject.newAccountOption, "Click on New Account option");
            enterAccountName(AccountName1, "Entered Account Name");
            enterPhoneNumber1(PhoneNumber1, "Entered phone Number");
            saveBtnOfNewAccount_ss("clicked save button");
            setCaseOrigin(origin, "Case origin value is selected");
            saveBtnOfNewCase_ss("Clicked on Save button");
        } catch (Exception e) {
            catchAssertError(e);
        }
    }

    /**
     * Enter contact name field for new account.
     *
     * @param logStep the log
     * @param firstname the firstname
     * @param lastname the lastname
     * @param origin the origin
     */
    public static void newCaseByCreatingNewContact(String firstname,String lastname,String origin,String logStep) throws InterruptedException {
        try {
            CasesUtil.clickCasesTab("Clicked on CasesTab");
            CasesUtil.clickNewButton("Clicked on New Button for Cases");
            KeywordUtil.waitForVisible(ServiceSupportObject.searchContacts);
            KeywordUtil.click(ServiceSupportObject.searchContacts, "Click on search contacts");
            KeywordUtil.delay(3000);
            KeywordUtil.waitForVisible(ServiceSupportObject.newContactOption);
            KeywordUtil.click(ServiceSupportObject.newContactOption, "Click on New Contact option");
            KeywordUtil.inputText(ServiceSupportObject.firstNameFieldForNewContact, firstname,logStep);
            KeywordUtil.inputText(ServiceSupportObject.lastNameFieldForNewContact, lastname,logStep);
            KeywordUtil.click(ServiceSupportObject.saveBtnOfNewAccount, "Click on New Contact option");
            setCaseOrigin(origin, "Case origin value is selected");
            saveBtnOfNewCase_ss("Clicked on Save button");
        } catch (Exception e) {
            catchAssertError(e);
        }
    }
}
