import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownSelectValue {
    public static void main(String[] args) {
        //Declaracion e instanciar los objetos/variables
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");

        //instancia de objeto driver
        WebDriver driver = new ChromeDriver();
        String baseUrl = "http://demo.guru99.com/selenium/newtours/register.php";
        driver.get(baseUrl);

        Select dropCountry = new Select(driver.findElement((By.name("country"))));
        dropCountry.selectByVisibleText("AUSTRIA");

        //cerrar chrome
        //driver.close();
        //System.exit(0);
    }
}
