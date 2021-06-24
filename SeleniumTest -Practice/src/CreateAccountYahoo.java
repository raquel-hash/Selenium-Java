import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountYahoo {
    public static void main(String[] args) {
        //Declaracion e instanciar los objetos/variables
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");

        //instancia de objeto driver
        WebDriver driver = new ChromeDriver();

        //URL del sitio web que quiero validar
        String baseUrl = "https://login.yahoo.com/";
        driver.get(baseUrl);
        driver.findElement(By.cssSelector("a[id=createacc]")).click();

        WebElement name = driver.findElement(By.name("firstName"));
        WebElement lastName = driver.findElement(By.name("lastName"));
        WebElement email = driver.findElement(By.name("yid"));
        WebElement password = driver.findElement(By.name("password"));
        Select dropShortCountryCode = new Select(driver.findElement((By.name("shortCountryCode"))));
        WebElement phone = driver.findElement(By.name("phone"));
        Select dropMonth = new Select(driver.findElement((By.name("mm"))));
        WebElement day = driver.findElement(By.name("dd"));
        WebElement year = driver.findElement(By.name("yyyy"));


        //button
        WebElement signup = driver.findElement(By.name("signup"));

        //llenando los campos
        name.sendKeys("Raquel");
        lastName.sendKeys("Quelca");
        email.sendKeys("raquelquelca");
        password.sendKeys("Secret123456789,");
        dropShortCountryCode.selectByValue("BO");
        phone.sendKeys("78364256");
        dropMonth.selectByIndex(3);
        day.sendKeys("02");
        year.sendKeys("2003");

        signup.click();
    }
}
