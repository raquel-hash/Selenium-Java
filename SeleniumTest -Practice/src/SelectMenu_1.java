import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class SelectMenu_1 {
    public static void main(String[] args) {
        //Declaracion e instanciar los objetos/variables
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");

        //instancia de objeto driver
        WebDriver driver = new ChromeDriver();

        //URL del sitio web que quiero validar
        String baseUrl = "https://www.uab.edu.bo/";
        driver.get(baseUrl);


        WebElement linkServicios =driver.findElement(By.linkText("SERVICIOS"));
        System.out.println("Title of page is: "+ driver.getTitle());


        //crear un objeto de la clase actions y pasar en el constructor como paramentro el webdriver
        Actions actions = new Actions(driver);

        //llamar al metodo moveElement(), para mover el cursor del Mouse de un WebElement Servicios
        actions.moveToElement(linkServicios); //Mueve el mouse al centro del eleemnto
        actions.clickAndHold(); // hace clic (sin soltar) en la ubicacion actual del mouse
        actions.release().perform();

        WebElement linkResidenciasEstudiantiles =  driver.findElement(By.linkText("Residencias Estudiantiles"));

        Actions builder = new Actions(driver);
        Action mouseOverHome = builder.moveToElement(linkResidenciasEstudiantiles).build();
        String bgcolor = linkResidenciasEstudiantiles.getCssValue("color");
        System.out.println("Before Over: " + bgcolor); //color naranja
        mouseOverHome.perform();
        System.out.println("After Over: " + bgcolor);


    }
}
