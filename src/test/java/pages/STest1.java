package pages;

import org.testng.annotations.Test;
import utils.DriverPrimitiv;
import utils.Locators;

public class STest1 extends DriverPrimitiv implements Locators {


    @Test
    public void test2(){
        CreateDriver();
        driver.get(url);

    }

}
