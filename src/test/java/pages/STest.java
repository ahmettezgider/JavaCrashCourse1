package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utils.DriverPrimitiv;
import utils.Locators;
import utils.SiteSeleniumMethods;

public class STest extends SiteSeleniumMethods implements Locators {

    WebDriver driver;



    @Test
    public void test1(){
        /*
            //Manuel tanimlar

            System.setProperty("webdriver.chrome.driver", "d:/chromedriver.exe");
            WebDriver driver1 = new ChromeDriver();
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver2 = new ChromeDriver();



        driver2.get(url);
        bekle(2000);
        driver2.quit();



    }


    @Test
    public void test2(){
        DriverPrimitiv d = new DriverPrimitiv();

        driver = d.CreateDriver();

    }

}
