package utils;

public class SiteSeleniumMethods {

    public void bekle(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
