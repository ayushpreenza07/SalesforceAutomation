package SalesforceModules;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageobjects.SalesforceObjects.ContactObject;
import utilities.KeywordUtil;

import java.util.HashMap;

public class ContactUtil {

    static HashMap<String, String> map = new HashMap<>();

    /**
     * click new button for creating new contact.
     *
     * @param logStep the log
     */
    public static void NewButtonContact(String logStep) throws InterruptedException {
        KeywordUtil.delay(3000);
        KeywordUtil.waitForVisible(ContactObject.newContactButton);
        KeywordUtil.click(ContactObject.newContactButton,logStep);
    }


    /**
     * Enter first contact name field for new contact.
     *
     * @param logStep the log
     * @param name the account name
     */
    public static void enterContactName(String name, String logStep){
        KeywordUtil.waitForVisible(ContactObject.firstName);
        KeywordUtil.inputText(ContactObject.firstName, name,logStep);
    }

    /**
     * Enter last contact name field for new contact.
     *
     * @param logStep the log
     * @param name the contact name
     */
    public static void enterLastContactName(String name, String logStep){
        KeywordUtil.waitForVisible(ContactObject.lastName);
        KeywordUtil.inputText(ContactObject.lastName, name,logStep);
    }

    /**
     * Enter phone contact name field for new contact.
     *
     * @param logStep the log
     * @param phone the contact name
     */
    public static void enterPhoneContact(String phone, String logStep){
        KeywordUtil.waitForVisible(ContactObject.phoneField);
        KeywordUtil.inputText(ContactObject.phoneField, phone,logStep);
    }

    public static void enterEmail(String email, String logStep){
        KeywordUtil.waitForVisible(ContactObject.emailField);
        if(email.contains("@") && email.contains(".")) {
            KeywordUtil.inputText(ContactObject.emailField, email, logStep);
        }else{
            Assert.fail("invalid email format");
        }
    }

    /**
     * click save button.
     *
     * @param logStep the log
     */
    public static void clickSaveButton(String logStep){
        KeywordUtil.waitForVisible(ContactObject.saveButton);
        KeywordUtil.click(ContactObject.saveButton,logStep);
    }

    public static void clickContactButton(String logStep) throws InterruptedException {
        KeywordUtil.delay(3000);
        KeywordUtil.waitForVisible(ContactObject.contactButton);
        WebElement element = KeywordUtil.getDriver().findElement(ContactObject.contactButton);
        JavascriptExecutor executor = (JavascriptExecutor)KeywordUtil.getDriver();
        executor.executeScript("arguments[0].click();", element);
    }

    public static void backToAccount(String logStep) throws InterruptedException {
        try {
            KeywordUtil.delay(5000);
            KeywordUtil.waitForVisible(ContactObject.backToAccount);
            KeywordUtil.click(ContactObject.backToAccount, logStep);
        }catch(Throwable e) {
            KeywordUtil.delay(3000);
            KeywordUtil.waitForVisible(ContactObject.backToAccount);
            WebElement element = KeywordUtil.getDriver().findElement(ContactObject.backToAccount);
            JavascriptExecutor executor = (JavascriptExecutor) KeywordUtil.getDriver();
            executor.executeScript("arguments[0].click();", element);
        }
    }
    public static void setSalutation(String salutation, String logStep){
        boolean flag = false;
        KeywordUtil.waitForVisible(ContactObject.salutationButton);
        KeywordUtil.click(ContactObject.salutationButton,logStep);
        String xpath = "//lightning-base-combobox-item[contains(@data-value,'"+salutation+"')]";
        try{
            flag = KeywordUtil.getDriver().findElement(By.xpath(xpath)).isDisplayed();
        }catch (Exception e){}

        if(!flag){
            Assert.fail("No such salutation is present");
        }else {
            KeywordUtil.click(By.xpath(xpath), "salutation selected");
        }
    }

    public static void createContact(String salutation, String lastname, String email, String phoneNumber) throws InterruptedException {
        clickContactButton("Navigated to Contacts");
        NewButtonContact("New contact button clicked");
        setSalutation(salutation,salutation+"Set Salutation");
        enterLastContactName(lastname,lastname+" lastname set");
        enterEmail(email,email+" email entered");
        enterPhoneContact(phoneNumber,phoneNumber+" phone number entered");
        clickSaveButton("save button clicked");
        backToAccount("Navigated back to account");
    }
}