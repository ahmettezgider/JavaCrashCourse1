package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverStatic;
import utils.SiteSeleniumMethods;


public class BaseClass extends SiteSeleniumMethods {


    WebDriver driver;
    WebDriverWait wait;

    public BaseClass(){
        driver = DriverStatic.getDriver();
        wait = new WebDriverWait(driver, 10);

    }


}
