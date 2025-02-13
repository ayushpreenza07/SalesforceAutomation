package SalesforceModules;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import pageobjects.SalesforceObjects.AccountObject;
import pageobjects.SalesforceObjects.ServiceSupportObject;

import utilities.GlobalUtil;
import utilities.KeywordUtil;

import java.util.List;

import static SalesforceModules.ContactUtil.enterLastContactName;

public class EditandDeleteUtil extends GlobalUtil {

    /**
     * click edit Button for creating new account.
     *
     * @param logStep the log
     */
    public static void clickEditButton(String logStep) throws InterruptedException {
        KeywordUtil.waitForElementPresence(ServiceSupportObject.editButton);
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
        clickAccountsTab("Click accounts tab");
        clickOpenAccount("Click open account");
        clickEditButton("Clicked edit button for accounts");
        editPhoneNumber(phone, phone+" entered phone");
        clickSaveButton("clicked save button");
    }


    /**
     * click Open Accounts
     *
     * @param logStep the log
     */
    public static void clickOpenAccount(String logStep) throws InterruptedException {
        KeywordUtil.waitForElementPresence(ServiceSupportObject.openaccount_ss);
        WebElement element = KeywordUtil.getDriver().findElement(ServiceSupportObject.openaccount_ss);
        JavascriptExecutor executor = (JavascriptExecutor)KeywordUtil.getDriver();
        executor.executeScript("arguments[0].click();", element);
    }

    /**
     * click Accounts tab.
     *
     * @param logStep the log
     */
    public static void clickAccountsTab(String logStep) throws InterruptedException {
        KeywordUtil.waitForElementPresence(AccountObject.accountsTab);
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


    /**
     * click drop down in contacts section.
     *
     * @param logStep the log
     */
    public static void clickDropDownButton_ss(String logStep){
        KeywordUtil.waitForVisible(ServiceSupportObject.dropdown_ss);
        KeywordUtil.clickJS(ServiceSupportObject.dropdown_ss,logStep);
    }

    /**
     * click edit Button for creating new account.
     *
     * @param logStep the log
     */
    public static void clickEditButtonforcontact(String logStep) throws InterruptedException {
        KeywordUtil.waitForElementPresence(ServiceSupportObject.editButton_ss);
        KeywordUtil.click(ServiceSupportObject.editButton_ss,logStep);
    }

    /**
     * Edit Contact Details
     *
     *
     *  @param lastname the lastname
     */
    public static void editContactDetails(String lastname) throws InterruptedException {
        clickContactTab_cnt();
        clickDropDownButton_ss("Clicked drop down button for contacts");
        clickEditButtonforcontact("Clicked edit button for accounts");
        enterLastContactName(lastname,lastname+" lastname set");
        clickSaveButton("clicked save button");
    }

    /**
     * click drop down in contacts section.
     *
     * @param logStep the log
     */
    public static void clickDropDownButton_cnt(String logStep){
        KeywordUtil.waitForElementPresence(ServiceSupportObject.dropDown_cnt);
        KeywordUtil.click(ServiceSupportObject.dropDown_cnt,logStep);
    }

    /**
     * select delete button from dropdown
     *
     * @param logStep the log
     */
    public static void selectDeleteButton_cnt(String logStep){
        KeywordUtil.waitForVisible(ServiceSupportObject.deleteButton_cnt);
        KeywordUtil.click(ServiceSupportObject.deleteButton_cnt,logStep);
    }

    /**
     * click delete in contacts section.
     *
     * @param logStep the log
     */
    public static void clickDeleteButton_cnt(String logStep){
        KeywordUtil.waitForVisible(ServiceSupportObject.clickdeleteButton_cnt);
        KeywordUtil.click(ServiceSupportObject.clickdeleteButton_cnt,logStep);
    }

    /**
     * Delete Contact
     *
     *
     *  @param logStep the log
     */
    public static void deleteContact(String logStep) throws InterruptedException {
        clickContactTab_cnt();
        clickDropDownButton_cnt("Clicked dropdown button");
        selectDeleteButton_cnt("Selected delete button");
        clickDeleteButton_cnt("Clicked delete button");

    }

    /**
     * For creating filter
     *
     *
     *  @param fieldname the fieldname
     *  @param matchingValue the matchingValue
     *
     */
    public static void selectFilterInContacts_cnt(String fieldname,String matchingValue) throws InterruptedException {
        clickShowFilter_cnt();
        clickAddFilter_cnt();
        clickFieldFilter_cnt();
        selectNameFilter_cnt(fieldname);
        enterValue_cnt(matchingValue);
        clickDoneButton_cnt();
        saveFilter_cnt();
        clickCloseFilter_cnt();
    }

    /**
     * For clicking show filter

     *
     */
    public static void clickShowFilter_cnt(){
        KeywordUtil.waitForClickable(ServiceSupportObject.showFiltersInContacts_ss);
        KeywordUtil.click(ServiceSupportObject.showFiltersInContacts_ss,"click on show filters");
    }

    /**
     * For adding filter

     *
     */
    public static void clickAddFilter_cnt(){
        KeywordUtil.waitForClickable(ServiceSupportObject.addFiltersInContacts_ss);
        KeywordUtil.click(ServiceSupportObject.addFiltersInContacts_ss,"click on Add filters");
    }

    /**
     * For clicking field filter

     *
     */
    public static void clickFieldFilter_cnt(){
        KeywordUtil.waitForClickable(ServiceSupportObject.clickFieldFilter_ss);
        KeywordUtil.click(ServiceSupportObject.clickFieldFilter_ss,"click on Field filters dropdown");
    }

    /**
     * For entering value filled
     *
     */
    public static void enterValue_cnt(String matchingValue){
        KeywordUtil.inputText(ServiceSupportObject.enter_value_ss,matchingValue,"enter the value in filed");
    }

    /**
     * For entering value filled
     *
     */
    public static void clickDoneButton_cnt(){
        KeywordUtil.waitForClickable(ServiceSupportObject.doneButton_ss);
        KeywordUtil.click(ServiceSupportObject.doneButton_ss,"click on done button");
    }

    /**
     * For Save filter
     *
     */
    public static void saveFilter_cnt() throws InterruptedException {
        KeywordUtil.waitForElementPresence(ServiceSupportObject.saveFilterButton_ss);
        WebElement element = KeywordUtil.getDriver().findElement(ServiceSupportObject.saveFilterButton_ss);
        JavascriptExecutor executor = (JavascriptExecutor) KeywordUtil.getDriver();
        executor.executeScript("arguments[0].click();", element);
    }

    /**
     * For selecting name filter
     *
     */
    public static void selectNameFilter_cnt(String filedName) throws InterruptedException {
        List<WebElement> getAllelements=KeywordUtil.getListElements(ServiceSupportObject.allDropdownElementsInFieldFilter_ss,"");
        for(WebElement element:getAllelements){
            if(element.getText().equalsIgnoreCase(filedName)){
                JavascriptExecutor executor = (JavascriptExecutor) KeywordUtil.getDriver();
                executor.executeScript("arguments[0].scrollIntoView(true);", element);
                element.click();
            }
        }
    }

    /**
     * For clicking close filter
     *
     */
    public static void clickCloseFilter_cnt() throws InterruptedException {
        KeywordUtil.waitForElementPresence(ServiceSupportObject.closeFilterButton_ss);
        WebElement element = KeywordUtil.getDriver().findElement(ServiceSupportObject.closeFilterButton_ss);
        JavascriptExecutor executor = (JavascriptExecutor) KeywordUtil.getDriver();
        executor.executeScript("arguments[0].click();", element);
    }

    /**
     * For clicking contact tab
     *
     */
    public static void clickContactTab_cnt() throws InterruptedException {
        KeywordUtil.waitForElementPresence(ServiceSupportObject.contactTab_ss);
        WebElement element = KeywordUtil.getDriver().findElement(ServiceSupportObject.contactTab_ss);
        JavascriptExecutor executor = (JavascriptExecutor) KeywordUtil.getDriver();
        executor.executeScript("arguments[0].click();", element);
    }

    /**
     * For remove filter
     *
     */
    public static void removeFilter_cnt() throws InterruptedException {
        clickShowFilter_cnt();
        clickRemoveAllButton_cnt();
        saveFilter_cnt();
        clickCloseFilter_cnt();

    }

    /**
     * For clicking removeAll button for filter
     *
     */
    public static void clickRemoveAllButton_cnt() throws InterruptedException {
        KeywordUtil.waitForElementPresence(ServiceSupportObject.removeFiltersInContacts_ss);
        WebElement element = KeywordUtil.getDriver().findElement(ServiceSupportObject.removeFiltersInContacts_ss);
        JavascriptExecutor executor = (JavascriptExecutor) KeywordUtil.getDriver();
        executor.executeScript("arguments[0].click();", element);
    }
}
