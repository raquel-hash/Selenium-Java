import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class SelectMenu_2 {
    public static void main(String[] args) {
        //Declaracion e instanciar los objetos/variables
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");

        //instancia de objeto driver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //URL del sitio web que quiero validar
        String baseUrl = "https://www.ucb.edu.bo/#";
        driver.get(baseUrl);

        WebElement linkInvestigacion = driver.findElement(By.cssSelector("a[id=menu-item-dropdown-43]"));
        System.out.println("Title of page is: "+ driver.getTitle());

        //

        //crear un objeto de la clase actions y pasar en el constructor como paramentro el webdriver
        Actions actions = new Actions(driver);

        //llamar al metodo moveElement(), para mover el cursor del Mouse de un WebElement investigacion
        actions.moveToElement(linkInvestigacion); //Mueve el mouse al centro del eleemnto
        //actions.clickAndHold(); // hace clic (sin soltar) en la ubicacion actual del mouse
        //actions.moveToElement(linkPrincipalesPublicaciones);
        actions.release().perform();

        WebElement linkPrincipalesPublicaciones = driver.findElement(By.linkText("Principales Publicaciones"));

        Actions builder = new Actions(driver);
        Action mouseOverHome = builder.moveToElement(linkPrincipalesPublicaciones).build();
        String bgcolor = linkPrincipalesPublicaciones.getCssValue("color");
        System.out.println("Before Over: " + bgcolor); //color naranja
        mouseOverHome.perform();
        System.out.println("After Over: " + bgcolor);


    }
}
