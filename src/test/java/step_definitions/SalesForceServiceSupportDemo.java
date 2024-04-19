package step_definitions;

import SalesforceModules.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.testng.Assert;
import utilities.ConfigReader;
import utilities.ExcelDataUtil;
import utilities.GlobalUtil;
import utilities.KeywordUtil;

import java.util.HashMap;

import static step_definitions.salesforceDemo.dataMap;

public class SalesForceServiceSupportDemo {

    public static HashMap<String, String> dataMap = new HashMap<String, String>();

    @When("^click on service support button$")
    public void click_on_service_support_button() throws Exception {
        AccountUtil.clickSlideShowButton("Clicked menu button");
        ServiceSupportUtil.ClickServiceSupportButton("click service support button");
        }

    @When("^Edit Account Details")
    public void edit_account_details() throws Exception{
        dataMap= salesforceDemo.dataMap;
        EditandDeleteUtil.editAccountDetails(dataMap.get("Phone"));
    }

    @When("^Delete Account")
    public void delete_account_details() throws Exception{
        EditandDeleteUtil.deleteAccount("deleted the account");
    }

    @When("^create contact for service support$")
    public void create_contact() throws Exception{
        ContactUtil.createContactforServiceSupport(dataMap.get("Salutation"), dataMap.get("ContactLastName"),dataMap.get("ContactEmail"),dataMap.get("Phone"));
      //  ContactUtil.backToAccount("Navigated back to account");
    }

    @When("^Edit Contact Details for service support")
    public void edit_contact_details() throws Exception{
        dataMap= salesforceDemo.dataMap;
        EditandDeleteUtil.editContactDetails("Anjali");
    }

    @When("^Filter Contact Details for service support")
    public void filter_contact_details() throws Exception{
        EditandDeleteUtil.clickContactTab_cnt();
        EditandDeleteUtil.selectFilterInContacts_cnt("Name","Rahul");

    }

    @When("^Remove All Filters Contact Details for service support")
    public void RemoveAll_filter_contact_details() throws Exception{
        EditandDeleteUtil.removeFilter_cnt();

    }

    @When("^Delete Contact Details for service support")
    public void Delete_contact_details() throws Exception {
        EditandDeleteUtil.deleteContact("Deleted the contact");
    }
}
