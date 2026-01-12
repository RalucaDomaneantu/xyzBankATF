package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ManagerPage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreateCustomerAccountsTest {
    public WebDriver driver;

    @Test

    public void automationTest() {
        driver = new ChromeDriver();
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginBankManager();

        ManagerPage managerPage = new ManagerPage(driver);
        managerPage.createCustomer();

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


        //Pentru un customer vreau sa creez 3 conturi

        List<String> currencyValuesList = Arrays.asList("Dollar", "Pound", "Rupee");

        String fullname = firstNameValue + " " + lastNameValue;

        for (int i = 0; i < currencyValuesList.size(); i++) {

            WebElement customerName = driver.findElement(By.id("userSelect"));
            Select selectCustomer = new Select(customerName);
            selectCustomer.selectByVisibleText(fullname);

            WebElement currency = driver.findElement(By.id("currency"));
            Select selectCurrency = new Select(currency);
            selectCurrency.selectByVisibleText(currencyValuesList.get(i));

            WebElement process = driver.findElement(By.xpath("//button[@type = 'submit']"));
            process.click();

            Alert accountAlert = driver.switchTo().alert();
            String accountAlertText = accountAlert.getText();
            System.out.println(accountAlertText);
            accountAlert.accept();

        }

        WebElement showCustomerElement = driver.findElement(By.xpath("//button[@ng-click='showCust()']"));
        showCustomerElement.click();

        WebElement searchCustomerElement = driver.findElement(By.xpath("//input[@placeholder = 'Search Customer']"));
        searchCustomerElement.sendKeys(fullname);
    }

}