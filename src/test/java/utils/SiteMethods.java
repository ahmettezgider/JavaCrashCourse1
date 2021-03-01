package utils;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;


import java.net.HttpURLConnection;
import java.net.URL;

import static com.codeborne.selenide.Selenide.$;

public class SiteMethods implements Locators{

    public static final String urlClass = "https://www.ikea.com/";


    public void cookies(CookieChoice choice){
        switch (choice){
            case deny:
                break;
            case dontKnow:
                break;
            default:
                $(cookieAcceptButton).shouldBe(Condition.enabled).click();
        }

    }


    public boolean verifyLink(String url){
        //Configuration.screenshots = true;
        //Configuration.reportsFolder = "/build/";
        try {
            URL urlSite = new URL(url);
            HttpURLConnection urlConnection = (HttpURLConnection) urlSite.openConnection();
            urlConnection.setConnectTimeout(3000);
            urlConnection.connect();
            if (urlConnection.getResponseCode()>=200 && urlConnection.getResponseCode()<400) {
                urlConnection.disconnect();
                return true;
            }else {
                String a = Selenide.screenshot("rsm.jpg");
                System.out.println(a);
                urlConnection.disconnect();
                return false;
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
            Selenide.screenshot("rsm.jpg");
            return false;
        }


    }


}
