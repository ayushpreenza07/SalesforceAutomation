package utilities.Salesforce;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import pageobjects.SalesforceObjects.AccountObject;
import pageobjects.SalesforceObjects.QuoteObject;
import utilities.GlobalUtil;
import utilities.KeywordUtil;

import java.util.HashMap;

public class AccountUtil extends GlobalUtil {

    static HashMap<String, String> map = new HashMap<>();

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
     * click New Accounts Button for creating new account.
     *
     * @param logStep the log
     */
    public static void clickNewButton(String logStep){
        KeywordUtil.waitForVisible(AccountObject.newAccountButton);
        KeywordUtil.click(AccountObject.newAccountButton,logStep);
    }

    public static void clickSlideShowButton(String logStep){
        KeywordUtil.waitForVisible(AccountObject.slideButton);
        KeywordUtil.click(AccountObject.slideButton,logStep);
    }

    public static void clickCpqButton(String logStep){
        KeywordUtil.waitForVisible(AccountObject.cpqButton);
        KeywordUtil.click(AccountObject.cpqButton,logStep);
    }

    /**
     * Enter account name field for new account.
     *
     * @param logStep the log
     * @param name the account name
     */
    public static void enterAccountName(String name, String logStep){
        KeywordUtil.waitForVisible(AccountObject.accountNameField);
        KeywordUtil.inputText(AccountObject.accountNameField, name,logStep);
    }

    /**
     * Enter phone number field for new account.
     *
     * @param logStep the log
     * @param phone the account name
     */
    public static void enterPhoneNumber(String phone, String logStep){
        KeywordUtil.waitForVisible(AccountObject.phoneNumberField);
        KeywordUtil.inputText(AccountObject.phoneNumberField, phone,logStep);
    }

    /**
     * Enter account number field for new account.
     *
     * @param logStep the log
     * @param accountNumber the account number
     */
    public static void accountNumberField(String accountNumber ,String logStep){
        KeywordUtil.waitForVisible(AccountObject.accountNumberField);
        KeywordUtil.inputText(AccountObject.accountNumberField, accountNumber, logStep);
    }

    /**
     * click save button.
     *
     * @param logStep the log
     */
    public static void clickSaveButton(String logStep){
        KeywordUtil.waitForVisible(AccountObject.saveButton);
        KeywordUtil.click(AccountObject.saveButton,logStep);

//        JavascriptExecutor executor = (JavascriptExecutor)KeywordUtil.getDriver();
//        executor.executeScript("arguments[0].click();", KeywordUtil.getDriver().findElement(AccountObject.saveButton));
    }

    public static void enterBillingAddress(String address, String logStep){
        KeywordUtil.waitForVisible(AccountObject.billingAddress);
        KeywordUtil.inputText(AccountObject.billingAddress,address,logStep);
    }

    public static void enterShippingAddress(String address, String logStep){
        KeywordUtil.waitForVisible(AccountObject.shippingAddress);
        KeywordUtil.inputText(AccountObject.shippingAddress,address,logStep);
    }


    public static void createNewAccount(String name, String accountNumber, String phone) throws InterruptedException {
        clickSlideShowButton("Clicked menu button");
        clickCpqButton("Navigated to Salesforce cpq");
        clickAccountsTab("Navigated to accounts");
        clickNewButton("Clicked new button for accounts");
        enterAccountName(name,name+" entered name");
        enterPhoneNumber(phone, phone+" entered phone");
        accountNumberField(accountNumber,accountNumber+" account number entered");
        clickSaveButton("clicked save button");
    }

}
