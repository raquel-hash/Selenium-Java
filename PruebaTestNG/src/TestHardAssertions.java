import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestHardAssertions {
    public  static WebDriver driver;

    //methods under this annotation will be executed prior to the first test case in the TestNG file.
    @BeforeTest
    public void setUrl(){
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
        driver = new ChromeDriver();

    }

    //@Test is used to tell that the method under it is a test case.
    @Test
    public static void verifyHomepageTitle () {
        driver.get("http://demo.guru99.com/test/newtours");
        String expectedTitle = "Welcome: Mercury Tours";
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        //La clase Assert se utiliza para realizar operaciones de verificacion de TestNG
        Assert.assertEquals(actualTitle,expectedTitle);
        System.out.println("Assert passed AssertEquals()");
    }


    @Test
    public static void verifyAssertNotEquals(){
        // comparar resultados reales y esperados, si los resultados esperados no son los
        //mismos, caso de prueba approbado, ussado para verifficar que cada dato es unico
        //en una pagina web
        driver.get("http://chennaiiq.com/chennai/pincode-by-name.php");
        WebElement Adambakkam = driver.findElement(By.xpath("//table[contains(@class,'TBox')]/tbody/tr[5]/td[3]"));
        WebElement Aminijikarai = driver.findElement(By.xpath("//table[contains(@class,'TBox')]/tbody/tr[15]/td[3]"));
        String Pincode1 = Adambakkam.getText();
        String Pincode2 = Aminijikarai.getText();

        System.out.println("\n Two Unique pincodes are :  " +Pincode1 +" And "+Pincode2);

        Assert.assertNotEquals(Pincode1, Pincode2);
        System.out.println("\n Assert passed AssertNotEquals()");
    }

    @Test
    public static void verifyAssertTrue() {
        driver.get("https://www.amazon.in");
        WebElement Navigation = driver.findElement(By.xpath("//*[@id='nav-link-accountList']"));
        WebElement SignInButton = driver.findElement(By.xpath("//span[text()='Sign in']"));
        Actions move = new Actions(driver);
        move.moveToElement(Navigation).build().perform();

        Boolean CheckButtonPresence = SignInButton.isDisplayed();
        Assert.assertTrue(CheckButtonPresence);
        System.out.println("\n Button is displayed: "+ SignInButton.isDisplayed() );
    }

    @Test
    public static void verifyAssertFalse(){
        driver.get("https://www.spicejet.com/");
        Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
        System.out.println("\n Is Selected: "+driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
    }


    @Test
    public static void verifyAssertNull(){
        driver.get("http://only-testing-blog.blogspot.com/2014/02/attributes.html");
        WebElement txt1 = driver.findElement(By.xpath("//input[@id='text1']"));;
        Assert.assertNull(txt1.getAttribute("disabled"));
        System.out.print("\n IS null: "+txt1.getAttribute("disabled"));
    }

    @Test
    public static void verifyAsserNotNull(){
        driver.get("http://only-testing-blog.blogspot.com/2014/02/attributes.html");
        WebElement txt2 = driver.findElement(By.xpath("//input[@id='text2']"));
        Assert.assertNotNull(txt2.getAttribute("disabled"));
        System.out.print("\n Is not NUll:"+ txt2.getAttribute("disabled"));
    }
}
