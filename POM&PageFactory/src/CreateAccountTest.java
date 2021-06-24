import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateAccountTest {
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
    public void test() throws InterruptedException{
        Account account = new Account("ana123@gmail.com", "ana", "ana123", "ana123");
        account.setFirstName("Ana")
                .setLastName("Banana")
                .setAddress("calle #123")
                .setCity("Austria")
                .setCountry("AUSTRIA")
                .setPhone("1234567")
                .setPostalCode("50156567")
                .setStateProvince("Cercado");
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        Assert.assertTrue(createAccountPage.goToRegister());
        createAccountPage.createAccount(account);
        String expectedMessage = "Note: Your user name is " + account.getUserName();
        Assert.assertTrue(createAccountPage.isTextPresent(expectedMessage));
    }
}
