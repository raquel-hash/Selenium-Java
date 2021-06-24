import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FormWebElements_1 {
    public static void main(String[] args) {
        //Declaracion e instanciar los objetos/variables
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");

        //instancia de objeto driver
        WebDriver driver = new ChromeDriver();

        //URL del sitio web que quiero validar
        String baseUrl = "http://demo.guru99.com/selenium/newtours";
        driver.get(baseUrl);

        //TextBox, Button obtener los webElements
        driver.findElement(By.name("userName")).sendKeys("Hola");
        driver.findElement(By.name("password")).sendKeys("123");
        driver.findElement(By.name("submit")).submit();
       //driver.findElement(By.name("submit")).click();

        driver.close();
        System.exit(0);
    }
}
