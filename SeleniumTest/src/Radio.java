import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Radio {
    public static void main(String[] args) {
        //Declaracion e instanciar los objetos/variables
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");

        //instancia de objeto driver
        WebDriver driver = new ChromeDriver();
        driver.get("http://demo.guru99.com/test/radio.html");

        //Radio
        driver.findElement(By.id("vfb-7-1")).click();
        driver.findElement(By.id("vfb-7-2")).click();
        driver.findElement(By.id("vfb-7-3")).click();

        //cerrar chrome
        //driver.close();
        //System.exit(0);
    }
}
