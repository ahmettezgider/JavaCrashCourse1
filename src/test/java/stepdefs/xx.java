package stepdefs;

import org.testng.annotations.Test;
import utils.Locators;
import utils.Locators1;
import utils.SiteMethods;

public class xx extends SiteMethods implements Locators, Locators1 {

    public static void main(String[] args) {
        String str = "a";

        System.out.println(aa.a.getNum());
        System.out.println(aa.valueOf(str).getNum());
        System.out.println(aa.b == aa.valueOf("b"));
    }


    @Test
    public void test1(){
        System.out.println(urlClass);
        System.out.println(url);




    }


    @Override
    public void deneme() {

    }
}

enum aa{
    a("1"),
    b("2"),
    c("3")
    ;

    private String num;

    aa(String num) {
        this.num = num;
    }

    public String getNum() {
        return num;
    }
}