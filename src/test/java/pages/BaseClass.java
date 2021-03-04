package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;
import utils.SiteSeleniumMethods;
import utils.WaitConditions;


public class BaseClass extends SiteSeleniumMethods {


    WebDriver driver;
    WebDriverWait wait;

    public BaseClass(){
        driver = Driver.getDriver();
        wait = new WebDriverWait(driver, 10);

    }


    public void scrollAndClickTo(By selector){
        scrollTo(selector);
        clickTo(selector);
    }

    public void clickTo(By selector){
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(selector));
        element.click();
    }

    public void scrollTo(By selector){
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        WebElement e = wait.until(ExpectedConditions.presenceOfElementLocated(selector));
        js.executeScript("arguments[0].scrollIntoView();", e);
    }


    public WebElement waitFor(By selector, WaitConditions tobe){
        WebElement e;
        switch (tobe){
            case visible:
                //e = wait.until(ExpectedConditions.presenceOfElementLocated(selector));
                //e = wait.until(ExpectedConditions.visibilityOf(e));
                e = wait.until(ExpectedConditions.visibilityOf(waitFor(selector, WaitConditions.presence)));
                break;
            case clickable:
            case enable:
                e = wait.until(ExpectedConditions.elementToBeClickable(selector));
                break;
            default:
                e = wait.until(ExpectedConditions.presenceOfElementLocated(selector));
                break;
        }
        return e;
    }

}
