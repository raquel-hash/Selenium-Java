import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Set;
import java.util.Iterator;

public class AlertMultipleWindows {
    public static void main(String[] args) throws InterruptedException {
        //Declaracion e instanciar los objetos/variables
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");

        //instancia de objeto driver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String baseUrl = "http://demo.guru99.com/popup.php";
        driver.get(baseUrl);

        driver.manage().window().maximize();


        //start with the code to the windows
        driver.findElement(By.linkText("Click Here")).click();

        //"getWindowHandle()", Cuando se abre el sitio web, se necesita manejar la ventana principal.
        //este metodo manejara la venta actual que la identifica de forma unica dentro de esta insancia del controlador
        String mainWindow = driver.getWindowHandle();

        //"getWindowHansles()", Para manipular todas las ventanas abiertas
        Set<String> s1 = driver.getWindowHandles();

        Iterator<String> i1 = s1.iterator();
        while (i1.hasNext()){
            String ChildWindow = i1.next();
            if (!mainWindow.equalsIgnoreCase(ChildWindow)){
                //Intercambio a la ventana hijo
                driver.switchTo().window(ChildWindow);
                driver.findElement(By.name("emailid")).sendKeys("prueba@gmail.com");
                Thread.sleep(5000);
                driver.findElement(By.name("btnLogin")).click();
                Thread.sleep(5000);
                //Cerrando la venta hijo
                driver.close();
            }
        }

        //Switching to parent window i.e Main windows
        driver.switchTo().window(mainWindow);
    }
}
