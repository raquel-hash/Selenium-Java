import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestLogin {
    public static void main(String[] args) {
        //Declaracion e instanciar los objetos/variables
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");

        //instancia de objeto driver
        WebDriver driver = new ChromeDriver();

        //URL del sitio web que quiero validar
        String baseUrl = "http://demo.guru99.com/selenium/newtours";
        driver.get(baseUrl);

        //Textbox
        WebElement name = driver.findElement(By.name("userName"));
        WebElement password = driver.findElement(By.name("password"));

        //button
        WebElement btnSubmit = driver.findElement(By.name("submit"));

        //llenando los campos
        name.sendKeys("Hola");
        password.sendKeys("123");

        //Limpiand los Texboxes
        name.clear();
        password.clear();

        //llenando los campos
        name.sendKeys("Hola");
        password.sendKeys("123");

        //button
        btnSubmit.click();

        //cerrar chrome
        driver.close();
        System.exit(0);
    }
}
