package SalesforceModules;

import com.relevantcodes.extentreports.LogStatus;
import org.bouncycastle.operator.KeyWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import pageobjects.SalesforceObjects.QuoteObject;
import step_definitions.RunCukesTest;
import utilities.GlobalUtil;
import utilities.HTMLReportUtil;
import utilities.KeywordUtil;

import java.util.HashMap;

public class QuoteUtil {

    static HashMap<String, String> map = new HashMap<>();

    /**
     * click on new button for creating new Quote.
     * @param logStep the log
     */
    public static void newButtonQuote(String logStep){
        KeywordUtil.waitForVisible(QuoteObject.newQuoteButton);
        KeywordUtil.click(QuoteObject.newQuoteButton,logStep);
    }

    /**
     * click Quote tab.
     *
     * @param logStep the log
     */
    public static void clickQuoteTab(String logStep) throws InterruptedException {
        KeywordUtil.delay(3000);
        WebElement element = KeywordUtil.getDriver().findElement(QuoteObject.clickOnQuotes);
        JavascriptExecutor executor = (JavascriptExecutor)KeywordUtil.getDriver();
        executor.executeScript("arguments[0].click();", element);
    }
    public static void clickQuotesTab(String logStep) throws InterruptedException {
        try {
            KeywordUtil.delay(3000);
            KeywordUtil.isWebElementVisible(QuoteObject.clickOnQuotesTab,"Quoates tab visible");
          KeywordUtil.click(QuoteObject.clickOnQuotesTab,"Clicked on Quote Tab");

        }
        catch (Exception e) {
            KeywordUtil.delay(3000);
            WebElement element = KeywordUtil.getDriver().findElement(QuoteObject.clickOnQuotesTab);
            JavascriptExecutor executor = (JavascriptExecutor) KeywordUtil.getDriver();
            executor.executeScript("arguments[0].click();", element);
        }
    }
    public static void clickQuoteTabFromRHS(String logStep) throws InterruptedException {
        KeywordUtil.delay(5000);
        try {
            KeywordUtil.isWebElementVisible(QuoteObject.rhsQuote,"Quote is visible");
            KeywordUtil.click(QuoteObject.rhsQuote,"Quote is Clickable");

               } catch (Exception e) {
            KeywordUtil.delay(3000);
            WebElement element = KeywordUtil.getDriver().findElement(QuoteObject.rhsQuote);
            JavascriptExecutor executor = (JavascriptExecutor) KeywordUtil.getDriver();
            executor.executeScript("arguments[0].click();", element);

        }
    }
    /**
     * Select the opportunity field for new quote.
     *
     * @param logStep the log
     * @param opportunityname the opportunity name
     */
    public static void enterOpportunityName(String opportunityname, String logStep){
        KeywordUtil.waitForVisible(QuoteObject.searchOpportunities);
        KeywordUtil.clickJS(QuoteObject.searchOpportunities);
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
        KeywordUtil.clickJS(QuoteObject.searchOpportunities);

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
     * Using the following method need to select Opportunity
     * @param  logStep the log
     * @param opport the opportunity name
     * @return
     */
    public static void selectOpportunityForLeads(String opport, String logStep) throws InterruptedException {
        boolean flag = false;
        KeywordUtil.delay(2000);
        KeywordUtil.waitForVisible(QuoteObject.searchOpportunities);
        KeywordUtil.clickJS(QuoteObject.searchOpportunities);
            KeywordUtil.click(QuoteObject.selectOppurtunityLeads,"Clicked on First option");
        KeywordUtil.inputText(QuoteObject.searchOpportunities,opport,logStep);
        KeywordUtil.delay(3000);
        String xpath = "//lightning-base-combobox-formatted-text[contains(@title,'"+opport+"')]";
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
     * Enter account name field for new quote.
     *
     * @param logStep the log
     * @param name the account name
     */
    public static void enterAccountName(String name, String logStep){
        KeywordUtil.waitForVisible(QuoteObject.searchAccounts);
        KeywordUtil.inputText(QuoteObject.searchAccounts, name,logStep);
    }

    /**
     * Select the Account field for new quote.
     *
     * @param logStep the log
     * @param account the account name
     */
    public static void selectAccount(String account, String logStep) throws InterruptedException {
        boolean flag = false;
        KeywordUtil.waitForVisible(QuoteObject.searchAccounts);
        KeywordUtil.clickJS(QuoteObject.searchAccounts);
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
     * Click on Search field on Accounts to select the Account.
     * @param logStep the log
     * @param account the account name
     */
    public static void selectAccountForLeads(String account, String logStep) throws InterruptedException {
        boolean flag = false;
        KeywordUtil.waitForVisible(QuoteObject.searchAccounts);
        KeywordUtil.clickJS(QuoteObject.searchAccounts);
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

    /**
     * Select the Types field for new quote.
     *
     * @param logStep the log
     * @param type the Types name
     */
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

    /**
     * click Quote button.
     *
     * @param logStep the log
     */
    public static void clickQuoteButton(String logStep){
        KeywordUtil.waitForVisible(QuoteObject.quoteBtn);
        KeywordUtil.click(QuoteObject.quoteBtn,logStep);
    }
    /**
     * Click on Quote Card in RHS.
     * @param logStep the log
     */
    public static void clickQuoteCard(String logStep) {
        KeywordUtil.waitForVisible(QuoteObject.quoteCardBtn);
        KeywordUtil.click(QuoteObject.quoteCardBtn,logStep);
    }


    /**
     * Tick the primary checkbox.
     *
     * @param logStep the log
     */
    public static void checkPrimary(String logStep) throws Exception {
            KeywordUtil.waitForVisible(QuoteObject.primaryCheckbox);
            WebElement check = KeywordUtil.getDriver().findElement(QuoteObject.primaryCheckbox);
            JavascriptExecutor executor = (JavascriptExecutor)KeywordUtil.getDriver();
            executor.executeScript("arguments[0].click();", check);
    }

    /**
     * Tick the ordered checkbox.
     *
     * @param logStep the log
     */
    public static void checkOrdered(String logStep) throws Exception {
            KeywordUtil.waitForVisible(QuoteObject.orderedCheckbox);
            WebElement check = KeywordUtil.getDriver().findElement(QuoteObject.orderedCheckbox);
            JavascriptExecutor executor = (JavascriptExecutor)KeywordUtil.getDriver();
            executor.executeScript("arguments[0].click();", check);
    }
    /**
     * Tick the ordered checkbox.
     *
     * @param logStep the log
     */
    public static void checkOrderedUnderEdit(String logStep) throws Exception {
        try {
            KeywordUtil.waitForVisible(QuoteObject.orderedCheckbox);
            KeywordUtil.scrollElementIntoViewUsingActions(QuoteObject.orderedCheckbox);
            KeywordUtil.click(QuoteObject.orderedCheckbox,"Clicked on Ordered Checkbox");

        }
        catch (Exception e){
            KeywordUtil.waitForVisible(QuoteObject.orderedCheckbox);
            KeywordUtil.scrollElementIntoViewUsingActions(QuoteObject.orderedCheckbox);
            WebElement check = KeywordUtil.getDriver().findElement(QuoteObject.orderedCheckbox);
            JavascriptExecutor executor = (JavascriptExecutor) KeywordUtil.getDriver();
            executor.executeScript("arguments[0].click();", check);

        }
    }
    /**
     * Click EditLines
     *
     * @param logStep the log
     */
    public static void clickEditLines(String logStep) throws InterruptedException {
        KeywordUtil.delay(10000);
        KeywordUtil.waitForClickable(QuoteObject.editLines);
        KeywordUtil.click(QuoteObject.editLines,logStep);
    }
    /**
     * Click on EditLines for adding the products
     * @param logStep the log
     *
     */
    public static void clickEditLinesForLeads(String logStep) throws InterruptedException {
        KeywordUtil.delay(10000);
        addDiscountProductForLeads();
    }

    /**
     * Click Generate Document and save
     *
     * @param logStep the log
     */
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

    /**
     * Enter discount and select product using JS paths
     *
     * @param discount,logStep,product the log
     */
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
        RunCukesTest.logger.log(LogStatus.PASS,
                HTMLReportUtil.passStringGreenColor(" <font color='green'>Clicked on Edit Line Save Button</font> page"));

        //add discount using JS path
        WebElement addDiscount = KeywordUtil.excuteJavaScriptExecutorScripts("return document.querySelector('#sbPageContainer').shadowRoot.querySelector('#content > sb-line-editor').shadowRoot.querySelector('#quoteInformation > div > sb-field-set-table').shadowRoot.querySelector('#firstColumn').shadowRoot.querySelector('#g > div > sb-field-set-table-item:nth-child(2)').shadowRoot.querySelector('#field').shadowRoot.querySelector('#f > sb-input').shadowRoot.querySelector('#myinput')");
        JavascriptExecutor js = (JavascriptExecutor)KeywordUtil.getDriver();
        js.executeScript("arguments[0].value='"+discount+"';", addDiscount);
        KeywordUtil.delay(2000);
        RunCukesTest.logger.log(LogStatus.PASS,
                HTMLReportUtil.passStringGreenColor(" <font color='green'>Adding Discount</font>"));

        //click on quick save button using JS path
        WebElement quickSave = KeywordUtil.excuteJavaScriptExecutorScripts("return document.querySelector('#sbPageContainer').shadowRoot.querySelector('#content > sb-line-editor').shadowRoot.querySelector('#actions > sb-custom-action:nth-child(9)').shadowRoot.querySelector('#mainButton');");
        executor.executeScript("arguments[0].click();", quickSave);
        KeywordUtil.delay(2000);
        RunCukesTest.logger.log(LogStatus.PASS,
                HTMLReportUtil.passStringGreenColor(" <font color='green'>Clicked on QuickSave Button</font> page"));
        //click on add product button using JS path
        WebElement addProducts = KeywordUtil.excuteJavaScriptExecutorScripts("return document.querySelector('#sbPageContainer').shadowRoot.querySelector('#content > sb-line-editor').shadowRoot.querySelector('#actions > sb-custom-action:nth-child(1)').shadowRoot.querySelector('#mainButton')");
        executor.executeScript("arguments[0].click();", addProducts);
        KeywordUtil.delay(2000);
        RunCukesTest.logger.log(LogStatus.PASS,
                HTMLReportUtil.passStringGreenColor(" <font color='green'>Adding product</font>"));

        //click on search and enter your product using JS path
        WebElement searchProduct = KeywordUtil.excuteJavaScriptExecutorScripts("return document.querySelector('#sbPageContainer').shadowRoot.querySelector('#content > sb-product-lookup').shadowRoot.querySelector('#headersearch').shadowRoot.querySelector('#typeahead').shadowRoot.querySelector('#itemLabel')");
        executor.executeScript("arguments[0].value='"+product+"';", searchProduct);
        executor.executeScript("arguments[0].click();", searchProduct);
        KeywordUtil.delay(2000);
        Actions action = new Actions(KeywordUtil.getDriver());
        action.sendKeys(Keys.ENTER).build().perform();
        KeywordUtil.delay(5000);
        RunCukesTest.logger.log(LogStatus.PASS,
                HTMLReportUtil.passStringGreenColor(" <font color='green'>click on search and enter your product</font> "));

        //click on search icon button using JS path
        WebElement searchIcon = KeywordUtil.excuteJavaScriptExecutorScripts("return document.querySelector(\"#sbPageContainer\").shadowRoot.querySelector(\"#content > sb-product-lookup\").shadowRoot.querySelector(\"#headersearch\").shadowRoot.querySelector(\"#search\")");
        executor.executeScript("arguments[0].click();", searchIcon);
        KeywordUtil.delay(5000);
        RunCukesTest.logger.log(LogStatus.PASS,
                HTMLReportUtil.passStringGreenColor(" <font color='green'>click on search icon button</font> page"));
        //check first checkbox after searching using JS path
        WebElement checkBox = KeywordUtil.excuteJavaScriptExecutorScripts("return document.querySelector('#sbPageContainer').shadowRoot.querySelector('#content > sb-product-lookup').shadowRoot.querySelector('#lookupLayout').shadowRoot.querySelector('#tableRow').shadowRoot.querySelector('#selection').shadowRoot.querySelector('#g > div > sb-table-cell-select').shadowRoot.querySelector('#checkbox').shadowRoot.querySelector('#checkboxContainer')");
        executor.executeScript("arguments[0].click();", checkBox);
        KeywordUtil.delay(5000);
        RunCukesTest.logger.log(LogStatus.PASS,
                HTMLReportUtil.passStringGreenColor(" <font color='green'>check first checkbox after searching</font> page"));

        //select product using JS path
        WebElement select = KeywordUtil.excuteJavaScriptExecutorScripts("return document.querySelector('#sbPageContainer').shadowRoot.querySelector('#content > sb-product-lookup').shadowRoot.querySelector('#plSelect')");
        executor.executeScript("arguments[0].click();",select);
        KeywordUtil.delay(8000);
        RunCukesTest.logger.log(LogStatus.PASS,
                HTMLReportUtil.passStringGreenColor(" <font color='green'>select product</font> page"));

        //clicking save button using JS path
        WebElement save = KeywordUtil.excuteJavaScriptExecutorScripts("return document.querySelector('#sbPageContainer').shadowRoot.querySelector('#content > sb-line-editor').shadowRoot.querySelector('#actions > sb-custom-action:nth-child(13)').shadowRoot.querySelector('#mainButton')");
        executor.executeScript("arguments[0].click();",save);
        RunCukesTest.logger.log(LogStatus.PASS,
                HTMLReportUtil.passStringGreenColor(" <font color='green'>clicked save button</font> page"));

        //switching back to parent frame
        KeywordUtil.getDriver().switchTo().parentFrame();
    }

    /**
     * Navigate to Opportunity
     *
     * @param logStep the log
     */
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

    /**
     * Change status of quote
     *
     * @param logStep the log
     * @param type the type
     */
    public static void changeStatus(String type, String logStep){
        boolean flag = false;
        try {
            KeywordUtil.waitForVisible(QuoteObject.statusButton);
            KeywordUtil.click(QuoteObject.statusButton, logStep);
        }catch (Exception e){
            WebElement element1 = KeywordUtil.getDriver().findElement(QuoteObject.statusButton);
            JavascriptExecutor executor = (JavascriptExecutor) KeywordUtil.getDriver();
            executor.executeScript("arguments[0].click();", element1);
        }
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

    /**
     * Change status to approve and go to opportunity
     *
     * @param logStep the log
     *
     */
    public static void changeQuoteStatusAndGoToOpportunity(String logStep) throws Exception {
        KeywordUtil.waitForVisible(QuoteObject.quoteConnected);
        WebElement quote = KeywordUtil.getDriver().findElement(QuoteObject.quoteConnected);
        JavascriptExecutor executor = (JavascriptExecutor)KeywordUtil.getDriver();
        executor.executeScript("arguments[0].click();", quote);

        KeywordUtil.waitForVisible(QuoteObject.editButton);
        KeywordUtil.click(QuoteObject.editButton, "Edit button clicked");

        changeStatus("Approved", logStep);
        checkOrdered("Ordered checkbox checked");
        KeywordUtil.delay(2000);
        clickSaveButton("save button clocked");

        KeywordUtil.delay(5000);
        KeywordUtil.waitForVisible(QuoteObject.opportunityAfterQuote);
        WebElement Opportunity = KeywordUtil.getDriver().findElement(QuoteObject.opportunityAfterQuote);
        executor.executeScript("arguments[0].click();", Opportunity);
    }

    /**
     * Navigate to quote and create order
     *
     * @param logStep the log
     *
     */
    public static void goToQuoteAndCreateOrder(String logStep) throws InterruptedException {
        KeywordUtil.waitForVisible(QuoteObject.quoteConnected);
        WebElement quote = KeywordUtil.getDriver().findElement(QuoteObject.quoteConnected);
        JavascriptExecutor executor = (JavascriptExecutor)KeywordUtil.getDriver();
        executor.executeScript("arguments[0].click();", quote);

        KeywordUtil.waitForVisible(QuoteObject.orders);
        KeywordUtil.click(QuoteObject.orders, "Order button clicked");

        KeywordUtil.delay(3000);

        KeywordUtil.waitForClickable(QuoteObject.openOrder);
        WebElement order = KeywordUtil.getDriver().findElement(QuoteObject.openOrder);
        executor.executeScript("arguments[0].click();", order);
    }

    /**
     * Activating order
     *
     */
    public static void activateOrder() throws InterruptedException {

        KeywordUtil.waitForVisible(QuoteObject.activatedTab);
        WebElement quote = KeywordUtil.getDriver().findElement(QuoteObject.activatedTab);
        JavascriptExecutor executor = (JavascriptExecutor)KeywordUtil.getDriver();
        executor.executeScript("arguments[0].click();", quote);

        try {
            KeywordUtil.waitForVisible(QuoteObject.markCurrentStatus);
            KeywordUtil.click(QuoteObject.markCurrentStatus, "Activated status Marked");
        }catch (Exception e){
            WebElement markStatus = KeywordUtil.getDriver().findElement(QuoteObject.markCurrentStatus);
            executor.executeScript("arguments[0].click();", markStatus);
        }
    }


    /**
     * Click edit lines and add discount
     *
     */
    public static void addDiscountProduct() throws InterruptedException {
        clickEditLines("Edit Lines clicked");
        enterDiscount("5","2FAUSBKEY","Entered discount");
    }
    /**
     * Click edit lines and add discount
     */
    public static void addDiscountProductForLeads() throws InterruptedException {
        clickEditLines("Edit Lines clicked");
        enterDiscount("5","2FAUSBKEY","Entered discount");
    }

    /**
     * Create new quote combining all methods
     * @param name,opportunityName the log
     *
     */
    public static void createNewQuote(String name, String opportunityName, String type) throws Exception {
        clickQuoteButton("Navigated to quote");
        newButtonQuote("Clicked new button");
        checkPrimary("primary checkbox marked");
        selectOpportunity(opportunityName,opportunityName+" entered opportunities name");
        selectAccount(name,name+" entered account name");
        selectType(type,"selected type");
        clickSaveButton("clicked save button");
        addDiscountProduct();
    }
    /**
     * Selecting Opportunity and type and click on save button
     *
     * @param opportunityName the account name
     */
    public static void createNewQuotes(String opportunityName) throws Exception {
        selectOpportunityForLeads(opportunityName,opportunityName+" entered opportunities name");
        checkPrimary("primary checkbox marked");
        clickSaveButton("clicked save button");
    }
    /**
     * Verifying Product Titile
     */
    public static void verifyProductTitle(){
       String  productTitle=KeywordUtil.getElementText(QuoteObject.quoteTitle);
       boolean productTit=KeywordUtil.isWebElementVisible(QuoteObject.quoteTitle,"");
       if (productTit){
         RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor("verify Product Title"+productTitle));
          }
       else {
           RunCukesTest.logger.log(LogStatus.FAIL, HTMLReportUtil.failStringRedColor("Title not displayed"+productTitle));

       }
    }
    /**
     * click Quote Number in Quote Tab.
     *
     * @param logStep the log
     */
    public static void clickQuoteNumber(String logStep) throws InterruptedException {
       try {
           KeywordUtil.delay(4000);
           KeywordUtil.isWebElementVisible(QuoteObject.quoteNumber,"Quote Number displayed");
           KeywordUtil.click(QuoteObject.quoteNumber,"Clicked on Quotenumber");
       }
       catch (Exception e){
           KeywordUtil.delay(4000);
           KeywordUtil.isWebElementVisible(QuoteObject.quoteNumber,"");
           WebElement element = KeywordUtil.getDriver().findElement(QuoteObject.quoteNumber);
           JavascriptExecutor executor = (JavascriptExecutor) KeywordUtil.getDriver();
           executor.executeScript("arguments[0].click();", element);

       }
    }
    /**
     * click Quote Number in Quote Tab.
     *
     * @param logStep the log
     */
    public static void clickQuoteNumberFromQuote(String logStep) throws InterruptedException {
        KeywordUtil.delay(4000);
        WebElement element = KeywordUtil.getDriver().findElement(QuoteObject.quoteNumberFromQuote);
        JavascriptExecutor executor = (JavascriptExecutor)KeywordUtil.getDriver();
        executor.executeScript("arguments[0].click();", element);
    }

    /**
     * click on Quote Edit Status.
     *
     * @param logStep the log
     */
    public static void clickOnEditStatus(String type,String logStep) throws InterruptedException {
        try {
            KeywordUtil.delay(3000);
            KeywordUtil.isWebElementVisible(QuoteObject.changeEditStatus, "Edit icon displayed");
            KeywordUtil.click(QuoteObject.changeEditStatus,"Clicked on EditStatus");
            KeywordUtil.delay(1000);
            KeywordUtil.isWebElementVisible(QuoteObject.clickOnStatus, "Status displayed");
            KeywordUtil.scrollElementIntoViewUsingActions(QuoteObject.clickOnStatus);
            KeywordUtil.clickJS(QuoteObject.clickOnStatus);
            KeywordUtil.delay(2000);
            KeywordUtil.isWebElementVisible(QuoteObject.selectReviewOption,"Review Option Displayed");
            KeywordUtil.scrollElementIntoViewUsingActions(QuoteObject.selectReviewOption);
            KeywordUtil.click(QuoteObject.selectReviewOption, "Select Review Option");
        } catch (Exception e) {
            KeywordUtil.scrollElementIntoViewUsingActions(QuoteObject.changeEditStatus);
            WebElement element = KeywordUtil.getDriver().findElement(QuoteObject.changeEditStatus);
            JavascriptExecutor executor = (JavascriptExecutor) KeywordUtil.getDriver();
            executor.executeScript("arguments[0].click();", element);
            KeywordUtil.clickJS(QuoteObject.clickOnStatus);
            KeywordUtil.click(QuoteObject.selectReviewOption, "Select Review Option");
        }
    }
    /**
     * click on Quote Edit Button.
     *
     * @param logStep the log
     */
    public static void clickOnEdit(String logStep) throws InterruptedException {
        try {
            KeywordUtil.delay(4000);
            KeywordUtil.isWebElementVisible(QuoteObject.quoteEditButton
                    , "Edit button displayed");
            KeywordUtil.clickJS(QuoteObject.quoteEditButton);

          } catch (Exception e) {
            WebElement element = KeywordUtil.getDriver().findElement(QuoteObject.quoteEditButton);
            JavascriptExecutor executor = (JavascriptExecutor) KeywordUtil.getDriver();
            executor.executeScript("arguments[0].click();", element);
             }
    }
    /**
     * Change Review to Approve.
     *
     * @param logStep the log
     */
    public static void clickOnEditStatusReviewToApprove(String type,String logStep) throws InterruptedException {
        try {
            KeywordUtil.delay(3000);
            selectType(type,"selected type");
            KeywordUtil.isWebElementVisible(QuoteObject.clickReviewStatusDropDown,"verified Review Status Dropdown");
            KeywordUtil.clickJS(QuoteObject.clickReviewStatusDropDown);
            KeywordUtil.isWebElementVisible(QuoteObject.selectApproveOption, "verified Approve option");
            KeywordUtil.clickJS(QuoteObject.selectApproveOption);
              }
        catch (Exception e) {
            KeywordUtil.waitForVisible(QuoteObject.selectTypes);
            KeywordUtil.click(QuoteObject.selectTypes,logStep);
            KeywordUtil.pressDown(QuoteObject.clickReviewStatusDropDown);
            WebElement element = KeywordUtil.getDriver().findElement(QuoteObject.clickReviewStatusDropDown);
            JavascriptExecutor executor = (JavascriptExecutor) KeywordUtil.getDriver();
            executor.executeScript("arguments[0].click();", element);
            KeywordUtil.click(QuoteObject.selectApproveOption, "Select Review Option");
        }
    }
    /**
     * verify Approve Status.
     *
     *
     */
    public static void verifyApprovedStatus(){
        String approvedText=KeywordUtil.getVisibleText(QuoteObject.statusApproved);
    if (KeywordUtil.isWebElementVisible(QuoteObject.statusApproved,"Approved status visible")){
        RunCukesTest.logger.log(LogStatus.PASS,HTMLReportUtil.passStringGreenColor("verify Status"+approvedText));
    }
    else{
        RunCukesTest.logger.log(LogStatus.FAIL,"Status is not showing: "+approvedText);
    }
    }
}
