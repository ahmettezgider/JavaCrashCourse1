package pages;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utils.DriverSingleton;
import utils.Locators;

public class STest2 implements Locators {

    WebDriver driver;

    @Test
    public void test2(){

        driver = DriverSingleton.getDriver();
        driver.get(url);

        driver = DriverSingleton.getDriver();
        driver.get(url);

    }

}
