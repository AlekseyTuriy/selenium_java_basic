package selenium.tasks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class Task1 {
    WebDriver driver;

    @Before
    public void openPage() {

        String libWithDriversLocation = System.getProperty("user.dir") + File.separator + "lib" + File.separator;
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver" + new selenium.ChangeToFileExtension().extension());
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
    }

    @After
    public void closeBrowser() {
        driver.close();
    }

    @Test
    public void errorOnText() {
//        TODO
           String testText="test";
           driver.findElement(By.id("numb")).clear();
           driver.findElement(By.id("numb")).sendKeys(testText);

//        enter a text instead of a number, check that correct error is seen
           driver.findElement(By.tagName("button")).click();


           assertEquals("Please enter a number",driver.findElement(By.id("ch1_error")).getText());

    }

    @Test
    public void errorOnNumberTooSmall() {
//        TODO
        String testText="25";
        driver.findElement(By.id("numb")).clear();
        driver.findElement(By.id("numb")).sendKeys(testText);

       driver.findElement(By.tagName("button")).click();
       assertEquals("Number is too small",driver.findElement(By.id("ch1_error")).getText());
//        enter number which is too small (below 50), check that correct error is seen
    }

    @Test
    public void errorOnNumberTooBig() {

//        BUG: if I enter number 666 no errors where seen
        String testText="666";
        driver.findElement(By.id("numb")).clear();
        driver.findElement(By.id("numb")).sendKeys(testText);
        driver.findElement(By.tagName("button")).click();
        assertEquals("",driver.findElement(By.id("ch1_error")).getText());
//        TODO
        String testText1="120";
        driver.findElement(By.id("numb")).clear();
        driver.findElement(By.id("numb")).sendKeys(testText1);
        driver.findElement(By.tagName("button")).click();
        assertEquals("Number is too big",driver.findElement(By.id("ch1_error")).getText());

//        enter number which is too big (above 100), check that correct error is seen
    }

    @Test
    public void correctSquareRootWithoutRemainder() {
//        TODO
//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 2 is square root of 4),
//        then and press submit and check that correct no error is seen and check that square root is calculated correctly
        String testText1="81";
        driver.findElement(By.id("numb")).clear();
        driver.findElement(By.id("numb")).sendKeys(testText1);
        driver.findElement(By.tagName("button")).click();
        Alert alert = driver.switchTo().alert();
        double i= Math.sqrt(81);
        assertEquals("Square root of 81 is "+ String.format("%.2f",i),alert.getText());
        alert.accept();
        assertEquals("",driver.findElement(By.id("ch1_error")).getText());




    }

    @Test
    public void correctSquareRootWithRemainder() {
//        TODO
//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 1.732.. is square root of 3) and press submit,
//        then check that correct no error is seen and check that square root is calculated correctly
        String testText1="95";
        driver.findElement(By.id("numb")).clear();
        driver.findElement(By.id("numb")).sendKeys(testText1);
        driver.findElement(By.tagName("button")).click();
        Alert alert1 = driver.switchTo().alert();
        double i= Math.sqrt(95);;
        assertEquals("Square root of 95 is "+ String.format("%.2f",i),alert1.getText());

        alert1.accept();
        assertEquals("",driver.findElement(By.id("ch1_error")).getText());
//    for (int i = 50; i <= 100; i++) { // check them all!!!
//
//            if ((int) Math.sqrt(i) == Math.sqrt(i)) {
//                System.out.println("testNumber = " + i + " was skipped");
//                continue;
//            }
//
//            int testNumber = i;
//
//            driver.findElement(By.id("numb")).sendKeys(String.valueOf(testNumber));
//            driver.findElement(By.tagName("button")).click();
//
//            String expectedMessage =
//                    String.format(Locale.US, "Square root of %d is %.2f", testNumber, Math.sqrt(testNumber));
//
//            Alert alert = driver.switchTo().alert();
//            String actualMessage = alert.getText();
//            alert.accept();
//
//            assertEquals(expectedMessage, actualMessage);
//        }
//
//    }
//
//
//
    }
}
