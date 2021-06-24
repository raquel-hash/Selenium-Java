import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkTextCaseSensitive {
    public static void main(String[] args) {

        //Declaracion e instanciar los objetos/variables
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");

        //instancia de objeto driver
        WebDriver driver = new ChromeDriver();

        //URL del sitio web que quiero validar
        String baseUrl = "http://demo.guru99.com/test/newtours";
        driver.get(baseUrl);

        String theLinkText = driver.findElement(By.partialLinkText("egis")).getText();

        //Should display "Register here"
        System.out.println(theLinkText);
        theLinkText= driver.findElement(By.partialLinkText("EGIS")).getText();

        //should display "REGISTER"
        System.out.println(theLinkText);
    }
}
