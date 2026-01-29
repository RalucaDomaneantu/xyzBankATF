package pages;

import models.CustomerModel;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.log.Log;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utils.LogUtility;

public class AccountPage extends BasePage
{
    @FindBy(id = "userSelect")
    private WebElement customerName;

    @FindBy(id = "currency")
    private WebElement currency;

    @FindBy(xpath = "//button[@type = 'submit']")
    private  WebElement process;

    @FindBy(xpath = "//button[@ng-click='showCust()']")
    private WebElement showCustomerElement;

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public void createAccountProcess(CustomerModel testdata){

        Select selectCustomer = new Select(customerName);
        selectCustomer.selectByVisibleText(testdata.getFullname());
        LogUtility.infoLog("The user selects " + testdata.getFullname() + "value from dropdown");

        Select selectCurrency = new Select(currency);
        selectCurrency.selectByVisibleText(testdata.getCurrencyValue());
        LogUtility.infoLog("The user clicks on process button");

        process.click();

        Alert accountAlert = driver.switchTo().alert();
        String accountAlertText = accountAlert.getText();
        System.out.println(accountAlertText);
        String [] accountsArray = accountAlertText.split(":");
        String accountNumber = accountsArray[1];
        accountAlert.accept();
        LogUtility.infoLog("The user accepts the account creation alert");

    }

    public void openCustomersPage(){
        showCustomerElement.click();
        LogUtility.infoLog("The user clicks on Customers page");

    }
}