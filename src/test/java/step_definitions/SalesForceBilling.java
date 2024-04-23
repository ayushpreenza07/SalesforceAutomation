package step_definitions;

import SalesforceModules.AccountUtil;
import SalesforceModules.LoginSalesforceUtil;
import SalesforceModules.SalesForceBillingUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import utilities.ConfigReader;
import utilities.KeywordUtil;

public class SalesForceBilling {


    @And("go to salesforce cpq")
    public void goToSalesforceCpq() {
        AccountUtil.clickSlideShowButton("Clicked menu button");
        AccountUtil.clickCpqButton("CPQ selected");
    }

    @And("go to products tab")
    public void goToProducts() {
        SalesForceBillingUtil.productsTab("Products tab clicked");
    }

    @And("Create new product")
    public void createNewProduct() throws Exception {
        SalesForceBillingUtil.newProduct();
    }

    @And("add price book and standard price")
    public void addPriceBookAndStandardPrice() throws InterruptedException {
        SalesForceBillingUtil.clickRelated("Related tab selected");
        SalesForceBillingUtil.addStandardPrice("Added standard price");
    }

    @And("click okay")
    public void clickOkay() {
        LoginSalesforceUtil.okayLogin();
    }
}
