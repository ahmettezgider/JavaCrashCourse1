package stepdefs;

import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.CookieChoice;
import utils.Locators;
import utils.SiteMethods;

import static com.codeborne.selenide.Selenide.*;

public class Images extends SiteMethods implements Locators {
    @Test
    public void images(){

        open(url);
        cookies(CookieChoice.accept);
/*
        // verify links and images
        $$("img").forEach(e-> Assert.assertTrue(verifyLink(e.getAttribute("src"))));

        // find heigth of the images on hover and not hover
        $$("img").forEach(e-> {
                        e.hover();
                        //System.out.println(e.getAttribute("srcset") + e.getAttribute("src"));
                    System.out.println(e.getSize().height);
                }
            );

      int i=0;
        for (SelenideElement e : $$ ("img")){
            e.hover();
            if (i>=1 && i<5) {
                int w1 = e.getSize().height;
                e.hover();
                int w2 = e.getSize().height;
                Assert.assertNotEquals(w1, w2);
            }
            i++;
        }
        */
        for (int j = 1; j < 5; j++) {
            SelenideElement e = $("img", j);
            int w1 = e.getSize().height;
            e.hover();
            int w2 = e.getSize().height;
            Assert.assertNotEquals(w1, w2);
        }

    }
}
