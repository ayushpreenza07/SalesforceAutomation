package pageobjects.SalesforceObjects;

import org.openqa.selenium.By;

public class ForecastingPage {

    public static By setupIcon = By.xpath("//lightning-icon[@class='slds-icon-utility-setup slds-button__icon slds-global-header__icon forceIcon slds-icon_container']");
    public static By setupTitle = By.xpath("//span[@title='Setup']");
    public static By setupOption = By.xpath("//*[@class='slds-align-middle'][text()='Setup']");
    public static By setupSearch = By.xpath("//input[@class=\"filter-box input\"]");
    public static By usersPage = By.xpath("//h1[@class='noSecondHeader pageType']");
    public static By loggedInUser = By.xpath("//*[@title=\"Select Jagtap, Sukanya\"]/following-sibling::a[text()=\"Edit\"]");
    public static By allowForecasting = By.xpath("//*[@for=\"forecast_enabled\"][text()=\"Allow Forecasting\"]");
    public static By allowForecastingChecked = By.xpath("//*[@id=\"forecast_enabled\" and @checked=\"checked\"]");
    public static By allowForecastingCheckbox = By.xpath("//*[@name='forecast_enabled']");
    public static By userOption = By.xpath("//li[@aria-level=\"2\"]/child::div[@title=\"Users\"]//a");
    public static By userGeneralInfo = By.xpath("//*[text()=\"General Information\"]");
    public static By closeButton = By.xpath("//*[@name=\"cancel\"]");
    public static By saveButton = By.xpath("//*[@name=\"save\"]");
    public static By sampleRoleHierarchy = By.xpath("//select[@name=\"samples\"]");
    public static By setupRoles = By.xpath("//input[@title=\"Set Up Roles\"]");
    public static By emptyUsersBox = By.xpath("//*[@id=\"duel_select_1\"]/option[text()='--None--']");
    public static By selectUser = By.xpath("//*[@id=\"duel_select_0\"]");
    public static By addUser = By.xpath("//img[@title=\"Add\"]");
    public static By expandAllRoles = By.xpath("//*[text()=\"Expand All\"]");
    public static By forecastsRoleUser = By.xpath("//span[@class=\"roleUser\"]");
    public static By hamburgerMenu=By.xpath("//*[@class=\"slds-icon-waffle\"]");


    public static By searchText= By.xpath("//input[@class='slds-input']");
    public static By ownerNameDropdown= By.xpath("//h1/*[@class=\"slds-icon-utility-down slds-is-absolute downIcon slds-button__icon slds-icon_container forceIcon\"]");
    public static By ownerName= By.xpath("//h1/*[@class=\"triggerLinkText\"]");
    public static By searchForOtherUser = By.xpath("//*[@class=\" default input uiInput uiInputTextForAutocomplete uiInput--default uiInput--input\"]");
    public static By verifyOtherUser = By.xpath("//a[@role='option']/mark");
    public static By activateOption = By.xpath("//a[./span[text()='Activate']]");
    public static By appLauncherIcon = By.xpath("//div[@class='appLauncher slds-context-bar__icon-action']//button");
    public static By searchAppInput = By.xpath("//input[@class='slds-input']");
    public static By forecastAppOption = By.xpath("//a[.//b[text()='Forecasts']]");

    public static By searchSetupOption(String searchValue) {
        return By.xpath("//li[@role='treeitem' and @aria-label='" + searchValue + "'] | //li[@aria-level=\"4\" and @aria-label='" + searchValue + "']");
    }
    public static By userOption(String searchValue) {
        return By.xpath("//li[@role='treeitem']/child::div[@title='" + searchValue + "']//a//mark | //li[@aria-level=\"4\"]/child::div[@title='" + searchValue + "']//a//mark");
    }
    public static By assignOption(String roleValue, String actionValue) {
        return By.xpath("//span//a[text()='" + roleValue + "']/parent::span/following-sibling::span//a[text()='" + actionValue + "']");
    }
    public static By showActionsButton(String forecastName){
        return By.xpath("//tr[.//div[normalize-space()='"+ forecastName +"']]//button[./*[text()='Show actions']]");
    }

    public static By forecastTitle(String forecastName){
        return By.xpath("//li[@title='"+ forecastName +"']");
    }

}
