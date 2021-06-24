import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkOutInsBlockHTML5 {
    public static void main(String[] args) {

        //Declaracion e instanciar los objetos/variables
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");

        //instancia de objeto driver
        WebDriver driver = new ChromeDriver();

        //URL del sitio web que quiero validar
        String baseUrl = "http://demo.guru99.com/test/block.html";
        driver.get(baseUrl);

        driver.findElement(By.partialLinkText("Inside")).click();
        System.out.println(driver.getTitle());

        driver.navigate().back();//volver pagina anterior

        driver.findElement(By.partialLinkText("Outside")).click();
        System.out.println(driver.getTitle());
        driver.quit();
    }
}
