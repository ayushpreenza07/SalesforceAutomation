package SalesforceModules;

import mobileutil.MobileKeywords2;
import pageobjects.SalesforceObjects.*;
import utilities.DriverUtil;
import utilities.KeywordUtil;
import utilities.LogUtil;

public class ForecastingModule {
    public static void click_On_Setup(String logStep) {
        if (KeywordUtil.isWebElementPresent(ForecastingPage.setupTitle, "Setup page is opened")) {

        } else {
            KeywordUtil.waitForVisible(ForecastingPage.setupIcon);
            KeywordUtil.click(ForecastingPage.setupIcon, logStep);
        }
    }
}
