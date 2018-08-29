package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.ThreadLocalRandom;

public class newUser {

 @Test
    public void newUser() {

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

     //click Accounts
     wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Accounts")));
     ((ChromeDriver) wd).findElementByLinkText("Accounts").click();

     //Search account
     wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[3]/div[2]/div/div[1]/div[1]/ul/li[7]/a")));
     WebElement accIdSearch = ((ChromeDriver) wd).findElementByXPath("/html/body/div/div[2]/div/form/div/div/input");
     accIdSearch.sendKeys("569");
     accIdSearch.sendKeys(Keys.RETURN);

     //click Account Users
     wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/ng-include/div/div/ul[1]/li[5]/a")));
     WebElement accUsers = wd.findElement(By.xpath("/html/body/div/ng-include/div/div/ul[1]/li[5]/a"));
     accUsers.click();

     wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[1]/div[1]/a")));
     WebElement addUserButton = wd.findElement(By.xpath("/html/body/div/div[1]/div[1]/a"));
     addUserButton.click();

     //Waits for the Save button
     wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[2]/div[3]/div/div/button")));

     WebElement saveUserButton = ((ChromeDriver) wd).findElementByXPath("/html/body/div/div[2]/div[3]/div/div/button");
     userName = ((ChromeDriver) wd).findElementByXPath("/html/body/div/div[2]/div[1]/div/div/form/div[1]/div[1]/input");
     WebElement firstName = ((ChromeDriver) wd).findElementByXPath("/html/body/div/div[2]/div[1]/div/div/form/div[2]/div[1]/input");
     WebElement lastName = ((ChromeDriver) wd).findElementByXPath("/html/body/div/div[2]/div[1]/div/div/form/div[2]/div[2]/input");
     WebElement userEmail = ((ChromeDriver) wd).findElementByXPath("/html/body/div/div[2]/div[1]/div/div/form/div[3]/div[1]/input");
     WebElement accountId = ((ChromeDriver) wd).findElementByXPath("/html/body/div/div[2]/div[1]/div/div/form/div[1]/div[2]/input");
     Select timeZone = new Select (((ChromeDriver) wd).findElementByXPath("/html/body/div/div[2]/div[1]/div/div/form/div[4]/div/select"));
     WebElement phoneInput = ((ChromeDriver) wd).findElementByXPath("/html/body/div/div[2]/div[1]/div/div/form/div[3]/div[2]/input");
     WebElement adminPermit = ((ChromeDriver) wd).findElementByXPath("/html/body/div/div[2]/div[2]/div/div/div/a[2]");
     WebElement billingPermit = ((ChromeDriver) wd).findElementByXPath("/html/body/div/div[2]/div[2]/div/div/div/a[3]");
     WebElement techPermit = ((ChromeDriver) wd).findElementByXPath("/html/body/div/div[2]/div[2]/div/div/div/a[4]");

     int rn = ThreadLocalRandom.current().nextInt(15, 1500 + 1);

     String randomName = "User" + rn + "Selenium";

     userName.sendKeys(randomName);
     firstName.sendKeys("Joaquin");
     lastName.sendKeys("Selenium");
     userEmail.sendKeys("joaquin@thinq.com");
     timeZone.selectByValue("-3");
     phoneInput.sendKeys("9192487801");
     adminPermit.click();
     billingPermit.click();
     techPermit.click();
     saveUserButton.click();

     wait.until(ExpectedConditions.alertIsPresent());
     Alert alert = wd.switchTo().alert();
     alert.accept();

     WebElement userList = wd.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-6\"]/ul[1]/li[2]/a"));
     userList.click();

     wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[3]/div/div/div[1]/div[1]/ul/li[7]/a")));

     WebElement usernameSearch = wd.findElement(By.xpath("/html/body/div/div[2]/div/form/div/div/input"));
     usernameSearch.sendKeys(randomName);
     usernameSearch.sendKeys(Keys.RETURN);

 }
}
