package pages;

import models.CustomerModel;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

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

        Select selectCurrency = new Select(currency);
        selectCurrency.selectByVisibleText(testdata.getCurrencyValue());

        process.click();

        Alert accountAlert = driver.switchTo().alert();
        String accountAlertText = accountAlert.getText();
        System.out.println(accountAlertText);
        String [] accountsArray = accountAlertText.split(":");
        String accountNumber = accountsArray[1];
        System.out.println(accountsArray[1]);
        accountAlert.accept();

    }

    public void openCustomersPage(){
        showCustomerElement.click();

    }
}