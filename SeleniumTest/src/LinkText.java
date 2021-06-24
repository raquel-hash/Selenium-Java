import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkText {
    public static void main(String[] args) {
        //Declaracion e instanciar los objetos/variables
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");

        //instancia de objeto driver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://demo.guru99.com/test/link.html");

        driver.findElement(By.linkText("click here")).click();
        System.out.println("Title of page is: "+ driver.getTitle());
    }
}
