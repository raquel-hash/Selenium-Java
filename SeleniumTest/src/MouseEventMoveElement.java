import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class MouseEventMoveElement {
    public static void main(String[] args) {

        //Declaracion e instanciar los objetos/variables
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");

        //instancia de objeto driver
        WebDriver driver = new ChromeDriver();

        //URL del sitio web que quiero validar
        String baseUrl = "http://demo.guru99.com/selenium/newtours";
        driver.get(baseUrl);

        //Codigo donde comienza para realizar el mouse event => MoveToElement()
        WebElement linkHome = driver.findElement(By.linkText("Home"));
        WebElement td_Home = driver.findElement(By.xpath("//html/body/div" +
                "/table/tbody/tr/td" +
                "/table/tbody/tr/td" +
                "/table/tbody/tr/td" +
                "/table/tbody/tr"));
        Actions builder = new Actions(driver);
        Action mouseOverHome = builder.moveToElement(linkHome).build();
        String bgcolor = td_Home.getCssValue("color");
        System.out.println("Before Over: " + bgcolor); //color naranja
        mouseOverHome.perform();
        System.out.println("After Over: " + bgcolor);

        //driver.close();
    }
}
