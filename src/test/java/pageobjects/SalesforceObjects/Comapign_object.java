package pageobjects.SalesforceObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Comapign_object {

    public static By Comapign_Tab = By.xpath("//span[@class='slds-truncate'][text()='Campaigns']");

    public static  By Comapign_Name= By.xpath("//div[@class=\"actionBody\"]//span[text()='Campaign Name']//parent::label//following-sibling::input");

    //div[@class="actionBody"]//span[text()='Campaign Name']//parent::label//following-sibling::input

    public static By Save_Button= By.xpath("//button[@title=\"Save\"]");


    public static By Table= By.xpath("//table[@role=\"grid\"]");

    public static By parentLink= By.xpath("(//span[text()='Edit Parent Campaign: Item '])[1]");


    public static By success_message= By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']");

    public static By select_parentCompain=By.xpath("//span[normalize-space()='Festival']");

    public static By parent_compaign_Save_button=By.xpath("//span[normalize-space()='Save']");

    public static By new_contact_button=By.xpath("//div[@title=\"New Contact\"]");

    public static By Salutation_Button=By.xpath("//a[normalize-space()='--None--']");

    public static By lastname=By.xpath("//input[@placeholder='Last Name']");

    public static By contact_eamiladdress=By.xpath("//input[@inputmode=\"email\"]");

    public static By contact_enter_Telephone=By.xpath("//input[@type=\"tel\"]");

    public static By Show_Actions=By.xpath("//table[@role=\"grid\"]//tr//th[@scope=\"row\" ]//a[text()='DEF']//ancestor::th//following-sibling::td[8]//a//span[text()='Show Actions']");

    public static By Show_Actions_Edit_Button=By.xpath("//a[@title='Edit']");

    public static By Show_Actions_Delete_button=By.xpath("(//a[@title='Delete'])[2]");

    public static By compaign_Delete_button=By.xpath("//span[text()='Delete']");

    public static By select_option(String option) {
        return By.xpath("//P[@class='slds-truncate'][text()='" + option + "']");
    }


    public static By show_Actions(String campaignName){
        return By.xpath("//table[@role=\"grid\"]//tr//th[@scope=\"row\"]//a[text()='"+campaignName+"']//ancestor::th//following-sibling::td[8]//a//span[text()='Show Actions']");
    }



    public static WebElement select_Tab(String tabname){
        return (WebElement) By.xpath("//span[@class='slds-truncate'][text()='"+tabname+"']");
    }


}
