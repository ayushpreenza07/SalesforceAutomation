package step_definitions;

import SalesforceModules.ForecastingModule;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobjects.SalesforceObjects.LeadsPage;
import utilities.KeywordUtil;

import static utilities.KeywordUtil.catchAssertError;

public class SalesForceForecasting {


    @When("Check Forecast access for logged in User")
    public void checkForecastAccessForLoggedInUser() throws InterruptedException {
        try {
            ForecastingModule.clickAndEnterValue("Enter the value in search field", "Users");
            ForecastingModule.clickOnEditOption();
            ForecastingModule.scrollToAllowForecast();
            ForecastingModule.closeTheUserGeneralInfoPage();
        } catch (Exception e) {
            catchAssertError(e);
        }
    }

    @And("Assign a Role to the Forecast User")
    public void assignARoleToTheForecastUser() {
        try {
            ForecastingModule.clickAndEnterValue("Enter the value in search field", "Roles");
            ForecastingModule.selectValueFromSampleRoleHierarchies();
            ForecastingModule.selectRolesFromHierarchy("CEO","Assign");
            ForecastingModule.assignRolesToUser();
        } catch (Exception e) {
            catchAssertError(e);
        }
    }

    @And("Check users shown in the Forecasts Hierarchy")
    public void checkUsersShownInTheForecastsHierarchy() {
        try {
            ForecastingModule.clickAndEnterValue("Enter the value in search field", "Forecasts Hierarchy");
            ForecastingModule.verifyRoleAssignToUSer();
        } catch (Exception e) {
            catchAssertError(e);
        }
    }
    @And("Navigate to forecast settings page")
    public void navigateToForecastSettingsPage() {
        try {
            ForecastingModule.clickAndEnterValue("Enter the value in search field", "Forecasts Settings");
            ForecastingModule.validateForecastSettingsPageShouldBeLoaded();
        } catch (Exception e) {
            catchAssertError(e);
        }
    }
    @Then("Activate Forecast")
    public void activateForecast() {
        try{
            ForecastingModule.clickOnShowActionsOfForecast("testAuto");
            ForecastingModule.selectActivateFromActions();
        }
        catch(Exception e){
            catchAssertError(e);
        }
    }
    @And("Search For Forecasts application and Navigate To Forecasts page")
    public void searchForForForecastsApplicationAndNavigateToForecastsPage() {
        try {
            ForecastingModule.clickOnAppLauncherIconAndSerachForForecast();
            ForecastingModule.validateForecastingPageIsLoaded();
        }
        catch(Exception e){
            catchAssertError(e);
        }
    }

    @And("Validate Activated Forecast Is Visible")
    public static void validateActivatedForecastIsVisible() {
        try{
        ForecastingModule.validateActivatedForecastIsAvailable("testAuto");
    }
        catch(Exception e){
            catchAssertError(e);
        }
    }
    @Then("Deactivate Forecast")
    public void deactivateForecast() {
        try{
            ForecastingModule.clickOnShowActionsOfForecast("testAuto");
            ForecastingModule.selectDeactivateFromActions();
        }
        catch(Exception e){
            catchAssertError(e);
        }
    }
    @And("Navigate to forecast settings page In New Window")
    public void navigateToForecastSettingsPageInNewWindow() {
        try {
            KeywordUtil.switchToWindow();
            ForecastingModule.clickAndEnterValue("Enter the value in search field", "Forecasts Settings");
            ForecastingModule.validateForecastSettingsPageShouldBeLoaded();
        } catch (Exception e) {
            catchAssertError(e);
        }
    }

}