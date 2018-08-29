package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.awt.font.ShapeGraphicAttribute;

public class Browser {


    static WebDriver wd = new ChromeDriver();


    public static void goTo(String url){
        wd.get(url);
    }

    public static String title() {
        return wd.getTitle();
    }

    public static void close() {
        wd.close();
    }
}
