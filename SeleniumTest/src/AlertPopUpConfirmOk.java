import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.NoAlertPresentException;

public class AlertPopUpConfirmOk {
    public static void main(String[] args) throws NoAlertPresentException, InterruptedException {
        //Declaracion e instanciar los objetos/variables
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");

        //instancia de objeto driver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String baseUrl = "http://demo.guru99.com/test/delete_customer.php/";
        driver.get(baseUrl);


        //The form "Delete form"
        driver.findElement(By.name("cusid")).sendKeys("53920");
        driver.findElement(By.name("submit")).submit();

        //Switching to Alert
        Alert alert = driver.switchTo().alert();

        //Capturando el texto del mensaje de alerta
        String alertMessage = driver.switchTo().alert().getText();

        //Mostrnado el mensaje de alerta
        System.out.println(alertMessage);
        Thread.sleep(5000);
        alert.accept();
    }
}
