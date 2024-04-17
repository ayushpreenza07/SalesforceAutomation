package pageobjects.SalesforceObjects;

import org.openqa.selenium.By;

public class ServiceSupportObject {

    //Edit xpaths
    public static By clickServiceSupportButton = By.xpath("//p[@class='slds-truncate'][text()='Service']");
    public static By editButton = By.xpath ("//button[@class='slds-button slds-button_neutral' and @name='Edit']");
    public static By  phoneNumberUpdate= By.xpath ("//input[@class='slds-input' and @name='Phone']");
    public static By saveButton = By.xpath("//BUTTON[@class='slds-button slds-button_brand'][text()='Save']");

    //Delete xpaths
    public static By dropDown = By.xpath("//th[span[a[text()='TXTest']]]/following-sibling::td//a[@role='button']");
    public static By deleteButton = By.xpath("//a[@data-target-selection-name='sfdc:StandardButton.Account.Delete']");
    public static By clickdeleteButton = By.xpath("//button[@title='Delete']");

    //Contact xpaths
    public static By newContactButton_ss = By.xpath("//button[@class='slds-button slds-button_neutral middleButton actionListButton' and text()='New']");
    public static By dropdown_ss = By.xpath("(//button[@class='slds-button slds-button_icon-border-filled fix-slds-button_icon-border-filled slds-button_last'])[1]");
    public static By editButton_ss =By.xpath("(//a[@role='menuitem' and @aria-disabled='false'])[1]");

    //Delete xpaths for contact
    public static By  dropDown_cnt= By.xpath("//tr[th/lightning-primitive-cell-factory/span/div/lightning-primitive-custom-cell/runtime_pipeline_inspector-name-field/force-lookup/div/a/slot[text()='Anjali']]/td//button[span[text()='Show Actions']]");
    public static By deleteButton_cnt = By.xpath("//a[@title='Delete']");
    public static By clickdeleteButton_cnt = By.xpath("//button//span[text()='Delete']");

    //Filter xpaths for contact
    public static By showFiltersInContacts_ss=By.xpath("//button[@title=\"Show filters\"]");

    public static By addFiltersInContacts_ss=By.xpath("//button[text()=\"Add Filter\"]");
    public static By clickFieldFilter_ss=By.xpath("(//button[@class=\"slds-combobox__input slds-input_faux fix-slds-input_faux slds-combobox__input-value\"])[1]");
    public static By allDropdownElementsInFieldFilter_ss=By.xpath("//span[@class=\"slds-media__body\"]");

    public static By enter_value_ss=By.xpath("//input[@type=\"text\"]");

    public static By doneButton_ss=By.xpath("//span[text()=\"Done\"]");

    public static By saveFilterButton_ss=By.xpath("//button[text()='Save']");
    public static By closeFilterButton_ss=By.xpath("//span[text()='Close Filters']");

    //xpaths for contactTab
    public static By contactTab_ss=By.xpath("//span[@class='slds-truncate'][text()='Contacts']");

    //xpaths for RemoveAll filter

    public static By removeFiltersInContacts_ss=By.xpath("//button[text()=\"Remove All\"]");
}
