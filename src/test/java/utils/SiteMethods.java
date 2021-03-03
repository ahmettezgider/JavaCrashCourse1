package utils;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;


import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class SiteMethods implements Locators{

    public static final String urlClass = "https://www.ikea.com/";


    public void cookies(CookieChoice choice){
        sleep(500);
        switch (choice){
            case deny:
                break;
            case dontKnow:
                break;
            default:
                if ($(cookieAcceptButton).isDisplayed())
                    $(cookieAcceptButton).click();
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


    public boolean verifyImage(String url){
        try {
            URL urlSite = new URL(url);
            HttpURLConnection urlConnection = (HttpURLConnection) urlSite.openConnection();
            urlConnection.setConnectTimeout(3000);
            urlConnection.connect();
            if (urlConnection.getResponseCode()>=200 && urlConnection.getResponseCode()<400) {
                urlConnection.disconnect();
                return true;
            }else {
                String a = Selenide.screenshot("rsm" + new Random(1000));
                System.out.println(a);
                urlConnection.disconnect();
                return false;
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
            Selenide.screenshot("rsm" + new Random(1000));
            return false;
        }


    }
}
