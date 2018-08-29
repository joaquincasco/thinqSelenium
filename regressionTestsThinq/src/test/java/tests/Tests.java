package tests;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Browser;
import pages.loginPage;

import java.util.concurrent.TimeUnit;

public class Tests {



    @Test
    public void logIn(){
        System.setProperty("webdriver.chrome.driver", "C:/chrome_driver/chromedriver.exe");
        loginPage.homePage().goTo();
        Assert.assertTrue(loginPage.homePage().isAt());
        loginPage.homePage().logIn();
        loginPage.homePage().accountsBtn();
        loginPage.homePage().accountsPage();
        loginPage.homePage().createAcc();

    }

    @Test
    public void createUser(){

        loginPage.homePage().goTo();
        loginPage.homePage().createNewUser();

    }




}
