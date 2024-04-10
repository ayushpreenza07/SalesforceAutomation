package step_definitions;

import SalesforceModules.ForecastingModule;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

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
            ForecastingModule.selectValueFromDropDown();
            ForecastingModule.selectRolesFromHierarchy("COO","Assign");
            ForecastingModule.assignRolesToUser();
        } catch (Exception e) {
            catchAssertError(e);
        }
    }
}