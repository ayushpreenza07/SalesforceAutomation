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

    public static By selectParentCompaign=By.xpath("//span[normalize-space()='Festival']");

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


    public static By listOfParentComapign=By.xpath("//li[@role='presentation']");



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


}
