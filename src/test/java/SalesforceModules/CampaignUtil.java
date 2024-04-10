package SalesforceModules;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageobjects.SalesforceObjects.CampaignObject;
import step_definitions.RunCukesTest;
import utilities.HTMLReportUtil;
import utilities.KeywordUtil;

import java.util.List;

public class CampaignUtil {

    public static void clickCampaignTab(String logStep) throws InterruptedException {
        KeywordUtil.delay(3000);
        KeywordUtil.waitForVisible(CampaignObject.CampaignTab);
        WebElement element = KeywordUtil.getDriver().findElement(CampaignObject.CampaignTab);
        JavascriptExecutor executor = (JavascriptExecutor) KeywordUtil.getDriver();
        executor.executeScript("arguments[0].click();", element);
    }

    public static void enterCampaignName(String Campaignname, String logstep) {
        KeywordUtil.waitForVisible(CampaignObject.CampaignName);
        KeywordUtil.inputText(CampaignObject.CampaignName, Campaignname, logstep);
        KeywordUtil.click(CampaignObject.CampaignName, "click on the Campaign name filed");
    }


    public static void clickParentClick(String Campaignname) throws InterruptedException {
        KeywordUtil.delay(3000);
        KeywordUtil.waitForVisible(CampaignObject.clickParentLink(Campaignname));
        WebElement element = KeywordUtil.getDriver().findElement(CampaignObject.clickParentLink(Campaignname));
        JavascriptExecutor executor = (JavascriptExecutor) KeywordUtil.getDriver();
        executor.executeScript("arguments[0].click();", element);
    }

    public static void enterCampaignInParentSearchBox(String Campaignname,String logstep){
        KeywordUtil.waitForVisible(CampaignObject.parentLinkSearchCompaign);
        KeywordUtil.inputText(CampaignObject.parentLinkSearchCompaign, Campaignname, logstep);
    }

    public static void selectParentCampaign(String campaignName) {
        List<WebElement> CampaignName=KeywordUtil.getListElements(CampaignObject.listOfParentCampaignItems,"getting the parent Campaigns list");
        for(int i =0;i<CampaignName.size();i++){
            if(CampaignName.get(i).getText()==campaignName){
                KeywordUtil.click(CampaignObject.listOfParentComapign,"clicked on the parent comapign");
            }
        }

    }
    public static void selectOption(String option) {

        KeywordUtil.click(CampaignObject.selectOption(option), "user has succesfully selected the " +option);
        KeywordUtil.takeScreenshotAndAttachInReport();
    }
    public static void clickSaveButton(String logStep) throws InterruptedException {
        KeywordUtil.delay(3000);
        KeywordUtil.waitForVisible(CampaignObject.SaveButton);
        WebElement element = KeywordUtil.getDriver().findElement(CampaignObject.SaveButton);
        JavascriptExecutor executor = (JavascriptExecutor) KeywordUtil.getDriver();
        executor.executeScript("arguments[0].click();", element);
    }
    public static void createCampaign(String Campaignname) throws InterruptedException {
        AccountUtil.clickNewButton("user has clicked on the new button");
        enterCampaignName(Campaignname, "user has succesffully entered the " + Campaignname);
        clickSaveButton("user has successfully click on the  save button");
       clickSaveButton("user has successfully click on the  save button");
    }

    public static void clickNewContact() {
        KeywordUtil.waitForVisible(CampaignObject.newContactButton);
        KeywordUtil.click(CampaignObject.newContactButton, "click on the new contact button");
    }

    public static void addParentCampaign(String Campaignname,String ParentCompaign) throws InterruptedException {
        clickParentClick(Campaignname);
        enterCampaignInParentSearchBox(Campaignname,"entered the " +Campaignname+ " in the search box");
        selectParentCampaign(ParentCompaign);
    }

    public static void setSalutation(String salutation, String logStep) throws InterruptedException {
        boolean flag = false;
        KeywordUtil.waitForVisible(CampaignObject.SalutationButton);
        KeywordUtil.click(CampaignObject.SalutationButton, logStep);
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
        KeywordUtil.waitForVisible(CampaignObject.lastName);
        KeywordUtil.inputText(CampaignObject.lastName, name, logStep);
    }

    public static void enterEmail(String email, String logStep) {
        KeywordUtil.waitForVisible(CampaignObject.contactEmailAddress);
        if (email.contains("@") && email.contains(".")) {
            KeywordUtil.inputText(CampaignObject.contactEmailAddress, email, logStep);
        } else {
            Assert.fail("invalid email format");
        }
    }

    public static void enterPhoneContact(String phone, String logStep) {
        KeywordUtil.waitForVisible(CampaignObject.contactEnterTelephone);
        KeywordUtil.inputText(CampaignObject.contactEnterTelephone, phone, logStep);
    }


    public static void clickOnShowActions(String Campaignname,String logstep) throws InterruptedException {
        KeywordUtil.delay(3000);
        KeywordUtil.waitForVisible(CampaignObject.showActions(Campaignname));
        WebElement element = KeywordUtil.getDriver().findElement(CampaignObject.showActions(Campaignname));
        JavascriptExecutor executor = (JavascriptExecutor) KeywordUtil.getDriver();
        executor.executeScript("arguments[0].click();", element);
    }

    public static void clickOnShowActionsEditButton(){
        KeywordUtil.waitForVisible(CampaignObject.ShowActionsEditButton);
       KeywordUtil.click(CampaignObject.ShowActionsEditButton,"click on the edit button");
    }

    public static void clickOnShowActionsDeleteButton() throws InterruptedException {
        KeywordUtil.waitForVisible(CampaignObject.ShowActionsDeletebutton);
        KeywordUtil.click(CampaignObject.ShowActionsDeletebutton,"click on the Delete button");

    }

    public static void clickOnCampaignDelete(){
        KeywordUtil.waitForVisible(CampaignObject.campaignDeletebutton);
        KeywordUtil.click(CampaignObject.campaignDeletebutton,"click on the delete button");
    }
    public static void addContactInCampaign(String salutation, String lastname, String email, String phoneNumber) throws InterruptedException {
        clickNewContact();
        setSalutation(salutation, salutation + "Set Salutation");
        enterLastContactName(lastname, lastname + " lastname set");
        enterEmail(email, email + " email entered");
        enterPhoneContact(phoneNumber, phoneNumber + " phone number entered");
        clickSaveButton("save button clicked");
    }
    public static void editCampaignName(String Campaignname,String editCampaignname) throws InterruptedException {
        clickOnShowActions(Campaignname,"user successfully click on the show Actions buttons");
        clickOnShowActionsEditButton();
        enterCampaignName(editCampaignname,"enter the Campaign name");
        clickSaveButton("user has successfully click on the  save button");
        clickSaveButton("user has successfully click on the  save button");

    }
    public static void deleteCampaign(String Campaignname) throws InterruptedException {
        clickOnShowActions(Campaignname,"user successfully click on the show Actions buttons");
       clickOnShowActionsDeleteButton();
       clickOnCampaignDelete();
    }
    public static void verificationMessage() {
        String gettext = KeywordUtil.getElementText(CampaignObject.successMessage);
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("user has got the message  : " + gettext));

    }
}

