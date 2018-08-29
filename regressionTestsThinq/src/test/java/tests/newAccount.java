package tests;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class newAccount {



    @Test
    public void createAccount() {

        // Starting Chrome maximized:
        System.setProperty("webdriver.chrome.driver","C:/chrome_driver/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        WebDriver wd = new ChromeDriver(chromeOptions);

        // Go to URL:
        wd.get("http://diego.rdu.vamp.com/panel/dev/#/login");

        // Wait for element and log in:

        WebDriverWait wait = new WebDriverWait(wd, 20);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("username")));
        WebElement userName = ((ChromeDriver) wd).findElementById("username");
        WebElement password = ((ChromeDriver) wd).findElementById("pass");

        //Log In:
        userName.sendKeys("superadmin");
        password.sendKeys("Asdasd11");
        password.sendKeys(Keys.RETURN);

        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Accounts")));
        ((ChromeDriver) wd).findElementByLinkText("Accounts").click();

        // Click 'New Account' button:
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[1]/div[1]/a")));
        WebElement addNewAccButton = ((ChromeDriver) wd).findElementByXPath("/html/body/div/div[1]/div[1]/a");
        addNewAccButton.click();

        // Wait for the account creation loads:
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='btn-group']//*[text()=' Save']")));

        // Gather Account creation page elements:
        WebElement saveButton = ((ChromeDriver) wd).findElementByXPath("//*[@class='btn-group']//*[text()=' Save']");
        WebElement accName = ((ChromeDriver) wd).findElementByXPath("//*[contains(@ng-model,'account.name')]");
        WebElement orgName = ((ChromeDriver) wd).findElementByXPath("//*[contains(@ng-model,'account.organization')]");
        WebElement sLimit = ((ChromeDriver) wd).findElementByXPath("//*[contains(@ng-model,'account.sl')]");
        WebElement hLimit = ((ChromeDriver) wd).findElementByXPath("//*[contains(@ng-model,'account.hl')]");
        WebElement addressInput = ((ChromeDriver) wd).findElementByXPath("//*[contains(@ng-model,'account.billing_address.address1')]");
        WebElement cityInput = ((ChromeDriver) wd).findElementByXPath("//*[contains(@ng-model,'account.billing_address.city')]");
        WebElement stateInput = ((ChromeDriver) wd).findElementByXPath("//*[contains(@ng-model,'account.billing_address.state')]");
        WebElement countryInput = ((ChromeDriver) wd).findElementByXPath("//*[contains(@ng-model,'account.billing_address.country')]");
        WebElement zipCodeInput = ((ChromeDriver) wd).findElementByXPath("//*[contains(@ng-model,'account.billing_address.zipcode')]");
        WebElement phoneInput = ((ChromeDriver) wd).findElementByXPath("//*[contains(@ng-model,'account.billing_address.phone')]");
        WebElement emailInput = ((ChromeDriver) wd).findElementByXPath("//*[contains(@ng-model,'account.billing_address.email')]");
        WebElement copyFromBilling = ((ChromeDriver) wd).findElementByXPath("/html/body/div/div[2]/div[4]/h4/small/a");
        Select paymentTypeDropdown = new Select(((ChromeDriver) wd).findElementByXPath("//*[contains(@ng-model,'account.payment_type')]"));

        //random number for account name
        int rn = ThreadLocalRandom.current().nextInt(15, 1500 + 1);

        // Submit new account:
        accName.sendKeys("CreatedWithSelenium" + rn);
        orgName.sendKeys("SeleniumORG2");
        sLimit.sendKeys("-100");
        hLimit.sendKeys("-600");
        paymentTypeDropdown.selectByValue("string:postpaid");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@ng-model,'account.billing_info')]")));
        Select paymentTermDropdown = new Select(((ChromeDriver) wd).findElementByXPath("//*[contains(@ng-model,'account.billing_info')]"));
        paymentTermDropdown.selectByVisibleText("7net7");
        addressInput.sendKeys("701 N Person St");
        cityInput.sendKeys("Raleigh");
        stateInput.sendKeys("NC");
        countryInput.sendKeys("United States");
        zipCodeInput.sendKeys("27604");
        phoneInput.sendKeys("9196667878");
        emailInput.sendKeys("joaquin@thinq.com");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[2]/div[4]/h4/small/a")));
        copyFromBilling.click();
        saveButton.click();

        // Alert Message 'OK':
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = wd.switchTo().alert();
        String alertText = alert.getText();
        String accId = alertText.substring(alertText.length() -3);
        System.out.println(accId);
        alert.accept();


    }


}
