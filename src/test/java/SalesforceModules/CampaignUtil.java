package SalesforceModules;

import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.Then;
import net.bytebuddy.description.modifier.Ownership;
import org.apache.commons.exec.ExecuteException;
import org.apache.xmlbeans.impl.xb.xsdschema.All;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;
import org.testng.Assert;
import pageobjects.SalesforceObjects.CampaignObject;
import pageobjects.SalesforceObjects.LeadsPage;
import pageobjects.SalesforceObjects.OppurtunitiesObject;
import step_definitions.RunCukesTest;
import utilities.GlobalUtil;
import utilities.HTMLReportUtil;
import utilities.KeywordUtil;

import java.security.Key;
import java.util.List;

public class CampaignUtil {

    /**
     * Click on the Campaign Tab
     * @param logStep the log step
     * @throws InterruptedException the interrupted exception
     */
    public static void clickCampaignTab(String logStep) throws InterruptedException {
        KeywordUtil.delay(3000);
        KeywordUtil.waitForVisible(CampaignObject.CampaignTab);
        WebElement element = KeywordUtil.getDriver().findElement(CampaignObject.CampaignTab);
        JavascriptExecutor executor = (JavascriptExecutor) KeywordUtil.getDriver();
        executor.executeScript("arguments[0].click();", element);
    }

    /**
     * Enter the Campaign Name
     * @param logStep the log step
     * @param campaignName the campaignName
     * @throws InterruptedException the interrupted exception
     */
    public static void entercampaignName(String campaignName, String logStep) {
        KeywordUtil.waitForVisible(CampaignObject.CampaignName);
        KeywordUtil.inputText(CampaignObject.CampaignName, campaignName, logStep);
        KeywordUtil.click(CampaignObject.CampaignName, "click on the Campaign name filed");
    }

    /**
     * Enter the ParentCampaignName in Search Box after clicking on the parentCampaignLink present in the parentCampaign column
     * @param logStep the log step
     * @param campaignName the campaignName
     * @throws InterruptedException the interrupted exception
     */
    public static void enterCampaignInParentSearchBox(String campaignName,String logStep){
        KeywordUtil.waitForVisible(CampaignObject.parentLinkSearchCompaign);
        KeywordUtil.inputText(CampaignObject.parentLinkSearchCompaign, campaignName, logStep);
    }
    /**
     * Select parentCampaignName from the dropdown list after entering the ParentCampaign Name
     * @param campaignName the campaignName
     * @throws InterruptedException the interrupted exception
     */
    public static void selectParentCampaign(String campaignName) throws InterruptedException {

        List<WebElement> campaignNames=KeywordUtil.getListElements(CampaignObject.listOfParentCampaignItems,"getting the parent Campaigns list");
        for (WebElement campaign : campaignNames) {
            if (campaign.getText().equalsIgnoreCase(campaignName)) {

                campaign.click();
                break;
            }
        }
    }


    /**
     * Click on Save Button after Select parentCampaignName from the dropdown list after entering the ParentCampaign Name
     * @throws InterruptedException the interrupted exception
     */

    public static void parentClickSaveButton(){
        KeywordUtil.waitForVisible(CampaignObject.parent_compaign_Save_button);
        KeywordUtil.click(CampaignObject.parent_compaign_Save_button,"click on the save button");
    }

    /**
     * Selected the option after Clicking on App launcher Button
     * @param option passign the which option have to select
     * @throws InterruptedException the interrupted exception
     */
    public static void selectOption(String option) {

        KeywordUtil.click(CampaignObject.selectOption(option), "user has succesfully selected the " +option);
        KeywordUtil.takeScreenshotAndAttachInReport();
    }
    /**
     * Selected the ParentCampaign Link button from the second Column using Campaign Name In Camapign Tab
     * @param campaignName passing the campaignName
     * @throws InterruptedException the interrupted exception
     */

    public static void clickParentClick(String campaignName) throws InterruptedException {
        KeywordUtil.delay(3000);
        KeywordUtil.waitForVisible(CampaignObject.clickParentLink(campaignName));
        WebElement element = KeywordUtil.getDriver().findElement(CampaignObject.clickParentLink(campaignName));
        JavascriptExecutor executor = (JavascriptExecutor) KeywordUtil.getDriver();
        executor.executeScript("arguments[0].click();", element);
    }

    /**
     * Clicked on the Save Button
     * @param logStep log the steps
     * @throws InterruptedException the interrupted exception
     */
    public static void clickSaveButton(String logStep) throws InterruptedException {
        KeywordUtil.delay(3000);
        KeywordUtil.waitForVisible(CampaignObject.SaveButton);
        WebElement element = KeywordUtil.getDriver().findElement(CampaignObject.SaveButton);
        JavascriptExecutor executor = (JavascriptExecutor) KeywordUtil.getDriver();
        executor.executeScript("arguments[0].click();", element);
    }

    /**
     * Created a New Campaign By clicking on the new Button , entering the CampaignName in the SearchBox and clicking on the save button
     * @param campaignName passing the campaignName
     * @throws InterruptedException the interrupted exception
     */
    public static void createCampaign(String campaignName) throws InterruptedException {
        AccountUtil.clickNewButton("user has clicked on the new button");
        entercampaignName(campaignName, "user has succesffully entered the " + campaignName);
        clickSaveButton("user has successfully click on the  save button");
       clickSaveButton("user has successfully click on the  save button");
    }
    /**
     * Clicking on the NewContactButton in after creating the new Campaign
     */

    public static void clickNewContact() {
        KeywordUtil.waitForVisible(CampaignObject.newContactButton);
        KeywordUtil.click(CampaignObject.newContactButton, "click on the new contact button");
    }

    /**
     * Adding the parentCampaign by clicking on the paerntCampaignlink , enter the parentcampaign in the search box
      and selecting the parent Campaign
     * @param campaignName for passing the campaignName
     * @param  parentCompaign for passign the parentCampaign
     * @throws InterruptedException the interrupted exception
     */

    public static void addParentCampaign(String campaignName,String parentCompaign) throws InterruptedException {
        clickParentClick(campaignName);
        enterCampaignInParentSearchBox(parentCompaign,"entered the " +campaignName+ " in the search box");
        selectParentCampaign(parentCompaign);
        parentClickSaveButton();

    }
    /**
     * Clicking on the Save button while editing the Contact
     * @throws InterruptedException the interrupted exception
     */

    public static void clickEditContactSaveButton() throws InterruptedException {
        KeywordUtil.delay(3000);
        KeywordUtil.waitForVisible(CampaignObject.saveEditContactButton);
        WebElement element = KeywordUtil.getDriver().findElement(CampaignObject.saveEditContactButton);
        JavascriptExecutor executor = (JavascriptExecutor) KeywordUtil.getDriver();
        executor.executeScript("arguments[0].click();", element);
    }

    /**
     * Setting the Salutation in the Contact
     * @param salutation selecting the salutation
     * @param logStep log the step
     *  @throws InterruptedException the interrupted exception
     */
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

    /**
     * entering the name in the last name field
     * @param name Entering the name in the last contact field
     * @param logStep log the step
     *  @throws InterruptedException the interrupted exception
     */
    public static void enterLastContactName(String name, String logStep) {
        KeywordUtil.waitForVisible(CampaignObject.lastName);
        KeywordUtil.inputText(CampaignObject.lastName, name, logStep);
    }

    /**
     * entering the email in the email field
     * @param email Entering the name in the last contact field
     * @param logStep log the step
     *  @throws InterruptedException the interrupted exception
     */
    public static void enterEmail(String email, String logStep) {
        KeywordUtil.waitForVisible(CampaignObject.contactEmailAddress);
        if (email.contains("@") && email.contains(".")) {
            KeywordUtil.inputText(CampaignObject.contactEmailAddress, email, logStep);
        } else {
            Assert.fail("invalid email format");
        }
    }
    /**
     * entering the Contact no in the phone contact field
     * @param phone Entering the name in the last contact field
     * @param logStep log the step
     *  @throws InterruptedException the interrupted exception
     */
    public static void enterPhoneContact(String phone, String logStep) {
        KeywordUtil.waitForVisible(CampaignObject.contactEnterTelephone);
        KeywordUtil.inputText(CampaignObject.contactEnterTelephone, phone, logStep);
    }

    /**
     * Clicking on the Show Actions for opening the dropdown for edit and delete the campaign name
     * @param campaignName Entering the campaignName
     * @param logstep log the step
     *  @throws InterruptedException the interrupted exception
     */
    public static void clickOnShowActions(String campaignName,String logstep) throws InterruptedException {
        KeywordUtil.delay(3000);
        KeywordUtil.waitForVisible(CampaignObject.showActions(campaignName));
        WebElement element = KeywordUtil.getDriver().findElement(CampaignObject.showActions(campaignName));
        JavascriptExecutor executor = (JavascriptExecutor) KeywordUtil.getDriver();
        executor.executeScript("arguments[0].click();", element);
    }

    /**
     * Clicking on the Edit buttons for editing the Campaign after clicking on the show Actions dropdown button
     *  @throws InterruptedException the interrupted exception
     */
    public static void clickOnShowActionsEditButton() throws InterruptedException {
        KeywordUtil.delay(3000);
        KeywordUtil.waitForVisible(CampaignObject.ShowActionsEditButton);
        WebElement element = KeywordUtil.getDriver().findElement(CampaignObject.ShowActionsEditButton);
        JavascriptExecutor executor = (JavascriptExecutor) KeywordUtil.getDriver();
        executor.executeScript("arguments[0].click();", element);
    }


    /**
     * Clicking on the Edit buttons for editing the contact  after clicking on the show Actions dropdown butotn
     *  @throws InterruptedException the interrupted exception
     */
    public static void clickOnContactShowActionsEditButton() throws InterruptedException {
        KeywordUtil.delay(3000);
        KeywordUtil.waitForVisible(CampaignObject.EditContactsShowActions);
        WebElement element = KeywordUtil.getDriver().findElement(CampaignObject.EditContactsShowActions);
        JavascriptExecutor executor = (JavascriptExecutor) KeywordUtil.getDriver();
        executor.executeScript("arguments[0].click();", element);
    }

    /**
     * Clicking on the Delete buttons after clicking on the show Actions dropdown button
     *  @throws InterruptedException the interrupted exception
     */
    public static void clickOnShowActionsDeleteButton() throws InterruptedException {
        KeywordUtil.waitForVisible(CampaignObject.ShowActionsDeletebutton);
        KeywordUtil.click(CampaignObject.ShowActionsDeletebutton,"click on the Delete button");

    }

    /**
     * Clicking on the Delete buttons for delete the campaign After clicking on the Delete button in the Show Actions dropdown
     *  @throws InterruptedException the interrupted exception
     */

    public static void clickOnCampaignDelete(){
        KeywordUtil.waitForVisible(CampaignObject.campaignDeletebutton);
        KeywordUtil.click(CampaignObject.campaignDeletebutton,"click on the delete button");
    }
    /**
     * Addign the contact in Campaign By entering the salutation, lastname, email, and phone number
     * @param salutation for selecting the salutation
     * @param lastname for entering the lastname in the lastname field
     * @param email for entering the email in the email field
     * @param phoneNumber for entering the phone number in the field
     *  @throws InterruptedException the interrupted exception
     */

    public static void addContactInCampaign(String salutation, String lastname, String email, String phoneNumber) throws InterruptedException {
        clickNewContact();
        setSalutation(salutation, salutation + "Set Salutation");
        enterLastContactName(lastname, lastname + " lastname set");
        enterEmail(email, email + " email entered");
        enterPhoneContact(phoneNumber, phoneNumber + " phone number entered");
        clickSaveButton("save button clicked");
    }

    /**
     * edit the campaign name by clicking on the show Actions dropdown menu, click on the edit button from the dropdown and then entering the campaignName and save the campaignName
     * @param campaignName for selecting the showAction buttons using the campaignName
     * @param editcampaignName for entering the newCampignName
     *  @throws InterruptedException the interrupted exception
     */
    public static void editCampaignName(String campaignName,String editcampaignName) throws InterruptedException {
        clickOnShowActions(campaignName,"user successfully click on the show Actions buttons");
        clickOnShowActionsEditButton();
        entercampaignName(editcampaignName,"enter the Campaign name");
        clickSaveButton("user has successfully click on the  save button");
        clickSaveButton("user has successfully click on the  save button");

    }

    /**
     * delete the campaign name by clicking on the show Actions dropdown menu, Select the delete button from the dropdown and click on the delete button,
     * @param campaignName for selecting the showAction buttons using the campaignName
     *  @throws InterruptedException the interrupted exception
     */
    public static void deleteCampaign(String campaignName) throws InterruptedException {
        clickOnShowActions(campaignName,"user successfully click on the show Actions buttons");
       clickOnShowActionsDeleteButton();
       clickOnCampaignDelete();
    }
    /**
     *retriving the text from all alert that we are getting after creating, editing, and deletign the Campaign and Contact
     */
    public static void verificationMessage() {
        String gettext = KeywordUtil.getElementText(CampaignObject.successMessage);
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("user has got the message  : " + gettext));

    }

    /**
     * click on  the campaign name from the CampaignName Column  in the CampaignTab,
     * @param campaignName for campaignName
     *  @throws InterruptedException the interrupted exception
     */
    public static void clickCampaignName( String campaignName){
        KeywordUtil.waitForVisible(CampaignObject.clickCampaign(campaignName));
        KeywordUtil.click(CampaignObject.clickCampaign(campaignName),"click on the " +campaignName);
    }
    /**
     * Add the leads in the Campaign by scrolling to the Campaign Member and click on the Addleads button
     *  @throws InterruptedException the interrupted exception
     */

    public static void clickAddLeads() throws InterruptedException {
        KeywordUtil.delay(3000);
        KeywordUtil.scrollingToElementofAPage(CampaignObject.campaignMember,"scroll to the campaign member");
        KeywordUtil.delay(5000);
        KeywordUtil.click(CampaignObject.addLeadsButton,"click on the add leads button");

    }

    /**
     * click on the next button after selecting the leads
     *  @throws InterruptedException the interrupted exception
     */
    public static void clickNextButton(){
        KeywordUtil.waitForVisible(CampaignObject.leadsNextButton);
        KeywordUtil.click(CampaignObject.leadsNextButton,"click on the next  button");
    }
    /**
     * click on the submit button after clicking the next button and selecting the leads
     *  @throws InterruptedException the interrupted exception
     */

    public static void clickSubmitButton(){
        KeywordUtil.waitForVisible(CampaignObject.leadsSubmitButton);
        KeywordUtil.click(CampaignObject.leadsSubmitButton,"click on the submit button");
    }

    /**
     * Selecting the lead from the dropdown after entering the leadname
     * @param leadName
     * @throws InterruptedException
     */
    public static void selectLead(String leadName) throws InterruptedException {
        KeywordUtil.delay(5000);
        KeywordUtil.inputText(CampaignObject.searchLeads,leadName,"enter the leadName in the search box");
        KeywordUtil.delay(6000);
        List<WebElement> LeadNames=KeywordUtil.getListElements(CampaignObject.listOfParentCampaignItems,"getting the Lead members list");
        for (WebElement Lead : LeadNames) {

            if (Lead.getText().contains(leadName)) {
                Thread.sleep(8000);
                Lead.click();
                break;
            }
        }

    }

    /**
     * retrieve the successfull lead creation alert message
     */
    public static void leadVerificationMessage(){
        String gettext = KeywordUtil.getElementText(CampaignObject.successLeadMessage);
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("user has got the message  : " + gettext));
    }

    /**
     * adding the leads in Campaign by clicking on the Add leads button, selected the lead name,click on the next button,  click on the submit button and then getting the lead verification message,
     * @param leadName for entering the leadname
     * @throws InterruptedException
     */
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

    /**
     * click on the Contact Tab
     * @throws InterruptedException
     */
    public static void clickContactTab() throws InterruptedException {
        KeywordUtil.delay(3000);
        KeywordUtil.waitForVisible(CampaignObject.contactTab);
        WebElement element = KeywordUtil.getDriver().findElement(CampaignObject.contactTab);
        JavascriptExecutor executor = (JavascriptExecutor) KeywordUtil.getDriver();
        executor.executeScript("arguments[0].click();", element);
    }

    /**
     * click on the show filter in contact tab
     */
    public static void clickShowFilter(){
        KeywordUtil.waitForClickable(CampaignObject.showFiltersInContacts);
        KeywordUtil.click(CampaignObject.showFiltersInContacts,"click on show filters");

    }

    /**
     * click on the Add filter button
     */
    public static void clickAddFilter(){
        KeywordUtil.waitForClickable(CampaignObject.addFiltersInContacts);
        KeywordUtil.click(CampaignObject.addFiltersInContacts,"click on Add filters");

    }

    /**
     * clicking on the field filter button for selecting different fields
     */
    public static void clickFieldFilter(){
        KeywordUtil.waitForClickable(CampaignObject.clickFieldFilter);
        KeywordUtil.click(CampaignObject.clickFieldFilter,"click on Field filters dropdown");
    }

    /**
     * entering the matching value in the field
     * @param matchingValue
     */
    public static void enterValue(String matchingValue){
        KeywordUtil.inputText(CampaignObject.enter_value,matchingValue,"enter the value in filed");

    }

    /**
     * click on the Done button after selecting the field and entering the matching value
     */
    public static void clickDoneButton(){
        KeywordUtil.waitForClickable(CampaignObject.doneButton);
        KeywordUtil.click(CampaignObject.doneButton,"click on done button");
    }

    /**
     * click on the Save filter button
     * @throws InterruptedException
     */
    public static void saveFilter() throws InterruptedException {
        KeywordUtil.delay(3000);
        KeywordUtil.waitForVisible(CampaignObject.saveFilterButton);
        WebElement element = KeywordUtil.getDriver().findElement(CampaignObject.saveFilterButton);
        JavascriptExecutor executor = (JavascriptExecutor) KeywordUtil.getDriver();
        executor.executeScript("arguments[0].click();", element);
    }

    /**
     * select the  name filter in field option in the Add filter
     * @param filedName
     * @throws InterruptedException
     */
    public static void selectNameFilter(String filedName) throws InterruptedException {
        List<WebElement> getAllelements=KeywordUtil.getListElements(CampaignObject.allDropdownElementsInFieldFilter,"");
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

    /**
     * click on the close button for closing the filter window
     * @throws InterruptedException
     */
    public static void clickCloseFilter() throws InterruptedException {
        KeywordUtil.delay(3000);
        KeywordUtil.waitForVisible(CampaignObject.closeFilterButton);
        WebElement element = KeywordUtil.getDriver().findElement(CampaignObject.closeFilterButton);
        JavascriptExecutor executor = (JavascriptExecutor) KeywordUtil.getDriver();
        executor.executeScript("arguments[0].click();", element);
    }

    /**
     * click on the showAction dropwdown in Contacts Tab
     * @param  contactName  for passign the contact name
     * @throws InterruptedException
     */
    public static void clickShowActionsInContacs(String contactName) throws InterruptedException {
        KeywordUtil.delay(3000);
        KeywordUtil.waitForVisible(CampaignObject.clickShowActionsInContacts(contactName));
        WebElement element = KeywordUtil.getDriver().findElement(CampaignObject.clickShowActionsInContacts(contactName));
        JavascriptExecutor executor = (JavascriptExecutor) KeywordUtil.getDriver();
        executor.executeScript("arguments[0].click();", element);
    }

    /**
     * Delete the contact using the delete button present in the dropdown after clicking on the Show Actions dropdown
     * @param contactName for passing the contactname
     * @throws InterruptedException
     */
    public static void clickDeleteShowActionsInContacts(String contactName) throws InterruptedException {
        KeywordUtil.delay(3000);
        KeywordUtil.waitForVisible(CampaignObject.DeleteShowActionInContacts(contactName));
        WebElement element = KeywordUtil.getDriver().findElement(CampaignObject.DeleteShowActionInContacts(contactName));
        JavascriptExecutor executor = (JavascriptExecutor) KeywordUtil.getDriver();
        executor.executeScript("arguments[0].click();", element);
    }

    /**
     * click on the removeall button
     * @throws InterruptedException
     */
  public static void clickRemoveAllButton() throws InterruptedException {
      KeywordUtil.delay(3000);
      KeywordUtil.waitForVisible(CampaignObject.removeFiltersInContacts);
      WebElement element = KeywordUtil.getDriver().findElement(CampaignObject.removeFiltersInContacts);
      JavascriptExecutor executor = (JavascriptExecutor) KeywordUtil.getDriver();
      executor.executeScript("arguments[0].click();", element);
  }

    /**
     * click on the new button in Contact tab for creating the newcontact
     * @throws InterruptedException
     */
  public static void clickNewButtonInContactTab() throws InterruptedException {
      KeywordUtil.delay(3000);
      KeywordUtil.waitForVisible(CampaignObject.newButtonInContactTab);
      WebElement element = KeywordUtil.getDriver().findElement(CampaignObject.newButtonInContactTab);
      JavascriptExecutor executor = (JavascriptExecutor) KeywordUtil.getDriver();
      executor.executeScript("arguments[0].click();", element);
  }

    /**
     * selecting the filter in contacts
     * @param fieldname passing the field name
     * @param matchingValue passing the matching value
     * @throws InterruptedException
     */

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

    /**
     * edit the contact using edit button present in the showAction dropdown menu
     * @param email passing the new email
     * @param contact passing the contactName
     * @throws InterruptedException
     */
    public static void editContact(String email,String contact) throws InterruptedException {
        clickShowActionsInContacs(contact);
        clickOnContactShowActionsEditButton();
        enterEmail(email, " email entered");
        KeywordUtil.delay(8000);
        clickEditContactSaveButton();
    }

    /**
     * Delete the contact
     * @param contact passing the contact name
     * @throws InterruptedException
     */
    public static void deleteContact(String contact) throws InterruptedException {
      clickDeleteShowActionsInContacts(contact);
      clickOnShowActionsDeleteButton();
        clickOnCampaignDelete();

    }

    /**
     * remove the filter that we applied
     * @throws InterruptedException
     */
    public static void removeFilter() throws InterruptedException {
        clickShowFilter();
        clickRemoveAllButton();
        saveFilter();
       clickCloseFilter();

    }

    /**
     * create new contact in contact tab By clicking on the new button present on the contact tab and entering the lastname and email
     * @param lastname passing the lastName
     * @param email psssing the email
     * @throws InterruptedException
     */
    public static void createContactInContactTab( String lastname, String email ) throws InterruptedException {
        clickNewButtonInContactTab();
        enterLastContactName(lastname, lastname + " lastname set");
        enterEmail(email, email + " email entered");
        clickEditContactSaveButton();
    }

    /**
     * create the new opportunity in contact tab
     * @param name passing the opportunity name
     * @param amount passing the amount name
     * @param stage passing the stage
     * @throws InterruptedException
     */
    public static void createOpportunityInContact(String name, String amount, String stage) throws InterruptedException {
        OppurtunitiesUtil.NewButtonOppurtunity("clicked new button for Opportunity");
        OppurtunitiesUtil.enterOppurtunityName(name, name+" entered in Opportunity");
        OppurtunitiesUtil.enterCloseDate(2024,1,2,"Close date entered");
        OppurtunitiesUtil.enterAmount(amount, "Amount entered "+amount);
        OppurtunitiesUtil.setStage(stage, "Stage selected - "+stage);
        OppurtunitiesUtil.clickSaveButton("saved");

    }

    /**
     * click on the view All button in the opportunities section
     * @throws InterruptedException
     */

    public static void clickViewAllButton() throws InterruptedException {
        KeywordUtil.delay(3000);
        KeywordUtil.waitForVisible(CampaignObject.viewAll);
        WebElement element = KeywordUtil.getDriver().findElement(CampaignObject.viewAll);
        JavascriptExecutor executor = (JavascriptExecutor) KeywordUtil.getDriver();
        executor.executeScript("arguments[0].click();", element);
    }

    /**
     * getting all the opportunities in the opportunity name column
     */
    public static void getAllOpportunitiesName(){
        List<WebElement> AllOpportunities=KeywordUtil.getListElements(CampaignObject.getOpportunitiesName,"getting all opportunities name");
        for(WebElement opportunity: AllOpportunities){
            String input = opportunity.getText();
            String[] parts = input.split(" ");
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.infoStringGreenColor("the opportunities is : " +parts[1]));

        }
    }

    /**
     * getting all the stages in the stage column
     */
    public static void getAllStages(){
        List<WebElement> allStages=KeywordUtil.getListElements(CampaignObject.getAllStages,"getting all Stages  name");
        for(WebElement stage: allStages){
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.infoStringGreenColor("the stage is : " +stage.getText()));
        }
    }

    /**
     * getting all the amount in the Amount column
     */
    public static void getAllAmount(){
        List<WebElement> allAmount=KeywordUtil.getListElements(CampaignObject.getAllAmount,"getting all Amount name");
        for(WebElement Amount:allAmount){
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.infoStringGreenColor("the Amount is : " +Amount.getText()));
        }
    }

    /**
     * getting all the closed date in closed date column
     */
    public static void getClosedDate(){
        List<WebElement> ClosedDate=KeywordUtil.getListElements(CampaignObject.getCloseDate,"getting the closed date");
        for(WebElement Date:ClosedDate){
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.infoStringGreenColor("the Closed date  is : " +Date.getText()));
        }
    }

    /**
     * see all the opportunity in contact and getting the opportunity name, stage ,amount and clsoed date
     * @throws InterruptedException
     */
    public static void seeOpportunityInContact() throws InterruptedException {
        clickViewAllButton();
        getAllOpportunitiesName();
        getAllStages();
        getAllAmount();
        getClosedDate();
    }

    /**
     * click on the Add to campaign button after scrolling to the campaign History
     */
    public static void clickAddToCampaignButton(){
        try{
            KeywordUtil.waitForVisible(CampaignObject.addToCampaign);
            KeywordUtil.click(CampaignObject.addToCampaign,"click on the Add to Campaign button ");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * entering the campaign name in the search box
     */

    public static void enterCampaignNameInSearchBox(String campaignName){
        KeywordUtil.inputText(CampaignObject.enterCampaignName,campaignName,"entering the campaign name");
    }

    /**
     * select the campaign from the dropdown after entering the campaignname in the seachbox
     */
    public static void selectCampaign(String campaignName) throws InterruptedException {

        List<WebElement> camapignName=KeywordUtil.getListElements(CampaignObject.listOfParentCampaignItems,"getting the Campaign list");
        for (WebElement campaign : camapignName) {
            if (campaign.getText().equals(campaignName)) {
                campaign.click();
                break;
            }
        }

    }
    /**
     * clicking on the save button after selecting the campign name anad click on the next button
     */
    public static void clickSaveButtonForContactToCampaign(){
        try {
            KeywordUtil.delay(3000);
            KeywordUtil.waitForVisible(CampaignObject.saveButtonAfterSelectingCampaign);
            WebElement element = KeywordUtil.getDriver().findElement(CampaignObject.saveButtonAfterSelectingCampaign);
            JavascriptExecutor executor = (JavascriptExecutor) KeywordUtil.getDriver();
            executor.executeScript("arguments[0].click();", element);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * selecting the status in the new campaign member page
     */

    public static void selectStatus(){
        KeywordUtil.click(CampaignObject.statusPopUp,"click on the status pop up");
        KeywordUtil.click(CampaignObject.respondedStatus,"selected the responded status");
    }
    /**
     * Adding the contact to campaign after creating the new contact
     */
    public static void addContactToCampaign(String campaignName){
        try {
            KeywordUtil.scrollingToElementofAPage(CampaignObject.campaignHistory, "scrolling to the Campaign member");
            clickAddToCampaignButton();
            enterCampaignNameInSearchBox(campaignName);
            selectCampaign(campaignName);
            clickNextButton();
            selectStatus();
            clickSaveButtonForContactToCampaign();
            verificationMessage();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }




    /**
     * Click on the view all button in the campaign history
     */
    public static void clickViewAllInCampaignHistory() {
        try {
            KeywordUtil.scrollingToElementofAPage(CampaignObject.campaignHistoryViewAllButton, "scroll to the view All in the campaign History");
            KeywordUtil.click(CampaignObject.campaignHistoryViewAllButton,"click on the view All button in the campaign History Button");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * getting all the campaign names in campaign history
     */
    public static void getAllCampaignNameInCampaignHistory(){
        List<WebElement> AllCamapigns=KeywordUtil.getListElements(CampaignObject.campaignNameInCampaignHistory,"getting all campaign  name in campaign history");
        for(WebElement campaign: AllCamapigns){
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.infoStringGreenColor("the campaign Name is : " +campaign.getText()));

        }
    }

    /**
     * getting all the status in campaign history
     */
    public static void getStatusInCampaignHistory(){
        List<WebElement> Allstatus=KeywordUtil.getListElements(CampaignObject.statusInCampaignHistory,"getting status in campaign history");
        for(WebElement status: Allstatus){
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.infoStringGreenColor("the status Name is : " +status.getText()));

        }
    }

    /**
     * getting memeber status in campaign history
     */
    public static void getMemberstatusInCampaignHistory(){
        List<WebElement> Allmemberstatus=KeywordUtil.getListElements(CampaignObject.memberStatusInCampaignHistory,"getting status in campaign history");
        for(WebElement memberstatus: Allmemberstatus){
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.infoStringGreenColor("the member status Name is : " +memberstatus.getText()));

        }
    }
    /**
     * see the campaign history
     */
    public static void seeCampaignHistory(){
        clickViewAllInCampaignHistory();
        getAllCampaignNameInCampaignHistory();
        getStatusInCampaignHistory();
        getMemberstatusInCampaignHistory();
    }


    /**
     * click on the new button to create new case in contact
     */
    public static void clickNewCaseButton() throws InterruptedException {
        try {
            KeywordUtil.delay(3000);
            KeywordUtil.waitForVisible(CampaignObject.newCaseButton);
            WebElement element = KeywordUtil.getDriver().findElement(CampaignObject.newCaseButton);
            JavascriptExecutor executor = (JavascriptExecutor) KeywordUtil.getDriver();
            executor.executeScript("arguments[0].click();", element);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Select status In Case
     */
    public static void selectStatusInCase(){
        KeywordUtil.click(CampaignObject.statusButtonInCase,"click on the status dropdown");
        KeywordUtil.click(CampaignObject.selectStatusInCase("Working"),"click on the working status");
    }

    /***
     * click on the case origin in case
     */

    public static void clickCaseOriginInCase(){
        KeywordUtil.click(CampaignObject.caseOriginInCase,"click on the case origin dropdown");
    }

    /**
     * Select Case origin
     */

    public static void selectCaseOrigin() {
        try {
            KeywordUtil.delay(3000);
            KeywordUtil.waitForVisible(CampaignObject.selectCaseOrigin("Web"));
            WebElement element = KeywordUtil.getDriver().findElement(CampaignObject.selectCaseOrigin("Web"));
            JavascriptExecutor executor = (JavascriptExecutor) KeywordUtil.getDriver();
            executor.executeScript("arguments[0].click();", element);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    /**
     * clicking on the save button in Case
     */
    public static void clickSaveButtonInCase(){
        KeywordUtil.click(CampaignObject.saveButtonInCase,"click on the save button");
    }
    /**
     * Adding the case in the contact
     */
    public static void addCaseInContact() throws InterruptedException {
        clickNewCaseButton();
        selectStatusInCase();
        clickCaseOriginInCase();
        selectCaseOrigin();
        clickSaveButtonInCase();
    }

    /**
     * click view All Button in Cases to see the case History
     */
    public static void clickCaseViewAllButton(){
    try {
        KeywordUtil.delay(3000);
        KeywordUtil.waitForVisible(CampaignObject.casesViewAllButton);
        WebElement element = KeywordUtil.getDriver().findElement(CampaignObject.casesViewAllButton);
        JavascriptExecutor executor = (JavascriptExecutor) KeywordUtil.getDriver();
        executor.executeScript("arguments[0].click();", element);
    }catch (Exception e){
        System.out.println(e.getMessage());
    }
}

    /**
     * get the cases Name in the case history
     */
    public static void getCasesName(){
        List<WebElement> allCases = KeywordUtil.getListElements(CampaignObject.casesNameInCaseHistory, "Getting case name in case history");
        for (WebElement currentCase : allCases) {
            try {
                String caseName = currentCase.getText();
                String[] parts = caseName.split(" ");
                RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.infoStringGreenColor("The case name is: " + parts[1]));
            } catch (Exception e) {
                RunCukesTest.logger.log(LogStatus.FAIL, "Failed to retrieve case name due to: " + e.getMessage());
            }
        }

    }

    /**
     * getting priorities in case History
     */
    public static void getPriorityInCaseHistory(){
        List<WebElement> allPriority = KeywordUtil.getListElements(CampaignObject.priorityInCaseHistory, "Getting  priority in case history");
        for (WebElement priority : allPriority) {
            try {
                String prioritytext = priority.getText();
                RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.infoStringGreenColor("The priority name is: " + prioritytext));
            } catch (Exception e) {
                RunCukesTest.logger.log(LogStatus.FAIL, "Failed to retrieve case name due to: " + e.getMessage());
            }
        }

    }

    /**
     * getting the Status present in the case history
     */
    public static void getStatusInCaseHistory(){
        List<WebElement> allStatus = KeywordUtil.getListElements(CampaignObject.statusInCaseHistory, "Getting  status in case history");
        for (WebElement status : allStatus) {
            try {
                String statustext = status.getText();
                RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.infoStringGreenColor("The status is: " + statustext));
            } catch (Exception e) {
                RunCukesTest.logger.log(LogStatus.FAIL, "Failed to retrieve case name due to: " + e.getMessage());
            }
        }

    }

    /**
     * getting the dates present in the case History
     */
    public static void getDateInCaseHistory(){
        List<WebElement> datesOpened = KeywordUtil.getListElements(CampaignObject.dateOpenedInCaseHistory, "Getting date in case history");
        for (WebElement date : datesOpened){
            try {
                String datetext = date.getText();
                RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.infoStringGreenColor("The  date is: " + datetext));
            } catch (Exception e) {
                RunCukesTest.logger.log(LogStatus.FAIL, "Failed to retrieve case name due to: " + e.getMessage());
            }
        }

    }

    /**
     * to see the case History
     */
    public static void seeCaseHistory(){
        clickCaseViewAllButton();
        getCasesName();
        getPriorityInCaseHistory();
        getDateInCaseHistory();
        getStatusInCaseHistory();

    }

    /**
     * click on the leads Tab
     */
    public static void clickLeadsTab(){
        try {
            KeywordUtil.delay(3000);
            KeywordUtil.waitForVisible(CampaignObject.leadsTab);
            WebElement element = KeywordUtil.getDriver().findElement(CampaignObject.leadsTab);
            JavascriptExecutor executor = (JavascriptExecutor) KeywordUtil.getDriver();
            executor.executeScript("arguments[0].click();", element);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * enter last name and city name in the leads field
     * @param lastName enter the last name
     * @param cityName enter the city
     */
    public static void enterLastNameandCityNameInLeads(String lastName,String cityName){
        KeywordUtil.inputText(LeadsPage.lastName,lastName,"Enter Last Name");
        KeywordUtil.inputText(LeadsPage.companyName,cityName,"Entered City Name");
    }

    /**
     * create the lead
     * @param lastname enter the last name
     * @param cityName  enter the city
     * @throws InterruptedException
     */
    public static void createLead(String lastname, String cityName) throws InterruptedException {
        Leads.clickNewButton();
        enterLastNameandCityNameInLeads(lastname,cityName);
        Leads.clickOnSaveButton();
        verificationMessage();

    }

    /**
     * click on show Actions button in leads tab for editing the lead
     * @param contactName enter the lead name
     * @throws InterruptedException
     */
    public static void clickShowActionsInLeads(String contactName) throws InterruptedException {
        KeywordUtil.delay(3000);
        KeywordUtil.waitForVisible(CampaignObject.clickShowActionsInLeads(contactName));
        WebElement element = KeywordUtil.getDriver().findElement(CampaignObject.clickShowActionsInLeads(contactName));
        JavascriptExecutor executor = (JavascriptExecutor) KeywordUtil.getDriver();
        executor.executeScript("arguments[0].click();", element);
    }

    /**
     * edit the lead
     * @param leadName
     * @param lastName
     * @param city
     * @throws InterruptedException
     */
    public static void editLead(String leadName,String lastName, String city) throws InterruptedException {
      clickShowActionsInLeads(leadName);
        clickOnShowActionsEditButton();
      enterLastNameandCityNameInLeads(lastName,city);
      Leads.clickOnSaveButton();
      verificationMessage();
    }

    /**
     * click on Delete button in show Actions for delete the lead
     * @throws InterruptedException
     */
    public static void clickDeleteButtonInShowActionForLeads() throws InterruptedException {
        KeywordUtil.delay(3000);
        KeywordUtil.waitForVisible(CampaignObject.leadsShowActionsDeleteButton);
        WebElement element = KeywordUtil.getDriver().findElement(CampaignObject.leadsShowActionsDeleteButton);
        JavascriptExecutor executor = (JavascriptExecutor) KeywordUtil.getDriver();
        executor.executeScript("arguments[0].click();", element);
    }

    /**
     * click on the show Actions for delete the lead
     * @param leadName enter the lead name
     * @throws InterruptedException
     */
    public static void clickShowActionsInLeadsForDelete(String leadName) throws InterruptedException {
        KeywordUtil.delay(3000);
        KeywordUtil.waitForVisible(CampaignObject.deleteShowActionInLeads(leadName));
        WebElement element = KeywordUtil.getDriver().findElement(CampaignObject.deleteShowActionInLeads(leadName));
        JavascriptExecutor executor = (JavascriptExecutor) KeywordUtil.getDriver();
        executor.executeScript("arguments[0].click();", element);
    }

    /**
     * delete the lead
     * @param leadName enter the leadName
     * @throws InterruptedException
     */
    public static void deleteLead(String leadName) throws InterruptedException {
        clickShowActionsInLeadsForDelete(leadName);
        clickDeleteButtonInShowActionForLeads();
        clickOnCampaignDelete();
        verificationMessage();

    }

}

