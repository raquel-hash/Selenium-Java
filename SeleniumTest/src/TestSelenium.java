import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
/**import org.openqa.selenium.firefox.FirefoxDriver;*/

public class TestSelenium {
    public static void main(String[] args) {
        //declaracion e instanciar los objetivos/variables
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");

        //Instancia de objeto driver
        WebDriver driver = new ChromeDriver();
        String baseUrl = "http://demo.guru99.com/selenium/newtours";
        String expectedTitle = "Welcome: Mercury Tours";
        String actualTitle = "";

        //Lanzar Chrome y dirigirlo a la base URL
        driver.get(baseUrl);

        //Obtiene el valor real del titulo
        actualTitle = driver.getTitle();

        /** comprara el titulo real de la pagina con la que se esperaa e imprime
         * el resultado es "Passed" o "Failed" */

        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }

        //cerrar Chrome
        driver.close();

    }
}
