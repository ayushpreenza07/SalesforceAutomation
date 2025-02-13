package utilities;

import com.google.common.base.Function;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.MobileBy;
import org.apache.commons.compress.utils.IOUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.DriverFactory;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import pageobjects.SalesforceObjects.QuoteObject;
import step_definitions.RunCukesTest;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


import static utilities.GlobalUtil.getDriver;

/**
 * The type Keyword util.
 *
 * @author TX
 */
public class KeywordUtil extends GlobalUtil {
    private static final long DEFAULT_WAIT_MORE_SECONDS =10 ;
    /**
     * The constant cucumberTagName.
     */
    public static String cucumberTagName;
    private static final int DEFAULT_WAIT_SECONDS = 40;
    /**
     * The constant FAIL.
     */
    protected static final int FAIL = 0;
    /**
     * The Web element.
     */
    static WebElement webElement;
    /**
     * The constant url.
     */
    protected static String url = "";
    private static final String userDir = "user.dir";
    @SuppressWarnings("unused")
    private static final String text = "";
    /**
     * The constant VALUE.
     */
    public static final String VALUE = "value";
    /**
     * The constant lastAction.
     */
    public static String lastAction = "";

    /**
     * The Result folder name.
     */
    static String result_FolderName = System.getProperty("user.dir") + "ExecutionReports\\HTMLReports";
    /**
     * The Rt.
     */
    static Runtime rt = Runtime.getRuntime();



    /**
     * On execution finish.
     */
    public static void onExecutionFinish() {

        // Send Mail functionality if
        LogUtil.infoLog(KeywordUtil.class, "Test process has ended");

        String htmlReportFile = System.getProperty("user.dir") + "\\" + ConfigReader.getValue("HtmlReportFullPath");
        LogUtil.infoLog(KeywordUtil.class, "cucumber path is" + htmlReportFile);
        File f = new File(htmlReportFile);
        if (f.exists()) {
            try {
                rt.exec("rundll32 url.dll,FileProtocolHandler " + htmlReportFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String htmlExtentReportFile = System.getProperty("user.dir") + File.separator + "ExecutionReports"
                + File.separator + "HTMLReportsBackup" + File.separator + RunCukesTest.tagName + ".html";
        LogUtil.infoLog(KeywordUtil.class, "Extent Report File path is  " + htmlExtentReportFile);
        File extentReport = new File(htmlExtentReportFile);
        if (extentReport.exists()) {

            try {
                rt.exec("rundll32 url.dll,FileProtocolHandler " + htmlExtentReportFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Take screenshot byte [ ].
     *
     * @param screenshotFilePath the screenshot file path
     * @return the byte [ ]
     */
    public static byte[] takeScreenshot(String screenshotFilePath) {
        try {
            byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
            FileOutputStream fileOuputStream = new FileOutputStream(screenshotFilePath);
            fileOuputStream.write(screenshot);
            fileOuputStream.close();
            return screenshot;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Scrolling to elementof a page boolean.
     *
     * @param locator the locator
     * @param logStep the log step
     * @return the boolean
     * @throws InterruptedException the interrupted exception
     */
    public static boolean scrollingToElementofAPage(By locator, String logStep) throws InterruptedException {
        Thread.sleep(5000);
        WebElement element = getDriver().findElement(locator);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView();", element);
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(logStep));

        return true;
    }

    /**
     * Scroll down as per coordinates
     *
     * @throws InterruptedException the interrupted exception
     */

    public static void scrollDown() {
        ((JavascriptExecutor) getDriver()).executeScript("window.scrollBy(0, 350)");
    }

    /**
     * Gets current date time.
     *
     * @return the current date time
     */
    public static String getCurrentDateTime() {

        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyyMMddHHmmss");
        Date now = new Date();
        String strDate = sdfDate.format(now);
        LogUtil.infoLog(KeywordUtil.class, strDate);
        return strDate;
    }

    /**
     * Navigate to url.
     *
     * @param url the url
     * @return
     */
    public static void navigateToUrl(String url) {
        try {
            KeywordUtil.lastAction = "Navigate to: " + url;
            LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
            getDriver().get(url);
            String Pagetitle = getDriver().getTitle();
            LogUtil.infoLog(KeywordUtil.class, Pagetitle);
            if (Pagetitle.contains("Robot Check")) {
                getDriver().get(url);
            }

        } catch (Exception e) {
        }
    }

    /**
     * Gets current url.
     *
     * @return the current url
     */
    public static String getCurrentUrl() {
        return getDriver().getCurrentUrl();
    }

    /**
     * Wait for clickable web element.
     *
     * @param locator the locator
     * @return the web element
     */
    public static WebElement waitForClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(getDriver(), DEFAULT_WAIT_SECONDS);
        wait.ignoring(ElementNotVisibleException.class);
        wait.ignoring(WebDriverException.class);

        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    /**
     * Wait for present web element.
     *
     * @param locator the locator
     * @return web element
     */
    public static WebElement waitForPresent(By locator) {
        WebDriverWait wait = new WebDriverWait(getDriver(), DEFAULT_WAIT_SECONDS);
        wait.ignoring(ElementNotVisibleException.class);
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    /**
     * Wait for visible web element.
     *
     * @param locator the locator
     * @return web element
     */
    public static WebElement waitForVisible(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), DEFAULT_WAIT_SECONDS);
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
            return null;
        }
    }


    /**
     * Wait for in visibile boolean.
     *
     * @param locator the locator
     * @return the boolean
     */
    public static boolean waitForInVisibile(By locator) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    /**
     * click JS useable method
     *
     * @param logStep the log
     */
    public static void clickJS_component(By locator, String logStep) throws InterruptedException {
        KeywordUtil.delay(10000);
        KeywordUtil.lastAction = "Double click: " + locator.toString();
        LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
        WebElement element = getDriver().findElement(locator);
        JavascriptExecutor executor = (JavascriptExecutor) KeywordUtil.getDriver();
        executor.executeScript("arguments[0].click();", element);
    }



    /**
     * Wait for visible ignore stale element web element.
     *
     * @param locator the locator
     * @return the web element
     */
    public static WebElement waitForVisibleIgnoreStaleElement(By locator) {
        WebDriverWait wait = new WebDriverWait(getDriver(), DEFAULT_WAIT_SECONDS);
        wait.ignoring(StaleElementReferenceException.class);
        wait.ignoring(ElementNotVisibleException.class);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Find with fluint wait web element.
     *
     * @param locator    the locator
     * @param seconds    the seconds
     * @param poolingMil the pooling mil
     * @return web element
     * @throws Exception the exception
     */
    @SuppressWarnings("deprecation")
    public static WebElement findWithFluintWait(final By locator, int seconds, int poolingMil) throws Exception {
        // Because if implicit wait is set then fluint wait will not work

        getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
        WebElement element = null;
        try {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver()).withTimeout(seconds, TimeUnit.SECONDS)
                    .pollingEvery(poolingMil, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class)
                    .ignoring(StaleElementReferenceException.class).ignoring(ElementNotVisibleException.class)
                    .ignoring(WebDriverException.class);
            element = wait.until(new Function<WebDriver, WebElement>() {
                @Override
                public WebElement apply(WebDriver driver) {
                    return driver.findElement(locator);
                }
            });

        } catch (Exception t) {
            throw new Exception("Timeout reached when searching for element! Time: " + seconds + " seconds " + "\n"
                    + t.getMessage());
        } finally {
        }

        return element;
    }// End FindWithWait()

    /**
     * Find with fluint wait web element.
     *
     * @param locator the locator
     * @return web element
     * @throws Exception the exception
     */
    @SuppressWarnings("deprecation")
    public static WebElement findWithFluintWait(final By locator) throws Exception {
        getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
        // Because if implict wait is set then fluint wait will not work
        KeywordUtil.lastAction = "Find Element: " + locator.toString();
        WebElement element = null;

        try {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver())
                    .withTimeout(DEFAULT_WAIT_SECONDS, TimeUnit.SECONDS).pollingEvery(200, TimeUnit.MILLISECONDS)
                    .ignoring(NoSuchElementException.class).ignoring(StaleElementReferenceException.class)
                    .ignoring(ElementNotVisibleException.class);

            element = wait.until(new Function<WebDriver, WebElement>() {
                @Override
                public WebElement apply(WebDriver driver) {
                    return driver.findElement(locator);
                }
            });

        } catch (Exception t) {
            throw new Exception("Timeout reached when searching for element! Time: " + DEFAULT_WAIT_SECONDS
                    + " seconds " + "\n" + t.getMessage());
        } finally {
        }

        return element;
    }// End FindWithWait()

    /**
     * Gets web element.
     *
     * @param locator the locator
     * @return the web element
     * @throws Exception the exception
     */
    public static WebElement getWebElement(By locator) throws Exception {
        KeywordUtil.lastAction = "Find Element: " + locator.toString();
        LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
        return findWithFluintWait(locator);
    }
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    /*
     * Web driver common functions
     * ===========================================================
     */

    /**
     * Click boolean.
     *
     * @param locator the locator
     * @param logStep the log step
     * @return boolean
     */
    public static boolean click(By locator, String logStep) {

        WebDriverWait wait = new WebDriverWait(getDriver(), 20);
        wait.until(ExpectedConditions.elementToBeClickable(locator)).isDisplayed();

        KeywordUtil.lastAction = "Click: " + locator.toString();
        LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
        WebElement elm = waitForClickable(locator);
        if (elm == null) {
            return false;
        } else {
            elm.click();
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(logStep));

            return true;
        }
    }


    /**
     * Click cart boolean.
     *
     * @param locator the locator
     * @param logStep the log step
     * @return the boolean
     */
// ............
    public static boolean clickCart(By locator, String logStep) {

        KeywordUtil.lastAction = "Click: " + locator.toString();
        LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
        WebElement elm = waitForClickable(locator);
        if (elm == null) {
            return false;
        } else {

            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView();", elm);
            elm.click();
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(logStep));

            return true;
        }
    }

    // ....

    /**
     * Accept alert boolean.
     *
     * @return the boolean
     */
    public static boolean acceptAlert() {

        Alert alert = getDriver().switchTo().alert();
        alert.accept();
        return true;

    }

    /**
     * Switch to window boolean.
     *
     * @return
     */
// ......
    public static boolean switchToWindow() {

        ArrayList<String> tabs2 = new ArrayList<String>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs2.get(1));
        return true;
    }
    // ....

    /**
     * Click link boolean.
     *
     * @param linkText the link text
     * @param logStep  the log step
     * @return boolean
     */
    public static boolean clickLink(String linkText, String logStep) {
        KeywordUtil.lastAction = "Click Link: " + linkText;
        LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
        WebElement elm = waitForClickable(By.linkText(linkText));
        if (elm == null) {
            return false;
        } else {
            elm.click();
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(logStep));

            return true;
        }
    }

    /**
     * Gets element text.
     *
     * @param locator the locator
     * @return element text
     */
    public static String getElementText(By locator) {
        KeywordUtil.lastAction = "Get Element text: " + locator.toString();
        LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
        WebElement elm = waitForClickable(locator);
        return elm.getText().trim();
    }

    /**
     * Gets image title.
     *
     * @param locator the locator
     * @return the image title
     */
    public static String getImageTitle(By locator) {
        WebElement elm = waitForVisible(locator);
        return elm.getAttribute("title");

    }

    /**
     * Is web element visible boolean.
     *
     * @param locator the locator
     * @param logStep the log step
     * @return boolean
     */
    public static boolean isWebElementVisible(By locator, String logStep) {
        try {
            KeywordUtil.lastAction = "Check Element visible: " + locator.toString();
            LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
            WebElement elm = waitForVisible(locator);
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(logStep));

            return elm.isDisplayed();
        } catch (Exception e) {
            return false;
        }

    }

    /**
     * Is web element displayed
     *
     * @param element the element
     * @param logStep the log step
     * @return boolean
     */
    public static boolean isElementDisplayed(String element, String logStep) {
        try {
            KeywordUtil.lastAction = "Check Element visible: " + element;
            getDriver().findElement(By.xpath(element));
            LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(logStep));

            return  getDriver().findElement(By.xpath(element)).isDisplayed();
        } catch (Exception e) {
            return false;
        }

    }


    /**
     * Is web element enable boolean.
     *
     * @param locator the locator
     * @param logStep the log step
     * @return the boolean
     */
    public static boolean isWebElementEnable(By locator, String logStep) {
        KeywordUtil.lastAction = "Check Element visible: " + locator.toString();
        LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
        WebElement elm = waitForVisible(locator);
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(logStep));

        return elm.isEnabled();
    }

    /**
     * Gets list elements.
     *
     * @param locator the locator
     * @param logStep the log step
     * @return list elements
     */
    public static List<WebElement> getListElements(By locator, String logStep) {
        KeywordUtil.lastAction = "Get List of Elements: " + locator.toString();
        LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);

        try {
            findWithFluintWait(locator, 60, 300);
        } catch (Exception e) {
            e.printStackTrace();
        }
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(logStep));

        return getDriver().findElements(locator);

    }

    /**
     * Is web element present boolean.
     *
     * @param locator the locator
     * @param logStep the log step
     * @return the boolean
     */
    public static boolean isWebElementPresent(By locator, String logStep) {

        KeywordUtil.lastAction = "Check Element present: " + locator.toString();
        LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
        List<WebElement> elements = getDriver().findElements(locator);
        if (elements.isEmpty()) {
            RunCukesTest.logger.log(LogStatus.FAIL, HTMLReportUtil.failStringRedColor(logStep));
            return false;
        }
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(logStep));

        return true;
    }

    /**
     * Hover on element boolean.
     *
     * @param by the by
     * @return the boolean
     * @throws InterruptedException the interrupted exception
     */
    public static boolean hoverOnElement(By by) throws InterruptedException {

        WebElement element = getDriver().findElement(by);
        Actions act = new Actions(getDriver());
        act.moveToElement(element).build().perform();

        Thread.sleep(3000);

        return true;

    }

    /**
     * Is web element not present boolean.
     *
     * @param locator the locator
     * @return boolean
     */
    public static boolean isWebElementNotPresent(By locator) {
        KeywordUtil.lastAction = "Check Element not present: " + locator.toString();
        LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
        List<WebElement> elements = (new WebDriverWait(getDriver(), DEFAULT_WAIT_SECONDS))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));

        return elements.isEmpty();
    }

    /**
     * Input text boolean.
     *
     * @param locator the locator
     * @param data    the data
     * @param logStep the log step
     * @return boolean
     */
    public static boolean inputText(By locator, String data, String logStep) {
        KeywordUtil.lastAction = "Input Text: " + data + " - " + locator.toString();
        LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
        WebElement elm = waitForVisible(locator);
        if (elm == null) {
            return false;
        } else {
            elm.clear();
            elm.sendKeys(data);
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(logStep));
            return true;
        }
    }


    /**
     * Press tab key.
     *
     * @param locator the locator
     */
    public static void pressTabKey(By locator) {
        WebElement elm = waitForVisible(locator);
        elm.sendKeys(Keys.TAB);
    }

    /**
     * Press enter.
     *
     * @param locator the locator
     */
    public static void pressEnter(By locator) {
        WebElement elm = waitForVisible(locator);
        elm.sendKeys(Keys.ENTER);
    }
    /**
     * Press Down.
     *
     * @param locator the locator
     */
    public static void pressDown(By locator) {
        WebElement elm = waitForVisible(locator);
        elm.sendKeys(Keys.PAGE_DOWN);
    }

    /**
     * Input text js boolean.
     *
     * @param locator the locator
     * @param data    the data
     * @param logStep the log step
     * @return boolean
     */
    public static boolean inputTextJS(By locator, String data, String logStep) {
        KeywordUtil.lastAction = "Input Text: " + data + " - " + locator.toString();
        LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
        WebElement element = waitForVisible(locator);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].value = arguments[1]", element, data);
        if (element.getText().equalsIgnoreCase(data)) {
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(logStep));

            return true;
        } else
            return false;
    }

    /**
     * Is radio selected boolean.
     *
     * @param locator the locator
     * @param logStep the log step
     * @return boolean
     */
    public static boolean isRadioSelected(By locator, String logStep) {
        KeywordUtil.lastAction = "Is Radio Selected: " + locator.toString();
        LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
        WebElement element = waitForVisible(locator);
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(logStep));

        return element.isSelected();
    }

    /**
     * Is radio not selected boolean.
     *
     * @param locator the locator
     * @param logStep the log step
     * @return boolean
     */
    public static boolean isRadioNotSelected(By locator, String logStep) {
        KeywordUtil.lastAction = "Is Radio Not Selected: " + locator.toString();
        LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
        boolean check = isRadioSelected(locator, logStep);
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(logStep));

        return (!check);
    }

    /**
     * Clear input boolean.
     *
     * @param locator the locator
     * @return boolean
     */
    public static boolean clearInput(By locator) {
        WebElement element = waitForVisible(locator);
        element.clear();
        element = waitForVisible(locator);
        return element.getAttribute(VALUE).isEmpty();
    }

    /**
     * Verify css property boolean.
     *
     * @param locator the locator
     * @param data    the data
     * @param logStep the log step
     * @return boolean
     */
    public static boolean verifyCssProperty(By locator, String data, String logStep) {
        KeywordUtil.lastAction = "Verify CSS : " + data + " - " + locator.toString();
        LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);

        String[] property = data.split(":", 2);
        String expProp = property[0];
        String expValue = property[1];
        boolean flag = false;
        String prop = (waitForPresent(locator)).getCssValue(expProp);
        if (prop.trim().equals(expValue.trim())) {
            flag = true;
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(logStep));

            return flag;
        } else {
            return flag;
        }
    }

    public static WebElement excuteJavaScriptExecutorScripts(String script) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            //code to enter value in the email textbox
            WebElement ele = (WebElement) js.executeScript(script);
//			LogUtil.infoLog(CommonUtil.class, lastAction);
//			ExtentTestManager.getTest().log(Status.PASS, HTMLReportUtil.passStringGreenColor(lastAction));
            return ele;
        } catch (Throwable e) {
            lastAction = "Unable to execute the script for " + text;
//			LogUtil.infoLog(CommonUtil.class, lastAction+" "+e.getMessage());

            Assert.fail(lastAction, e);
            return null;
        }

    }

    /**
     * Verify input text boolean.
     *
     * @param locator the locator
     * @param data    the data
     * @param logStep the log step
     * @return boolean
     */
    public static boolean verifyInputText(By locator, String data, String logStep) {
        KeywordUtil.lastAction = "Verify Input Expected Text: " + data + " - " + locator.toString();
        LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
        WebElement element = waitForVisible(locator);
        String actual = element.getAttribute(VALUE);
        LogUtil.infoLog(KeywordUtil.class, "Actual:" + actual);
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(logStep));

        return actual.equalsIgnoreCase(data);

    }

    /**
     * Verify input text js boolean.
     *
     * @param locator the locator
     * @param data    the data
     * @param logStep the log step
     * @return boolean
     */
    public static boolean verifyInputTextJS(By locator, String data, String logStep) {
        KeywordUtil.lastAction = "Verify Input Expected Text: " + data + " - " + locator.toString();
        LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
        WebElement element = waitForVisible(locator);

        String message = String.format("Verified text expected \"%s\" actual \"%s\" ", data, element.getText());
        LogUtil.infoLog(KeywordUtil.class, message);
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(logStep));

        return data.equalsIgnoreCase(element.getText());
    }

    /**
     * <h1>Log results</h1>
     * <p>
     * This function will write results to the log file.
     * </p>
     *
     * @param locator
     * @param data
     * @return
     */
    /**
     * Verify text boolean.
     *
     * @param locator the locator
     * @param data    the data
     * @param logStep the log step
     * @return boolean
     */
    public static boolean verifyText(By locator, String data, String logStep) {
        KeywordUtil.lastAction = "Verify Expected Text: " + data + " - " + locator.toString();
        LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
        WebElement element = waitForVisible(locator);
        String message = String.format("Verified text expected \"%s\" actual \"%s\" ", data, element.getText());
        LogUtil.infoLog(KeywordUtil.class, message);
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(logStep));

        return element.getText().equalsIgnoreCase(data);
    }


    /**
     * Verify text contains boolean.
     *
     * @param locator the locator
     * @param data    the data
     * @param logStep the log step
     * @return the boolean
     */
    public static boolean verifyTextContains(By locator, String data, String logStep) {
        KeywordUtil.lastAction = "Verify Text Contains: " + data + " - " + locator.toString();
        LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
        WebElement element = waitForVisible(locator);
        String message = String.format("Verified text expected \"%s\" actual \"%s\" ", data, element.getText());
        LogUtil.infoLog(KeywordUtil.class, message);
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(logStep));

        return element.getText().toUpperCase().contains(data.toUpperCase());

    }

    /**
     * Verify display and enable boolean.
     *
     * @param locator the locator
     * @param logStep the log step
     * @return boolean
     */
    public static boolean verifyDisplayAndEnable(By locator, String logStep) {
        KeywordUtil.lastAction = "Is Element Displayed and Enable : " + locator.toString();
        LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
        WebElement element = waitForVisible(locator);
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(logStep));
        return element.isDisplayed() && element.isEnabled();
    }

    /**
     * Click js boolean.
     *
     * @param locator the locator
     * @param logStep the log step
     * @return boolean
     */
    public static boolean clickJS(By locator, String logStep) {
        KeywordUtil.lastAction = "Click : " + locator.toString();
        LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
        WebElement element = waitForVisible(locator);
        Object obj = ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", element);
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(logStep));

        return obj == null;
    }
    /**
     * Using clickJS for identifying the Webelement and click the element using JavaScript
     * @param locator
     * @return
     */
    public static boolean clickJS(By locator) {
        WebElement element = KeywordUtil.getDriver().findElement(locator);
        Object obj = ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", element);
        return obj == null;
    }
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    /*
     * Handling selects ===========================================================
     */

    /**
     * Select by index boolean.
     *
     * @param locator the locator
     * @param index   the index
     * @param logStep the log step
     * @return boolean
     */
    public static boolean selectByIndex(By locator, int index, String logStep) {
        KeywordUtil.lastAction = "Select dropdown by index : " + index + " - " + locator.toString();
        LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
        Select sel = new Select(getDriver().findElement(locator));
        sel.selectByIndex(index);

        // Check whether element is selected or not
        sel = new Select(getDriver().findElement(locator));
        if (sel.getFirstSelectedOption().isDisplayed()) {
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(logStep));
            return true;
        } else {
            return false;
        }
    }

    /**
     * Select by value boolean.
     *
     * @param locator the locator
     * @param value   the value
     * @param logStep the log step
     * @return boolean
     */
    public static boolean selectByValue(By locator, String value, String logStep) {
        KeywordUtil.lastAction = "Select dropdown by value : " + value + " - " + locator.toString();
        LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
        Select sel = new Select(getDriver().findElement(locator));
        sel.selectByValue(value);

        // Check whether element is selected or not
        sel = new Select(getDriver().findElement(locator));
        if (sel.getFirstSelectedOption().isDisplayed()) {
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(logStep));

            return true;
        } else {
            return false;
        }
    }

    /**
     * Select by visible text boolean.
     *
     * @param locator the locator
     * @param value   the value
     * @param logStep the log step
     * @return boolean
     */
    public static boolean selectByVisibleText(By locator, String value, String logStep) {
        try {
            KeywordUtil.lastAction = "Select dropdown by text : " + value + " - " + locator.toString();
            LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
            Select sel = new Select(getDriver().findElement(locator));
            sel.selectByVisibleText(value);
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(logStep));

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Verify all values of drop down boolean.
     *
     * @param locator the locator
     * @param data    the data
     * @param logStep the log step
     * @return boolean
     * @throws Throwable the throwable
     */
    public static boolean verifyAllValuesOfDropDown(By locator, String data, String logStep) throws Throwable {
        KeywordUtil.lastAction = "Verify Dropdown all values: " + data + " - " + locator.toString();
        LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
        boolean flag = false;
        WebElement element = findWithFluintWait(locator);
        List<WebElement> options = element.findElements(By.tagName("option"));
        String[] allElements = data.split(",");
        String actual;
        for (int i = 0; i < allElements.length; i++) {
            LogUtil.infoLog(KeywordUtil.class, options.get(i).getText());
            LogUtil.infoLog(KeywordUtil.class, allElements[i].trim());

            actual = options.get(i).getText().trim();
            if (actual.equalsIgnoreCase(allElements[i].trim())) {
                RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(logStep));

                flag = true;
            } else {
                flag = false;
                break;
            }
        }
        return flag;
    }

    /**
     * Verify dropdown selected value boolean.
     *
     * @param locator the locator
     * @param data    the data
     * @param logStep the log step
     * @return boolean
     */
    public static boolean verifyDropdownSelectedValue(By locator, String data, String logStep) {
        KeywordUtil.lastAction = "Verify Dropdown selected option: " + data + " - " + locator.toString();
        LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
        Select sel = new Select(waitForVisible(locator));
        String defSelectedVal = sel.getFirstSelectedOption().getText();
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(logStep));
        return defSelectedVal.trim().equals(data.trim());
    }

    /**
     * Verify element size boolean.
     *
     * @param locator the locator
     * @param size    the size
     * @param logStep the log step
     * @return boolean
     */
    public static boolean verifyElementSize(By locator, int size, String logStep) {
        KeywordUtil.lastAction = "Verify Element size: " + size + " - " + locator.toString();
        LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
        List<WebElement> elements = getDriver().findElements(locator);
        if (elements.size() == size) {
            LogUtil.infoLog(KeywordUtil.class, "Element is Present " + size + "times");
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(logStep));

            return true;
        } else {
            LogUtil.infoLog(KeywordUtil.class, "Element is not Present with required size");
            LogUtil.infoLog(KeywordUtil.class, "Expected size:" + size + " but actual size: " + elements.size());
            return false;
        }
    }

    /**
     * Write in input char by char boolean.
     *
     * @param locator the locator
     * @param data    the data
     * @param logStep the log step
     * @return boolean
     * @throws InterruptedException the interrupted exception
     */
    public static boolean writeInInputCharByChar(By locator, String data, String logStep) throws InterruptedException {
        WebElement element = waitForVisible(locator);
        element.clear();
        String[] b = data.split("");
        for (int i = 0; i < b.length; i++) {
            element.sendKeys(b[i]);
            Thread.sleep(250);
        }
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(logStep));

        return true;
    }

    /**
     * Gets element info.
     *
     * @param locator the locator
     * @return the element info
     * @throws Exception the exception
     */
// Get Tag name and locator value of Element
    public static String getElementInfo(By locator) throws Exception {
        return " Locator: " + locator.toString();
    }

    /**
     * Gets element info.
     *
     * @param element the element
     * @return the element info
     * @throws Exception the exception
     */
    public static String getElementInfo(WebElement element) throws Exception {
        String webElementInfo = "";
        webElementInfo = webElementInfo + "Tag Name: " + element.getTagName() + ", Locator: ["
                + element.toString().substring(element.toString().indexOf("->") + 2);
        return webElementInfo;

    }

    /**
     * Delay.
     *
     * @param time the time
     * @throws InterruptedException the interrupted exception
     */
    public static void delay(long time) throws InterruptedException {
        Thread.sleep(time);
    }

    public static void waitForElementPresence(By locator) {
        try {

            WebDriverWait wait = new WebDriverWait(getDriver(),Long.valueOf(ConfigReader.getValue("explicitWaitTime")));
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));

        } catch (Throwable e) {
            e.printStackTrace();
        }

    }

    public static void scrollup(By converted) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(10,0);", converted);

    }

    public static String getVisibleText(By locator) {
        KeywordUtil.lastAction = "Get Element text: " + locator.toString();
        LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
        WebElement elm = KeywordUtil.waitForVisible(locator);
        return elm.getText().trim();

    }

    public static void scrolldown(By locator) {
        JavascriptExecutor js = (JavascriptExecutor) GlobalUtil.getDriver();
        js.executeScript("window.scrollBy(0,600);", locator);

    }
    /**
     * scroll bar scroll down
     */
    public static void scrolldownScrollbar(By locator) {
        JavascriptExecutor js = (JavascriptExecutor) GlobalUtil.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", locator);

    }

    /*** Clicks on a WebElement using the Action class.
     ** @param locator WebElement to click.
     *  @param logStep the log.
     */
    public static void clickUsingAction(By locator, String logStep) {
            WebDriver driver = getDriver();
            WebElement element = getDriver().findElement(locator);
            Actions actions = new Actions(driver);
            actions.click(element).build().perform();
        }


    /**
     * Verify current date input boolean.
     *
     * @param locator the locator
     * @param logStep the log step
     * @return boolean
     */
    public boolean verifyCurrentDateInput(By locator, String logStep) {
        boolean flag = false;
        WebElement element = waitForVisible(locator);
        String actual = element.getAttribute(VALUE).trim();
        DateFormat dtFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date();
        dtFormat.setTimeZone(TimeZone.getTimeZone("US/Central"));
        String expected = dtFormat.format(date).trim();
        if (actual.trim().contains(expected)) {
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(logStep));

            flag = true;

        }
        return flag;
    }

    /**
     * Upload files using send keys boolean.
     *
     * @param locator the locator
     * @param data    the data
     * @param logStep the log step
     * @return boolean
     * @throws InterruptedException the interrupted exception
     */
    public static boolean uploadFilesUsingSendKeys(By locator, String data, String logStep)
            throws InterruptedException {
        WebElement element = waitForVisible(locator);
        element.clear();
        element.sendKeys(System.getProperty(userDir) + "\\src\\test\\resources\\uploadFiles\\" + data);
        RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(logStep));

        return true;
    }

    /**
     * Del directory boolean.
     *
     * @return boolean
     */
    public boolean delDirectory() {
        File delDestination = new File(System.getProperty(userDir) + "\\src\\test\\resources\\downloadFile");
        if (delDestination.exists()) {
            File[] files = delDestination.listFiles();
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory()) {
                    delDirectory();
                } else {
                    files[i].delete();
                }
            }
        }
        return delDestination.delete();
    }

    /**
     * Double click boolean.
     *
     * @param locator the locator
     * @param logStep the log step
     * @return the boolean
     */
    public static boolean doubleClick(By locator, String logStep) {
        boolean result = false;
        try {
            KeywordUtil.lastAction = "Double click: " + locator.toString();
            LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
            WebElement element = getDriver().findElement(locator);
            Actions action = new Actions(getDriver()).doubleClick(element);
            action.build().perform();
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(logStep));

            result = true;

        } catch (StaleElementReferenceException e) {
            LogUtil.infoLog(KeywordUtil.class,
                    locator + " - Element is not attached to the page document " + e.getStackTrace());
            result = false;
        } catch (NoSuchElementException e) {
            LogUtil.infoLog(KeywordUtil.class,
                    locator + " - Element is not attached to the page document " + e.getStackTrace());
            result = false;
        } catch (Exception e) {
            LogUtil.infoLog(KeywordUtil.class,
                    locator.toString() + " - Element is not attached to the page document " + e.getStackTrace());
            result = false;
        }
        return result;
    }

    /**
     * Switch to frame boolean.
     *
     * @param frameName the frame name
     * @return the boolean
     */
    public static boolean switchToFrame(String frameName) {

        try {
            getDriver().switchTo().frame(frameName);
            return true;

        } catch (Exception e) {
            LogUtil.infoLog(KeywordUtil.class, frameName + " TO FRAME FAILED" + e.getStackTrace());
            return false;
        }
    }

    /**
     * Switch to frame boolean.
     *
     * @param frameName the frame name
     */
    public static void switchToIFrame(int index, String frameName) {

        try {

            getDriver().switchTo().frame(index);
            lastAction = "Switched to " + frameName + " successfully";
            LogUtil.infoLog(KeywordUtil.class, lastAction);
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(lastAction));

        } catch (Throwable e) {
            lastAction = "SWITCHING TO " + frameName + " FAILED" + index;
            LogUtil.infoLog(KeywordUtil.class, lastAction + " " + e.getMessage());
            Assert.fail(lastAction, e);
        }
    }

    /**
     * Create zip file string.
     *
     * @return the string
     * @throws IOException the io exception
     */
    public static String createZipFile() throws IOException {
        result_FolderName = result_FolderName.replace("\\", "/");
        String outputFile = result_FolderName + ".zip";
        FileOutputStream fos = new FileOutputStream(outputFile);
        ZipOutputStream zos = new ZipOutputStream(fos);
        packCurrentDirectoryContents(result_FolderName, zos);
        zos.closeEntry();
        zos.close();
        fos.close();
        return outputFile;
    }

    /**
     * Pack current directory contents.
     *
     * @param directoryPath the directory path
     * @param zos           the zos
     * @throws IOException the io exception
     */
    public static void packCurrentDirectoryContents(String directoryPath, ZipOutputStream zos) throws IOException {
        for (String dirElement : new File(directoryPath).list()) {
            String dirElementPath = directoryPath + "/" + dirElement;
            if (new File(dirElementPath).isDirectory()) {
                packCurrentDirectoryContents(dirElementPath, zos);
            } else {
                ZipEntry ze = new ZipEntry(dirElementPath.replaceAll(result_FolderName + "/", ""));
                zos.putNextEntry(ze);
                FileInputStream fis = new FileInputStream(dirElementPath);
                byte[] bytesRead = new byte[512];
                int bytesNum;
                while ((bytesNum = fis.read(bytesRead)) > 0) {
                    zos.write(bytesRead, 0, bytesNum);
                }

                fis.close();
            }
        }
    }

    /**
     * Select value from drop down.
     *
     * @param dropdownLocator dropdown field by locator
     * @param optionName select option by name
     *
     */
    public static void  selectValueFromDropdown(By dropdownLocator, String optionName,String logStep) {
        try {
            KeywordUtil.click(dropdownLocator, "Click on dropdown.");
            WebDriverWait wait = new WebDriverWait(getDriver(), 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(dropdownLocator));
            WebElement dropdownElement = getDriver().findElement(dropdownLocator);
            WebElement option = dropdownElement.findElement(By.xpath("//span[text()='" + optionName + "']"));
            option.click();
            takeScreenshotAndAttachInReport();
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(logStep));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder result = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length()); // Generate a random index
            result.append(characters.charAt(index)); // Append the character at the random index
        }

        return result.toString();
    }

    public static void markTestAsPassedInBrowserStackWeb(String testStatus) {
        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript(String.format(
                "browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"%s\", \"reason\": \"<reason>\"}}",
                testStatus));

    }

    /**
     * Error handling.
     *
     * @param
     */

    public static void catchAssertError(Throwable e) {
        GlobalUtil.e = e;
        GlobalUtil.errorMsg = e.getMessage();
        String[] msg = e.getMessage().split("expected");
        RunCukesTest.logger.log(LogStatus.FAIL, msg[0]);
        Assert.fail(e.getMessage());
    }

    /**
     * Refersh the Browser
     */
    public static void BrowserRefresh(){
        GlobalUtil.getDriver().navigate().refresh();
    }

    /**
     * Take a Screenshot and attach in report.
     *
     * @param
     */

    public static void takeScreenshotAndAttachInReport() {
        try {
            Thread.sleep(3000);
            if (ConfigReader.getValue("screenshotFlag").equalsIgnoreCase("true")) {
                String imagePath, pathForLogger;
                String scFileName = "ScreenShot_" + System.currentTimeMillis();
                String screenshotFilePath = ConfigReader.getValue("screenshotsPath") + "\\" + scFileName + ".png";

                imagePath = HTMLReportUtil.testFailTakeScreenshot(screenshotFilePath);

                InputStream is = new FileInputStream(imagePath);
                byte[] imageBytes = IOUtils.toByteArray(is);
                Thread.sleep(2000);
                String base64 = Base64.getEncoder().encodeToString(imageBytes);
                pathForLogger = RunCukesTest.logger.addBase64ScreenShot("data:image/png;base64," + base64);
                RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.infoStringGreenColor(pathForLogger));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Select value from drop down.
     *
     * @param
     */
    public static void selectOptionFromDropdown(By dropdownLocator, int optionIndex,String logStep) {
        try {
            KeywordUtil.click(dropdownLocator, "Click on dropdown.");
            WebDriverWait wait = new WebDriverWait(getDriver(), 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(dropdownLocator));
            WebElement dropdownElement = getDriver().findElement(dropdownLocator);
            WebElement option = dropdownElement.findElements(By.tagName("option")).get(optionIndex);
            option.click();
            takeScreenshotAndAttachInReport();
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(logStep));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Validate Page should be loaded with title
     */
    public static void validatePageShouldBeLoaded(String title) {
        try{
            String Pagetitle = getDriver().getTitle();
            LogUtil.infoLog(KeywordUtil.class, Pagetitle);
            Assert.assertEquals(Pagetitle.contains(title),true, title.concat(" page is not loaded"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
    /**
     * Scroll Element into view using Actions
     */
    public static void scrollElementIntoViewUsingActions(By element){
        try {
            // Actions class with moveToElement()
            Actions a = new Actions(getDriver());
            a.moveToElement(getDriver().findElement(element)).perform();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Select name value from drop down.
     *
     * @param dropdownLocator dropdown field
     * @param optionName option name from list
     *
     */
    public static void selectOptionNameFromDropdown(String dropdownLocator, String optionName, String logStep) {
        try {
            KeywordUtil.click(By.xpath("//*[@aria-label='" + dropdownLocator + "']"), "Click on dropdown.");
            WebDriverWait wait = new WebDriverWait(getDriver(), 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@aria-label='" + dropdownLocator + "']")));
            WebElement dropdownElement = getDriver().findElement(By.xpath("//*[@aria-label='" + dropdownLocator + "']"));
            WebElement option = dropdownElement.findElement(By.xpath("//span[text()='" + optionName + "']"));
            option.click();
            takeScreenshotAndAttachInReport();
            RunCukesTest.logger.log(LogStatus.PASS, HTMLReportUtil.passStringGreenColor(logStep));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Generate a random name
     *
     * @return
     */
    public static String generateRandomName() {
        Random rand = new Random();
        StringBuilder name = new StringBuilder();
        for (int i = 0; i < 5; i++) { // Generating a random name of length 5
            char randomChar = (char) ('A' + rand.nextInt(26)); // Random letter from A to Z
            name.append(randomChar);
        }
        return name.toString();
    }

}// End class

/**
 * The type Test step failed exception.
 */
@SuppressWarnings("serial")
class TestStepFailedException extends Exception {
    /**
     * Instantiates a new Test step failed exception.
     *
     * @param s the s
     */
    TestStepFailedException(String s) {
        super(s);
    }

    /**
     * Scrolldown.
     *
     * @param Element the element
     */
    public static void scrolldown(WebElement Element) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,600);", Element);
    }
    /**
     * Get Element Text
     */
    public static String getVisibleText(By locator) {
        KeywordUtil.lastAction = "Get Element text: " + locator.toString();
        LogUtil.infoLog(KeywordUtil.class, KeywordUtil.lastAction);
        WebElement elm = KeywordUtil.waitForVisible(locator);
        return elm.getText().trim();
    }
    /**
     * Scroll Element into view using Actions
     */
    public static void scrollElementIntoViewUsingActions(By element){
        try {
            Actions a = new Actions(getDriver());
            a.moveToElement(getDriver().findElement(element)).perform();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }




}
