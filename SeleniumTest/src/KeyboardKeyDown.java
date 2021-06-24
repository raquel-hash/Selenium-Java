import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class KeyboardKeyDown {
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
            driver.findElement(By.name("q")).sendKeys("Tutorial de Python" + Keys.ENTER);


            Actions actions = new Actions(driver);

            //simula el presionar las teclas: CTRL + a => en el teclado ingles selecciona un sitio web o texto
            Action keydown = actions.keyDown(Keys.CONTROL).sendKeys("a").build();
            keydown.perform();
        }finally {
            //driver.quit();
        }
    }
}
