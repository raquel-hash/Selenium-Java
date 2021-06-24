import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MultipleSelectItems {
    public static void main(String[] args) {

        //Declaracion e instanciar los objetos/variables
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");

        //instancia de objeto driver
        WebDriver driver = new ChromeDriver();
        String baseUrl = "http://output.jsbin.com/osebed/2";
        driver.get(baseUrl);

        Select listoxFruits = new Select(driver.findElement(By.id("fruits")));
        listoxFruits.selectByVisibleText("Banana");
        listoxFruits.selectByVisibleText("Apple");
        listoxFruits.selectByIndex(3);

        //cerrar chrome
        //driver.close();
        //System.exit(0);
    }
}
