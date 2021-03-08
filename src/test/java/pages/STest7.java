package pages;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.testng.annotations.Test;
import utils.Driver;
import utils.Locators;


import java.util.List;

public class STest7 extends BaseClass implements Locators {


    @Test
    public void test1(){
        driver.get(url);
        scrollAndClickTo(cookieAcceptButton);
        clickTo(entranceMenuToggleButton);
        bekle(1000);
        /*
        List<WebElement> links = driver.findElements(ikeaMenuLinks);
        int a=0;
        for (WebElement link : links) {
            a++;
            if (a==2)
                link.click();
            System.out.println(link.getText() + ", " + link.getAttribute("href")+ ", " + link.getAttribute("class"));
        }

        //links.forEach(link -> System.out.println(link.getText() + ", " + link.getAttribute("href")+ ", " + link.getAttribute("class")));

         */

        clickToIn(ikeaMenuLinks, "today  ");
        bekle(1000);
        //Driver.quitDriver();

        /*
            elementler listesi var, bunlar icinden istenilen birisine tiklazacak method


         */

    }


    @Test
    public void test2(){
        driver.get(url);
        //driver.manage().window().maximize();
        driver.manage().window().setSize(new Dimension(600, 600));
        driver.manage().window().setPosition(new Point(300, 200));
        scrollAndClickTo(cookieAcceptButton);
        clickTo(buttonSelectLanguage);
        clickToIn(listOfLanguages, "english");
        scrollAndClickTo(buttonGotoEntrance);
        bekle(1000);
        Driver.quitDriver();
    }


}
