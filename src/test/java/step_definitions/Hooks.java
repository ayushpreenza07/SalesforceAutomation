package step_definitions;

import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.compress.utils.IOUtils;
import org.openqa.selenium.JavascriptExecutor;
import utilities.*;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Base64;

import static utilities.GlobalUtil.getDriver;

public class Hooks {

    static String testCaseDescription;
    String imagePath;
    String pathForLogger;

    @Before("@Web or @salesforce or @MarketingCRM_01")
    public void beforeMethodAmazon(Scenario scenario) {

        if (scenario.getName().contains("_"))
            testCaseDescription = scenario.getName().split("_")[1].trim();
        else
            testCaseDescription = scenario.getName();

        RunCukesTest.logger = RunCukesTest.extent.startTest(testCaseDescription);
        RunCukesTest.tagName = scenario.getSourceTagNames().toString().replace("[@", "").replace("]", "").trim();

        LogUtil.infoLog(getClass(),
                "\n+----------------------------------------------------------------------------------------------------------------------------+");
        LogUtil.infoLog(getClass(), "Test Started: " + scenario.getName());
        LogUtil.infoLog(Hooks.class,
                "Test is executed in Environment: " + GlobalUtil.getCommonSettings().getExecutionEnv());
        LogUtil.infoLog(Hooks.class, "Test is started with browser: " + GlobalUtil.getCommonSettings().getBrowser());
        GlobalUtil.setDriver(DriverUtil.getBrowser("Window", "Chrome"));
    }

    @After("@Web")
    public void afterMethodSmoke(Scenario scenario) throws InterruptedException {

        String testName;

        if (scenario.getName().contains("_"))
            testName = scenario.getName().split("_")[0].trim();
        else
            testName = scenario.getName();

        if (scenario.isFailed()) {
            try {
                String scFileName = "ScreenShot_" + System.currentTimeMillis();
                String screenshotFilePath = ConfigReader.getValue("screenshotPath") + "\\" + scFileName + ".png";
                imagePath = HTMLReportUtil.testFailTakeScreenshot(screenshotFilePath);

                InputStream is = new FileInputStream(imagePath);
                byte[] imageBytes = IOUtils.toByteArray(is);
                Thread.sleep(2000);
                String base64 = Base64.getEncoder().encodeToString(imageBytes);
                pathForLogger = RunCukesTest.logger.addBase64ScreenShot("data:image/png;base64," + base64);
                RunCukesTest.logger.log(LogStatus.FAIL,
                        HTMLReportUtil.failStringRedColor("Failed at point: " + pathForLogger) + GlobalUtil.e);

                byte[] screenshot = KeywordUtil.takeScreenshot(imagePath);
                scenario.attach(screenshot, "image/png", "Failed Screenshot");

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {

            LogUtil.infoLog(Hooks.class,
                    "Test has ended closing browser: " + GlobalUtil.getCommonSettings().getBrowser());

        }
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.postMessage({ type: 'DOWNLOAD' }, '*');");
        Thread.sleep(10000);
        // close the browsers
        getDriver().quit();
      
        RunCukesTest.extent.endTest(RunCukesTest.logger);
    }


}