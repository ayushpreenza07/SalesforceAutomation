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

    public static void clickUsers(String logStep) throws InterruptedException {
            try {
                KeywordUtil.isWebElementVisible(ForecastingPage.userOption, "Users Option is visible");
                KeywordUtil.click(ForecastingPage.userOption, "Click on user options");
            } catch (Exception e) {
                catchAssertError(e);
            }
        }

        /* Click on New users button...*/
        public static void clickOnNewUser(String logStep)throws InterruptedException {
            try {
                KeywordUtil.switchToIFrame(0, "All Users ~ Salesforce - Developer Edition");
                KeywordUtil.isWebElementVisible(ForecastingPage.NewUser, "New User is visible");
                KeywordUtil.waitForVisible(ForecastingPage.NewUser);
                takeScreenshotAndAttachInReport();
                KeywordUtil.click(ForecastingPage.NewUser, "Click on New User.");
                GlobalUtil.getDriver().switchTo().defaultContent();
            } catch (Exception e) {
                catchAssertError(e);
            }
        }

        /* Enter all New User details.....*/
        public static void enterNewUserDetails(HashMap<String, String> dataMap, String logStep) throws InterruptedException {
            try {
                KeywordUtil.switchToIFrame(0, "New User ~ Salesforce - Developer Edition");
                KeywordUtil.isWebElementVisible(ForecastingPage.FirstName, "First Name field is present");
                KeywordUtil.waitForVisible(ForecastingPage.FirstName);
                KeywordUtil.inputText(ForecastingPage.FirstName, dataMap.get("FirstName"), "Enter First Name value");
                KeywordUtil.isWebElementPresent(ForecastingPage.LastName, "Last Name field is present");
                KeywordUtil.inputText(ForecastingPage.LastName, dataMap.get("LastName"), "Enter Last Name value");
                KeywordUtil.isWebElementPresent(ForecastingPage.Alias, "Alias field is present");
                KeywordUtil.inputText(ForecastingPage.Alias, dataMap.get("Alias"), "Enter Alias value");
                KeywordUtil.isWebElementPresent(ForecastingPage.Email, "Email field is present");
                KeywordUtil.inputText(ForecastingPage.Email, dataMap.get("Email"), "Enter Email value");
                KeywordUtil.isWebElementPresent(ForecastingPage.Username, "UserName field is present");
                KeywordUtil.inputText(ForecastingPage.Username, dataMap.get("n_username"), "Enter Username value");
                KeywordUtil.isWebElementPresent(ForecastingPage.Nickname, "Nickname field is present");
                KeywordUtil.inputText(ForecastingPage.Nickname, dataMap.get("Nickname"), "Enter Nickname value");
                KeywordUtil.isWebElementPresent(ForecastingPage.CompanyName, "Company name field is present");
                KeywordUtil.inputText(ForecastingPage.CompanyName, dataMap.get("CompanyName"), "Enter Company Name");
                KeywordUtil.isWebElementPresent(ForecastingPage.Department, "Department field is present");
                KeywordUtil.inputText(ForecastingPage.Department, dataMap.get("Department"), "Enter Department Name");
                KeywordUtil.selectOptionFromDropdown(ForecastingPage.Role, 2, "Click and select value from Role dropdown.");
                KeywordUtil.selectOptionFromDropdown(ForecastingPage.UserLicense, 6, "Click and select value from user license dropdown");
                KeywordUtil.selectOptionFromDropdown(ForecastingPage.Profile, 1, "Click and select value profile dropdown");
                KeywordUtil.click(ForecastingPage.AllowForecasting, "Click on allow forecasting checkbox.");
                KeywordUtil.isWebElementVisible(ForecastingPage.SaveButton, "Save button is present");
                KeywordUtil.click(ForecastingPage.SaveButton, "Click on save button");

            } catch (Exception e) {
                catchAssertError(e);
            }
        }

        /* Click on Forecasts Settings option.... */
    public static void forecastSettingsOption(String logstep) throws InterruptedException {
        try {
            KeywordUtil.isWebElementVisible(ForecastingPage.forecastsSettingsOption, "Forecasts settings Option is visible");
            KeywordUtil.click(ForecastingPage.forecastsSettingsOption, "Click on Forecasts Settings options");
        } catch (Exception e) {
            catchAssertError(e);
        }
    }

    /* Click on Enable Forecasts Toggle button.... */
            public static void enableForecasts(String logStep) throws InterruptedException
            {
                try{
                    KeywordUtil.isWebElementVisible(ForecastingPage.enableForecastsToggleButton, "Forecasts toggle button is visible");

                    KeywordUtil.click(ForecastingPage.enableForecastsToggleButton, "Click on forecasts toggle button");

                }
                catch (Exception e) {
                    catchAssertError(e);
                }

        }


    }
