package SalesforceModules;

import com.relevantcodes.extentreports.LogStatus;
import pageobjects.SalesforceObjects.OrdersObject;
import step_definitions.RunCukesTest;
import utilities.GlobalUtil;
import utilities.HTMLReportUtil;
import utilities.KeywordUtil;

import java.security.Key;

public class OrderUtil extends GlobalUtil {
    /**
     * ClickingOrderTab
     *
     * @param logStep the log
     *
     */
    public static void clickOnOrderTab(String logStep) {
        try{
            KeywordUtil.waitForVisible(OrdersObject.ordersTab);
            KeywordUtil.click(OrdersObject.ordersTab, logStep);
        }
       catch (Exception e){
           KeywordUtil.waitForVisible(OrdersObject.ordersTab);
           KeywordUtil.clickJS(OrdersObject.ordersTab, logStep);
       }
    }
    /**
     * ClickingOrderNumberInOrderTab
     *
     * @param logStep the log
     *
     */
    public static void clickOnOrderNumber(String logStep) {
        try{
            KeywordUtil.waitForVisible(OrdersObject.orderNumber);
            KeywordUtil.click(OrdersObject.orderNumber, logStep);
        }
        catch (Exception e){
            KeywordUtil.waitForVisible(OrdersObject.orderNumber);
            KeywordUtil.clickJS(OrdersObject.orderNumber, logStep);
        }
    }
    /**
     * ClickingOrderActivatedTab
     *
     * @param logStep the log
     *
     */
    public static void clickOnOrderActivated(String logStep) {
        try{
            KeywordUtil.isWebElementVisible(OrdersObject.orderActivated,"Activated Tab Displayed");
            KeywordUtil.click(OrdersObject.orderActivated, logStep);
        }
        catch (Exception e){
            KeywordUtil.waitForVisible(OrdersObject.orderActivated);
            KeywordUtil.clickJS(OrdersObject.orderActivated, logStep);
        }
    }
    /**
     * ClickingOnMarkStatusAsCompleteInOrderTab
     *
     * @param logStep the log
     *
     */
    public static void clickOnMarkStatusAsComplete(String logStep) {
        try{
            KeywordUtil.waitForVisible(OrdersObject.markStatusAsComplete);
            KeywordUtil.click(OrdersObject.markStatusAsComplete, logStep);
        }
        catch (Exception e){
            KeywordUtil.BrowserRefresh();
            KeywordUtil.waitForVisible(OrdersObject.markStatusAsComplete);
            KeywordUtil.clickJS(OrdersObject.markStatusAsComplete, logStep);
        }
    }
    public static void verifyOnOrderActivated(String logStep) {
            String activatedTab= KeywordUtil.getVisibleText(OrdersObject.orderActivated);
            boolean activatedTabVisibile=KeywordUtil.isWebElementVisible(OrdersObject.orderActivated,"Activated Tab Displayed");
            if(activatedTabVisibile){
                RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("verify Status: "+activatedTab));
            }
            else{
                RunCukesTest.logger.log(LogStatus.FAIL, HTMLReportUtil.failStringRedColor("verify Status: "+activatedTab));
            }
     }
}
