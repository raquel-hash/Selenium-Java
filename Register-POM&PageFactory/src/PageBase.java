import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class PageBase {
    private final WebDriver driver;
    @FindBy(tagName = "body")
    WebElement body;
    public PageBase(WebDriver driver){
        this.driver=driver;
    }

    public boolean isTextPresent(String text){
        return body.getText().contains(text);
    }

    public void selectCheckBox(WebElement[] locators){
        for(WebElement locator: locators){
            locator.click();
        }
    }

    public void selectDropDown(WebElement locator, String selectValue){
        new Select(locator).selectByVisibleText(selectValue);
    }

    public WebElement findElement(WebElement element){
        return element;
    }

    public void mouseMove(WebElement locator){
        Actions actions = new Actions(driver);
        actions.moveToElement(locator);
        actions.release().perform();
    }
}
