package stepdefs;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class bookingCom {

    @Test
    public void test1(){

        String cookieAcceptButton = "button#onetrust-accept-btn-handler";
        By languageButton = By.cssSelector("button[data-modal-id='language-selection']");
        By languages = By.cssSelector("div.bui-group.bui-group--small li");


        open("https://www.booking.com/");

        /*
        if ($(cookieAcceptButton).is(Condition.enabled))
            $(cookieAcceptButton).click();

        if ($(cookieAcceptButton).isDisplayed())
            $(cookieAcceptButton).click();
        */
        $(cookieAcceptButton).shouldBe(Condition.enabled).click();
        $(languageButton).shouldBe(Condition.enabled).click();

        ElementsCollection langArr = $$(languages);

        langArr.forEach(e -> System.out.println(e.getText() + ", " + e.find("a").getAttribute("hreflang")));

        System.out.println("-----------------------------");

        langArr.filter(Condition.text("o")).forEach(e -> System.out.println(e.getText()));



    }


}
