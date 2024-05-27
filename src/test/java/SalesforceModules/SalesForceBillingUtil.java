package SalesforceModules;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import pageobjects.SalesforceObjects.*;
import utilities.KeywordUtil;

import java.security.Key;
import java.util.List;

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
            ((JavascriptExecutor) KeywordUtil.getDriver()).executeScript("window.scrollBy(0, 800)");
            KeywordUtil.waitForVisible(BillingObject.addStandardPrice);
            KeywordUtil.click(BillingObject.addStandardPrice, logstep);
            enterListPrice("230");
    }

    /**
     * Add standard price in price book
     * @param logstep the log
     */
    public static void editStandardPrice(String logstep) throws InterruptedException {

        KeywordUtil.waitForVisible(BillingObject.editViewButtonHolder);

        List<WebElement> elements = KeywordUtil.getDriver().findElements(BillingObject.editViewButtonHolder);

        // Click on the last element
        if (!elements.isEmpty()) {
            WebElement lastElement = elements.get(elements.size() - 1);
            lastElement.click();
        } else {
            System.out.println("No elements found!");
        }

        KeywordUtil.waitForVisible(BillingObject.editButton);
        KeywordUtil.click(BillingObject.editButton, logstep);

        KeywordUtil.waitForVisible(BillingObject.editListPrice);
        KeywordUtil.inputText(BillingObject.editListPrice,"100", logstep);

        clickSaveButton("Saved");
    }

    /**
     * search product with product code
     *
     * @param code the product
     */
    public static void searchProduct(String code){
        KeywordUtil.waitForVisible(BillingObject.searchProduct);
        KeywordUtil.inputText(BillingObject.searchProduct, code,"Product code entered");
        Actions action = new Actions(KeywordUtil.getDriver());
        action.sendKeys(Keys.ENTER).build().perform();
    }

    /**
     * Entering list price in price book
     *
     * @param price the product
     */
    public static void enterListPrice(String price){
        try {
            KeywordUtil.waitForVisible(BillingObject.addListPrice);
            KeywordUtil.inputText(BillingObject.addListPrice, price, "List price entered");
        }catch (Exception e){
            JavascriptExecutor js = (JavascriptExecutor) KeywordUtil.getDriver();
            String zoomJS = "document.body.style.zoom='0.8'";
            js.executeScript(zoomJS);
            KeywordUtil.inputText(BillingObject.addListPrice, price, "List price entered");
            js.executeScript("document.body.style.zoom='1'");
        }
        clickSaveButton("List price saved");
    }


    /**
     * Click on view all link
     * @param logStep
     * @throws InterruptedException
     */
    public static void viewAll(String logStep) throws InterruptedException {
        KeywordUtil.waitForVisible(BillingObject.viewAll);
        KeywordUtil.click(BillingObject.viewAll, logStep);
    }
    /**
     * Clicking on salesforce billing option
     * @param logStep
     * @throws InterruptedException
     */
    public static void salesforceBilling(String logStep) throws InterruptedException {
        KeywordUtil.delay(5000);
        KeywordUtil.scrollingToElementofAPage(BillingObject.salesforceBilling,"Scrolling to the billing");
        KeywordUtil.waitForVisible(BillingObject.salesforceBilling);
        KeywordUtil.click(BillingObject.salesforceBilling, logStep);
    }
    /**
     * select the salutation value from dropdown
     * @param salutation
     * @param logStep
     * @throws InterruptedException
     */
    public static void setSalutationForNewContact(String salutation, String logStep) throws InterruptedException {
        boolean flag = false;
        KeywordUtil.waitForVisible(BillingObject.salutationOfNewContactOnExistAccount);
        KeywordUtil.click(BillingObject.salutationOfNewContactOnExistAccount, logStep);
        String xpath = "//li/a[contains(@title,'" + salutation + "')]";
        KeywordUtil.delay(2000);
        System.out.println(xpath);
        try {
            flag = KeywordUtil.getDriver().findElement(By.xpath(xpath)).isDisplayed();
        } catch (Exception e) {
        }
        if (!flag) {
            Assert.fail("No such salutation is present");
        } else {
            KeywordUtil.click(By.xpath(xpath), "salutation selected");
        }
    }
    /**
     * Creating new customer account
     * @param name
     * @param phone
     * @throws InterruptedException
     */
    public static void createCustomerAccount(String name, String phone) throws InterruptedException {
        KeywordUtil.waitForVisible(AccountObject.accountsTab);
        KeywordUtil.delay(3000);
        AccountUtil.clickAccountsTab("Navigated to accounts");
        AccountUtil.clickNewButton("Clicked new button for accounts");
        AccountUtil.enterAccountName(name, "Entered account name");
        AccountUtil.enterPhoneNumber(phone, "Entered phone number");
        AccountUtil.clickSaveButton("clicked on save button");
    }
    /**
     * creating contact from existing link account
     * @param salutation
     * @param lastname
     * @param email
     * @param phoneNumber
     * @throws InterruptedException
     */
    public static void createContactLinkExisting(String salutation, String lastname, String email, String phoneNumber) throws InterruptedException {
        AccountUtil.clickAccountsTab("Navigated to accounts");
        KeywordUtil.delay(5000);
        KeywordUtil.click(BillingObject.accountNameLink, "Clicked on name link");
        KeywordUtil.delay(3000);
        KeywordUtil.click(BillingObject.newBtnContactsOfAccount, "Clicked on New button of account name contacts");
        ContactUtil.setSalutation(salutation, salutation + "Set Salutation");
        ContactUtil.enterLastContactName(lastname, lastname + " lastname set");
        ContactUtil.enterEmail(email, email + " email entered");
        ContactUtil.enterPhoneContact(phoneNumber, phoneNumber + " phone number entered");
        ContactUtil.clickSaveButton("save button clicked");
        KeywordUtil.delay(3000);
    }
    /***
     * Entering last name of contact
     * @param lastname
     * @param logStep
     */
    public static void enterLastNameOfContact(String lastname, String logStep) {
        KeywordUtil.waitForVisible(BillingObject.lastNameOfNewContactOnExistAccount);
        KeywordUtil.inputText(BillingObject.lastNameOfNewContactOnExistAccount, lastname, logStep);
    }
    /**
     * Entering phone number for contact
     * @param phone
     * @param logStep
     */
    public static void enterPhoneNumberOfContact(String phone, String logStep) {
        KeywordUtil.waitForVisible(BillingObject.phoneNumberOfNewContactOnExistAccount);
        KeywordUtil.inputText(BillingObject.phoneNumberOfNewContactOnExistAccount, phone, logStep);
    }
    /**
     * entering email id for contact
     * @param email
     * @param logStep
     */
    public static void enterEmailOfContact(String email, String logStep){
        KeywordUtil.waitForVisible(BillingObject.emailOfNewContactOnExistAccount);
        if(email.contains("@") && email.contains(".")) {
            KeywordUtil.inputText(BillingObject.emailOfNewContactOnExistAccount, email, logStep);
        }else{
            Assert.fail("invalid email format");
        }
    }
    /**
     * creating another contact from link account existing
     * @param salutation
     * @param lastname
     * @param email
     * @param phoneNumber
     * @throws InterruptedException
     */
    public static void createAnotherContactFromLinkExisting(String salutation, String lastname, String email, String phoneNumber) throws InterruptedException {
        KeywordUtil.waitForVisible(BillingObject.newContactBtnOnExistAccount);
        KeywordUtil.click(BillingObject.newContactBtnOnExistAccount, "Clicked on New Contact button");
        KeywordUtil.delay(3000);
        setSalutationForNewContact(salutation,salutation+"Set Salutation");
        enterLastNameOfContact(lastname,lastname+" lastname entered");
        enterEmailOfContact(email,email+" email entered");
        enterPhoneNumberOfContact(phoneNumber,phoneNumber+" phone number entered");
        KeywordUtil.click(BillingObject.saveButtonOfNewContact,"Clicked on save button");
    }
    /**
     * Clicking on New button
     * @param logStep
     * @throws InterruptedException
     */
    public static void newButtonOfContactsTab(String logStep) throws InterruptedException {
        KeywordUtil.delay(3000);
        KeywordUtil.waitForVisible(BillingObject.newBtnOfContactsTab);
        KeywordUtil.click(BillingObject.newBtnOfContactsTab,logStep);
    }
    /**
     * Creating New contacts By creating new Account
     * @param salutation
     * @param name
     * @param accountName_ss
     * @param phoneNumber_ss
     * @throws InterruptedException
     */
    public static void createNewContactOfContacts(String salutation, String name, String accountName_ss, String phoneNumber_ss) throws InterruptedException {
        ContactUtil.clickContactButton("Click on Contact Tab");
        KeywordUtil.delay(3000);
        newButtonOfContactsTab("Clicked on New button after clicked on Contacts tab");
        KeywordUtil.delay(3000);
        ContactUtil.setSalutation(salutation, salutation + "Set Salutation");
        ContactUtil.enterLastContactName(name, "Entered last name");
        KeywordUtil.scrollingToElementofAPage(ServiceSupportObject.searchAccountsForAccountName,"scrolling down for Accounts Search");
        KeywordUtil.waitForVisible(ServiceSupportObject.searchAccountsForAccountName);
        KeywordUtil.click(ServiceSupportObject.searchAccountsForAccountName, "Click on search accounts");
        KeywordUtil.delay(3000);
        KeywordUtil.waitForVisible(ServiceSupportObject.newAccountOption);
        KeywordUtil.click(ServiceSupportObject.newAccountOption, "Click on New Account option");
        KeywordUtil.delay(3000);
        CasesUtil.enterAccountNameForServiceSupport(accountName_ss, "Entered Account Name");
        CasesUtil.enterPhoneNumberForServiceSupport(phoneNumber_ss, "Entered Phone Number");
        CasesUtil.saveBtnOfNewAccount_ss("clicked save button");
        ContactUtil.clickSaveButton("Clicked on Save button");
    }

    /**
     * Setting the caseEditOrgin
     * @param origin
     * @param logStep
     * @throws InterruptedException
     */

    public static void setCaseEditOrigin(String origin, String logStep) throws InterruptedException {
        boolean flag = false;
        KeywordUtil.waitForVisible(BillingObject.editOrigin);
        KeywordUtil.click(BillingObject.editOrigin,logStep);
        KeywordUtil.delay(2000);
        String xpath = "//lightning-base-combobox-item[contains(@data-value,'"+origin+"')]";
        try{
            flag = KeywordUtil.getDriver().findElement(By.xpath(xpath)).isDisplayed();
        }catch (Exception e){}
        if(!flag){
            Assert.fail("No such case origin is present");
        }else {
            KeywordUtil.click(By.xpath(xpath), "case origin selected");
        }
    }

    /**
     * Clicking new button on Cases
     * @param logStep
     * @throws InterruptedException
     */
    public static void clickOnNewBtnOfCases(String logStep) throws InterruptedException {
        KeywordUtil.delay(2000);
        KeywordUtil.scrollingToElementofAPage(BillingObject.newBtnOfCases,"Scrolling to the case");
        KeywordUtil.waitForVisible(BillingObject.newBtnOfCases);
        KeywordUtil.click(BillingObject.newBtnOfCases, logStep);
    }

    /**
     * Create new case
     * @param logStep
     * @throws InterruptedException
     */
    public static void createNewCase(String origin, String logStep) throws InterruptedException {
        clickOnNewBtnOfCases("Clicked on New button of cases");
        KeywordUtil.delay(2000);
        CasesUtil.setCaseOrigin(origin, "Case origin value selected");
        CasesUtil.clickSaveButton("Click on save button");
    }

    /**
     * Click on DropDown
     * @param logStep
     * @throws InterruptedException
     */
    public static void clickOnDropdown(String logStep) throws InterruptedException {
        KeywordUtil.scrollingToElementofAPage(BillingObject.dropdownOfCases,"Scrolling to the dropdown");
        KeywordUtil.waitForVisible(BillingObject.dropdownOfCases);
        KeywordUtil.click(BillingObject.dropdownOfCases, logStep);
        KeywordUtil.delay(3000);
    }

    /**
     * Click on Edit Option
     * @param logStep
     * @throws InterruptedException
     */
    public static void clickOnEditOption(String logStep) throws InterruptedException {
        KeywordUtil.waitForVisible(BillingObject.dropdownEditOption);
        KeywordUtil.clickJS(BillingObject.dropdownEditOption, logStep);
        KeywordUtil.delay(2000);
    }

    /**
     * Click on Delete Option
     * @param logStep
     * @throws InterruptedException
     */
    public static void clickOnDeleteOption(String logStep) throws InterruptedException {
        KeywordUtil.waitForVisible(BillingObject.dropdownDeleteOption);
        KeywordUtil.clickJS(BillingObject.dropdownDeleteOption, logStep);
        KeywordUtil.delay(2000);
    }

    /**
     * Edit Create New case
     * @param origin
     * @throws InterruptedException
     */
    public static void editCreatedNewCase(String origin) throws InterruptedException {
        clickOnDropdown("Click on dropdown");
        clickOnEditOption("Click on edit option");
        KeywordUtil.scrollingToElementofAPage(BillingObject.editOrigin,"Scroll till origin");
        setCaseEditOrigin(origin, "Other value of case origin is selected");
        CasesUtil.clickSaveButton("Click on save button");
    }

    /**
     * Input the webCompany
     * @param company the Company
     * @param logStep the logStep
     * @throws InterruptedException
     */
    public static void webCompany(String company, String logStep) throws InterruptedException {
        KeywordUtil.waitForVisible(BillingObject.webCompany);
        KeywordUtil.inputText(BillingObject.webCompany, company, logStep);
    }

    /**
     * UpdateCreate New Case
     * @param Company the Company
     *
     * @throws InterruptedException
     */
    public static void updateCreatedNewCase(String Company) throws InterruptedException{
        clickOnDropdown("Click on dropdown");
        clickOnEditOption("Click on edit option");
        webCompany(Company,"Enter web company value");
        CasesUtil.clickSaveButton("Click on save button");
    }

    /**
     * Delete the Created case
     *
     * @param logStep the logStep
     * @throws InterruptedException
     */
    public static void deleteCreatedNewCase(String logStep) throws InterruptedException{
        clickOnDropdown("Click on dropdown");
        KeywordUtil.clickJS_component(BillingObject.caseDropDown,"");
        clickOnDeleteOption("Click on delete option");
    }

}



