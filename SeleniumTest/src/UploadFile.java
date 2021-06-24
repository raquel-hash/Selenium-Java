import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UploadFile {
    public static void main(String[] args) {
        //Declaracion e instanciar los objetos/variables
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");

        //instancia de objeto driver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String baseUrl = "http://demo.guru99.com/test/upload/";
        driver.get(baseUrl);

        //Get the input element
        WebElement uploadElement = driver.findElement(By.id("uploadfile_0"));
        //Enter the file path the input field
        uploadElement.sendKeys("C:\\Users\\R\\Desktop\\Clases Virtuales - IS 2021 v.2.0.pdf");

        //Check "I accept the terms of service"  checkbox
        driver.findElement(By.id("terms")).click();

        //Click the "Submit File" button
        driver.findElement(By.name("send")).click();

        //cerrar chrome
        //driver.close();
        //System.exit(0);
    }
}
