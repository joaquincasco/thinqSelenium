package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.ThreadLocalRandom;

import static pages.Browser.wd;

public class Pages {

    static String url = "http://diego.rdu.vamp.com/panel/dev/#/login";
    static String title = "Management Panel";
    static String accId;

    public void goTo() {
        Browser.goTo(url);
    }


    public boolean isAt() {
        return Browser.title().equals(title);
    }

    public void logIn() {

        WebDriverWait wait = new WebDriverWait(wd, 20);
        wd.get(url);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("username")));
        WebElement username = wd.findElement(By.id("username"));
        WebElement password = wd.findElement(By.id("pass"));
        WebElement loginBtn = wd.findElement(By.xpath("/html/body/div/div/form/button"));
        username.sendKeys("superadmin");
        password.sendKeys("Asdasd11");
        loginBtn.click();

    }

    public void accountsBtn() {

        WebDriverWait wait = new WebDriverWait(wd, 20);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"bs-example-navbar-collapse-6\"]/ul[1]/li[1]/a")));
        WebElement accounts = wd.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-6\"]/ul[1]/li[1]/a"));
        accounts.click();

    }

    public void accountsPage(){

        WebDriverWait wait = new WebDriverWait(wd, 20);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[3]/div[2]/div/div[1]/div[1]/ul/li[7]/a")));
        WebElement addAccBtn = wd.findElement(By.xpath("/html/body/div/div[1]/div[1]/a"));
        addAccBtn.click();

    }

    public void createAcc() {

        WebDriverWait wait = new WebDriverWait(wd, 20);
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

    public void createNewUser(){

        WebDriverWait wait = new WebDriverWait(wd, 20);
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
        WebElement userName = ((ChromeDriver) wd).findElementByXPath("/html/body/div/div[2]/div[1]/div/div/form/div[1]/div[1]/input");
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
