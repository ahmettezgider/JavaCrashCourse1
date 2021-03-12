package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class IkeaPlanner implements IkeaPlannerLocators{

    @Test
    public void test1(){

        open(url);
        //$$(products).filter(Condition.text("desk")).forEach(e -> System.out.println(e.getText()));

        $$(products)
                .filter(Condition.text("desk"))
                .first()
                .scrollTo()
                .click();


        //$(logo).shouldBe(exist, enabled, text("logo"), attributeMatching("class", "logo"));
        $(logo).shouldBe(enabled);

        switchTo().frame($("iframe.planner-iframe").shouldBe(enabled));
        $(buttons, 1).shouldBe(enabled).click();
        $$(menuSelectorAktiv).forEach(e-> System.out.println(e.getAttribute("class")));
//.filter(Condition.attributeMatching("class", "selectable"))

        $$(menuSelectorAktiv).get(1).click();
        sleep(2000);
        $(menuSelectorAktiv,2).click();
        sleep(2000);

        switchTo().parentFrame();
        $(inputSearch).scrollTo().setValue("desk").pressEnter();
        sleep(2000);
    }


}


interface IkeaPlannerLocators{
    String url = "https://www.ikea.com/us/en/planners/";
    By products = By.cssSelector("div[data-pub-type='page-list'] > div> div");
    By buttons = By.cssSelector("div.menu-button");
    By menuSelectorAktiv = By.cssSelector("div.menu-selector.active li");
    By logo = By.cssSelector("div[class$='header__logo']");
    By inputSearch = By.cssSelector("input[name='q']");
}


