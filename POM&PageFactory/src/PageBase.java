import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

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
}
