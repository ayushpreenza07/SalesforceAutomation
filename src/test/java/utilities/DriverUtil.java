package utilities;


import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;


/**
 * This DriverUtil class refer to browsers, os details, browser versions and
 * will close all browsers
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DriverUtil {


    public static WebDriver getBrowser(String exeEnv, String browserName) {
        if (exeEnv.equalsIgnoreCase("Window")) {
            if (browserName.equalsIgnoreCase("Chrome")) {

                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-notifications");
                GlobalUtil.setDriver(new ChromeDriver(options));
            } else if (browserName.equalsIgnoreCase("IE")) {
                WebDriverManager.iedriver().setup();
                GlobalUtil.setDriver(new InternetExplorerDriver());
            } else if (browserName.equalsIgnoreCase("Firefox")) {
                WebDriverManager.firefoxdriver().setup();
                GlobalUtil.setDriver(new FirefoxDriver());

                //For Mac Operating System
            } else if (exeEnv.equalsIgnoreCase("MAC")) {
                if (browserName.equalsIgnoreCase("CHROME")) {
                    WebDriverManager.chromedriver().setup();
                    GlobalUtil.setDriver(new ChromeDriver());
                } else if (browserName.equalsIgnoreCase("IE")) {
                    WebDriverManager.iedriver().setup();
                    GlobalUtil.setDriver(new InternetExplorerDriver());
                } else if (browserName.equalsIgnoreCase("Firefox")) {
                    WebDriverManager.firefoxdriver().setup();
                    GlobalUtil.setDriver(new FirefoxDriver());
                } else if (browserName.equalsIgnoreCase("Safari")) {
                    GlobalUtil.setDriver(new SafariDriver());
                }
            }

            GlobalUtil.getDriver().manage().window().maximize();
            LogUtil.infoLog(DriverUtil.class,
                    GlobalUtil.getCommonSettings().getBrowser() + " : Browser Launched and Maximized.");
        }
        return GlobalUtil.getDriver();
    }

}