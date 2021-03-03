package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.DriverStatic;
import utils.Locators;

public class STest3 implements Locators {

    WebDriver driver;
    WebDriverWait wait;



    @Test
    public void test1(){

        driver = DriverStatic.getDriver();

        driver.get(url);
        driver.findElement(entranceMenuToggleButton).click();




    }
}
