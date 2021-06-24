import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends PageBase{
    @FindBy(xpath = "/html/head/body")
    WebElement titleElement;

    @FindBy(name = "userName")
    WebElement userNameElement;

    @FindBy(name = "password")
    WebElement passwordElement;

    @FindBy(name = "submit")
    WebElement btnSubmit;

    @FindBy(xpath = "//*[contains(text(), 'Enter your userName and password correct')]")
    WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
        driver.get("http://demo.guru99.com/test/newtours/");
        PageFactory.initElements(driver, this);
    }

    public void doLogin(String user, String password){
        userNameElement.sendKeys(user);
        passwordElement.sendKeys(password);
        btnSubmit.click();
    }//end function

    public String getTitle(){
        return titleElement.getText();
    }

    public String verifyErrorMessage(){
        return errorMessage.getText();
    }
}//end class LoginPage

