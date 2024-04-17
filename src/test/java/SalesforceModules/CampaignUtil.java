package SalesforceModules;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.xmlbeans.impl.xb.xsdschema.All;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;
import org.testng.Assert;
import pageobjects.SalesforceObjects.CampaignObject;
import pageobjects.SalesforceObjects.OppurtunitiesObject;
import step_definitions.RunCukesTest;
import utilities.GlobalUtil;
import utilities.HTMLReportUtil;
import utilities.KeywordUtil;

import java.security.Key;
import java.util.List;

public class CampaignUtil {

    public static void clickCampaignTab(String logStep) throws InterruptedException {
        KeywordUtil.delay(3000);
        KeywordUtil.waitForVisible(CampaignObject.CampaignTab);
        WebElement element = KeywordUtil.getDriver().findElement(CampaignObject.CampaignTab);
        JavascriptExecutor executor = (JavascriptExecutor) KeywordUtil.getDriver();
        executor.executeScript("arguments[0].click();", element);
    }

    public static void entercampaignName(String campaignName, String logstep) {
        KeywordUtil.waitForVisible(CampaignObject.CampaignName);
        KeywordUtil.inputText(CampaignObject.CampaignName, campaignName, logstep);
        KeywordUtil.click(CampaignObject.CampaignName, "click on the Campaign name filed");
    }


    public static void clickParentClick(String campaignName) throws InterruptedException {
        KeywordUtil.delay(3000);
        KeywordUtil.waitForVisible(CampaignObject.clickParentLink(campaignName));
        WebElement element = KeywordUtil.getDriver().findElement(CampaignObject.clickParentLink(campaignName));
        JavascriptExecutor executor = (JavascriptExecutor) KeywordUtil.getDriver();
        executor.executeScript("arguments[0].click();", element);
    }

    public static void enterCampaignInParentSearchBox(String campaignName,String logstep){
        KeywordUtil.waitForVisible(CampaignObject.parentLinkSearchCompaign);
        KeywordUtil.inputText(CampaignObject.parentLinkSearchCompaign, campaignName, logstep);
    }

    public static void selectParentCampaign(String campaignName) throws InterruptedException {

        List<WebElement> campaignNames=KeywordUtil.getListElements(CampaignObject.listOfParentCampaignItems,"getting the parent Campaigns list");
        for (WebElement campaign : campaignNames) {
            if (campaign.getText().equalsIgnoreCase(campaignName)) {
                KeywordUtil.delay(9000);
                campaign.click();
                break;
            }
        }



    }

    public static void parentClickSaveButton(){
        KeywordUtil.waitForVisible(CampaignObject.parent_compaign_Save_button);
        KeywordUtil.click(CampaignObject.parent_compaign_Save_button,"click on the save button");
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
    public static void createCampaign(String campaignName) throws InterruptedException {
        AccountUtil.clickNewButton("user has clicked on the new button");
        entercampaignName(campaignName, "user has succesffully entered the " + campaignName);
        clickSaveButton("user has successfully click on the  save button");
       clickSaveButton("user has successfully click on the  save button");
    }

    public static void clickNewContact() {
        KeywordUtil.waitForVisible(CampaignObject.newContactButton);
        KeywordUtil.click(CampaignObject.newContactButton, "click on the new contact button");
    }

    public static void addParentCampaign(String campaignName,String parentCompaign) throws InterruptedException {
        clickParentClick(campaignName);
        enterCampaignInParentSearchBox(parentCompaign,"entered the " +campaignName+ " in the search box");
        selectParentCampaign(parentCompaign);
        parentClickSaveButton();

    }

    public static void clickEditContactSaveButton() throws InterruptedException {
        KeywordUtil.delay(3000);
        KeywordUtil.waitForVisible(CampaignObject.saveEditContactButton);
        WebElement element = KeywordUtil.getDriver().findElement(CampaignObject.saveEditContactButton);
        JavascriptExecutor executor = (JavascriptExecutor) KeywordUtil.getDriver();
        executor.executeScript("arguments[0].click();", element);
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


    public static void clickOnShowActions(String campaignName,String logstep) throws InterruptedException {
        KeywordUtil.delay(3000);
        KeywordUtil.waitForVisible(CampaignObject.showActions(campaignName));
        WebElement element = KeywordUtil.getDriver().findElement(CampaignObject.showActions(campaignName));
        JavascriptExecutor executor = (JavascriptExecutor) KeywordUtil.getDriver();
        executor.executeScript("arguments[0].click();", element);
    }

    public static void clickOnShowActionsEditButton() throws InterruptedException {
        KeywordUtil.delay(3000);
        KeywordUtil.waitForVisible(CampaignObject.ShowActionsEditButton);
        WebElement element = KeywordUtil.getDriver().findElement(CampaignObject.ShowActionsEditButton);
        JavascriptExecutor executor = (JavascriptExecutor) KeywordUtil.getDriver();
        executor.executeScript("arguments[0].click();", element);
    }

    public static void clickOnContactShowActionsEditButton() throws InterruptedException {
        KeywordUtil.delay(3000);
        KeywordUtil.waitForVisible(CampaignObject.EditContactsShowActions);
        WebElement element = KeywordUtil.getDriver().findElement(CampaignObject.EditContactsShowActions);
        JavascriptExecutor executor = (JavascriptExecutor) KeywordUtil.getDriver();
        executor.executeScript("arguments[0].click();", element);
    }

    public static void clickOnShowActionsDeleteButton() throws InterruptedException {
        KeywordUtil.waitForVisible(CampaignObject.ShowActionsDeletebutton);
        KeywordUtil.click(CampaignObject.ShowActionsDeletebutton,"click on the Delete button");

    }
    public static void clickOnContactShowActionsDeleteButton() throws InterruptedException {
        KeywordUtil.waitForVisible(CampaignObject.deleteContactsShowActions);
        KeywordUtil.click(CampaignObject.deleteContactsShowActions,"click on the Delete button");

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
    public static void editCampaignName(String campaignName,String editcampaignName) throws InterruptedException {
        clickOnShowActions(campaignName,"user successfully click on the show Actions buttons");
        clickOnShowActionsEditButton();
        entercampaignName(editcampaignName,"enter the Campaign name");
        clickSaveButton("user has successfully click on the  save button");
        clickSaveButton("user has successfully click on the  save button");

    }
    public static void deleteCampaign(String campaignName) throws InterruptedException {
        clickOnShowActions(campaignName,"user successfully click on the show Actions buttons");
       clickOnShowActionsDeleteButton();
       clickOnCampaignDelete();
    }
    public static void verificationMessage() {
        String gettext = KeywordUtil.getElementText(CampaignObject.successMessage);
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("user has got the message  : " + gettext));

    }

    public static void clickCampaign( String campaignName){
        KeywordUtil.waitForVisible(CampaignObject.clickCampaign(campaignName));
        KeywordUtil.click(CampaignObject.clickCampaign(campaignName),"click on the " +campaignName);
    }

    public static void clickAddLeads() throws InterruptedException {
        KeywordUtil.delay(3000);
        KeywordUtil.scrollingToElementofAPage(CampaignObject.campaignMember,"scroll to the campaign member");
        KeywordUtil.delay(5000);
        KeywordUtil.click(CampaignObject.addLeadsButton,"click on the add leads button");

    }

    public static void clickNextButton(){
        KeywordUtil.waitForVisible(CampaignObject.leadsNextButton);
        KeywordUtil.click(CampaignObject.leadsNextButton,"click on the next  button");
    }

    public static void clickSubmitButton(){
        KeywordUtil.waitForVisible(CampaignObject.leadsSubmitButton);
        KeywordUtil.click(CampaignObject.leadsSubmitButton,"click on the submit button");
    }
    public static void selectLead(String leadName) throws InterruptedException {
        KeywordUtil.delay(5000);
        KeywordUtil.inputText(CampaignObject.searchLeads,leadName,"enter the leadName in the search box");
        KeywordUtil.delay(6000);
        List<WebElement> LeadNames=KeywordUtil.getListElements(CampaignObject.listOfParentCampaignItems,"getting the Lead members list");
        for (WebElement Lead : LeadNames) {
            System.out.println(Lead.getText());
            if (Lead.getText().equals(leadName)) {
                Thread.sleep(8000);
                Lead.click();
                break;
            }
        }

    }

    public static void leadVerificationMessage(){
        String gettext = KeywordUtil.getElementText(CampaignObject.successLeadMessage);
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("user has got the message  : " + gettext));
    }


    public static void addLeads(String leadName) throws InterruptedException {
        CampaignUtil.clickAddLeads();
        KeywordUtil.delay(5000);
        CampaignUtil.selectLead(leadName);
        CampaignUtil.clickNextButton();
        KeywordUtil.delay(6000);
        CampaignUtil.clickSubmitButton();
        KeywordUtil.delay(7000);
        CampaignUtil.leadVerificationMessage();
        KeywordUtil.takeScreenshotAndAttachInReport();
    }


    public static void clickContactTab() throws InterruptedException {
        KeywordUtil.delay(3000);
        KeywordUtil.waitForVisible(CampaignObject.contactTab);
        WebElement element = KeywordUtil.getDriver().findElement(CampaignObject.contactTab);
        JavascriptExecutor executor = (JavascriptExecutor) KeywordUtil.getDriver();
        executor.executeScript("arguments[0].click();", element);
    }

    public static void clickShowFilter(){
        KeywordUtil.waitForClickable(CampaignObject.showFiltersInContacts);
        KeywordUtil.click(CampaignObject.showFiltersInContacts,"click on show filters");

    }

    public static void clickAddFilter(){
        KeywordUtil.waitForClickable(CampaignObject.addFiltersInContacts);
        KeywordUtil.click(CampaignObject.addFiltersInContacts,"click on Add filters");

    }

    public static void clickFieldFilter(){
        KeywordUtil.waitForClickable(CampaignObject.clickFieldFilter);
        KeywordUtil.click(CampaignObject.clickFieldFilter,"click on Field filters dropdown");
    }

    public static void enterValue(String matchingValue){
        KeywordUtil.inputText(CampaignObject.enter_value,matchingValue,"enter the value in filed");

    }

    public static void clickDoneButton(){
        KeywordUtil.waitForClickable(CampaignObject.doneButton);
        KeywordUtil.click(CampaignObject.doneButton,"click on done button");
    }

    public static void saveFilter() throws InterruptedException {
        KeywordUtil.delay(3000);
        KeywordUtil.waitForVisible(CampaignObject.saveFilterButton);
        WebElement element = KeywordUtil.getDriver().findElement(CampaignObject.saveFilterButton);
        JavascriptExecutor executor = (JavascriptExecutor) KeywordUtil.getDriver();
        executor.executeScript("arguments[0].click();", element);
    }

    public static void selectNameFilter(String filedName) throws InterruptedException {

        List<WebElement> getAllelements=KeywordUtil.getListElements(CampaignObject.allDropdownElements,"");
        for(WebElement element:getAllelements){
            if(element.getText().equalsIgnoreCase(filedName)){
                KeywordUtil.delay(6000);
                JavascriptExecutor executor = (JavascriptExecutor) KeywordUtil.getDriver();
                executor.executeScript("arguments[0].scrollIntoView(true);", element);
                KeywordUtil.delay(6000);
                element.click();
            }
        }


    }

    public static void clickCloseFilter() throws InterruptedException {
        KeywordUtil.delay(3000);
        KeywordUtil.waitForVisible(CampaignObject.closeFilterButton);
        WebElement element = KeywordUtil.getDriver().findElement(CampaignObject.closeFilterButton);
        JavascriptExecutor executor = (JavascriptExecutor) KeywordUtil.getDriver();
        executor.executeScript("arguments[0].click();", element);
    }

    public static void clickShowActiosnInContacs(String contactName) throws InterruptedException {
        KeywordUtil.delay(3000);
        KeywordUtil.waitForVisible(CampaignObject.clickShowActionsInContacts(contactName));
        WebElement element = KeywordUtil.getDriver().findElement(CampaignObject.clickShowActionsInContacts(contactName));
        JavascriptExecutor executor = (JavascriptExecutor) KeywordUtil.getDriver();
        executor.executeScript("arguments[0].click();", element);
    }

    public static void clickDeleteShowActiosnInContacs(String contactName) throws InterruptedException {
        KeywordUtil.delay(3000);
        KeywordUtil.waitForVisible(CampaignObject.DeleteShowActionInContacts(contactName));
        WebElement element = KeywordUtil.getDriver().findElement(CampaignObject.DeleteShowActionInContacts(contactName));
        JavascriptExecutor executor = (JavascriptExecutor) KeywordUtil.getDriver();
        executor.executeScript("arguments[0].click();", element);
    }

  public static void clickRemoveAllButton() throws InterruptedException {
      KeywordUtil.delay(3000);
      KeywordUtil.waitForVisible(CampaignObject.removeFiltersInContacts);
      WebElement element = KeywordUtil.getDriver().findElement(CampaignObject.removeFiltersInContacts);
      JavascriptExecutor executor = (JavascriptExecutor) KeywordUtil.getDriver();
      executor.executeScript("arguments[0].click();", element);
  }


  public static void clickNewButtonInContactTab() throws InterruptedException {
      KeywordUtil.delay(3000);
      KeywordUtil.waitForVisible(CampaignObject.newButtonInContactTab);
      WebElement element = KeywordUtil.getDriver().findElement(CampaignObject.newButtonInContactTab);
      JavascriptExecutor executor = (JavascriptExecutor) KeywordUtil.getDriver();
      executor.executeScript("arguments[0].click();", element);
  }


  public static void selectFilterInContacts(String fieldname,String matchingValue) throws InterruptedException {
        clickShowFilter();
        clickAddFilter();
        clickFieldFilter();
        selectNameFilter(fieldname);
        enterValue(matchingValue);
        clickDoneButton();
        saveFilter();
        clickCloseFilter();
  }

    public static void editContact(String email,String contact) throws InterruptedException {
        clickShowActiosnInContacs(contact);
        clickOnContactShowActionsEditButton();
        enterEmail(email, " email entered");
        KeywordUtil.delay(8000);
        clickEditContactSaveButton();
    }

    public static void deletecontact(String contact) throws InterruptedException {
      clickDeleteShowActiosnInContacs(contact);
      clickOnShowActionsDeleteButton();
        clickOnCampaignDelete();

    }

    public static void removeFilter() throws InterruptedException {
        clickShowFilter();
        clickRemoveAllButton();
        saveFilter();
       clickCloseFilter();

    }

    public static void createConatctInConatctTab( String lastname, String email ) throws InterruptedException {
        clickNewButtonInContactTab();
        enterLastContactName(lastname, lastname + " lastname set");
        enterEmail(email, email + " email entered");
        clickEditContactSaveButton();
    }

    public static void createOpportunityInConatct(String name, String amount, String stage) throws InterruptedException {
        OppurtunitiesUtil.NewButtonOppurtunity("clicked new button for Opportunity");
        OppurtunitiesUtil.enterOppurtunityName(name, name+" entered in Opportunity");
        OppurtunitiesUtil.enterCloseDate(2024,1,2,"Close date entered");
        OppurtunitiesUtil.enterAmount(amount, "Amount entered "+amount);
        OppurtunitiesUtil.setStage(stage, "Stage selected - "+stage);
        OppurtunitiesUtil.clickSaveButton("saved");

    }


    public static void clickViewAllButton() throws InterruptedException {
        KeywordUtil.delay(3000);
        KeywordUtil.waitForVisible(CampaignObject.viewAll);
        WebElement element = KeywordUtil.getDriver().findElement(CampaignObject.viewAll);
        JavascriptExecutor executor = (JavascriptExecutor) KeywordUtil.getDriver();
        executor.executeScript("arguments[0].click();", element);
    }

    public static void getAllOpportunitiesName(){
        List<WebElement> AllOpportunities=KeywordUtil.getListElements(CampaignObject.getOpportunitiesName,"getting all opportunities name");
        for(WebElement opportunity: AllOpportunities){
            String input = opportunity.getText();
            String[] parts = input.split(" ");
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.infoStringGreenColor("the opportunities is : " +parts[1]));

        }





    }

    public static void getAllStages(){
        List<WebElement> allStages=KeywordUtil.getListElements(CampaignObject.getAllStages,"getting all Stages  name");
        for(WebElement stage: allStages){
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.infoStringGreenColor("the stage is : " +stage.getText()));
        }
    }

    public static void getAllmount(){
        List<WebElement> allAmount=KeywordUtil.getListElements(CampaignObject.getAllAmount,"getting all Amount name");
        for(WebElement Amount:allAmount){
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.infoStringGreenColor("the Amount is : " +Amount.getText()));
        }
    }

    public static void getClosedDate(){
        List<WebElement> ClosedDate=KeywordUtil.getListElements(CampaignObject.getCloseDate,"getting the closed date");
        for(WebElement Date:ClosedDate){
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.infoStringGreenColor("the Closed date  is : " +Date.getText()));
        }
    }

    public static void seeOpportunityInContact() throws InterruptedException {
        clickViewAllButton();
        getAllOpportunitiesName();
        getAllStages();
        getAllmount();
        getClosedDate();
    }

}

