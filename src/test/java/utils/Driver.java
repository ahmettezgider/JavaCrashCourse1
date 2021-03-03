package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.Random;

public class Driver {

    private static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();
    public static ThreadLocal<String> browsers = new ThreadLocal<>();
    public static ThreadLocal<Integer> numbers = new ThreadLocal<>();


    public static WebDriver getDriver() {

        numbers.set(new Random().nextInt(100));

        if (browsers.get() == null)
            browsers.set("chrome");

        switch (browsers.get()){
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                drivers.set(new FirefoxDriver());
                break;
            case "ie":
                WebDriverManager.iedriver().setup();
                drivers.set(new InternetExplorerDriver());
                break;
            default:
                WebDriverManager.chromedriver().setup();
                drivers.set(new ChromeDriver());
                break;

        }
        return drivers.get();
    }

    public static void quitDriver(){
        if (drivers.get() != null) {
            drivers.get().quit();
            drivers.set(null);
        }
    }


}
