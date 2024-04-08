package step_definitions;

import SalesforceModules.ForecastingModule;
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
}