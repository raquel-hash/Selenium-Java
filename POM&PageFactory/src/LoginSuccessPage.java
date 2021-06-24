import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginSuccessPage extends PageBase{

    public LoginSuccessPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isLogged() {
        return isTextPresent("Login Successfully");
    }

}
