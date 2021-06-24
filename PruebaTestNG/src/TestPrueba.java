    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.chrome.ChromeDriver;
    import org.testng.Assert;
    import org.testng.annotations.*;


    public class TestPrueba {
        private static String baseUrl = "http://demo.guru99.com/test/newtours";
        public  static WebDriver driver;

        //methods under this annotation will be executed prior to the first test case in the TestNG file.
        @BeforeTest
        public void setUrl(){
            System.setProperty("webdriver.chrome.driver", "C:\\selenium\\lib\\chromedriver.exe");
            driver = new ChromeDriver();

        }

        @Test
        public static void verifyHomepageTitle() {
            driver.get(baseUrl);
            String expectedTitle = "Welcome: Mercury Tours";
            String actualTitle = driver.getTitle();
            System.out.println(actualTitle);
            //La clase Assert se utiliza para realizar operaciones de verificacion de TestNG
            Assert.assertEquals(actualTitle,expectedTitle);
            System.out.println("Assert passed AssertEquals()");
        }

    }
