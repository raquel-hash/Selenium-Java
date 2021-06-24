import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Exercise4Class1 {
    public final static String URL = "http://demo.guru99.com/V1/index.php";
    public  static WebDriver driver;

    @BeforeTest
    public void setUrl(){
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(URL);
    }

    @Test(groups = {"Group2"})
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

    @Test(groups = {"group4"})
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

    @Test(groups = {"group3"})
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

    @Test(groups = {"group4"})
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

    @Test(groups = {"group2"})
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

    @Test(groups = {"group1"})
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

    @Test(groups = {"group3"})
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

    @Test(groups = {"group1"})
    public void  VerifyInputValid(){
        setUrl();
        boolean inputValid;
        String expectedMessage="Numbers are not allowed";
        driver.findElement(By.name("uid")).sendKeys("mngr329698");
        driver.findElement(By.name("password")).sendKeys("Utedeve");
        driver.findElement(By.name("btnLogin")).click();
        driver.findElement(By.linkText("New Customer")).click();
        driver.findElement(By.name("name")).sendKeys("4657983");
        WebElement message = driver.findElement(By.id("message"));

        if (message.getText().equals(expectedMessage)){
            inputValid=true;
        }else {
            inputValid=false;
        }

        Assert.assertTrue(inputValid);
        endSesion();
    }
    @Test(groups = {"group2"})
    public void verifyForm(){
        setUrl();
        boolean invalido;
        String mensajeEsperado= "Please fill all fields";
        driver.findElement(By.name("uid")).sendKeys("mngr329698");
        driver.findElement(By.name("password")).sendKeys("Utedeve");
        driver.findElement(By.name("btnLogin")).click();

        driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[2]/a")).click();

        driver.findElement(By.name("name")).sendKeys("Raquel");
        driver.findElement(By.name("dob")).sendKeys("01/01/2000");
        driver.findElement(By.name("addr")).sendKeys("EnriqueJimenez");
        driver.findElement(By.name("city")).sendKeys("La paz");
        driver.findElement(By.name("state")).sendKeys("Caranavi");
        driver.findElement(By.name("pinno")).sendKeys("123345");
        driver.findElement(By.name("telephoneno")).sendKeys("8357623");
        driver.findElement(By.name("emailid")).sendKeys("prue2ba@gmail.com");

        driver.findElement(By.name("sub")).click();

        Alert alert= driver.switchTo().alert();
        if (alert.getText().equals(mensajeEsperado)){
            invalido=true;
        }else {
            invalido=false;
        }
        Assert.assertTrue(invalido);
        endSesion();
    }

    @Test(groups = {"group3"})
    public void verifyEmptyField(){
        setUrl();
        boolean emptyField;
        String expectedMessage="Customer name must not be blank";
        driver.findElement(By.name("uid")).sendKeys("mngr329698");
        driver.findElement(By.name("password")).sendKeys("Utedeve");
        driver.findElement(By.name("btnLogin")).click();
        driver.findElement(By.linkText("New Customer")).click();
        WebElement name = driver.findElement(By.name("name"));
        name.sendKeys("");
        driver.findElement(By.xpath("/html/body/table")).click();
        WebElement message = driver.findElement(By.id("message"));
        if (message.getText().equals(expectedMessage)){
            emptyField=true;
        }else {
            emptyField=false;
        }
        Assert.assertTrue(emptyField);
        endSesion();
    }

    @AfterTest
    public void endSesion(){
        driver.quit();
    }
}
