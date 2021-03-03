package stepdefs;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class bookingCom2 {

    String cookieAcceptButton = "button#onetrust-accept-btn-handler";
    By languageButton = By.cssSelector("button[data-modal-id='language-selection']");
    By languages = By.cssSelector("div.bui-group.bui-group--small li");

    @Test
    public void test1(){
        open("https://www.booking.com/");

        $(cookieAcceptButton).shouldBe(Condition.enabled).click();
        $(languageButton).shouldBe(Condition.enabled).click();

        ElementsCollection langArr = $$(languages);

        for (int i = 0; i < langArr.size(); i++) {
            clickLang(i);
            $(languageButton).shouldBe(Condition.enabled).click();
        }

    }


    public void clickLang(int i){
        ElementsCollection langArr = $$(languages);
        langArr.get(i).find("a").click();
    }


}
