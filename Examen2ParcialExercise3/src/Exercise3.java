import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Exercise3 {
    public final static String URL = "http://demo.guru99.com/V1/index.php";
    public  static WebDriver driver;

    @BeforeTest
    public void setUrl(){
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(URL);
    }

    @Test(priority = 1)
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
    @Test
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

    @Test
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
