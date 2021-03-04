package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverSingleton {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            WebDriverManager .chromedriver().setup();
            driver = new ChromeDriver();
        }
        return driver;
    }

    // browser"a göre
    public static WebDriver getDriver(String browser) {
        if (driver == null) {
            switch (browser) {
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "ie":
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
            }
        }
        return driver;
    }

    public static void quitDriver(){
        if (driver != null)
            driver.quit();
    }


    /*
        wait
        1. implicitly wait  : her element icin gecerlidir, existance
        2. explicit wait    : her bir element icin tanimlanir, belirli sartlar icin yapilan beklemedir.

        FluentWait
            Explicit

        FluentWait
            .withTimeOut()    -> 10 sn
            .poolingEvery() ->  kac sn"de bir kontrol etsin
            .ignoring(NoSuchElementException.class)    -> bu ara hangi hatalari görmezden gelsin

     */
}
