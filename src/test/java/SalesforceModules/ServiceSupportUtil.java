package SalesforceModules;

import org.openqa.selenium.By;
import pageobjects.SalesforceObjects.AccountObject;
import pageobjects.SalesforceObjects.ServiceSupportObject;
import utilities.KeywordUtil;

public class ServiceSupportUtil {

    /**
     * click New Accounts Button for creating new account.
     *
     * @param logStep the log
     */
    public static void ClickServiceSupportButton(String logStep){
        KeywordUtil.waitForVisible(ServiceSupportObject.clickServiceSupportButton);
        KeywordUtil.click(ServiceSupportObject.clickServiceSupportButton,logStep);
    }


}
