package selenium.tasks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.io.File;
import static org.junit.Assert.*;

public class Task2 {
    WebDriver driver;

    @Before
    public void openPage() {
        String libWithDriversLocation = System.getProperty("user.dir") + File.separator + "lib" + File.separator;
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver" + new selenium.ChangeToFileExtension().extension());
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/tasks/provide_feedback");
    }

    @After
    public void closeBrowser() {
        driver.close();
    }

    @Test
    public void initialFeedbackPage() throws Exception {
//         TODO:
//         check that all field are empty and no tick are clicked
        assertEquals("",driver.findElement(By.cssSelector("#fb_form > form > div:nth-child(1) > div.w3-rest")).getText());
        assertEquals("",driver.findElement(By.id("fb_age")).getText());
//        language field
        assertFalse(driver.findElement(By.cssSelector("#lang_check > input:nth-child(2)")).isSelected());
        assertFalse(driver.findElement(By.cssSelector("#lang_check > input:nth-child(4)")).isSelected());
        assertFalse(driver.findElement(By.cssSelector("#lang_check > input:nth-child(6)")).isSelected());
        assertFalse(driver.findElement(By.cssSelector("#lang_check > input:nth-child(8)")).isSelected());
//      optional fiels
        assertFalse(driver.findElement(By.cssSelector("#fb_form > form > div:nth-child(4) > input:nth-child(2)")).isSelected());
        assertFalse(driver.findElement(By.cssSelector("#fb_form > form > div:nth-child(4) > input:nth-child(4)")).isSelected());
        assertFalse(driver.findElement(By.cssSelector("#like_us > option:nth-child(1)")).isEnabled());
//         "Don't know" is selected in "Genre"
        assertTrue(driver.findElement(By.cssSelector("#fb_form > form > div:nth-child(4) > input:nth-child(6)")).isSelected());
//         "Choose your option" in "How do you like us?"
        driver.findElement(By.cssSelector("#like_us > option:nth-child(2)")).click();
        assertTrue(driver.findElement(By.cssSelector("#like_us > option:nth-child(2)")).isSelected());
//         check that the button send is blue with white letters
        System.out.println(driver.findElement(By.className("w3-section")).getCssValue("background-color"));
        assertEquals("rgba(0, 0, 0, 0)",driver.findElement(By.className("w3-section")).getCssValue("background-color"));
        System.out.println(driver.findElement(By.className("w3-section")).getCssValue("color"));
        assertEquals("rgba(33, 150, 243, 1)",driver.findElement(By.className("w3-section")).getCssValue("color"));
    }

    @Test
    public void emptyFeedbackPage() throws Exception {
//         TODO:
//         click "Send" without entering any data
        driver.findElement(By.cssSelector("#fb_form > form > button")).click();
        //         check fields are empty or null
        assertEquals("",driver.findElement(By.id("name")).getText());
        assertEquals("",driver.findElement(By.id("age")).getText());
        assertEquals("",driver.findElement(By.id("language")).getText());
        assertEquals("null",driver.findElement(By.id("gender")).getText());
        assertEquals("null",driver.findElement(By.id("option")).getText());
        assertEquals("",driver.findElement(By.id("comment")).getText());
//        check button colors
        System.out.println(driver.findElement(By.cssSelector("#fb_thx > div > div.w3-btn-group > button.w3-btn.w3-green.w3-xlarge")).getCssValue("background-color"));
        assertEquals("rgba(76, 175, 80, 1)",driver.findElement(By.cssSelector("#fb_thx > div > div.w3-btn-group > button.w3-btn.w3-green.w3-xlarge")).getCssValue("background-color"));
        System.out.println(driver.findElement(By.cssSelector("#fb_thx > div > div.w3-btn-group > button.w3-btn.w3-green.w3-xlarge")).getCssValue("color"));
        assertEquals("rgba(255, 255, 255, 1)",driver.findElement(By.cssSelector("#fb_thx > div > div.w3-btn-group > button.w3-btn.w3-green.w3-xlarge")).getCssValue("color"));
//      check letters color
        System.out.println(driver.findElement(By.cssSelector("#fb_thx > div > div.w3-btn-group > button.w3-btn.w3-red.w3-xlarge")).getCssValue("color"));
        assertEquals("rgba(244, 67, 54, 1)",driver.findElement(By.cssSelector("#fb_thx > div > div.w3-btn-group > button.w3-btn.w3-red.w3-xlarge")).getCssValue("background-color"));
        System.out.println(driver.findElement(By.cssSelector("#fb_thx > div > div.w3-btn-group > button.w3-btn.w3-red.w3-xlarge")).getCssValue("color"));
        assertEquals("rgba(255, 255, 255, 1)",driver.findElement(By.cssSelector("#fb_thx > div > div.w3-btn-group > button.w3-btn.w3-red.w3-xlarge")).getCssValue("color"));

//         (green with white letter and red with white letters)
    }

    @Test
    public void notEmptyFeedbackPage() throws Exception {
//         TODO:
//         fill the whole form, click "Send"
        driver.findElement(By.id("fb_name")).sendKeys("Futher");

        driver.findElement(By.id("fb_age")).sendKeys("80");
//       language

        driver.findElement(By.cssSelector("#lang_check > input:nth-child(2)")).click();

//      Gender

//      "Don't know" is selected in "Genre"
        assertTrue(driver.findElement(By.cssSelector("#fb_form > form > div:nth-child(4) > input:nth-child(6)")).isSelected());
//         "Choose your option" in "How do you like us?"
        driver.findElement(By.cssSelector("#like_us > option:nth-child(3)")).click();
//        Check if Ok, i guess is selected
        assertTrue(driver.findElement(By.cssSelector("#like_us > option:nth-child(3)")).isSelected());
//        Fill in Comments
        driver.findElement(By.cssSelector("#fb_form > form > div:nth-child(6) > textarea")).sendKeys("What a wonderfull day");
//      click send
        driver.findElement(By.cssSelector("#fb_form > form > button")).click();
//         check fields are filled correctly
        Thread.sleep(10000);
        assertEquals("Futher",driver.findElement(By.id("name")).getText());
        assertEquals("80",driver.findElement(By.id("age")).getText());
        assertEquals("English",driver.findElement(By.id("language")).getText());
        assertEquals("null",driver.findElement(By.id("gender")).getText());
        assertEquals("Ok, i guess",driver.findElement(By.id("option")).getText());
        assertEquals("What a wonderfull day",driver.findElement(By.id("comment")).getText());
//         check button colors
        System.out.println(driver.findElement(By.cssSelector("#fb_thx > div > div.w3-btn-group > button.w3-btn.w3-green.w3-xlarge")).getCssValue("background-color"));
        assertEquals("rgba(76, 175, 80, 1)",driver.findElement(By.cssSelector("#fb_thx > div > div.w3-btn-group > button.w3-btn.w3-green.w3-xlarge")).getCssValue("background-color"));
        System.out.println(driver.findElement(By.cssSelector("#fb_thx > div > div.w3-btn-group > button.w3-btn.w3-green.w3-xlarge")).getCssValue("color"));
        assertEquals("rgba(255, 255, 255, 1)",driver.findElement(By.cssSelector("#fb_thx > div > div.w3-btn-group > button.w3-btn.w3-green.w3-xlarge")).getCssValue("color"));
//      check letters color
        System.out.println(driver.findElement(By.cssSelector("#fb_thx > div > div.w3-btn-group > button.w3-btn.w3-red.w3-xlarge")).getCssValue("color"));
        assertEquals("rgba(244, 67, 54, 1)",driver.findElement(By.cssSelector("#fb_thx > div > div.w3-btn-group > button.w3-btn.w3-red.w3-xlarge")).getCssValue("background-color"));
        System.out.println(driver.findElement(By.cssSelector("#fb_thx > div > div.w3-btn-group > button.w3-btn.w3-red.w3-xlarge")).getCssValue("color"));
        assertEquals("rgba(255, 255, 255, 1)",driver.findElement(By.cssSelector("#fb_thx > div > div.w3-btn-group > button.w3-btn.w3-red.w3-xlarge")).getCssValue("color"));

//         (green with white letter and red with white letters)
    }

    @Test
    public void yesOnWithNameFeedbackPage() throws Exception {
//         TODO:
//         enter only name
        driver.findElement(By.id("fb_name")).sendKeys("Futher");
//         click "Send"
        driver.findElement(By.cssSelector("#fb_form > form > button")).click();
//         click "Yes"
        driver.findElement(By.cssSelector("#fb_thx > div > div.w3-btn-group > button.w3-btn.w3-green.w3-xlarge")).click();
//         check message text: "Thank you, NAME, for your feedback!"
        assertEquals("Thank you, Futher, for your feedback!",driver.findElement(By.id("message")).getText());
//         color of text is white with green on the background
        System.out.println(driver.findElement(By.id("message")).getCssValue("background-color"));
        assertEquals("rgba(0, 0, 0, 0)",driver.findElement(By.id("message")).getCssValue("background-color"));
//        check letters color
        System.out.println(driver.findElement(By.id("message")).getCssValue("color"));
        assertEquals("rgba(255, 255, 255, 1)",driver.findElement(By.id("message")).getCssValue("color"));

    }

    @Test
    public void yesOnWithoutNameFeedbackPage() throws Exception {
//         TODO:
//         click "Send" (without entering anything
        driver.findElement(By.cssSelector("#fb_form > form > button")).click();
//         click "Yes"
        driver.findElement(By.cssSelector("#fb_thx > div > div.w3-btn-group > button.w3-btn.w3-green.w3-xlarge")).click();
//         check message text: "Thank you for your feedback!"
        assertEquals("Thank you for your feedback!",driver.findElement(By.id("message")).getText());
//         color of text is white with green on the background
        System.out.println(driver.findElement(By.id("message")).getCssValue("background-color"));
        assertEquals("rgba(0, 0, 0, 0)",driver.findElement(By.id("message")).getCssValue("background-color"));
//        check letters color
        System.out.println(driver.findElement(By.id("message")).getCssValue("color"));
        assertEquals("rgba(255, 255, 255, 1)",driver.findElement(By.id("message")).getCssValue("color"));
    }

    @Test
    public void noOnFeedbackPage() throws Exception {
//         TODO:
//         fill the whole form
        driver.findElement(By.id("fb_name")).sendKeys("Futher");

        driver.findElement(By.id("fb_age")).sendKeys("80");
        driver.findElement(By.cssSelector("#lang_check > input:nth-child(2)")).click();

//      Gender

//      "Don't know" is selected in "Male"
        driver.findElement(By.cssSelector("#fb_form > form > div:nth-child(4) > input:nth-child(2)")).click();
//         "Choose your option" in "How do you like us?" to OK.i guess
        driver.findElement(By.cssSelector("#like_us > option:nth-child(3)")).click();
//        Fill in Comments
        driver.findElement(By.cssSelector("#fb_form > form > div:nth-child(6) > textarea")).sendKeys("What a wonderfull day");
//      click send
        driver.findElement(By.cssSelector("#fb_form > form > button")).click();
//      click "No"
        driver.findElement(By.cssSelector("#fb_thx > div > div.w3-btn-group > button.w3-btn.w3-red.w3-xlarge")).click();
//         check fields are filled correctly

//        Name age fields
        assertEquals("Futher",driver.findElement(By.xpath("//*[@id=\"fb_name\"]")).getAttribute("value"));
//        assertEquals("80",driver.findElement(By.id("fb_age")).getText());
         assertEquals("80",driver.findElement(By.id("fb_age")).getAttribute("value"));
//        language
        assertTrue(driver.findElement(By.cssSelector("#lang_check > input:nth-child(2)")).isSelected());
//        Gender is Male selected
        assertTrue(driver.findElement(By.cssSelector("#fb_form > form > div:nth-child(4) > input:nth-child(2)")).isSelected());
//        Optional is OK,i guess selected
        assertTrue(driver.findElement(By.cssSelector("#like_us > option:nth-child(3)")).isSelected());
//        comments is filled What a wonderfull day
        assertEquals("What a wonderfull day",driver.findElement(By.cssSelector("#fb_form > form > div:nth-child(6) > textarea")).getAttribute("value"));




    }
}
