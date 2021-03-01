package stepdefs;

import com.codeborne.selenide.*;
import com.codeborne.selenide.testng.ScreenShooter;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import utils.CookieChoice;
import utils.Locators;
import utils.SiteMethods;

import java.util.Arrays;
import java.util.Map;

import static com.codeborne.selenide.Selenide.*;


public class EntranceMenuSteps extends SiteMethods implements Locators {

    String[] arr;

    @Given("user on homepage")
    public void userOnHomepage() {
        Configuration.holdBrowserOpen = true;
        open(url);
        cookies(CookieChoice.accept);

    }

    @When("user open the entrance menu")
    public void userOpenTheEntranceMenu() {

        $(entranceMenuToggleButton).shouldBe(Condition.enabled).click();

    }

    @Then("all links in the menu should be usable")
    public void allLinksInTheMenuShouldBeUsable() {
        for(SelenideElement e: $$ (linksOfEntranceMenu)){
            Assert.assertTrue(verifyLink(e.getAttribute("href")));
        }
    }

    @And("user should be able to close the entrance menu")
    public void userShouldBeAbleToCloseTheEntranceMenu() {
        $(entranceMenuToggleButton).click();
    }

    @When("user select the language as {string}")
    public void userSelectTheLanguageAs(String selection) {
        String ch = selection.replaceAll("[ ]+", " ").trim();
        arr = ch.split(" ");
        //System.out.println(selection + " - " + ch + " - " + Arrays.toString(arr));

        $(buttonSelectLanguage).shouldBe(Condition.appear).click();
        ElementsCollection list;
        list = $$(listOfLanguages);
        for (String s : arr) {
            list = list.filter(Condition.text(s));
        }
        list.last().click();
        $(buttonGotoEntrance).click();
        cookies(CookieChoice.accept);
    }


    @Then("user should be navigate to related page")
    public void userShouldBeNavigateToRelatedPage() {
        String url = WebDriverRunner.url();

        Assert.assertTrue(url.contains(arr[0]));
        // arr[1] = "Eng"
        String key="";


        if (arr.length>1){
            for (Map.Entry<String, String> m : siteLangs.entrySet()){
                if (m.getKey().toLowerCase().contains(arr[1].toLowerCase())){
                    key = m.getKey();
                    System.out.println(key);
                    break;
                }
            }
            Assert.assertTrue(url.contains(siteLangs.get(key)));
        }


    }
}
