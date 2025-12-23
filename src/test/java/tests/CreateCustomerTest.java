package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.time.Duration;

public class CreateCustomerTest {
    public WebDriver driver;

    @Test

    public void automationTest(){
        driver = new ChromeDriver();
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement bankManagerElement = driver.findElement(By.xpath("//button[text()='Bank Manager Login']"));
        bankManagerElement.click();

        WebElement addCustomerElement = driver.findElement(By.xpath("//button[@ng-click='addCust()']"));
        addCustomerElement.click();

        WebElement firstNameElement = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
        String firstNameValue = "Raluca";
        firstNameElement.sendKeys(firstNameValue);

        WebElement lastNameElement = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
        String lastNameValue = "Domaneantu";
        lastNameElement.sendKeys(lastNameValue);

        WebElement postCodeElement = driver.findElement(By.xpath("//input[@placeholder='Post Code']"));
        String postCodeValue = "123456";
        postCodeElement.sendKeys(postCodeValue);

        WebElement submitCustomerElement = driver.findElement(By.xpath("//button[@type='submit']"));
        submitCustomerElement.click();

        Alert customerAlert = driver.switchTo().alert();
        String customerAlertText = customerAlert.getText();
        System.out.println(customerAlertText);
        customerAlert.accept();

        WebElement openAccountElement = driver.findElement(By.xpath("//button[@ng-click='openAccount()']"));
        openAccountElement.click();

        WebElement customerName = driver.findElement(By.id("userSelect"));
        Select selectCustomer = new Select(customerName);
        String fullname = firstNameValue + " " +lastNameValue;
        selectCustomer.selectByVisibleText(fullname);

        WebElement currency = driver.findElement(By.id("currency"));
        Select selectCurrency = new Select(currency);
        String currencyValue = "Dollar";
        selectCurrency.selectByVisibleText(currencyValue);

        WebElement process = driver.findElement(By.xpath("//button[@type = 'submit']"));
        process.click();

        Alert accountAlert = driver.switchTo().alert();
        String accountAlertText = accountAlert.getText();
        System.out.println(accountAlertText);
        accountAlert.accept();

        WebElement showCustomerElement = driver.findElement(By.xpath("//button[@ng-click='showCust()']"));
        showCustomerElement.click();

        WebElement searchCustomerElement = driver.findElement(By.xpath("//input[@placeholder = 'Search Customer']"));
        searchCustomerElement.sendKeys(fullname);
    }
}
