import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverUtil {
    public static WebDriver chromeDriverConnection(){
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
        return new ChromeDriver();
    }
}
