package pageobjects.SalesforceObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CampaignObject {

    public static By CampaignTab = By.xpath("//span[@class='slds-truncate'][text()='Campaigns']");

    public static  By CampaignName= By.xpath("//div[@class=\"actionBody\"]//span[text()='Campaign Name']//parent::label//following-sibling::input");


    public static By SaveButton= By.xpath("(//span[text()=\"Save\"])[2]");


    public static By successMessage= By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']");

    public static By successLeadMessage=By.xpath("//span[@class=\"toastMessage forceActionsText\"]");


    public static By parent_compaign_Save_button=By.xpath("//span[normalize-space()='Save']");

    public static By newContactButton=By.xpath("//div[@title=\"New Contact\"]");

    public static By SalutationButton=By.xpath("//a[normalize-space()='--None--']");

    public static By lastName=By.xpath("//input[@placeholder='Last Name']");

    public static By contactEmailAddress=By.xpath("//input[@inputmode=\"email\"]");

    public static By contactEnterTelephone=By.xpath("//input[@type=\"tel\"]");
    public static By ShowActionsEditButton=By.xpath("//a[@title='Edit']");
    public static By ShowActionsDeletebutton=By.xpath("(//a[@title='Delete'])[2]");

    public static By campaignDeletebutton=By.xpath("//span[text()='Delete']");

    public static By parentLinkSearchCompaign=By.xpath("//input[@placeholder='Search Campaigns...']");

    public static By listOfParentCampaignItems=By.xpath("//li[@role='presentation']//div[@class=\"slds-m-left--smalllabels slds-truncate slds-media__body\"]");

    public static By addLeadsButton=By.xpath("//div[@title='Add Leads']");

    public static By campaignMember=By.xpath("//span[@title='Campaign Members']");

    public static By leadsNextButton=By.xpath("//button[text()=\"Next\"]");
    public static By leadsSubmitButton=By.xpath("//button[text()=\"Submit\"]");
    public static By searchLeads=By.xpath("//input[@title=\"Search Leads\"]");
    public static By viewAll=By.xpath("//a[@class=\"slds-card__footer\"]//span[text()='View All']");
    public static By contactTab=By.xpath("//span[@class='slds-truncate'][text()='Contacts']");

    public static By showFiltersInContacts=By.xpath("//button[@title=\"Show filters\"]");

    public static By addFiltersInContacts=By.xpath("//button[text()=\"Add Filter\"]");
    public static By clickFieldFilter=By.xpath("(//button[@class=\"slds-combobox__input slds-input_faux fix-slds-input_faux slds-combobox__input-value\"])[1]");
    public static By allDropdownElementsInFieldFilter=By.xpath("//span[@class=\"slds-media__body\"]");

    public static By enter_value=By.xpath("//input[@type=\"text\"]");

    public static By doneButton=By.xpath("//span[text()=\"Done\"]");


    public static By saveFilterButton=By.xpath("//button[text()='Save']");
    public static By closeFilterButton=By.xpath("//span[text()='Close Filters']");

    public static By EditContactsShowActions=By.xpath("(//a[@title='Edit'])[2]");
    public static By removeFiltersInContacts=By.xpath("//button[text()=\"Remove All\"]");


    public static By saveEditContactButton=By.xpath("//button[text()=\"Save\"]");

    public static By newButtonInContactTab=By.xpath("(//button[text()=\"New\"])[1]");

    public static By getOpportunitiesName=By.xpath("//table[@role=\"grid\"]//tbody//tr//th[@data-label=\"Opportunity Name\"]");

    public static By getAllStages=By.xpath("//table[@role=\"grid\"]//tbody//tr//td[@data-label=\"Stage\"]");

    public static By getAllAmount=By.xpath("//table[@role=\"grid\"]//tbody//tr//td[@data-label=\"Amount\"]");

    public static By getCloseDate=By.xpath("//table[@role=\"grid\"]//tbody//tr//td[@data-label=\"Close Date\"]");

    public static By campaignHistory=By.xpath("//span[@title=\"Campaign History\"]");

    public static By addToCampaign=By.xpath("//div[@title=\"Add to Campaign\"]");

    public static By enterCampaignName=By.xpath("//input[@title=\"Search Campaigns\"]");

    public static By saveButtonAfterSelectingCampaign=By.xpath("//span[text()='Save']");

    public static By statusPopUp=By.xpath("//div[@class=\"uiPopupTrigger\"]");

    public static By respondedStatus=By.xpath("//a[@title=\"Responded\"]");

    public static By addLeadLink = By.xpath("//a[@title='Add Leads']");

    public static By addLeadToCampaignDialogHeader = By.xpath("//h2[text()='Add Leads to Campaign']");

    public static By searchLeadsInputField = By.xpath("//input[@title='Search Leads']");

    public static By newLeadOption = By.xpath("//span[@title='New Lead']");

    public static By newLeadHeader = By.xpath("//h2[text()='New Lead']");

    public static By leadLastNameInputField = By.xpath("//label[./span[text()='Last Name']]/following-sibling::input");

    public static By leadCompanyNameInputField = By.xpath("//label[./span[text()='Company']]/following-sibling::input");

    public static By saveNewLeadButton = By.xpath("//button[@title='Save']");

    public static By allActiveCampaignsOption = By.xpath("//a[./span[normalize-space()='All Active Campaigns']]");

    public static By selectListViewCampaignsDropDown = By.xpath("//button[@title='Select a List View: Campaigns']");

    public static By searchListInputField = By.xpath("//input[@name='Campaign-search-input']");

    public static By nextButton = By.xpath("//button[text()='Next']");

    public static By submitButton = By.xpath("//button[text()='Submit']");

    public static By leadAddedSuccessMessage = By.className("toastTitle slds-text-heading--small");

    public static By viewAllCampaignMembers = By.xpath("//span[./span[text()='Campaign Members'] and text()='View All']");

    public static By searchButtonField = By.xpath("//button[text()='Search...']");

    public static By searchInputField = By.xpath("//input[@placeholder='Search...']");

    public static By workingContactedField = By.xpath("//a[@title='Working - Contacted']");

    public static By markAsCurrentStatusButton= By.xpath("//button[./span[text()='Mark as Current Status']]");

    public static By closedNotConvertedField = By.xpath("//a[./span[text()='Closed - Not Converted']]");

    public static By convertedField  = By.xpath("//a[./span[text()='Converted']]");

    public static By selectConvertedStatus = By.xpath("//button[./span[text()='Select Converted Status']]");

    public static By convertLeadHeader = By.xpath("//h2[normalize-space()='Convert Lead']");

    public static By convertButton = By.xpath("//button[text()='Convert']");

    public static By yourLeadHasBeenConvertedDialogHeader = By.xpath("//h2[text()='Your lead has been converted']");



    public static By clickCampaign(String campaignName){
        return By.xpath("(//table[@role=\"grid\"]//tr//th[@scope=\"row\" ]//a[text()='"+campaignName+"'])[1]");
    }

    public static By selectOption(String option) {
        return By.xpath("//P[@class='slds-truncate'][text()='" + option + "']");
    }
    public static By clickParentLink(String campaignName){
        return By.xpath("//table[@role=\"grid\"]//tr//th[@scope=\"row\" ]//a[text()='"+campaignName+"']//ancestor::th//following-sibling::td[1]//button[@type='button']");
    }
    public static By showActions(String campaignName){
        return By.xpath("//table[@role=\"grid\"]//tr//th[@scope=\"row\"]//a[text()='"+campaignName+"']//ancestor::th//following-sibling::td[8]//a//span[text()='Show Actions']");
    }

    public static By clickShowActionsInContacts(String name){
        return By.xpath("//table[@role=\"grid\"]//tbody//tr//a[@title='"+name+"']//ancestor::th//following-sibling::td[6]//span[text()='Show Actions']");
    }

    public static By DeleteShowActionInContacts(String name){
        return By.xpath("//table[@role=\"grid\"]//tbody//tr//a[@title='"+name+"']//ancestor::th//following-sibling::td[6]//span[text()='Show more actions']");
    }

    public static By LeadField(String leadName){
        return By.xpath("//a[@aria-labelledby='assistiveTextForPill']//span[text()='"+leadName+"']");
    }

    public static By campaignMember(String memberName){
        return By.xpath("(//th[.//a[@title='Lead']]/following-sibling::td//a[@title='"+ memberName +"'])[1]");
    }

    public static By leadLink(String leadName){
        return By.xpath("//mark[text()='"+ leadName +"']");
    }

    public static By leadPageHeader(String leadName){
        return By.xpath("//lightning-formatted-name[text()='"+ leadName +"']");
    }

}


