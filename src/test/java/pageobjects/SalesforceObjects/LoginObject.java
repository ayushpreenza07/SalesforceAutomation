package pageobjects.SalesforceObjects;

import org.openqa.selenium.By;

public class LoginObject {

    public static By username = By.xpath("//input[@id='username']");
    public static By password = By.xpath("//input[@id='password']");
    public static By loginBtn = By.xpath("//input[@id='Login']");
    public static By okayLogin = By.xpath("//input[@value='Okay']");
}
