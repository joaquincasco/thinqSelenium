package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class wrongLogin {

    @Test
    public void invalidLogin() {

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
        userName.sendKeys("wrongUser");
        password.sendKeys("wrongPassword");
        password.sendKeys(Keys.RETURN);

        //Waits for the error message to be visible + assert:
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div[1]/div/span")));
        WebElement wrongError = wd.findElement(By.xpath("/html/body/div/div/div[1]/div/span"));
        Assert.assertEquals(true, wrongError.isDisplayed());

    }

}
