package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.pages.GreenBlue;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class Sample9Task {
    WebDriver driver;
    static GreenBlue GreenBlue;

    @Before
    public void openPage() {
        String libWithDriversLocation = System.getProperty("user.dir") + File.separator + "lib" + File.separator;
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver" + new selenium.ChangeToFileExtension().extension());
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/examples/loading_color");
    }

    @After
    public void closeBrowser() {
        driver.close();
    }

    @Test
    public void loadGreenSleep() throws Exception {
//         TODO:
        GreenBlue = PageFactory.initElements(driver,GreenBlue.class);
//         * 1) click on start loading green button
        GreenBlue.startClick();
//        driver.findElement(By.id("start_green")).click();
        //         * 2) check that button does not appear,
            assertFalse(GreenBlue.stratrGreenisDisplayed());
//        assertFalse(driver.findElement(By.id("start_green")).isDisplayed());
//         * but loading text is seen instead   "Loading green..."
        assertTrue(GreenBlue.loadingGreenDisplayed());
//        assertTrue(driver.findElement(By.id("loading_green")).isDisplayed());

//         * 3) check that both button
        Thread.sleep(5000);
        assertFalse(GreenBlue.stratrGreenisDisplayed());
        assertFalse(GreenBlue.loadingGreenDisplayed());
//        assertFalse(driver.findElement(By.id("start_green")).isDisplayed());
//        assertFalse(driver.findElement(By.id("loading_green")).isDisplayed());
//         * and loading text is not seen,
//         * success is seen instead "Green Loaded"
        assertTrue(GreenBlue.finishGreenDisplayed());
        assertEquals("Green Loaded", GreenBlue.finishGreentext());
//        assertTrue(driver.findElement(By.id("finish_green")).isDisplayed());
//        assertEquals("Green Loaded",driver.findElement(By.id("finish_green")).getText());

    }

    @Test
    public void loadGreenImplicit() throws Exception {
//         TODO:
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//         * 1) click on start loading green button
//        GreenBlue.startClick();
        driver.findElement(By.id("start_green")).click();
        //         * 2) check that button does not appear,
        assertFalse(driver.findElement(By.id("start_green")).isDisplayed());

//         * but loading text is seen instead   "Loading green..."
        assertTrue(driver.findElement(By.id("loading_green")).isDisplayed());

//         * 3) check that both button
//         * and loading text is not seen,
        assertTrue(driver.findElement(By.id("finish_green")).isDisplayed());
        assertEquals("Green Loaded",driver.findElement(By.id("finish_green")).getText());
//         * success is seen instead "Green Loaded"
        assertFalse(driver.findElement(By.id("start_green")).isDisplayed());
        assertFalse(driver.findElement(By.id("loading_green")).isDisplayed());
    }

    @Test
    public void loadGreenExplicitWait() throws Exception {
//         TODO:
//         * 1) click on start loading green button
        WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver,5).ignoring(StaleElementReferenceException.class);
        GreenBlue.startClick();
//        driver.findElement(By.id("start_green")).click();
        assertFalse(driver.findElement(By.id("start_green")).isDisplayed());
//         * 2) check that button does not appear,
        assertFalse(driver.findElement(By.id("start_green")).isDisplayed());
//         * but loading text is seen instead   "Loading green..."
        assertTrue(driver.findElement(By.id("loading_green")).isDisplayed());

        assertEquals("Loading green...",driver.findElement(By.id("loading_green")).getText());
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("finish_green")));
//         * 3) check that both button
        assertFalse(driver.findElement(By.id("start_green")).isDisplayed());

        assertFalse(driver.findElement(By.id("loading_green")).isDisplayed());
//         * and loading text is not seen,
//         * success is seen instead "Green Loaded"
        assertTrue(driver.findElement(By.id("finish_green")).isDisplayed());
        assertEquals("Green Loaded",driver.findElement(By.id("finish_green")).getText());
    }

    @Test
    public void loadGreenAndBlueBonus() {
//         TODO:
//         * 0) wait until button to load green and blue appears
         WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver,5).ignoring(StaleElementReferenceException.class);
         wait.until(ExpectedConditions.presenceOfElementLocated(By.id("start_green_and_blue")));
//         * 1) click on start loading green and blue button
        driver.findElement(By.id("start_green_and_blue")).click();
//         * 2) check that button does not appear, but loading text is seen instead for green

//         * 3) check that button does not appear, but loading text is seen instead for green and blue
//         * 4) check that button and loading green does not appear,
//         * 		but loading text is seen instead for blue and success for green is seen
//         * 5) check that both button and loading text is not seen, success is seen instead

    }

}