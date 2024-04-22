package SalesforceModules;

import com.relevantcodes.extentreports.LogStatus;
import mobileutil.MobileKeywords2;
import org.apache.bcel.generic.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageobjects.SalesforceObjects.*;
import step_definitions.RunCukesTest;
import utilities.*;

import java.util.HashMap;

import static mobileutil.MobileKeywords2.click;
import static utilities.GlobalUtil.getDriver;
import static utilities.KeywordUtil.*;


public class ForecastingModule {

    /**
     * Click on setup menu
     *
     * @throws InterruptedException
     */
    public static void clickOnSetup(String logStep) throws InterruptedException {
        try {
            if (!KeywordUtil.isWebElementVisible(ForecastingPage.setupTitle, logStep)) {
                KeywordUtil.waitForVisible(ForecastingPage.setupIcon);
                KeywordUtil.click(ForecastingPage.setupIcon, "Click on setup Icon at top right side.");
                KeywordUtil.waitForVisible(ForecastingPage.setupOption);
                KeywordUtil.click(ForecastingPage.setupOption, "Click on setup option.");
                KeywordUtil.waitForVisible(ForecastingPage.setupTitle);
            }
        } catch (Exception e) {
            catchAssertError(e);
        }

    }

    /**
     * Click and insert value in text field
     *
     * @throws InterruptedException
     */
    public static void clickAndEnterValue(String logStep, String searchValue) throws InterruptedException {
        try {
            KeywordUtil.waitForVisible(ForecastingPage.setupSearch);
            WebElement searchInput = getDriver().findElement(ForecastingPage.setupSearch);
            searchInput.clear();
            KeywordUtil.inputText(ForecastingPage.setupSearch, searchValue, logStep);
            KeywordUtil.isWebElementVisible(ForecastingPage.searchSetupOption(searchValue), "Searched option is visible");
            takeScreenshotAndAttachInReport();
            KeywordUtil.click(ForecastingPage.userOption(searchValue), "Click on " + searchValue + " option.");
            KeywordUtil.isWebElementVisible(ForecastingPage.usersPage, searchValue + " page is visible.");
        } catch (Exception e) {
            catchAssertError(e);
        }
    }

    /**
     * switch to iframe
     * click on logged in user option
     *
     * @throws InterruptedException
     */
    public static void clickOnEditOption() throws InterruptedException {
        try {
            KeywordUtil.switchToIFrame(0, "All Users ~ Salesforce - Developer Edition");
            takeScreenshotAndAttachInReport();
            KeywordUtil.isWebElementVisible(ForecastingPage.loggedInUser, "Logged in user is visible.");
            KeywordUtil.click(ForecastingPage.loggedInUser, "Click on Logged in user");
            GlobalUtil.getDriver().switchTo().defaultContent();
        } catch (Exception e) {
            catchAssertError(e);
        }
    }

    /**
     * switch to iframe
     * scroll to element
     * checked allow forecast
     *
     * @throws InterruptedException
     */
    public static void scrollToAllowForecast() throws InterruptedException {
        try {
            KeywordUtil.waitForVisible(ForecastingPage.userGeneralInfo);
            KeywordUtil.switchToIFrame(0, "User Edit: Sukanya Jagtap ~ Salesforce - Developer Edition");
            KeywordUtil.scrollingToElementofAPage(ForecastingPage.allowForecasting, "Scroll to Allow forecasting option.");
            KeywordUtil.waitForVisible(ForecastingPage.allowForecasting);
            if (GlobalUtil.getDriver().findElement(By.xpath("//*[@name='forecast_enabled']")).getAttribute("checked") == null) {
                KeywordUtil.click(ForecastingPage.allowForecastingCheckbox, "Click on allow Forecasting Checkbox.");
                KeywordUtil.scrollingToElementofAPage(ForecastingPage.saveButton, "Scroll to save option.");
                KeywordUtil.waitForVisible(ForecastingPage.saveButton);
                takeScreenshotAndAttachInReport();
                KeywordUtil.click(ForecastingPage.saveButton, "Click on save option.");
            } else {
                GlobalUtil.getDriver().findElement(ForecastingPage.allowForecastingChecked).getAttribute("checked").equals("checked");
                takeScreenshotAndAttachInReport();
            }
            KeywordUtil.isWebElementVisible(ForecastingPage.allowForecastingChecked, "Verify Forecast access is given to user.");
        } catch (Exception e) {
            catchAssertError(e);
        }
    }

    /**
     * close The User General Info Page
     *
     * @throws InterruptedException
     */
    public static void closeTheUserGeneralInfoPage() throws InterruptedException {
        try {
            KeywordUtil.scrollingToElementofAPage(ForecastingPage.closeButton, "Scroll to close option.");
            KeywordUtil.waitForVisible(ForecastingPage.closeButton);
            KeywordUtil.click(ForecastingPage.closeButton, "Click on close option.");
            KeywordUtil.isWebElementVisible(ForecastingPage.usersPage, "User move to previous user page.");
            takeScreenshotAndAttachInReport();
            GlobalUtil.getDriver().switchTo().defaultContent();
        } catch (Exception e) {
            catchAssertError(e);
        }
    }

    /**
     * select Value From Sample Role Hierarchies
     * click on set up role button
     *
     * @throws InterruptedException
     */
    public static void selectValueFromSampleRoleHierarchies() throws InterruptedException {
        try {
            KeywordUtil.switchToIFrame(0, "Understanding Roles ~ Salesforce - Developer Edition");
            KeywordUtil.waitForVisible(ForecastingPage.sampleRoleHierarchy);
            takeScreenshotAndAttachInReport();
            KeywordUtil.selectOptionFromDropdown(ForecastingPage.sampleRoleHierarchy, 2, "Click and select value from Sample Role Hierarchy dropdown.");
            KeywordUtil.scrollingToElementofAPage(ForecastingPage.setupRoles, "Scroll to set up roles button.");
            KeywordUtil.click(ForecastingPage.setupRoles, "Click on set up roles button.");
            GlobalUtil.getDriver().switchTo().defaultContent();


        } catch (Exception e) {
            catchAssertError(e);
        }
    }

    /**
     * select Roles From Hierarchy
     *
     * @throws InterruptedException
     */
    public static void selectRolesFromHierarchy(String roleValue, String actionValue) throws InterruptedException {
        try {
            KeywordUtil.switchToIFrame(0, "Creating the Role Hierarchy ~ Salesforce - Developer Edition");
            KeywordUtil.isWebElementVisible(ForecastingPage.usersPage, "Role Hierarchy page is visible.");
            KeywordUtil.click(ForecastingPage.expandAllRoles, "Expand aLl roles list.");
            KeywordUtil.isWebElementVisible(ForecastingPage.assignOption(roleValue, actionValue), "Role options are visible");
            takeScreenshotAndAttachInReport();
            KeywordUtil.click(ForecastingPage.assignOption(roleValue, actionValue), "Click on " + actionValue + " option.");
            GlobalUtil.getDriver().switchTo().defaultContent();
        } catch (Exception e) {
            catchAssertError(e);
        }
    }

    /**
     * assign Roles To User from roles page
     * check if user is added in list to assign or not.
     *
     * @throws InterruptedException
     */
    public static void assignRolesToUser() throws InterruptedException {
        try {
            KeywordUtil.switchToIFrame(0, "Roles: COO ~ Salesforce - Developer Edition");
            takeScreenshotAndAttachInReport();
            KeywordUtil.isWebElementVisible(ForecastingPage.usersPage, "Role Hierarchy detail page is visible.");
            if (KeywordUtil.isWebElementVisible(ForecastingPage.emptyUsersBox, "")) {
                KeywordUtil.selectOptionFromDropdown(ForecastingPage.selectUser, 1, "Click and select Available Users list.");
                takeScreenshotAndAttachInReport();
                KeywordUtil.click(ForecastingPage.addUser, "Click on add user button.");
                takeScreenshotAndAttachInReport();
                KeywordUtil.click(ForecastingPage.saveButton, "Click on save option.");
            } else {
                takeScreenshotAndAttachInReport();
                KeywordUtil.click(ForecastingPage.saveButton, "Click on save option.");
            }
            KeywordUtil.isWebElementVisible(ForecastingPage.usersPage, "Role Hierarchy page is visible.");
            takeScreenshotAndAttachInReport();
            GlobalUtil.getDriver().switchTo().defaultContent();
        } catch (Exception e) {
            catchAssertError(e);
        }
    }

    /**
     * verify Role Assign To USer
     * check if assigned role is to user
     * and check same user in forecasts page from menu
     *
     * @throws InterruptedException
     */
    public static void verifyRoleAssignToUSer() throws InterruptedException {
        try {
            KeywordUtil.switchToIFrame(0, "Forecasts Hierarchy ~ Salesforce - Developer Edition");
            KeywordUtil.click(ForecastingPage.expandAllRoles, "Expand aLl Forecasts Hierarchy list.");
            if (KeywordUtil.isWebElementVisible(ForecastingPage.forecastsRoleUser, "Verify Role is assign to user.")) {
                KeywordUtil.isWebElementVisible(ForecastingPage.forecastsRoleUser, "Role is visible to user.");
                takeScreenshotAndAttachInReport();
                GlobalUtil.getDriver().switchTo().defaultContent();
                Leads.clickOnHamburgerMenu("User Clicked on Hamburger Menu");
                takeScreenshotAndAttachInReport();
                Leads.enterText("Forecasts");
                KeywordUtil.waitForVisible(ForecastingPage.ownerName);
                takeScreenshotAndAttachInReport();
                KeywordUtil.click(ForecastingPage.ownerNameDropdown, "Click on drop down option from forecats CPQ page.");
                KeywordUtil.inputText(ForecastingPage.searchForOtherUser, "Sukanya", "User Entered Text");
                Assert.assertEquals(getElementText(ForecastingPage.verifyOtherUser), "Sukanya");
                RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("User listed in Forecast CPQ"));

                takeScreenshotAndAttachInReport();
            } else {
                RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("Role is not visible to the user, so checking if the user is visible on the Forecast CPQ page."));
                takeScreenshotAndAttachInReport();
                GlobalUtil.getDriver().switchTo().defaultContent();
                Leads.clickOnHamburgerMenu("User Clicked on Hamburger Menu");
                takeScreenshotAndAttachInReport();
                Leads.enterText("Forecasts");
                KeywordUtil.waitForVisible(ForecastingPage.ownerName);
                takeScreenshotAndAttachInReport();
                KeywordUtil.click(ForecastingPage.ownerNameDropdown, "Click on drop down option from forecats CPQ page.");
                KeywordUtil.inputText(ForecastingPage.searchForOtherUser, "Sukanya", "User Entered Text");
                Assert.assertEquals(getElementText(ForecastingPage.verifyOtherUser), "Sukanya");
                RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("User listed in Forecast CPQ"));
                takeScreenshotAndAttachInReport();

            }

        } catch (Exception e) {
            catchAssertError(e);
        }
    }

    /* Click on Users Options... */
    public static void clickUsers(String logstep) throws InterruptedException {
        try {
            KeywordUtil.isWebElementVisible(ForecastingPage.userOption, "Users Option is visible");
            KeywordUtil.click(ForecastingPage.userOption, "Click on user options");
        } catch (Exception e) {
            catchAssertError(e);
        }
    }

    /* Click on New users button...*/

    public static void clickOnNewUser(String logStep) throws InterruptedException {
        try {
            KeywordUtil.switchToIFrame(0, "All Users ~ Salesforce - Developer Edition");
            KeywordUtil.isWebElementVisible(ForecastingPage.newUser, "New User is visible");
            KeywordUtil.waitForVisible(ForecastingPage.newUser);
            takeScreenshotAndAttachInReport();
            KeywordUtil.click(ForecastingPage.newUser, "Click on New User.");
            GlobalUtil.getDriver().switchTo().defaultContent();
        } catch (Exception e) {
            catchAssertError(e);
        }
    }

    /* Enter all New User details.....*/

    public static void enterNewUserDetails(HashMap<String, String> dataMap, String logStep) throws InterruptedException {
        try {
            KeywordUtil.switchToIFrame(0, "New User ~ Salesforce - Developer Edition");
            KeywordUtil.isWebElementVisible(ForecastingPage.firstName, "First Name field is present");
            KeywordUtil.waitForVisible(ForecastingPage.firstName);
            KeywordUtil.inputText(ForecastingPage.firstName, dataMap.get("FirstName"), "Enter First Name value");
            KeywordUtil.isWebElementPresent(ForecastingPage.lastName, "Last Name field is present");
            KeywordUtil.inputText(ForecastingPage.lastName, dataMap.get("LastName"), "Enter Last Name value");
            KeywordUtil.isWebElementPresent(ForecastingPage.alias, "Alias field is present");
            KeywordUtil.inputText(ForecastingPage.alias, dataMap.get("Alias"), "Enter Alias value");
            KeywordUtil.isWebElementPresent(ForecastingPage.email, "Email field is present");
            KeywordUtil.inputText(ForecastingPage.email, dataMap.get("Email"), "Enter Email value");
            KeywordUtil.isWebElementPresent(ForecastingPage.username, "UserName field is present");
            KeywordUtil.inputText(ForecastingPage.username, dataMap.get("n_username"), "Enter Username value");
            KeywordUtil.isWebElementPresent(ForecastingPage.nickname, "Nickname field is present");
            KeywordUtil.inputText(ForecastingPage.nickname, dataMap.get("Nickname"), "Enter Nickname value");
            KeywordUtil.isWebElementPresent(ForecastingPage.companyName, "Company name field is present");
            KeywordUtil.inputText(ForecastingPage.companyName, dataMap.get("CompanyName"), "Enter Company Name");
            KeywordUtil.isWebElementPresent(ForecastingPage.department, "Department field is present");
            KeywordUtil.inputText(ForecastingPage.department, dataMap.get("Department"), "Enter Department Name");
            KeywordUtil.selectOptionFromDropdown(ForecastingPage.role, 2, "Click and select value from Role dropdown.");
            KeywordUtil.selectOptionFromDropdown(ForecastingPage.userLicense, 6, "Click and select value from user license dropdown");
            KeywordUtil.selectOptionFromDropdown(ForecastingPage.profile, 1, "Click and select value profile dropdown");
            KeywordUtil.click(ForecastingPage.allowForecasts, "Click on allow forecasting checkbox.");
            KeywordUtil.isWebElementVisible(ForecastingPage.saveBtn, "Save button is present");
            KeywordUtil.click(ForecastingPage.saveBtn, "Click on save button");

        } catch (Exception e) {
            catchAssertError(e);
        }
    }

    /**
     * Creating a Forecast Type with opportunity and amount
     *
     * @throws InterruptedException
     */
    public static void createForecastTypeWithOpportunities() throws InterruptedException {
        try {
            KeywordUtil.scrollDown();
            KeywordUtil.waitForVisible(ForecastingPage.createForcastTypeButton);
            takeScreenshotAndAttachInReport();
            KeywordUtil.click(ForecastingPage.createForcastTypeButton, "Click on create a Forcast Type button");
            KeywordUtil.waitForVisible(ForecastingPage.startButton);
            takeScreenshotAndAttachInReport();
            KeywordUtil.click(ForecastingPage.startButton, "Click on start button on Create a Forecast Type form");
            KeywordUtil.waitForVisible(ForecastingPage.pickAnObjectHeader);
            KeywordUtil.selectOptionNameFromDropdown("Select an object... - Current Selection: Select an object...", "Opportunity", "Click and select forecast type.");
            KeywordUtil.click(ForecastingPage.nextButton, "Click on next button on Create a Forecast Type form");
            KeywordUtil.waitForVisible(ForecastingPage.measurePage);
            KeywordUtil.selectOptionNameFromDropdown("Select a measure... - Current Selection: Select a measure...", "Amount", "Click and select measure amount.");
            KeywordUtil.click(ForecastingPage.nextButton, "Click on next button on Create a Forecast Type form");
            KeywordUtil.waitForVisible(ForecastingPage.datetypePage);
            KeywordUtil.selectOptionNameFromDropdown("Select a date type... - Current Selection: Select a date type...", "Close Date (Opportunity)", "Click and select date type option.");
            KeywordUtil.click(ForecastingPage.nextButton, "Click on next button on Create a Forecast Type form");
            KeywordUtil.waitForVisible(ForecastingPage.hierarchyPage);
            KeywordUtil.selectOptionNameFromDropdown("Select a hierarchy... - Current Selection: Select a hierarchy...", "User role", "Click and select hierarchy option.");
            KeywordUtil.click(ForecastingPage.nextButton, "Click on next button on Create a Forecast Type form");
            KeywordUtil.waitForVisible(ForecastingPage.optionalFilterPage);
            takeScreenshotAndAttachInReport();
            KeywordUtil.click(ForecastingPage.nextButton, "Click on next button on optional Filter Page");
            KeywordUtil.waitForVisible(ForecastingPage.forecastTypeName);
            KeywordUtil.inputText(ForecastingPage.forecastTypeNameInputTextField, KeywordUtil.generateRandomName(), "Enter forecast type name.");
            takeScreenshotAndAttachInReport();
            KeywordUtil.click(ForecastingPage.nextButton, "Click on next button on forecast Type Name Page.");
            KeywordUtil.waitForVisible(ForecastingPage.forecastTypeSet);
            KeywordUtil.isWebElementVisible(ForecastingPage.forecastTypeSet, "Verify you've set up your forecast type.");
            takeScreenshotAndAttachInReport();
            KeywordUtil.click(ForecastingPage.saveButton, "Click on save option.");
            KeywordUtil.isWebElementVisible(ForecastingPage.opportunityList, "Verify customize the opportunity list page is opened.");
            takeScreenshotAndAttachInReport();
            KeywordUtil.click(ForecastingPage.nextButton, "Click on next button on opportunity list page.");
            KeywordUtil.isWebElementVisible(ForecastingPage.forecastTypeCompletion, "Verify forecasts type with opportunity is created.");
            takeScreenshotAndAttachInReport();
            KeywordUtil.click(ForecastingPage.doneButton, "Click on done button.");
            takeScreenshotAndAttachInReport();
            KeywordUtil.isWebElementVisible(ForecastingPage.newForecastAdded(KeywordUtil.generateRandomName()), "Verify created new forecast opportunity is visible in forecasts list.");
        } catch (Exception e) {
            catchAssertError(e);
        }
    }

    /**
     * Creating a Forecast Type with opportunity and product
     *
     * @throws InterruptedException
     */
    public static void createForecastTypeWithOpportunitiesandProduct() throws InterruptedException {
        try {
            KeywordUtil.scrollDown();
            KeywordUtil.waitForVisible(ForecastingPage.createForcastTypeButton);
            takeScreenshotAndAttachInReport();
            KeywordUtil.click(ForecastingPage.createForcastTypeButton, "Click on create a Forcast Type button");
            KeywordUtil.waitForVisible(ForecastingPage.startButton);
            takeScreenshotAndAttachInReport();
            KeywordUtil.click(ForecastingPage.startButton, "Click on start button on Create a Forecast Type form");
            KeywordUtil.waitForVisible(ForecastingPage.pickAnObjectHeader);
            KeywordUtil.selectOptionNameFromDropdown("Select an object... - Current Selection: Select an object...", "Opportunity Product", "Click and select forecast type.");
            KeywordUtil.click(ForecastingPage.nextButton, "Click on next button on Create a Forecast Type form");
            KeywordUtil.waitForVisible(ForecastingPage.measurePage);
            KeywordUtil.selectOptionNameFromDropdown("Select a measure... - Current Selection: Select a measure...", "Quantity", "Click and select measure amount.");
            KeywordUtil.click(ForecastingPage.nextButton, "Click on next button on Create a Forecast Type form");
            KeywordUtil.waitForVisible(ForecastingPage.datetypePage);
            KeywordUtil.selectOptionNameFromDropdown("Select a date type... - Current Selection: Select a date type...", "Date (Opportunity Product)", "Click and select date type option.");
            KeywordUtil.click(ForecastingPage.nextButton, "Click on next button on Create a Forecast Type form");
            KeywordUtil.waitForVisible(ForecastingPage.hierarchyPage);
            KeywordUtil.selectOptionNameFromDropdown("Select a hierarchy... - Current Selection: Select a hierarchy...", "User role", "Click and select hierarchy option.");
            KeywordUtil.click(ForecastingPage.nextButton, "Click on next button on Create a Forecast Type form");
            KeywordUtil.waitForVisible(ForecastingPage.optionalFilterPage);
            takeScreenshotAndAttachInReport();
            KeywordUtil.click(ForecastingPage.nextButton, "Click on next button on optional Filter Page");
            KeywordUtil.waitForVisible(ForecastingPage.forecastTypeName);
            KeywordUtil.inputText(ForecastingPage.forecastTypeNameInputTextField, KeywordUtil.generateRandomName(), "Enter forecast type name.");
            takeScreenshotAndAttachInReport();
            KeywordUtil.click(ForecastingPage.nextButton, "Click on next button on forecast Type Name Page.");
            KeywordUtil.waitForVisible(ForecastingPage.forecastTypeSet);
            KeywordUtil.isWebElementVisible(ForecastingPage.forecastTypeSet, "Verify you've set up your forecast type.");
            takeScreenshotAndAttachInReport();
            KeywordUtil.click(ForecastingPage.saveButton, "Click on save option.");
            KeywordUtil.isWebElementVisible(ForecastingPage.opportunityList, "Verify customize the opportunity list page is opened.");
            takeScreenshotAndAttachInReport();
            KeywordUtil.click(ForecastingPage.nextButton, "Click on next button on opportunity list page.");
            KeywordUtil.isWebElementVisible(ForecastingPage.forecastTypeCompletion, "Verify forecasts type with opportunity is created.");
            takeScreenshotAndAttachInReport();
            KeywordUtil.click(ForecastingPage.doneButton, "Click on done button.");
            takeScreenshotAndAttachInReport();
            KeywordUtil.isWebElementVisible(ForecastingPage.newForecastAdded(KeywordUtil.generateRandomName()), "Verify created new forecast opportunity is visible in forecasts list.");
        } catch (Exception e) {
            catchAssertError(e);
        }
    }


    /**
     * Choose a Default Date Range
     *
     * @throws InterruptedException
     */
    public static void chooseaDefaultDateRange() throws InterruptedException {
        try {
            KeywordUtil.scrollingToElementofAPage(ForecastingPage.dateRangeHeader, "Scroll to default date range header.");
            KeywordUtil.isWebElementVisible(ForecastingPage.dateRangeHeader, "Verify default date range is visible.");
            takeScreenshotAndAttachInReport();
            KeywordUtil.isWebElementVisible(ForecastingPage.forecastSections("Choose a Default Date Range", "Edit"), "Verify edit button of default date range is visible.");
            KeywordUtil.click(ForecastingPage.forecastSections("Choose a Default Date Range", "Edit"), "Click on edit button.");
            KeywordUtil.isWebElementVisible(ForecastingPage.dateRangeSettingHeader("ForecastPeriod"), "Verify default date range settings are visible.");
            takeScreenshotAndAttachInReport();
            KeywordUtil.isWebElementVisible(ForecastingPage.dateRangeSettingValue("Monthly"), "Verify default forecast period value is visible.");
            KeywordUtil.isWebElementVisible(ForecastingPage.dateRangeSettingValue("Current month"), "Verify default Starting On value is visible.");
            KeywordUtil.isWebElementVisible(ForecastingPage.dateRangeSettingValue("1 month"), "Verify default Extending For value is visible.");
            KeywordUtil.click(ForecastingPage.saveButton, "Click on save option.");

        } catch (Exception e) {
            catchAssertError(e);
        }
    }


    /**
     * Choose a Default Date Range
     *
     * @throws InterruptedException
     */
    public static void chooseaDefaultQuotas() throws InterruptedException {
        try {
            KeywordUtil.isWebElementVisible(ForecastingPage.forecastShowQuotesHeader, "Verify show quotas is visible.");
            takeScreenshotAndAttachInReport();
            KeywordUtil.isWebElementVisible(ForecastingPage.forecastSections("Show Quotas", "Edit"), "Verify edit button of Show Quotas is visible.");
            KeywordUtil.click(ForecastingPage.forecastSections("Show Quotas", "Edit"), "Click on edit button.");
            if (KeywordUtil.isWebElementVisible(ForecastingPage.showQuotasCheckbox, "Verify show quotas checkbox is checked or not.")) {
                KeywordUtil.isWebElementVisible(ForecastingPage.showQuotasCheckbox, "Show quotas checkbox is checked.");
                takeScreenshotAndAttachInReport();
            } else {
                KeywordUtil.isWebElementVisible(ForecastingPage.showQuotasUncheckedCheckbox, "Show quotas checkbox is not checked.");
                takeScreenshotAndAttachInReport();
                KeywordUtil.click(ForecastingPage.showQuotasUncheckedCheckbox, "Click on Show quotas checkbox.");
                Thread.sleep(2000);
                KeywordUtil.isWebElementVisible(ForecastingPage.showQuotasCheckbox, "Show quotas checkbox is checked.");
                takeScreenshotAndAttachInReport();
            }
            KeywordUtil.click(ForecastingPage.saveButton, "Click on save option.");

        } catch (Exception e) {
            catchAssertError(e);
        }
    }


    /**
     * Verify Forecast on Manager Users Dashboard
     *
     * @throws InterruptedException
     */
    public static void verifyForecastonManagerUsersDashboard() throws InterruptedException {
        try {
            Leads.clickOnHamburgerMenu("User Clicked on Menu");
            takeScreenshotAndAttachInReport();
            Leads.enterText("Forecasts");
            KeywordUtil.waitForVisible(ForecastingPage.ownerName);
            KeywordUtil.isWebElementVisible(ForecastingPage.ownerName, "Forecast on manager users dashboard is visible for user.");
            takeScreenshotAndAttachInReport();
            KeywordUtil.isWebElementVisible(ForecastingPage.showingDateRangeOnForecastsPage, "Verify date range filter is visible.");
            KeywordUtil.click(ForecastingPage.showingDateRangeOnForecastsPage, "Click on date range filter.");
            Thread.sleep(2000);
            KeywordUtil.selectValueFromDropdown(ForecastingPage.dateOfStartPeriod, "March FY 2023", "Select value from start date.");
            KeywordUtil.click(ForecastingPage.dateOfStartPeriod, "Click on date range filter.");
            KeywordUtil.click(ForecastingPage.startDateAndMonth("March FY 2023"), "Select value from date range filter.");
            takeScreenshotAndAttachInReport();
            KeywordUtil.click(ForecastingPage.saveButton, "Click on save option.");
            takeScreenshotAndAttachInReport();
            KeywordUtil.isWebElementVisible(ForecastingPage.opportunityAmountTab, "Verify opportunity amount tab is visible.");
            KeywordUtil.click(ForecastingPage.opportunityAmountTab, "Click on opportunity amount tab.");
            takeScreenshotAndAttachInReport();
            if (KeywordUtil.isWebElementVisible(ForecastingPage.assignedQuotas, "Verify assigned quotas value is visible or not.")) {
                RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("Assigned quotas value is visible to user on forecast on manager users dashboard."));
                takeScreenshotAndAttachInReport();
            } else {
                RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("No quotas value is assign to user from forecasts settings."));
                takeScreenshotAndAttachInReport();

            }
        } catch (Exception e) {
            catchAssertError(e);
        }
    }

    /**
     * Verify Forecast on Teams Users Dashboard
     *
     * @throws InterruptedException
     */
    public static void verifyForecastonTeamsUsersDashboard() throws InterruptedException {
        try {
            KeywordUtil.isWebElementVisible(AccountObject.accountProfileImage, "Account profile image is visible.");
            KeywordUtil.click(AccountObject.accountProfileImage, "Click on Account profile image.");
            KeywordUtil.isWebElementVisible(AccountObject.logOutButton, "Log out button is visible.");
            KeywordUtil.click(AccountObject.logOutButton, "Click on Log out.");
            LoginSalesforceUtil.loginToSalesforce("sukanya@testingxperts.com", "Tiger@1234");
            Leads.clickOnHamburgerMenu("User Clicked on Menu");
            takeScreenshotAndAttachInReport();
            Leads.enterText("Forecasts");
            KeywordUtil.waitForVisible(ForecastingPage.ownerName);
            KeywordUtil.isWebElementVisible(ForecastingPage.ownerName, "Forecast on manager users dashboard is visible for user.");
            takeScreenshotAndAttachInReport();
            KeywordUtil.isWebElementVisible(ForecastingPage.showingDateRangeOnForecastsPage, "Verify date range filter is visible.");
            KeywordUtil.click(ForecastingPage.showingDateRangeOnForecastsPage, "Click on date range filter.");
            Thread.sleep(2000);
            KeywordUtil.selectValueFromDropdown(ForecastingPage.dateOfStartPeriod, "March FY 2023", "Select value from start date.");
            KeywordUtil.click(ForecastingPage.dateOfStartPeriod, "Click on date range filter.");
            KeywordUtil.click(ForecastingPage.startDateAndMonth("March FY 2023"), "Select value from date range filter.");
            takeScreenshotAndAttachInReport();
            KeywordUtil.click(ForecastingPage.saveButton, "Click on save option.");
            takeScreenshotAndAttachInReport();
            KeywordUtil.isWebElementVisible(ForecastingPage.opportunityAmountTab, "Verify opportunity amount tab is visible.");
            KeywordUtil.click(ForecastingPage.opportunityAmountTab, "Click on opportunity amount tab.");
            takeScreenshotAndAttachInReport();
            if (KeywordUtil.isWebElementVisible(ForecastingPage.assignedQuotas, "Verify assigned quotas value is visible or not.")) {
                RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("Assigned quotas value is visible to user on forecast on manager users dashboard."));
                takeScreenshotAndAttachInReport();
            } else {
                RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("No quotas value is assign to user from forecasts settings."));
                takeScreenshotAndAttachInReport();

            }
        } catch (Exception e) {
            catchAssertError(e);
        }
    }

    /* Click on Forecasts Settings option.... */
    public static void forecastSettingsOption(String logStep) throws InterruptedException {
        try {
            KeywordUtil.isWebElementVisible(ForecastingPage.forecastsSettingsOption, "Forecasts settings Option is visible");
            KeywordUtil.click(ForecastingPage.forecastsSettingsOption, logStep);
        } catch (Exception e) {
            catchAssertError(e);
        }
    }

    /* Click on Enable Forecasts Toggle button.... */
    public static void enableForecasts(String logStep) throws InterruptedException {
        try {
            KeywordUtil.isWebElementVisible(ForecastingPage.enableForecastsToggleButton, "Forecasts toggle button is visible");

            KeywordUtil.click(ForecastingPage.enableForecastsToggleButton, logStep);

        } catch (Exception e) {
            catchAssertError(e);
        }

    }


}
