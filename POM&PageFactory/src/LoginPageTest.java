import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginPageTest {
    private WebDriver driver;

    @BeforeTest
    public void setUp(){
        driver = WebDriverUtil.chromeDriverConnection();
    }

    @AfterTest
    public void closeSite(){
        //driver.quit();
    }

    @Test
    public void test1_CorrectCredentials(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.doLogin("ana", "ana123");
        LoginSuccessPage loginSuccessPage = new LoginSuccessPage(driver);
        Assert.assertTrue(loginSuccessPage.isLogged());
    }

    @Test
    public void test2_IncorrectUserCredentials(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.doLogin("Hola", "abc123");
        System.out.println("Mostrando: " + loginPage.errorMessage);
        Assert.assertEquals(loginPage.errorMessage.getText(), "Enter your userName and password correct");
    }

}
