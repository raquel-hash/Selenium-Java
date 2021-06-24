import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class KeyboardSendKey {
    public static void main(String[] args) {
        //Declaracion e instanciar los objetos/variables
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");

        //instancia de objeto driver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String baseUrl = "http://www.google.com/";

        try{
            driver.get(baseUrl);
            driver.findElement(By.name("q")).sendKeys("Tutorial de Java" + Keys.ENTER);
        }finally {
            driver.quit();
        }

    }
}
