import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageBase{

    //variables constantes
    private final static By userNameLocator = By.name("userName");
    private final static By passwordLocator = By.name("password");
    private final static By btnSubmit = By.name("submit");


    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void doLogin(String user, String password){
        type(userNameLocator, user);
        type(passwordLocator, password);
        clickElement(btnSubmit);
    }// end function
}//end class LoginPage
