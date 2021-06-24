import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImageSelect {
    public static void main(String[] args) {

        //Declaracion e instanciar los objetos/variables
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");

        //instancia de objeto driver
        WebDriver driver = new ChromeDriver();
        String baseUrl = "https://www.karglobal.com/our-brands";
        driver.get(baseUrl);

        //click -> mandar siguiente pagina
        driver.findElement(By.cssSelector("img.logo-full")).click();
        if(driver.getTitle().equals("KAR Global")){
            System.out.println("You are in KAR Global site ");
        }else {
            System.out.println("You are't in KAR Global site ");
        }
        //cerrar chrome
        driver.close();
        System.exit(0);
    }
}
