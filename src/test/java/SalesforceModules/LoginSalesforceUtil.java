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
     * @param username the username
     * @param logStep the logstep
     */
    public static void enterUsername(String username, String logStep){
        KeywordUtil.waitForVisible(LoginObject.username);
        KeywordUtil.inputText(LoginObject.username, username,logStep);
    }

    /**
     * enter password
     *
     * @param password the password
     * @param logStep the logstep
     *
     */
    public static void enterPassword(String password, String logStep){
        KeywordUtil.waitForVisible(LoginObject.password);
        KeywordUtil.inputText(LoginObject.password, password,logStep);
    }

    /**
     * Click Login
     *
     * @param logStep the logstep
     */
    public static void clickLogin(String logStep){
        KeywordUtil.waitForVisible(LoginObject.loginBtn);
        KeywordUtil.click(LoginObject.loginBtn,logStep);
    }

    /**
     * enter username
     *
     * @param username the username
     * @param password the password
     */
    public static void loginToSalesforce(String username, String password){
        enterUsername(username,username+" - username entered");
        enterPassword(password,password+" - password entered");
        KeywordUtil.takeScreenshotAndAttachInReport();
        clickLogin("login button clicked");
    }

    /**
     * Click Login
     *
     *
     */
    public static void okayLogin(){
        KeywordUtil.waitForVisible(LoginObject.okayLogin);
        KeywordUtil.click(LoginObject.okayLogin, "Okay button clicked");
    }

}
