import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.security.Key;

public class KeyboardKeyUp {
    public static void main(String[] args) {
        //Declaracion e instanciar los objetos/variables
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");

        //instancia de objeto driver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String baseUrl = "http://www.google.com/";

        try{
            driver.get(baseUrl);
            //Ingresar el texto a buscar y ejecutar
            WebElement search = driver.findElement(By.name("q"));
            Actions actions = new Actions(driver);

            //Keydown: primero presiona SHIFT y se escribe en mayuscula,
            // luego suelta el teclado con el metodo "KeyUp".
            actions.keyDown(Keys.SHIFT).sendKeys(search, "hola mundo java ").keyUp(Keys.SHIFT).sendKeys("usando el key Up").perform();
        }finally {
            //driver.quit();
        }
    }
}
