package selenium.sample;


import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class Sample1Task {
    static String libWithDriversLocation = System.getProperty("user.dir") + File.separator + "lib" + File.separator;

    @Test
    public void goToHomepage() throws Exception {
//        TODO:
//         define driver
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell\\Desktop\\My bootcamp\\Selenium\\selenium_java_basic\\lib\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://kristinek.github.io/site/index2.html");
        System.out.println("Title :"+ driver.getTitle());
        System.out.println("URL"+ driver.getCurrentUrl());
        Thread.sleep(500);
        driver.quit();
        //System.setProperty("webdriver.chrome")
//         go to https://kristinek.github.io/site/index2.html
//         get title of page
//         get URL of current page
//         close browser
    }
}
