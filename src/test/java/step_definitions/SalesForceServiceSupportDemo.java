package step_definitions;

import SalesforceModules.AccountUtil;
import SalesforceModules.EditandDeleteUtil;
import SalesforceModules.ServiceSupportUtil;
import io.cucumber.java.en.When;

import java.util.HashMap;

public class SalesForceServiceSupportDemo {

    public static HashMap<String, String> dataMap = new HashMap<String, String>();

    @When("^click on service support button$")
    public void click_on_service_support_button() throws Exception {
        AccountUtil.clickSlideShowButton("Clicked menu button");
        ServiceSupportUtil.ClickServiceSupportButton("click service support button");
        }

    @When("^Edit Account Details")
    public void edit_account_details() throws Exception{
        dataMap= SalesForceCPQ.dataMap;
        EditandDeleteUtil.editAccountDetails(dataMap.get("Phone"));
    }

    @When("^Delete Account")
    public void delete_account_details() throws Exception{
        EditandDeleteUtil.deleteAccount("deleted the account");
    }

}
