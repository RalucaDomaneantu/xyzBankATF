package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import javax.xml.xpath.XPath;

public class AccountPage {
    public WebDriver driver;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "userSelect")
    public WebElement customerName;

    @FindBy(id = "currency")
    public WebElement currency;

    @FindBy(xpath = "//button[@type = 'submit']")
    public  WebElement process;

    @FindBy(xpath = "//button[@ng-click='showCust()']")
    public WebElement showCustomerElement;

    public void createAccountProcess(String fullname, String currencyValue){

        Select selectCustomer = new Select(customerName);
        selectCustomer.selectByVisibleText(fullname);

        Select selectCurrency = new Select(currency);
        selectCurrency.selectByVisibleText(currencyValue);

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