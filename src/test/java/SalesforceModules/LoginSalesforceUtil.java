package SalesforceModules;

import pageobjects.SalesforceObjects.LoginObject;
import utilities.GlobalUtil;
import utilities.KeywordUtil;

import java.util.HashMap;

public class LoginSalesforceUtil extends GlobalUtil {

    static HashMap<String, String> map = new HashMap<>();


    /**
     * enter username
     *
     * @param username
     */
    public static void enterUsername(String username, String logStep){
        KeywordUtil.waitForVisible(LoginObject.username);
        KeywordUtil.inputText(LoginObject.username, username,logStep);
    }

    public static void enterPassword(String password, String logStep){
        KeywordUtil.waitForVisible(LoginObject.password);
        KeywordUtil.inputText(LoginObject.password, password,logStep);
    }

    public static void clickLogin(String logStep){
        KeywordUtil.waitForVisible(LoginObject.loginBtn);
        KeywordUtil.click(LoginObject.loginBtn,logStep);
    }

    public static void loginToSalesforce(String username, String password){
        enterUsername(username,username+" - username entered");
        enterPassword(password,password+" - password entered");
        KeywordUtil.takeScreenshotAndAttachInReport();
        clickLogin("login button clicked");
    }


}
