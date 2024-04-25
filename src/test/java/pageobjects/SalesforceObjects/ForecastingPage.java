package pageobjects.SalesforceObjects;

import org.openqa.selenium.By;

public class ForecastingPage {

    public static By setupIcon = By.xpath("//lightning-icon[@class='slds-icon-utility-setup slds-button__icon slds-global-header__icon forceIcon slds-icon_container']");
    public static By setupTitle = By.xpath("//span[@title='Setup']");
    public static By setupOption = By.xpath("//*[@class='slds-align-middle'][text()='Setup']");
    public static By setupSearch = By.xpath("//input[@class=\"filter-box input\"] | //*[@class=\"uiInput uiInputSearch uiInput--custom\"]/input");
    public static By usersPage = By.xpath("//h1[@class='noSecondHeader pageType']");
    public static By loggedInUser = By.xpath("//*[@title=\"Select Jagtap, Sukanya\"]/following-sibling::a[text()=\"Edit\"]");
    public static By allowForecasting = By.xpath("//*[@for=\"forecast_enabled\"][text()=\"Allow Forecasting\"]");
    public static By allowForecastingChecked = By.xpath("//*[@id=\"forecast_enabled\" and @checked=\"checked\"]");
    public static By allowForecastingCheckbox = By.xpath("//*[@name='forecast_enabled']");
    public static By userOption = By.xpath("//li[@aria-level=\"2\"]/child::div[@title=\"Users\"]//a");
    public static By userGeneralInfo = By.xpath("//*[text()=\"General Information\"]");
    public static By closeButton = By.xpath("//*[@name=\"cancel\"]");
    public static By saveButton = By.xpath("//*[@name=\"save\" or text()=\"Save\"]");
    public static By sampleRoleHierarchy = By.xpath("//select[@name=\"samples\"]");
    public static By setupRoles = By.xpath("//input[@title=\"Set Up Roles\"]");
    public static By emptyUsersBox = By.xpath("//*[@id=\"duel_select_1\"]/option[text()='--None--']");
    public static By selectUser = By.xpath("//*[@id=\"duel_select_0\"]");
    public static By addUser = By.xpath("//img[@title=\"Add\"]");
    public static By expandAllRoles = By.xpath("//*[text()=\"Expand All\"]");
    public static By forecastsRoleUser = By.xpath("//span[@class=\"roleUser\"]");
    public static By ownerNameDropdown = By.xpath("//h1/*[@class=\"slds-icon-utility-down slds-is-absolute downIcon slds-button__icon slds-icon_container forceIcon\"]");
    public static By ownerName = By.xpath("//h1/*[@class=\"triggerLinkText\"]");
    public static By searchForOtherUser = By.xpath("//*[@class=\" default input uiInput uiInputTextForAutocomplete uiInput--default uiInput--input\"]");
    public static By verifyOtherUser = By.xpath("//a[@role='option']/mark");
    public static By createForcastTypeButton = By.xpath("//button[text()=\"Create a Forecast Type\"]");
    public static By startButton = By.xpath("//button[text()=\"Start\"]");
    public static By pickAnObjectHeader = By.xpath("//div[text()=\"Pick an object\"]");
    public static By dateRangeHeader = By.xpath("//section//span[text()=\"Choose a Default Date Range\"]/ancestor::section[@class=\"slds-col slds-size_2-of-3\"]/following-sibling::section//button[text()='Edit']");
    public static By forecastShowQuotesHeader = By.xpath("//section//span[text()=\"Show Quotas\"]/ancestor::section[@class=\"slds-col slds-size_2-of-3\"]/following-sibling::section//button[text()='Edit']");
    public static By showQuotasCheckbox = By.xpath("//lightning-input[@class='showQuotasCheckbox slds-form-element' and @checked]");
    public static By showQuotasUncheckedCheckbox = By.xpath("//span[@class=\"slds-checkbox\"]//label//span[@class=\"slds-checkbox_faux\"]");
    public static By nextButton = By.xpath("//*[text()=\"Next\"]");
    public static By measurePage = By.xpath("//*[text()=\"Specify a measure\"]");
    public static By dateOfStartPeriod = By.xpath("//select[@name=\"startPeriod\"]");
    public static By showingDateRangeOnForecastsPage = By.xpath("//span[@class=\"slds-m-right_small slds-text-color_weak\"]");
    public static By datetypePage = By.xpath("//*[text()=\"Select a date type\"]");
    public static By hierarchyPage = By.xpath("//*[text()=\"Choose a hierarchy\"]");
    public static By optionalFilterPage = By.xpath("//*[text()=\"Add optional filters\"]");
    public static By forecastTypeName = By.xpath("//*[text()=\"Name your forecast type\"]");
    public static By forecastTypeNameInputTextField = By.xpath("//input[@name=\"forecastTypeName\"]");
    public static By forecastTypeDevNameInputTextField = By.xpath("//input[@name=\"forecastTypeDevName\"]");
    public static By forecastTypeSet = By.xpath("//*[text()=\"You've set up your forecast type\"]");
    public static By activateOption = By.xpath("//a[./span[text()='Activate']]");
    public static By appLauncherIcon = By.xpath("//div[@class='appLauncher slds-context-bar__icon-action']//button");
    public static By searchAppInput = By.xpath("//input[@class='slds-input']");
    public static By forecastAppOption = By.xpath("//a[.//b[text()='Forecasts']]");
    public static By deactivateOption = By.xpath("//a[./span[text()='Deactivate']]");
    public static By deactivateButton = By.xpath(("//button[text()='Deactivate']"));
    public static By showQuotasButton = By.xpath("//button[normalize-space()='Show Quotas']");
    public static By selectAllCheckbox = By.xpath("//span[text()='Select All']/preceding-sibling::span");
    public static By editSelectedRowsButton = By.xpath("//button[normalize-space()='Edit Selected Rows']");
    public static By editQuotasDialog = By.xpath("//h2[text()='Edit Quotas']");
    public static By quotaInputField = By.xpath("//div[@role='dialog']//input");
    public static By editQuotaSaveButton = By.xpath("//button[normalize-space()='Save']");
    public static By quotaFieldValue = By.xpath("//td[.//span[text()='March FY 2023']]/following-sibling::td//span[@class='fct-value-quota-width uiOutputNumber']");


    public static By opportunityList = By.xpath("//*[text()=\"Customize the opportunity list\"]");
    public static By forecastTypeCompletion = By.xpath("//*[text()=\"Good job!\"]");
    public static By doneButton = By.xpath("//*[text()=\"Done\"]");
    public static By forecastsSettingsOption= By.xpath("//li[@aria-level=\"4\"]/child::div[@title=\"Forecasts Settings\"]//a");
    public static By enableForecastsToggleButton= By.xpath("//div[@class='slds-form-element__control']//span[@part='indicator']");
    public static By ForecastsToggleButton= By.xpath("//div[@class='slds-form-element__control']//label//span[text()='Enable Forecasts']");


    public static By quickFind = By.xpath("//input[@placeholder='Quick Find']");

    public static By users = By.xpath("//li[@aria-level=\"2\"]/child::div[@title=\"Users\"]//a");
    public static By newUser = By.xpath("//input[@value='New User']");
    public static By firstName = By.xpath("//input[@id='name_firstName']");
    public static By lastName = By.xpath("//input[@id='name_lastName']");
    public static By alias = By.xpath("//input[@id='Alias']");
    public static By email = By.xpath("//input[@id='Email']");
    public static By username = By.xpath("//input[@id='Username']");
    public static By nickname = By.xpath("//input[@id='CommunityNickname']");
    public static By companyName = By.xpath("//input[@id='CompanyName']");
    public static By department = By.xpath("//input[@id='Department']");

    public static By role = By.id("role");
    public static By userLicense = By.id("user_license_id");
    public static By profile = By.id("Profile");

    public static By allowForecasts = By.id("forecast_enabled");

    public static By saveBtn = By.xpath("//input[@value=' Save ']");
    public static By userCreatedPageDescription = By.xpath("//h2[@class='pageDescription']");
    public static By opportunityAmountTab = By.xpath("//a[@data-label='Opportunity Amount']");
    public static By assignedQuotas = By.xpath("//span[@class='fct-value-quota-width forceOutputCurrency']");

    public static By searchSetupOption(String searchValue) {
        return By.xpath("//li[@aria-level=\"2\" and @aria-label='" + searchValue + "'] | //li[@aria-level=\"4\" and @aria-label='" + searchValue + "']");
    }

    public static By userOption(String searchValue) {
           return By.xpath("//li[@aria-level=\"2\"]/child::div[@title='" + searchValue + "']//a//mark");
    }
    public static By menuOption(String searchValue) {
           return By.xpath("//li[@role='treeitem']/child::div[@title='" + searchValue + "']//a//mark");
    }

    public static By assignOption(String roleValue, String actionValue) {
        return By.xpath("//span//a[text()='" + roleValue + "']/parent::span/following-sibling::span//a[text()='" + actionValue + "']");
    }

    public static By forecastSections(String header, String action) {
        return By.xpath("//section//span[text()='" + header + "']/ancestor::section[@class=\"slds-col slds-size_2-of-3\"]/following-sibling::section//button[text()='" + action + "']");
    }

    public static By dateRangeSettingHeader(String header) {
        return By.xpath("//*[@name='" + header + "']");
    }

    public static By dateRangeSettingValue(String action) {
        return By.xpath("//button//span[text()='" + action + "']");
    }


    public static By newForecastAdded(String Value) {
        return By.xpath("//*[text()='" + Value + "']");
    }
    public static By startDateAndMonth(String Value) {
        return By.xpath("//option[text()='" + Value + "']");
    }
    public static By showActionsButton(String forecastName){
        return By.xpath("//tr[.//div[normalize-space()='"+ forecastName +"']]//button[./*[text()='Show actions']]");
    }

    public static By forecastTitle(String forecastName){
        return By.xpath("//li[@title='"+ forecastName +"']");
    }

    public static By forecastTypeLink(String forecastTypeName){
        return By.xpath("//a[text()='"+ forecastTypeName +"']");
    }

}
