import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginPageTest {
    private WebDriver driver;
    LoginPage loginPage;

    @BeforeTest
    public void setUp(){
        loginPage = new LoginPage(driver);
        driver = loginPage.chromeDriverConnection();
        loginPage.url("http://demo.guru99.com/test/newtours/index.php");
    }

    @AfterTest
    public void closeSite(){
        //driver.quit();
    }

    @Test
    public void test() throws InterruptedException{
        Assert.assertEquals("Welcome: Mercury Tours", loginPage.getTitle());
        loginPage.doLogin("ana", "ana123");
        Assert.assertTrue(loginPage.isTextPresent("Login Successfully"));
    }
}//end LoginPageTest
