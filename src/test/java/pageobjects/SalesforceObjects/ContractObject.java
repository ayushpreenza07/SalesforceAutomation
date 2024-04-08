package pageobjects.SalesforceObjects;

import org.openqa.selenium.By;

public class ContractObject {

    public static By contractBtn = By.xpath("//SPAN[@class='slds-truncate slds-m-right--xx-small'][text()='Contracts']");

    public static By newContract = By.xpath("(//DIV[@title='New'][text()='New'])[2]");

    public static By contractStatus = By.xpath("//button[@class='slds-combobox__input slds-input_faux fix-slds-input_faux slds-combobox__input-value' and span[text()='Draft']]");

    public static By startDate = By.xpath("//input[@name='StartDate']");

    public static By contractTerm = By.xpath("//input[@name='ContractTerm']");


}
