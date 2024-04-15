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



    public static By searchSetupOption(String searchValue) {
        return By.xpath("//li[@aria-level=\"2\" and @aria-label='" + searchValue + "']");
    }
    public static By userOption(String searchValue) {
        return By.xpath("//li[@aria-level=\"2\"]/child::div[@title='" + searchValue + "']//a//mark");
    }
    public static By assignOption(String roleValue, String actionValue) {
        return By.xpath("//span//a[text()='" + roleValue + "']/parent::span/following-sibling::span//a[text()='" + actionValue + "']");
    }

    public static By QuickFind= By.xpath("//input[@placeholder='Quick Find']");

    public static By Users= By.xpath("//li[@aria-level=\"2\"]/child::div[@title=\"Users\"]//a");
    public static By NewUser= By.xpath("//input[@value='New User']");
    public static By FirstName= By.xpath("//input[@id='name_firstName']");
    public static By LastName= By.xpath("//input[@id='name_lastName']");
    public static By Alias= By.xpath("//input[@id='Alias']");
    public static By Email= By.xpath("//input[@id='Email']");
    public static By Username= By.xpath("//input[@id='Username']");
    public static By Nickname= By.xpath("//input[@id='CommunityNickname']");
    public static By CompanyName= By.xpath("//input[@id='CompanyName']");
    public static By Department= By.xpath("//input[@id='Department']");

    public static By Role= By.id("role");
    public static By UserLicense= By.id("user_license_id");
    public static By Profile= By.id("Profile");

    public static By AllowForecasting= By.id("forecast_enabled");

    public static By SaveButton= By.xpath("//input[@value=' Save ']");




}
