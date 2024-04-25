package SalesforceModules;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageobjects.SalesforceObjects.*;
import utilities.KeywordUtil;

import java.security.Key;

public class SalesForceBillingUtil {


    /**
     * Select the products tab
     *
     * @param logstep the log
     */
    public static void productsTab(String logstep){
        KeywordUtil.waitForVisible(BillingObject.productsTab);
        KeywordUtil.clickJS(BillingObject.productsTab,logstep);
    }

    /**
     * Enter product name
     *
     * @param name the name
     */
    public static void enterProductName(String name){
        KeywordUtil.waitForVisible(BillingObject.productName);
        KeywordUtil.inputText(BillingObject.productName, name,"Product name entered");
    }


    /**
     * Setting the product family of product to hardware
     *
     * @param logStep the log
     */
    public static void setProductFamily(String logStep){
        KeywordUtil.waitForVisible(BillingObject.productFamily);
        KeywordUtil.click(BillingObject.productFamily,logStep);

        KeywordUtil.waitForVisible(BillingObject.selectFamily);
        KeywordUtil.click(BillingObject.selectFamily,logStep);
    }

    /**
     * Entering code for product
     *
     * @param code the product
     */
    public static void enterProductCode(String code){
        KeywordUtil.waitForVisible(BillingObject.productCode);
        KeywordUtil.inputText(BillingObject.productCode, code,"Product code entered");
    }

    /**
     * Tick the active checkbox.
     *
     * @param logStep the log
     */
    public static void checkActive(String logStep) throws Exception {
        KeywordUtil.waitForVisible(BillingObject.activeCheckBox);
        KeywordUtil.clickJS(BillingObject.activeCheckBox, logStep);
    }

    /**
     * click save button.
     *
     * @param logStep the log
     */
    public static void clickSaveButton(String logStep){
        KeywordUtil.waitForVisible(BillingObject.saveProduct);
        KeywordUtil.click(BillingObject.saveProduct,logStep);
    }

    /**
     * Creating new product
     */
    public static void newProduct() throws Exception {
        AccountUtil.clickNewButton("New button clicked");
        enterProductName("IntelPro");
        enterProductCode("INTP");
        setProductFamily("Hardware Family selected");
        checkActive("Active checkbox");
        clickSaveButton("Product saved");
    }

    /**
     * Creating new product
     * @param logStep the log
     */
    public static void clickRelated(String logStep){
        KeywordUtil.waitForVisible(BillingObject.relatedHeader);
        KeywordUtil.click(BillingObject.relatedHeader,logStep);
    }

    /**
     * Add standard price in price book
     * @param logstep the log
     */
    public static void addStandardPrice(String logstep) throws InterruptedException {

            KeywordUtil.delay(5000);
            ((JavascriptExecutor) KeywordUtil.getDriver()).executeScript("window.scrollBy(0, 700)");
            KeywordUtil.waitForVisible(BillingObject.addStandardPrice);
            KeywordUtil.click(BillingObject.addStandardPrice, logstep);
            enterListPrice("230");
    }

    /**
     * Entering list price in price book
     *
     * @param price the product
     */
    public static void enterListPrice(String price){
        try {
            KeywordUtil.waitForVisible(BillingObject.addStandardPrice);
            KeywordUtil.inputText(BillingObject.addStandardPrice, price, "List price entered");
        }catch (Exception e){
            JavascriptExecutor js = (JavascriptExecutor) KeywordUtil.getDriver();
            String zoomJS = "document.body.style.zoom='0.8'";
            js.executeScript(zoomJS);
            KeywordUtil.inputText(BillingObject.addListPrice, price, "List price entered");
            js.executeScript("document.body.style.zoom='1'");
        }
        clickSaveButton("List price saved");
    }

}
