package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.awt.font.ShapeGraphicAttribute;

public class Browser {



    static WebDriver wd = new ChromeDriver();
    // -Dwebdriver.chrome.driver="C:\chrome_driver\chromedriver.exe"


    static void goTo(String url){
        wd.manage().window().maximize();
        wd.get(url);
    }

    static String title() {
        return wd.getTitle();
    }

    public static void close() {
        wd.close();
    }
}
