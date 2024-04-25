package pageobjects.SalesforceObjects;

import org.openqa.selenium.By;

public class BillingObject {

    public static By productsTab = By.xpath("//a[@title='Products']");

    public static By productName = By.xpath("//input[@data-interactive-lib-uid='4']");

    public static By productFamily = By.xpath("//a[@data-interactive-lib-uid='5'][text()='--None--']");

    public static By productCode = By.xpath("//input[@data-interactive-lib-uid='6']");

    public static By activeCheckBox = By.xpath("//input[@data-interactive-lib-uid='8']");
    public static By selectFamily = By.xpath("//a[@title='Hardware']");

    public static By saveProduct = By.xpath("//button[@title='Save']");

    public static By relatedHeader = By.xpath("//a[@title='Related']");

    public static By addStandardPrice = By.xpath("//a[@title='Add Standard Price']");

    public static By addListPrice = By.xpath("//input[@data-interactive-lib-uid='68']");

}
