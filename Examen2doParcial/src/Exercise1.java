import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exercise1 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String baseUrl = "http://demo.guru99.com/";
        driver.get(baseUrl);

        WebElement email = driver.findElement(By.name("emailid"));
        WebElement btnSubmit = driver.findElement(By.name("btnLogin"));

        email.sendKeys("prueba2@gmail.com");
        btnSubmit.click();

        driver.close();
        System.exit(0);
    }
}
