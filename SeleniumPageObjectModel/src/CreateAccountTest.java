import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateAccountTest {
    private WebDriver driver;
    CreateAccountPage createAccountPage;

    @BeforeTest
    public void setUp() throws Exception{
        createAccountPage = new CreateAccountPage(driver);
        driver = createAccountPage.chromeDriverConnection();
        createAccountPage.url("http://demo.guru99.com/test/newtours/index.php");
    }

    @AfterTest
    public void closeSite() throws Exception{
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

        Assert.assertTrue(createAccountPage.goToRegister());
        createAccountPage.createAccount(account);
        String expectedMessage = "Note: Your user name is " + account.getUserName();
        Assert.assertTrue(createAccountPage.isTextPresent(expectedMessage));
    }
}
