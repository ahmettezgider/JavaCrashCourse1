package pages;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utils.DriverStatic;
import utils.Locators;

public class STest2 implements Locators {

    WebDriver driver;

    @Test
    public void test2(){

        driver = DriverStatic.getDriver();
        driver.get(url);

        driver = DriverStatic.getDriver();
        driver.get(url);

    }

}
