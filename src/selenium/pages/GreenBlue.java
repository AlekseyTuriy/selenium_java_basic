package selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

 public class GreenBlue extends GenericSamplePage {

    @FindBy(how = How.ID, using = "start_green") // By.id("name")
    private WebElement startGreen;
    @FindBy(how = How.ID, using = "loading_green") // By.name("age")
    private WebElement loadindGreen;
    @FindBy(how = How.ID, using = "finish_green")
    private WebElement finishGreen;

    public void startClick() {
        startGreen.click();
    }
     public boolean stratrGreenisDisplayed() {
         return startGreen.isDisplayed();
     }
     public boolean loadingGreenDisplayed() {
         return loadindGreen.isDisplayed();
     }
     public boolean finishGreenDisplayed() {
         return finishGreen.isDisplayed();
     }
     public String finishGreentext() {
         return finishGreen.getText();
     }
}
