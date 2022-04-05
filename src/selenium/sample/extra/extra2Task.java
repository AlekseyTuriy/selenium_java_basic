package selenium.sample.extra;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.Color;

import java.io.File;

import static org.junit.Assert.assertEquals;


public class extra2Task {
    WebDriver driver;
    String libWithDriversLocation = System.getProperty("user.dir") + File.separator + "lib" + File.separator;

    @After
    public void endingTests() throws Exception {
        driver.close();
    }

    @Test
    public void runningOnFirefox() throws Exception {
        System.setProperty("webdriver.gecko.driver", libWithDriversLocation + "geckodriver.exe");
        driver = new FirefoxDriver();
//        TODO
//        go to page https://kristinek.github.io/site/examples/po
        driver.get("https://kristinek.github.io/site/examples/po");
//        check the background color of h1 element
        WebElement h1 = driver.findElement(By.xpath("//h1"));
        System.out.println( Color.fromString(h1.getCssValue("backgroung-color")));

    }

    @Test
    public void runningOnChrome() throws Exception {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver" + new selenium.ChangeToFileExtension().extension());
        driver = new ChromeDriver();
//        TODO
//        go to page https://kristinek.github.io/site/examples/po
//        check the background color of h1 element
        driver.get("https://kristinek.github.io/site/examples/po");
        WebElement h1 = driver.findElement(By.xpath("//h1"));
        System.out.println( Color.fromString(h1.getCssValue("color")));
        assertEquals("rgba(0, 0, 0, 1)",Color.fromString(h1.getCssValue("color")));
    }

    @Test
    public void runningOnIE() throws Exception {
        System.setProperty("webdriver.ie.driver", libWithDriversLocation + "IEDriverServer.exe");
        driver = new InternetExplorerDriver();
//        TODO
//        go to page https://kristinek.github.io/site/examples/po
        driver.get("https://kristinek.github.io/site/examples/po");
        WebElement h1 = driver.findElement(By.xpath("//h1"));
        System.out.println( Color.fromString(h1.getCssValue("color")));
        assertEquals("rgba(0, 0, 0, 1)",Color.fromString(h1.getCssValue("color")));
//        check the background color of h1 element
    }
}
