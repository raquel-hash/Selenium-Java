import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverUtil {
    public static WebDriver chromeDriverConnection(){
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
        return new ChromeDriver();
    }

    public static WebDriver firefoxDriverConnection(){
        System.setProperty("webdriver.gecko.driver", "C:\\selenium\\geckodriver.exe");
        return new FirefoxDriver();
    }
}
