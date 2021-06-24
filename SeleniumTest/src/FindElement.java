import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElement {
    public static void main(String[] args) {

        //Declaracion e instanciar los objetos/variables
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");

        //instancia de objeto driver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://demo.guru99.com/test/ajax.html");

        // find the radio button for "No" using its ID and click on it
        driver.findElement(By.id("no")).click();

        //Click on check button
        driver.findElement(By.id("buttoncheck")).click();

        // find the radio button for "No" using its ID and click on it
        driver.findElement(By.id("no")).click();

        //Click on check button
        driver.findElement(By.id("buttoncheck")).click();

        String mensajeBuscar = "Radio button is checked and it's value is No";

        String mensajePagina = driver.findElement(By.xpath("//p[contains(text(), 'Radio button is')]")).getText();
        System.out.println(mensajePagina);
        if(mensajeBuscar.contentEquals(mensajePagina)){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }

    }
}
