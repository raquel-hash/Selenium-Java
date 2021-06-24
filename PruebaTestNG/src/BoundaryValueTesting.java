import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BoundaryValueTesting {
    public final static String URL = "https://www.guru99.com/equivalence-partitioning-boundary-value-analysis.html#3";
    public  static WebDriver driver;

    @BeforeTest
    public void setUrl(){
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(URL);
    }

    @Test(priority = 1)
    public void verifyInvalidPizza() throws InterruptedException {
        setUrl();
        boolean invalidNumberPizza;
        String expectedMessage="Invalid Number";
        driver.findElement(By.name("number")).sendKeys("0");
        driver.findElement(By.xpath("//*[@id=\"g-mainbar\"]/div[1]/div/div/div/div/div/div[2]/div[4]/input[2]")).click();
        Alert alert = driver.switchTo().alert();
        if (alert.getText().equals(expectedMessage)){
            invalidNumberPizza=true;
        }else {
            invalidNumberPizza=false;
        }
        Assert.assertTrue(invalidNumberPizza);
        System.out.println(alert.getText());
        Thread.sleep(5000);
        endSesion();
    }

    @Test(priority = 2)
    public void verifySuccesPizza1() throws InterruptedException {
        setUrl();
        boolean validNumberPizza;
        String expectedMessage="Success";
        driver.findElement(By.name("number")).sendKeys("1");
        driver.findElement(By.xpath("//*[@id=\"g-mainbar\"]/div[1]/div/div/div/div/div/div[2]/div[4]/input[2]")).click();
        Alert alert = driver.switchTo().alert();
        if (alert.getText().equals(expectedMessage)){
            validNumberPizza=true;
        }else {
            validNumberPizza=false;
        }
        Assert.assertTrue(validNumberPizza);
        System.out.println(alert.getText());
        Thread.sleep(5000);
        endSesion();
    }

    @Test(priority = 3)
    public void verifySuccesPizza2() throws InterruptedException {
        setUrl();
        boolean validNumberPizza;
        String expectedMessage="Success";
        driver.findElement(By.name("number")).sendKeys("10");
        driver.findElement(By.xpath("//*[@id=\"g-mainbar\"]/div[1]/div/div/div/div/div/div[2]/div[4]/input[2]")).click();
        Alert alert = driver.switchTo().alert();
        if (alert.getText().equals(expectedMessage)){
            validNumberPizza=true;
        }else {
            validNumberPizza=false;
        }
        Assert.assertTrue(validNumberPizza);
        System.out.println(alert.getText());
        Thread.sleep(5000);
        endSesion();
    }

    @Test(priority = 4)
    public void verifyInvalidPizza1() throws InterruptedException {
        setUrl();
        boolean invalidNumberPizza;
        String expectedMessage="Only 10 Pizza can be ordered";
        driver.findElement(By.name("number")).sendKeys("11");
        driver.findElement(By.xpath("//*[@id=\"g-mainbar\"]/div[1]/div/div/div/div/div/div[2]/div[4]/input[2]")).click();
        Alert alert = driver.switchTo().alert();
        if (alert.getText().equals(expectedMessage)){
            invalidNumberPizza=true;
        }else {
            invalidNumberPizza=false;
        }
        Assert.assertTrue(invalidNumberPizza);
        System.out.println(alert.getText());
        Thread.sleep(5000);
        endSesion();
    }

    @Test(priority = 5)
    public void verifyInvalidPizza2() throws InterruptedException {
        setUrl();
        boolean invalidNumberPizza;
        String expectedMessage="Only 10 Pizza can be ordered";
        driver.findElement(By.name("number")).sendKeys("99");
        driver.findElement(By.xpath("//*[@id=\"g-mainbar\"]/div[1]/div/div/div/div/div/div[2]/div[4]/input[2]")).click();
        Alert alert = driver.switchTo().alert();
        if (alert.getText().equals(expectedMessage)){
            invalidNumberPizza=true;
        }else {
            invalidNumberPizza=false;
        }
        Assert.assertTrue(invalidNumberPizza);
        System.out.println(alert.getText());
        Thread.sleep(5000);
        endSesion();
    }

    @Test(priority = 6)
    public void verifyInvalidPizza3() throws InterruptedException {
        setUrl();
        boolean invalidNumberPizza;
        String expectedMessage="Invalid Number";
        driver.findElement(By.name("number")).sendKeys("100");
        driver.findElement(By.xpath("//*[@id=\"g-mainbar\"]/div[1]/div/div/div/div/div/div[2]/div[4]/input[2]")).click();
        Alert alert = driver.switchTo().alert();
        if (alert.getText().equals(expectedMessage)){
            invalidNumberPizza=true;
        }else {
            invalidNumberPizza=false;
        }
        Assert.assertTrue(invalidNumberPizza);
        System.out.println(alert.getText());
        Thread.sleep(5000);
        endSesion();
    }

    @AfterTest
    public void endSesion(){
        driver.quit();
    }
}

