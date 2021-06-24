import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableDevTools {
    public static void main(String[] args) {
        //Declaracion e instanciar los objetos/variables
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");

        //instancia de objeto driver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String baseUrl = "http://demo.guru99.com/test/newtours/";
        driver.get(baseUrl);

        String innerText = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]" +
                "/table/tbody/tr[4]/td" +
                "/table/tbody/tr/td[2]" +
                "/table/tbody/tr[2]/td[1]" +
                "/table[2]/tbody/tr[3]/td[2]/font")).getText();
        System.out.println("innerText = " + innerText);
    }
}
