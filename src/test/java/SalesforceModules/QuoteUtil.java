package SalesforceModules;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pageobjects.SalesforceObjects.QuoteObject;
import utilities.KeywordUtil;

import java.util.HashMap;

public class QuoteUtil {

    static HashMap<String, String> map = new HashMap<>();

    /**
     * click new button for creating new Quote.
     *
     * @param logStep the log
     */
    public static void NewButtonQuote(String logStep) throws InterruptedException {
        Thread.sleep(5000);
        KeywordUtil.waitForVisible(QuoteObject.newQuoteButton);
        KeywordUtil.click(QuoteObject.newQuoteButton,logStep);
    }

    public static void clickQuoteTab(String logStep) throws InterruptedException {
//        KeywordUtil.waitForVisible(QuoteObject.clickOnQuotes);
//        KeywordUtil.click(QuoteObject.clickOnQuotes,logStep);
        KeywordUtil.delay(3000);
        WebElement element = KeywordUtil.getDriver().findElement(QuoteObject.clickOnQuotes);
        JavascriptExecutor executor = (JavascriptExecutor)KeywordUtil.getDriver();
        executor.executeScript("arguments[0].click();", element);
    }

    /**
     * Select the opportunity field for new quote.
     *
     * @param logStep the log
     * @param opportunityname the opportunity name
     */
    public static void enterOpportunityName(String opportunityname, String logStep){
        KeywordUtil.waitForVisible(QuoteObject.searchOpportunities);
        KeywordUtil.inputText(QuoteObject.searchOpportunities, opportunityname,logStep);
    }

    /**
     * Select the opportunity field for new quote.
     *
     * @param logStep the log
     * @param oppurt the opportunity name
     */

    public static void selectOpportunity(String oppurt, String logStep) throws InterruptedException {
        boolean flag = false;
        KeywordUtil.waitForVisible(QuoteObject.searchOpportunities);
        KeywordUtil.inputText(QuoteObject.searchOpportunities,oppurt,logStep);
        KeywordUtil.delay(3000);
        String xpath = "//lightning-base-combobox-formatted-text[contains(@title,'"+oppurt+"')]";
        try{
            flag = KeywordUtil.getDriver().findElement(By.xpath(xpath)).isDisplayed();

        }catch (Exception e){}

        if(!flag){
            System.out.println("no such opportunity present");
        }else {
            KeywordUtil.click(By.xpath(xpath), "opportunity selected");
        }
    }

    /**
     * Select the Account field for new quote.
     *
     * @param logStep the log
     * @param name the account name
     */
    public static void enterAccountName(String name, String logStep){
        KeywordUtil.waitForVisible(QuoteObject.searchAccounts);
        KeywordUtil.inputText(QuoteObject.searchAccounts, name,logStep);
    }

    public static void selectAccount(String account, String logStep) throws InterruptedException {
        boolean flag = false;
        KeywordUtil.waitForVisible(QuoteObject.searchAccounts);
        KeywordUtil.inputText(QuoteObject.searchAccounts,account,logStep);
        KeywordUtil.delay(3000);
        String xpath = "//lightning-base-combobox-formatted-text[contains(@title,'"+account+"')]";
        try{
            flag = KeywordUtil.getDriver().findElement(By.xpath(xpath)).isDisplayed();

        }catch (Exception e){}

        if(!flag){
            System.out.println("no such account present");
        }else {
            KeywordUtil.click(By.xpath(xpath), "account selected");
        }
    }

    /**
     * Select the Types field for new quote.
     *
     * @param logStep the log
     * @param Types the Types name
     */
    public static void enterTypes(String Types, String logStep){
        KeywordUtil.waitForVisible(QuoteObject.selectTypes);
        KeywordUtil.inputText(QuoteObject.selectTypes, Types,logStep);
    }

    public static void selectType(String type, String logStep){
        boolean flag = false;
        KeywordUtil.waitForVisible(QuoteObject.selectTypes);
        KeywordUtil.click(QuoteObject.selectTypes,logStep);
        String xpath = "//lightning-base-combobox-item[contains(@data-value,'"+type+"')]";
        try{
            flag = KeywordUtil.getDriver().findElement(By.xpath(xpath)).isDisplayed();

        }catch (Exception e){}

        if(!flag){
            System.out.println("no such type present");
        }else {
            KeywordUtil.click(By.xpath(xpath), "type selected");
        }
    }

    /**
     * click save button.
     *
     * @param logStep the log
     */
    public static void clickSaveButton(String logStep){
        KeywordUtil.waitForVisible(QuoteObject.saveButton);
        KeywordUtil.click(QuoteObject.saveButton,logStep);
    }

    public static void clickQuoteButton(String logStep){
        KeywordUtil.waitForVisible(QuoteObject.quoteBtn);
        KeywordUtil.click(QuoteObject.quoteBtn,logStep);
    }

    public static void checkPrimary(String logStep) throws Exception {
        try {
            KeywordUtil.waitForVisible(QuoteObject.primaryCheckbox);
            KeywordUtil.click(QuoteObject.primaryCheckbox, logStep);
        }catch(Exception e){
            WebElement check = KeywordUtil.getDriver().findElement(QuoteObject.primaryCheckbox);
            JavascriptExecutor executor = (JavascriptExecutor)KeywordUtil.getDriver();
            executor.executeScript("arguments[0].click();", check);
        }
    }

    public static void clickEditLines(String logStep) throws InterruptedException {
        KeywordUtil.delay(10000);
        KeywordUtil.waitForVisible(QuoteObject.editLines);
        KeywordUtil.click(QuoteObject.editLines,logStep);
    }

    public static void clickGenerateDocument(String logStep) throws InterruptedException {
        KeywordUtil.delay(5000);
        KeywordUtil.waitForVisible(QuoteObject.generateDocument);
        KeywordUtil.click(QuoteObject.generateDocument,logStep);

        try {
            KeywordUtil.waitForVisible(QuoteObject.saveDocument);
            KeywordUtil.click(QuoteObject.saveDocument,logStep);
        }catch(Exception e){
            KeywordUtil.switchToIFrame(3,"Edit Quote IFrame");
            KeywordUtil.delay(5000);

            WebElement saveDocument = KeywordUtil.excuteJavaScriptExecutorScripts("return document.querySelector(\"#sbDocGenPreview > div.sbPageTitle > div > div.sbPageTitleRight > div > button:nth-child(4)\")");

            JavascriptExecutor executor = (JavascriptExecutor)KeywordUtil.getDriver();
            executor.executeScript("arguments[0].click();", saveDocument);
            KeywordUtil.delay(15000);
            KeywordUtil.getDriver().switchTo().parentFrame();
            System.out.println(KeywordUtil.getDriver().switchTo().parentFrame().getTitle());
        }

        goToOpportunity("navigated to opportunity");
    }

    public static void enterDiscount(String discount,String product,String logStep) throws InterruptedException {
        KeywordUtil.delay(10000);

        //switching to iframe to click on JS path buttons
        KeywordUtil.switchToIFrame(3,"Edit Quote IFrame");
        KeywordUtil.delay(5000);

        // click on edit lines button using JS path
        WebElement saveOnEditLines = KeywordUtil.excuteJavaScriptExecutorScripts("return document.querySelector('#sbPageContainer').shadowRoot.querySelector('#content > sb-line-editor').shadowRoot.querySelector('#pricebookDialog').shadowRoot.querySelector('#dialog > paper-button > sb-i18n')");
        JavascriptExecutor executor = (JavascriptExecutor)KeywordUtil.getDriver();
        executor.executeScript("arguments[0].click();", saveOnEditLines);
        KeywordUtil.delay(2000);

        //add discount using JS path
        WebElement addDiscount = KeywordUtil.excuteJavaScriptExecutorScripts("return document.querySelector('#sbPageContainer').shadowRoot.querySelector('#content > sb-line-editor').shadowRoot.querySelector('#quoteInformation > div > sb-field-set-table').shadowRoot.querySelector('#firstColumn').shadowRoot.querySelector('#g > div > sb-field-set-table-item:nth-child(2)').shadowRoot.querySelector('#field').shadowRoot.querySelector('#f > sb-input').shadowRoot.querySelector('#myinput')");
        JavascriptExecutor js = (JavascriptExecutor)KeywordUtil.getDriver();
        js.executeScript("arguments[0].value='"+discount+"';", addDiscount);
        KeywordUtil.delay(2000);

        //click on quick save button using JS path
        WebElement quickSave = KeywordUtil.excuteJavaScriptExecutorScripts("return document.querySelector('#sbPageContainer').shadowRoot.querySelector('#content > sb-line-editor').shadowRoot.querySelector('#actions > sb-custom-action:nth-child(9)').shadowRoot.querySelector('#mainButton');");
        executor.executeScript("arguments[0].click();", quickSave);
        KeywordUtil.delay(2000);

        //click on add product button using JS path
        WebElement addProducts = KeywordUtil.excuteJavaScriptExecutorScripts("return document.querySelector('#sbPageContainer').shadowRoot.querySelector('#content > sb-line-editor').shadowRoot.querySelector('#actions > sb-custom-action:nth-child(1)').shadowRoot.querySelector('#mainButton')");
        executor.executeScript("arguments[0].click();", addProducts);
        KeywordUtil.delay(2000);

        //click on search and enter your product using JS path
        WebElement searchProduct = KeywordUtil.excuteJavaScriptExecutorScripts("return document.querySelector('#sbPageContainer').shadowRoot.querySelector('#content > sb-product-lookup').shadowRoot.querySelector('#headersearch').shadowRoot.querySelector('#typeahead').shadowRoot.querySelector('#itemLabel')");
        executor.executeScript("arguments[0].value='"+product+"';", searchProduct);
        executor.executeScript("arguments[0].click();", searchProduct);
        KeywordUtil.delay(2000);
        Actions action = new Actions(KeywordUtil.getDriver());
        action.sendKeys(Keys.ENTER).build().perform();
        KeywordUtil.delay(5000);

        //click on search icon button using JS path
        WebElement searchIcon = KeywordUtil.excuteJavaScriptExecutorScripts("return document.querySelector(\"#sbPageContainer\").shadowRoot.querySelector(\"#content > sb-product-lookup\").shadowRoot.querySelector(\"#headersearch\").shadowRoot.querySelector(\"#search\")");
        executor.executeScript("arguments[0].click();", searchIcon);
        KeywordUtil.delay(5000);

        //check first checkbox after searching using JS path
        WebElement checkBox = KeywordUtil.excuteJavaScriptExecutorScripts("return document.querySelector('#sbPageContainer').shadowRoot.querySelector('#content > sb-product-lookup').shadowRoot.querySelector('#lookupLayout').shadowRoot.querySelector('#tableRow').shadowRoot.querySelector('#selection').shadowRoot.querySelector('#g > div > sb-table-cell-select').shadowRoot.querySelector('#checkbox').shadowRoot.querySelector('#checkboxContainer')");
        executor.executeScript("arguments[0].click();", checkBox);
        KeywordUtil.delay(5000);

        //select product using JS path
        WebElement select = KeywordUtil.excuteJavaScriptExecutorScripts("return document.querySelector('#sbPageContainer').shadowRoot.querySelector('#content > sb-product-lookup').shadowRoot.querySelector('#plSelect')");
        executor.executeScript("arguments[0].click();",select);
        KeywordUtil.delay(8000);

        //clicking save button using JS path
        WebElement save = KeywordUtil.excuteJavaScriptExecutorScripts("return document.querySelector('#sbPageContainer').shadowRoot.querySelector('#content > sb-line-editor').shadowRoot.querySelector('#actions > sb-custom-action:nth-child(13)').shadowRoot.querySelector('#mainButton')");
        executor.executeScript("arguments[0].click();",save);

        //switching back to parent frame
        KeywordUtil.getDriver().switchTo().parentFrame();
    }

    public static void goToOpportunity(String logStep){
        try {
            KeywordUtil.delay(5000);
            KeywordUtil.waitForVisible(QuoteObject.joinedOpportunity);
            KeywordUtil.click(QuoteObject.joinedOpportunity, logStep);
        }catch (Exception e){
            System.out.println(KeywordUtil.getDriver().getTitle());
            WebElement oppor = KeywordUtil.getDriver().findElement(QuoteObject.joinedOpportunity);
            JavascriptExecutor executor = (JavascriptExecutor)KeywordUtil.getDriver();
            executor.executeScript("arguments[0].click();", oppor);

        }
    }

    public static void changeStatus(String type, String logStep){
        boolean flag = false;
        KeywordUtil.waitForVisible(QuoteObject.statusButton);
        KeywordUtil.click(QuoteObject.statusButton,logStep);
        String xpath = "//lightning-base-combobox-item[contains(@data-value,'"+type+"')]";
        try{
            flag = KeywordUtil.getDriver().findElement(By.xpath(xpath)).isDisplayed();

        }catch (Exception e){}

        if(!flag){
            System.out.println("no such status present");
        }else {
            KeywordUtil.click(By.xpath(xpath), "status selected");
        }
    }

    public static void changeQuoteStatusAndGoToOpportunity(String logStep) throws InterruptedException {
        KeywordUtil.waitForVisible(QuoteObject.quoteConnected);
        WebElement quote = KeywordUtil.getDriver().findElement(QuoteObject.quoteConnected);
        JavascriptExecutor executor = (JavascriptExecutor)KeywordUtil.getDriver();
        executor.executeScript("arguments[0].click();", quote);

        KeywordUtil.waitForVisible(QuoteObject.editButton);
        KeywordUtil.click(QuoteObject.editButton, "Edit button clicked");

        changeStatus("Approved", logStep);

        clickSaveButton("save button clocked");

        KeywordUtil.delay(2000);
        KeywordUtil.waitForVisible(QuoteObject.opportunityAfterQuote);
        WebElement Opportunity = KeywordUtil.getDriver().findElement(QuoteObject.opportunityAfterQuote);
        executor.executeScript("arguments[0].click();", Opportunity);
    }


    public static void addDiscountProduct() throws InterruptedException {
        clickEditLines("Edit Lines clicked");
        enterDiscount("5","2FAUSBKEY","Entered discount");
    }

    public static void createNewQuote(String name, String opportunityname, String type) throws Exception {
        clickQuoteButton("Navigated to quote");
        NewButtonQuote("Clicked new button");
        checkPrimary("primary checkbox marked");
        selectOpportunity(opportunityname,opportunityname+" entered opportunities name");
        selectAccount(name,name+" entered account name");
        selectType(type,"selected type");
        clickSaveButton("clicked save button");
        addDiscountProduct();
    }
}
