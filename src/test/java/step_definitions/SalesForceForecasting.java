package step_definitions;

import SalesforceModules.ForecastingModule;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import utilities.ExcelDataUtil;
import utilities.GlobalUtil;
import utilities.KeywordUtil;

import java.util.HashMap;

import static utilities.KeywordUtil.catchAssertError;
import java.util.Map;

public class SalesForceForecasting{
    public static HashMap<String, String> dataMap = new HashMap<String, String>();
    public static void main(String[] args) {
        dataMap = ExcelDataUtil.getTestDataWithTestCaseID("Salesforce", "TestData1");
        for (Map.Entry<String, String> entry : dataMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
    @Given("^Read the test data  \"([^\"]*)\" from Excel for Forecasting$")
    public void read_the_test_data_from_Excel(String arg1) {
        try {
            KeywordUtil.cucumberTagName = "Web";
            dataMap = ExcelDataUtil.getTestDataWithTestCaseID("Salesforce", arg1);
        } catch (Throwable e) {
            GlobalUtil.e = e;
            GlobalUtil.errorMsg = e.getMessage();
            Assert.fail(e.getMessage());
        }

    }

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
    @Then("Create Users Hierarchy for Forecast")
    public void createNewUserHierarchy(){
        try{
            ForecastingModule.clickAndEnterValue("Enter the value in search field", "Users");
            ForecastingModule.clickUsers("Click on Users option");
            ForecastingModule.clickOnNewUser("Click on new user");
            ForecastingModule.enterNewUserDetails(dataMap,"Enter New user details");
        }
        catch (Exception e) {
            catchAssertError(e);
        }
    }
}