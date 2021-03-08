package utils;

import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.Map;

public interface Locators {

    String url = "https://www.ikea.com/";
    By entranceMenuToggleButton = By.cssSelector("nav.header>div");
    By cookieAcceptButton = By.cssSelector("button#onetrust-accept-btn-handler");
    By linksOfEntranceMenu = By.cssSelector("div.menu a");
    By buttonGotoEntrance = By.cssSelector("div.region-picker a");
    By buttonSelectLanguage = By.cssSelector("div.region-picker button");
    By listOfLanguages = By.cssSelector("div.menu li");
    By ikeaMenuLinks = By.cssSelector("div.menu a");

    HashMap<String, String> siteLangs = new HashMap<String, String>(){{
        put("ENGLISH", "en");
        put("DEUTSCH", "de");
        put("Français", "fr");
        put("Italiano", "it");
        put("Nederlands", "nl");
    }};

}
