package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class deneme1 {

    @Test
    public void test1() {
        By mainMenuHeaders = By.cssSelector("ul.nav> li");

        open("http://opencart.abstracta.us/");
        /*
        for (SelenideElement element : $$(mainMenuHeaders)) {
            System.out.println(element.getText());
            System.out.println(element.hover().getText());
            System.out.println("--------------");
        }


        $$(mainMenuHeaders).forEach(e -> {
                    System.out.println(e.getText());
                    System.out.println(e.hover().getText());
                    System.out.println("--------------");
                }
        );


        for (SelenideElement element : $$(mainMenuHeaders)){
            writeTextOf(element, "pc", "test");
        }

        $$(mainMenuHeaders).filter(Condition.text("a")).forEach(e-> System.out.println(e.getText()));


        $$(mainMenuHeaders).forEach(e->{
            e.hover();
            if (e.getText().toLowerCase().contains("test"))
                System.out.println(e.getText());

        });

         */

        List<SelenideElement> list = getListOf($$(mainMenuHeaders), "Desk", "Tab", "Comp");
        list.forEach(e-> System.out.println(e.getText()));
    }




    public void writeTextOf(SelenideElement e, String...str){
        for (String s : str) {
            if (e.hover().getText().toLowerCase().contains(s.toLowerCase()))
                System.out.println(e.getText());
        }

    }
    /*
        {a, ab, acd, bc}


     */
    public List<SelenideElement> getListOf(ElementsCollection collection, String...str){

        List<SelenideElement> list = new ArrayList<>();

        for (String s : str) {
            for (SelenideElement element : collection) {
                if (element.getText().contains(s))
                    list.add(element);
            }
        }
        return list;
    }
}



/*
    driver definition

    driver.get(url)
    wait
    WebElement e = driver.findElement(By.())
    e.action();



    open(url);
    $(selector).should();
    $(selector).action();







 */