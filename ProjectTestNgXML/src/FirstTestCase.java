import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FirstTestCase {
    public final static String URL = "http://demo.guru99.com/test/newtours";
    public  static WebDriver driver;

    //methods under this annotation will be executed prior to the first test case in the TestNG file.
    @BeforeTest
    public void setUrl(){
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    //@test is used to tell that the method under it is a test case
    @Test(priority = 1)
    public static void verifyHomepageTitle() {
        driver.get(URL);
        String expectedTitle = "Welcome: Mercury Tours";
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        //La clase Assert se utiliza para realizar operaciones de verificacion de TestNG
        Assert.assertEquals(actualTitle,expectedTitle);
    }// end function

    @Test(priority = 3)
    public static void LoginSuccesfull(){
        driver.get(URL);
        WebElement name = driver.findElement(By.name("userName"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement btnSubmit = driver.findElement(By.name("submit"));
        name.sendKeys("Hola");
        password.sendKeys("123");
        btnSubmit.click();

        String expectedMessage = "Login Succesfully";
        System.out.println("expectedMessage = " + expectedMessage);
       // String actualMessage = driver.findElement(By.name("hello"));
    }
}
