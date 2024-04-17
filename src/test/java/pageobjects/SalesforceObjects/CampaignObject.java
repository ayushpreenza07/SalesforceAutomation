package pageobjects.SalesforceObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CampaignObject {

    public static By CampaignTab = By.xpath("//span[@class='slds-truncate'][text()='Campaigns']");

    public static  By CampaignName= By.xpath("//div[@class=\"actionBody\"]//span[text()='Campaign Name']//parent::label//following-sibling::input");


    public static By SaveButton= By.xpath("//button[@title=\"Save\"]");


    public static By Table= By.xpath("//table[@role=\"grid\"]");

    public static By parentLink= By.xpath("(//span[text()='Edit Parent Campaign: Item '])[1]");


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
    public static By viewAll=By.xpath("//span[text()=\"View All\"]");
    public static By contactTab=By.xpath("//span[@class='slds-truncate'][text()='Contacts']");
    public static By lsitOfAllContacts=By.xpath("//th[@data-label=\"Name\"]");

    public static By showFiltersInContacts=By.xpath("//button[@title=\"Show filters\"]");

    public static By addFiltersInContacts=By.xpath("//button[text()=\"Add Filter\"]");
    public static By clickFieldFilter=By.xpath("(//button[@class=\"slds-combobox__input slds-input_faux fix-slds-input_faux slds-combobox__input-value\"])[1]");

    public static By allDropdownElements=By.xpath("//span[@class=\"slds-media__body\"]");
    public static By accountNameFilter=By.xpath("//span[text()='Sort by:']//following-sibling::span[text()='Account Name']");
    public static By clickCampaign(String campaignName){
        return By.xpath("//table[@role=\"grid\"]//tr//th[@scope=\"row\" ]//a[text()='"+campaignName+"']");
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
    public static WebElement select_Tab(String tabname){
        return (WebElement) By.xpath("//span[@class='slds-truncate'][text()='"+tabname+"']");
    }
    public static By clickShowActionsInContacts(){
        return By.xpath("//table[@role=\"grid\"]//tbody//tr//a[@title=\"Rose Gonzalez\"]//ancestor::th//following-sibling::td[6]//a//span[text()='Show more actions']");
    }

}
