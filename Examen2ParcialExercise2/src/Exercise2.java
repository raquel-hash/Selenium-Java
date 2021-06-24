import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Exercise2 {
    public final static String URL = "http://demo.guru99.com/V1/index.php";
    public  static WebDriver driver;

    @BeforeTest
    public void setUrl(){
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(URL);
    }

    @Test(priority = 1)
    public void  emptyCredentials(){
        setUrl();
        boolean invalidCredentials;
        String expectedMessage= "Is not valid";

        driver.findElement(By.name("btnLogin")).click();
        Alert alert = driver.switchTo().alert();
        if(alert.getText().equals(expectedMessage)){
            invalidCredentials = true;
        }else{
            invalidCredentials = false;
        }
        Assert.assertTrue(invalidCredentials);
        System.out.println("Test Passed 1");
        endSesion();
    }

    @Test(priority = 2)
    public void  invalidCredentials(){
        setUrl();
        boolean invalidCredentials;
        String expectedMessage= "User is not valid";
        driver.findElement(By.name("uid")).sendKeys("user1");
        driver.findElement(By.name("password")).sendKeys("12345");
        driver.findElement(By.name("btnLogin")).click();
        Alert alert = driver.switchTo().alert();
        if(alert.getText().equals(expectedMessage)){
            invalidCredentials = true;
        }else{
            invalidCredentials = false;
        }
        Assert.assertTrue(invalidCredentials);
        System.out.println("Test Passed 2");
        endSesion();
    }

    @Test(priority = 3)
    public void  verifyButtonReset(){
        setUrl();
        boolean emptyCredentials;
        WebElement user = driver.findElement(By.name("uid"));
        user.sendKeys("user1");
        WebElement pass = driver.findElement(By.name("password"));
        pass.sendKeys("12345");
        driver.findElement(By.name("btnReset")).click();
        if(user.getAttribute("value").isEmpty() && pass.getAttribute("value").isEmpty()){
            emptyCredentials=true;
        }else{
            emptyCredentials=false;
        }
        Assert.assertTrue(emptyCredentials);
        System.out.println("Test Passed 3");
        endSesion();
    }

    @Test(priority = 4)
    public void UserInvalid(){
        setUrl();
        boolean invalidUser;
        String expectedMessage= "User is not valid";
        driver.findElement(By.name("uid")).sendKeys("mngr329698");
        driver.findElement(By.name("password")).sendKeys("12345");
        driver.findElement(By.name("btnLogin")).click();
        Alert alert = driver.switchTo().alert();
        if(alert.getText().equals(expectedMessage)){
            invalidUser = true;
        }else{
            invalidUser = false;
        }
        Assert.assertTrue(invalidUser);
        System.out.println("Test Passed 4");
        endSesion();
    }

    @Test(priority = 5)
    public void PasswordInvalid(){
        setUrl();
        boolean invalidUser;
        String expectedMessage= "User is not valid";
        driver.findElement(By.name("uid")).sendKeys("user1");
        driver.findElement(By.name("password")).sendKeys("Utedeve");
        driver.findElement(By.name("btnLogin")).click();
        Alert alert = driver.switchTo().alert();
        if(alert.getText().equals(expectedMessage)){
            invalidUser = true;
        }else{
            invalidUser = false;
        }
        Assert.assertTrue(invalidUser);
        System.out.println("Test Passed 5");
        endSesion();
    }

    @Test(priority = 6)
    public void LoginSuccefull(){
        setUrl();
        boolean validUser;
        String expectedMessage= "Welcome To Manager's Page of GTPL Bank";
        driver.findElement(By.name("uid")).sendKeys("mngr329698");
        driver.findElement(By.name("password")).sendKeys("Utedeve");
        driver.findElement(By.name("btnLogin")).click();
        WebElement label = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[2]/td/marquee"));
        System.out.println(label.getText());
        if (label.getText().equals(expectedMessage)){
            validUser = true;
        }else{
            validUser = false;
        }
        Assert.assertTrue(validUser);
        System.out.println("Test Passed 6");
        endSesion();
    }

    @Test(priority = 7)
    public void VerifyLoggedOut(){
        setUrl();
        boolean logoutValid;
        driver.findElement(By.name("uid")).sendKeys("mngr329698");
        driver.findElement(By.name("password")).sendKeys("Utedeve");
        driver.findElement(By.name("btnLogin")).click();
        String expectedMessage= "You Have Succesfully Logged Out!!";
        driver.findElement(By.linkText("Log out")).click();
        Alert alert = driver.switchTo().alert();
        if(alert.getText().equals(expectedMessage)){
            logoutValid = true;
        }else{
            logoutValid = false;
        }
        Assert.assertTrue(logoutValid);
        System.out.println("Test Passed 7");
        endSesion();
    }

    @AfterTest
    public void endSesion(){
        driver.quit();
    }
}
