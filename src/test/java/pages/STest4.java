package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import utils.DriverStatic;
import utils.Locators;

public class STest4 extends BaseClass implements Locators {

    @Test
    public void test1(){


        driver.get(url);

        WebElement cookieAccept = wait.until(ExpectedConditions.elementToBeClickable(cookieAcceptButton));
        cookieAccept.click();
        WebElement e = wait.until(ExpectedConditions.elementToBeClickable(entranceMenuToggleButton));
        e.click();
        bekle(2000);
        DriverStatic.quitDriver();



    }
}
