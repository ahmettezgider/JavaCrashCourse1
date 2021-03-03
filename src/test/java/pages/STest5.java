package pages;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.Driver;

public class STest5 extends Driver {
    WebDriver driver;

    @Parameters({"browser"})
    @Test
    public void test1(String browser){

        browsers.set(browser);
        driver = Driver.getDriver();
        driver.get("http://www.google.com");
        System.out.println(numbers.get());

        Driver.quitDriver();

    }


}
