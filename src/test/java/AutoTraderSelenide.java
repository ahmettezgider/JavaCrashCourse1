import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class AutoTraderSelenide {


    @BeforeClass
    public void beforeClass(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        Configuration.browserCapabilities = capabilities;
    }


    String url = "https://www.autotrader.com/";
    By byMake = By.cssSelector("button[title='Browse by Make']");
    By browseByStyle = By.cssSelector("button[title='Browse by Style']");
    By advancedSearch1 = By.xpath("//a[text()='Advanced Search']");
    By searchButton = By.xpath("//button[@class='btn btn-primary btn-block']");
    By makeDropDown = By.cssSelector("#makeCode");
    By modelDropDown = By.cssSelector("#ModelCode");

    @Test
    public void testPart1(){
        Configuration.startMaximized = true;
        open(url);
        $(byMake).shouldBe(Condition.enabled);
        $(browseByStyle).shouldBe(Condition.enabled);
        $(advancedSearch1).shouldBe(Condition.enabled);
        $(searchButton).shouldBe(Condition.enabled);
        $(makeDropDown).shouldBe(Condition.enabled);
        $(modelDropDown).shouldBe(Condition.text("Any Model"));
    }


    By advancedSearch2 = By.cssSelector("a[data-qaid='adv_srch']");
    By zipCode = By.cssSelector("#zip");
    By certified = By.xpath("//div[text()='Certified']");
    By convertible = By.xpath("//div[text()='Convertible']");
    By yearFrom = By.cssSelector("select[id='4101482096']");
    By yearTo = By.cssSelector("select[id='258002540']");
    By aracSecimSelecti = By.cssSelector("select[id='1970425032']");
    By searchBtn = By.xpath("//button[@class='btn btn-primary btn-block']");
    By searchlist = By.cssSelector("h2[data-cmp='subheading']");

    @Test(dependsOnMethods = "testPart1")
    public void testPart2(){
        $(advancedSearch2).click();
        $(zipCode).setValue("30004");
        $(certified).click();
        $(convertible).scrollTo().click();
        $(yearFrom).selectOptionByValue("2017");
        $(yearTo).selectOptionByValue("2020");
        $(aracSecimSelecti).scrollTo().selectOptionByValue("BMW");
        $(searchBtn).scrollTo().shouldBe(Condition.enabled).click();
        $$(searchlist).filter(Condition.text("BMW")).shouldHave(CollectionCondition.sizeGreaterThan(0));
        System.out.println($$(searchlist).size());
    }
}
