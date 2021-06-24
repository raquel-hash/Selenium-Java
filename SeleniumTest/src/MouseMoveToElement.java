import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseMoveToElement {
    public static void main(String[] args) {
        //Declaracion e instanciar los objetos/variables
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");

        //instancia de objeto driver
        WebDriver driver = new ChromeDriver();

        //URL del sitio web que quiero validar
        String baseUrl = "https://selenium08.blogspot.com/2020/01/click-and-hold.html";
        driver.get(baseUrl);

        //Usando XPath, para localizar los elementos A y C
        WebElement titleA = driver.findElement(By.xpath("//li[text() = 'A'"));
        WebElement titleC = driver.findElement(By.xpath("//li[text() = 'C'"));

        //crear un objeto de la clase actions y pasar en el constructor como paramentro el webdriver
        Actions actions = new Actions(driver);

        //llamar al metodo moveElement(), para mover el cursor del Mouse de un WebElement A
        actions.moveToElement(titleA); //Mueve el mouse al centro del eleemnto
        actions.clickAndHold(); // hace clic (sin soltar) en la ubicacion actual del mouse
        actions.moveToElement(titleC);
        actions.release().perform();
    }
}
