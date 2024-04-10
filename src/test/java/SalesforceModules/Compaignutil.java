package SalesforceModules;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageobjects.SalesforceObjects.Comapign_object;
import step_definitions.RunCukesTest;
import utilities.HTMLReportUtil;
import utilities.KeywordUtil;

import java.util.Random;

public class Compaignutil {

    //P[@class='slds-truncate'][text()='Community']




    public static void clickComapignTab(String logStep) throws InterruptedException {
        KeywordUtil.delay(3000);
        KeywordUtil.waitForVisible(Comapign_object.Comapign_Tab);
        WebElement element = KeywordUtil.getDriver().findElement(Comapign_object.Comapign_Tab);
        JavascriptExecutor executor = (JavascriptExecutor) KeywordUtil.getDriver();
        executor.executeScript("arguments[0].click();", element);
    }

    public static void entercompaignname(String compaignname, String logstep) {
        KeywordUtil.waitForVisible(Comapign_object.Comapign_Name);
        KeywordUtil.inputText(Comapign_object.Comapign_Name, compaignname, logstep);
        KeywordUtil.click(Comapign_object.Comapign_Name, "click on the compaign name filed");
    }


    public static void successmessage() {
        String gettext = KeywordUtil.getElementText(Comapign_object.success_message);

    }

    public static void click_link() throws InterruptedException {
        KeywordUtil.delay(3000);
        KeywordUtil.waitForVisible(Comapign_object.parentLink);
        WebElement element = KeywordUtil.getDriver().findElement(Comapign_object.parentLink);
        JavascriptExecutor executor = (JavascriptExecutor) KeywordUtil.getDriver();
        executor.executeScript("arguments[0].click();", element);


    }

    public static void select_parent_compaign() {
        KeywordUtil.waitForVisible(Comapign_object.select_parentCompain);
        KeywordUtil.click(Comapign_object.select_parentCompain, "select the parent link");
    }

    public static void clickSaveButton(String logStep) throws InterruptedException {
        KeywordUtil.delay(3000);
        KeywordUtil.waitForVisible(Comapign_object.Save_Button);
        WebElement element = KeywordUtil.getDriver().findElement(Comapign_object.Save_Button);
        JavascriptExecutor executor = (JavascriptExecutor) KeywordUtil.getDriver();
        executor.executeScript("arguments[0].click();", element);


//        JavascriptExecutor executor = (JavascriptExecutor)KeywordUtil.getDriver();
//        executor.executeScript("arguments[0].click();", KeywordUtil.getDriver().findElement(AccountObject.saveButton));
    }

    public static String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder result = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length()); // Generate a random index
            result.append(characters.charAt(index)); // Append the character at the random index
        }

        return result.toString();
    }

    public static void createcompaign(String compaignname) throws InterruptedException {

        AccountUtil.clickNewButton("user has clicked on the new button");
        entercompaignname(compaignname, "user has succesffully entered the " + compaignname);

        clickSaveButton("user has successfully click on the  save button");
       clickSaveButton("user has successfully click on the  save button");


    }

    public static void click_on_save_button() {
        KeywordUtil.waitForVisible(Comapign_object.parent_compaign_Save_button);
        //KeywordUtil.click(Comapign_object.parent_compaign_Save_button,"click on the parernt compaign save button");
    }

    public static void clickNewContact() {
        KeywordUtil.waitForVisible(Comapign_object.new_contact_button);
        KeywordUtil.click(Comapign_object.new_contact_button, "click on the new contact button");
    }

    public static void addparentcomapign() throws InterruptedException {
        click_link();
        select_parent_compaign();
        click_on_save_button();

    }

    public static void setSalutation(String salutation, String logStep) throws InterruptedException {
        boolean flag = false;
        KeywordUtil.waitForVisible(Comapign_object.Salutation_Button);
        KeywordUtil.click(Comapign_object.Salutation_Button, logStep);
        String xpath = "(//a[contains(@title,'" + salutation + "')])[2]";


        KeywordUtil.delay(2000);
        System.out.println(xpath);
        try {
            flag = KeywordUtil.getDriver().findElement(By.xpath(xpath)).isDisplayed();
        } catch (Exception e) {
        }

        if (!flag) {
            Assert.fail("No such salutation is present");
        } else {
            KeywordUtil.click(By.xpath(xpath), "salutation selected");
        }
    }

    public static void enterLastContactName(String name, String logStep) {
        KeywordUtil.waitForVisible(Comapign_object.lastname);
        KeywordUtil.inputText(Comapign_object.lastname, name, logStep);
    }

    public static void enterEmail(String email, String logStep) {
        KeywordUtil.waitForVisible(Comapign_object.contact_eamiladdress);
        if (email.contains("@") && email.contains(".")) {
            KeywordUtil.inputText(Comapign_object.contact_eamiladdress, email, logStep);
        } else {
            Assert.fail("invalid email format");
        }
    }

    public static void enterPhoneContact(String phone, String logStep) {
        KeywordUtil.waitForVisible(Comapign_object.contact_enter_Telephone);
        KeywordUtil.inputText(Comapign_object.contact_enter_Telephone, phone, logStep);
    }


    public static void click_on_Show_Actions(String compaignname,String logstep) throws InterruptedException {
        KeywordUtil.delay(3000);
        KeywordUtil.waitForVisible(Comapign_object.show_Actions(compaignname));
        WebElement element = KeywordUtil.getDriver().findElement(Comapign_object.show_Actions(compaignname));
        JavascriptExecutor executor = (JavascriptExecutor) KeywordUtil.getDriver();
        executor.executeScript("arguments[0].click();", element);
    }

    public static void click_on_Show_Actions_Edit_button(){
        KeywordUtil.waitForVisible(Comapign_object.Show_Actions_Edit_Button);
       KeywordUtil.click(Comapign_object.Show_Actions_Edit_Button,"click on the edit button");
    }

    public static void click_on_Show_Actions_delete_button() throws InterruptedException {
//        KeywordUtil.delay(3000);
//        KeywordUtil.waitForVisible(Comapign_object.Show_Actions_Delete_button);
//        WebElement element = KeywordUtil.getDriver().findElement(Comapign_object.Show_Actions_Delete_button);
//        JavascriptExecutor executor = (JavascriptExecutor) KeywordUtil.getDriver();
//        executor.executeScript("arguments[0].click();", element);
        KeywordUtil.waitForVisible(Comapign_object.Show_Actions_Delete_button);

        KeywordUtil.click(Comapign_object.Show_Actions_Delete_button,"click on the Delete button");

    }

    public static void click_on_Compaign_Delete(){
        KeywordUtil.waitForVisible(Comapign_object.compaign_Delete_button);
        KeywordUtil.click(Comapign_object.compaign_Delete_button,"click on the delete button");
    }


    public static void entercompaign(){
        KeywordUtil.waitForVisible(Comapign_object.Comapign_Name);
        KeywordUtil.inputText(Comapign_object.Comapign_Name, generateRandomString(7), "enterd the comapign name");
    }


    public static void addContactInComapign(String salutation, String lastname, String email, String phoneNumber) throws InterruptedException {
        clickNewContact();
        setSalutation(salutation, salutation + "Set Salutation");
        enterLastContactName(lastname, lastname + " lastname set");
        enterEmail(email, email + " email entered");
        enterPhoneContact(phoneNumber, phoneNumber + " phone number entered");
        clickSaveButton("save button clicked");
//        ContactUtil.backToAccount("Navigated back to account");
    }

    public static void editcompaignname(String compaignname,String editcompaignname) throws InterruptedException {
        click_on_Show_Actions(compaignname,"user successfully click on the show Actions buttons");
        click_on_Show_Actions_Edit_button();
        entercompaignname(editcompaignname,"enter the compaign name");
        clickSaveButton("user has successfully click on the  save button");
        clickSaveButton("user has successfully click on the  save button");

    }

    public static void deletecompaign(String compaignname) throws InterruptedException {
        click_on_Show_Actions(compaignname,"user successfully click on the show Actions buttons");
        Thread.sleep(6000);
        click_on_Show_Actions_delete_button();
        click_on_Compaign_Delete();




    }

    public static void verificationmessage(){
        String gettext=KeywordUtil.getElementText(Comapign_object.success_message);
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("user has got the message  : " +gettext));

    }
}

