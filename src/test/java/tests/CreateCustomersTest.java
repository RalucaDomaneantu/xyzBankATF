package tests;

import models.CustomerModel;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.CustomerPage;
import pages.LoginPage;
import pages.ManagerPage;
import sharedData.SharedData;

import java.util.Arrays;
import java.util.List;

public class CreateCustomersTest extends SharedData {


    @Test(groups = {SuiteType.REGRESSION_SUITE, SuiteType.CUSTOMER_SUITE})

    public void automationTest() {
       // CustomerModel testData = new CustomerModel("CustomersData.json");

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.loginBankManager();

        ManagerPage managerPage = new ManagerPage(getDriver());
        managerPage.createCustomer();

       List<String> firstNameValueList = Arrays.asList("Raluca1", "Raluca2", "Raluca3");
       List<String> lastNameValueList = Arrays.asList("Domaneantu1", "Domaneantu2", "Domaneantu3");
       List<String> postCodeValueList = Arrays.asList("1111", "2222", "3333");

        CustomerPage customerPage = new CustomerPage(getDriver());
        customerPage.createCustomersProcess(firstNameValueList, lastNameValueList, postCodeValueList);
    }
}

