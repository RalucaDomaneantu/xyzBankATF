package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import sharedData.SharedData;

import java.util.Arrays;
import java.util.List;

public class CreateCustomerAccountsTest extends SharedData {

    @Test
    public void automationTest() {
        WebElement bankManagerElement = getDriver().findElement(By.xpath("//button[text()='Bank Manager Login']"));
        bankManagerElement.click();

        WebElement addCustomerElement = getDriver().findElement(By.xpath("//button[@ng-click='addCust()']"));
        addCustomerElement.click();

        WebElement firstNameElement = getDriver().findElement(By.xpath("//input[@placeholder='First Name']"));
        String firstNameValue = "Raluca";
        firstNameElement.sendKeys(firstNameValue);

        WebElement lastNameElement = getDriver().findElement(By.xpath("//input[@placeholder='Last Name']"));
        String lastNameValue = "Domaneantu";
        lastNameElement.sendKeys(lastNameValue);

        WebElement postCodeElement = getDriver().findElement(By.xpath("//input[@placeholder='Post Code']"));
        String postCodeValue = "123456";
        postCodeElement.sendKeys(postCodeValue);

        WebElement submitCustomerElement = getDriver().findElement(By.xpath("//button[@type='submit']"));
        submitCustomerElement.click();

        Alert customerAlert = getDriver().switchTo().alert();
        String customerAlertText = customerAlert.getText();
        System.out.println(customerAlertText);
        customerAlert.accept();

        WebElement openAccountElement = getDriver().findElement(By.xpath("//button[@ng-click='openAccount()']"));
        openAccountElement.click();


        //Pentru un customer vreau sa creez 3 conturi

        List<String> currencyValuesList = Arrays.asList("Dollar", "Pound", "Rupee");

        String fullname = firstNameValue + " " + lastNameValue;

        for (int i = 0; i < currencyValuesList.size(); i++) {

            WebElement customerName = getDriver().findElement(By.id("userSelect"));
            Select selectCustomer = new Select(customerName);
            selectCustomer.selectByVisibleText(fullname);

            WebElement currency = getDriver().findElement(By.id("currency"));
            Select selectCurrency = new Select(currency);
            selectCurrency.selectByVisibleText(currencyValuesList.get(i));

            WebElement process = getDriver().findElement(By.xpath("//button[@type = 'submit']"));
            process.click();

            Alert accountAlert = getDriver().switchTo().alert();
            String accountAlertText = accountAlert.getText();
            System.out.println(accountAlertText);
            accountAlert.accept();

        }

        WebElement showCustomerElement = getDriver().findElement(By.xpath("//button[@ng-click='showCust()']"));
        showCustomerElement.click();

        WebElement searchCustomerElement = getDriver().findElement(By.xpath("//input[@placeholder = 'Search Customer']"));
        searchCustomerElement.sendKeys(fullname);
    }

}