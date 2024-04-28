package pageobjects.SalesforceObjects;

import org.openqa.selenium.By;

public class OrdersObject {
    public static By ordersTab =By.xpath("//div[@class='slds-context-bar']//a[@title='Orders']");
    public static By orderNumber=By.xpath("//*[@id='brandBand_1']//div/div/table/tbody/tr[1]/th/span/a");


    public static By orderActivated=By.xpath("//ul[@class='slds-path__nav']//li[@data-name='Activated']//a");
    public static By markStatusAsComplete=By.xpath("//button[@type='button']//span[@class='uiOutputText']");


}
