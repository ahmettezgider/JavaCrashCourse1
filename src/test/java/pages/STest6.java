package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import utils.Driver;
import utils.Locators;
import utils.WaitConditions;

public class STest6 extends BaseClass implements Locators {

    @Test
    public void test1(){

        driver.get(url);
        scrollAndClickTo(cookieAcceptButton);
        clickTo(entranceMenuToggleButton);
        bekle(1000);
        clickTo(entranceMenuToggleButton);

        waitFor(By.linkText("About us"), WaitConditions.visible).click();

        //scrollTo(By.linkText("About us"));


        bekle(2000);
        Driver.quitDriver();


    }
}
