package SalesforceModules;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import pageobjects.SalesforceObjects.AccountObject;
import pageobjects.SalesforceObjects.ServiceSupportObject;

import utilities.GlobalUtil;
import utilities.KeywordUtil;

public class EditandDeleteUtil extends GlobalUtil {

    /**
     * click edit Button for creating new account.
     *
     * @param logStep the log
     */
    public static void clickEditButton(String logStep) throws InterruptedException {
        KeywordUtil.delay(8000);
        KeywordUtil.waitForVisible(ServiceSupportObject.editButton);
        KeywordUtil.click(ServiceSupportObject.editButton,logStep);
    }

    /**
     * Edit phone number field for new account.
     *
     * @param logStep the log
     * @param phone the account name
     */
    public static void editPhoneNumber(String phone, String logStep){
        KeywordUtil.waitForVisible(ServiceSupportObject.phoneNumberUpdate);
        KeywordUtil.inputText(ServiceSupportObject.phoneNumberUpdate, phone,logStep);
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
     * Edit Account Details
     *
     *
     *  @param phone the phone
     */
    public static void editAccountDetails(String phone) throws InterruptedException {
        clickEditButton("Clicked edit button for accounts");
        editPhoneNumber(phone, phone+" entered phone");
        clickSaveButton("clicked save button");
    }

    /**
     * click Accounts tab.
     *
     * @param logStep the log
     */
    public static void clickAccountsTab(String logStep) throws InterruptedException {
        KeywordUtil.delay(3000);
        KeywordUtil.waitForVisible(AccountObject.accountsTab);
        WebElement element = KeywordUtil.getDriver().findElement(AccountObject.accountsTab);
        JavascriptExecutor executor = (JavascriptExecutor)KeywordUtil.getDriver();
        executor.executeScript("arguments[0].click();", element);
    }

    /**
     * click drop down in accounts section.
     *
     * @param logStep the log
     */
    public static void clickDropDownButton(String logStep){
        KeywordUtil.waitForVisible(ServiceSupportObject.dropDown);
        KeywordUtil.click(ServiceSupportObject.dropDown,logStep);
    }

    /**
     * select delete button from dropdown
     *
     * @param logStep the log
     */
    public static void selectDeleteButton(String logStep){
        KeywordUtil.waitForVisible(ServiceSupportObject.deleteButton);
        KeywordUtil.click(ServiceSupportObject.deleteButton,logStep);
    }

    /**
     * click delete in accounts section.
     *
     * @param logStep the log
     */
    public static void clickDeleteButton(String logStep){
        KeywordUtil.waitForVisible(ServiceSupportObject.clickdeleteButton);
        KeywordUtil.click(ServiceSupportObject.clickdeleteButton,logStep);
    }

    /**
     * Delete Account
     *
     *
     *  @param logStep the log
     */
    public static void deleteAccount(String logStep) throws InterruptedException {
        clickAccountsTab("Navigated to accounts");
        clickDropDownButton("Clicked dropdown button");
        selectDeleteButton("Selected delete button");
        clickDeleteButton("Clicked delete button");

    }
}
