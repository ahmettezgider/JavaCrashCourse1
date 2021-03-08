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

import java.util.List;


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

    public void scrollAndClickTo(WebElement element){
        scrollTo(element);
        clickTo(element);
    }

    public void clickTo(By selector){
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(selector));
        element.click();
    }

    public void clickTo(WebElement element){
        WebElement element1 = wait.until(ExpectedConditions.visibilityOf(element));
        element1.click();
    }

    public void scrollTo(By selector){
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        WebElement e = wait.until(ExpectedConditions.presenceOfElementLocated(selector));
        js.executeScript("arguments[0].scrollIntoView();", e);
    }

    public void scrollTo(WebElement element){
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView();", element);
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


    // Overload method
    public void clickToIn(By selector){
        List<WebElement> elements = driver.findElements(selector);  // $$()
        elements.get(0).click();
    }

    // Overload method
    public void clickToIn(By selector, int clickIndex){

        List<WebElement> elements = driver.findElements(selector);  // $$()
        if (clickIndex < 1) clickIndex = 1;
        if (clickIndex > elements.size()) clickIndex = elements.size();

        elements.get(clickIndex-1).click();
    }

    // Overload method
    public void clickToIn(By selector, String textInElement){
        List<WebElement> elements = driver.findElements(selector);  // $$()
        for (WebElement element : elements) {
            if (element.getText().toLowerCase().contains(textInElement.toLowerCase())) {
                clickTo(element);
                break;
            }
        }

    }


}
