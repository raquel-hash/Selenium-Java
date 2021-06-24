import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RegisterPageTest {
    private WebDriver driver;

    @BeforeTest
    public void setUp(){
        driver = WebDriverUtil.chromeDriverConnection();
    }

    @AfterTest
    public void closeSite(){
        //driver.quit();
    }

    @Test
    public void registerValidTest(){
        Account account = new Account("ana123@gmail.com", "Ana12345678,", "Ana12345678,");
        account.setFirstName("Ana")
                .setLastName("Cadena")
                .setAddress("calle #123")
                .setPhone("8364727476")
                .setLanguages(new String[]{"Spanish", "Danish", "Arabic"})
                .setSkill("Android")
                .setCountry("Select Country")
                .setYear("1999")
                .setMonth("March")
                .setDay("5")
                .setFile("C:\\Users\\R\\Pictures\\cruz.jpg");
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        Assert.assertTrue(createAccountPage.goToRegister());
        createAccountPage.createAccount(account);
    }

    @Test
    public void validEmptyFirstNameTest() throws InterruptedException{

        Account account = new Account("ana123@gmail.com", "Ana12345678,", "Ana12345678,");
        account.setFirstName("")
                .setLastName("Cadena")
                .setAddress("calle #123")
                .setPhone("8364727476")
                .setLanguages(new String[]{"Spanish", "Danish", "Arabic"})
                .setSkill("Android")
                .setCountry("Select Country")
                .setYear("1999")
                .setMonth("March")
                .setDay("5")
                .setFile("C:\\Users\\R\\Pictures\\cruz.jpg");
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        Assert.assertTrue(createAccountPage.goToRegister());
        createAccountPage.createAccount(account);
        String expectedMessage = "Please fill out this field.";
        System.out.println(createAccountPage.firstName.getAttribute("validationMessage"));
        Assert.assertTrue(createAccountPage.firstName.getAttribute("validationMessage").equals(expectedMessage));
    }

    @Test
    public void validEmptyLastNameTest() throws InterruptedException{

        Account account = new Account("ana123@gmail.com", "Ana12345678,", "Ana12345678,");
        account.setFirstName("Ana")
                .setLastName("")
                .setAddress("calle #123")
                .setPhone("8364727476")
                .setLanguages(new String[]{"Spanish", "Danish", "Arabic"})
                .setSkill("Android")
                .setCountry("Select Country")
                .setYear("1999")
                .setMonth("March")
                .setDay("5")
                .setFile("C:\\Users\\R\\Pictures\\cruz.jpg");

        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        Assert.assertTrue(createAccountPage.goToRegister());
        createAccountPage.createAccount(account);
        String expectedMessage = "Please fill out this field.";
        System.out.println(createAccountPage.lastName.getAttribute("validationMessage"));
        Assert.assertTrue(createAccountPage.lastName.getAttribute("validationMessage").equals(expectedMessage));
    }

    @Test
    public void validEmptyOptionsGender() throws InterruptedException{

        Account account = new Account("ana123@gmail.com", "Ana12345678,", "Ana12345678,");
        account.setFirstName("Ana")
                .setLastName("Cadena")
                .setAddress("calle #123")
                .setPhone("8364727476")
                .setLanguages(new String[]{"Spanish", "Danish", "Arabic"})
                .setSkill("Android")
                .setCountry("Select Country")
                .setYear("1999")
                .setMonth("March")
                .setDay("5")
                .setFile("C:\\Users\\R\\Pictures\\cruz.jpg");
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        Assert.assertTrue(createAccountPage.goToRegister());
        createAccountPage.verifyEmptyOptions(account);
        String expectedMessage = "Please select one of these options.";
        System.out.println(createAccountPage.genderMale.getAttribute("validationMessage"));
        Assert.assertTrue(createAccountPage.genderMale.getAttribute("validationMessage").equals(expectedMessage));
    }

    @Test
    public void validEmptySelectedCountry() throws InterruptedException {
        Account account = new Account("ana123@gmail.com", "Ana12345678,", "Ana12345678,");
        account.setFirstName("Ana")
                .setLastName("Cadena")
                .setAddress("calle #123")
                .setPhone("8364727476")
                .setLanguages(new String[]{"Spanish", "Danish", "Arabic"})
                .setSkill("Android")
                .setCountry("Select Country")
                .setYear("1999")
                .setMonth("March")
                .setDay("5")
                .setFile("C:\\Users\\R\\Pictures\\cruz.jpg");
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        Assert.assertTrue(createAccountPage.goToRegister());
        createAccountPage.createAccount(account);
        String expectedMessage = "Please select an item in the list.";
        System.out.println(createAccountPage.country.getAttribute("validationMessage"));
        Assert.assertTrue(createAccountPage.country.getAttribute("validationMessage").equals(expectedMessage));
    }

    @Test
    public void validSelectMultipleTest() throws InterruptedException{
        Account account = new Account("ana123@gmail.com", "Ana12345678,", "Ana12345678,");
        account.setFirstName("Ana")
                .setLastName("Cadena")
                .setAddress("calle #123")
                .setPhone("8364727476")
                .setLanguages(new String[]{"Spanish", "Danish", "Arabic", "Catalan", "Filipino"})
                .setSkill("Android")
                .setCountry("Select Country")
                .setYear("1999")
                .setMonth("March")
                .setDay("5")
                .setFile("C:\\Users\\R\\Pictures\\cruz.jpg");
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        Assert.assertTrue(createAccountPage.goToRegister());
        createAccountPage.createAccount(account);
        Assert.assertNotNull(createAccountPage.languages);
    }

    @Test
    public void invalidMessageEmailTest() throws InterruptedException{
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        Assert.assertTrue(createAccountPage.goToRegister());
        Assert.assertTrue(createAccountPage.getMessageValidateEmail());
    }

    @Test
    public void invalidEmail(){

        Account account = new Account("ana123", "Ana12345678,", "Ana12345678,");
        account.setFirstName("Ana")
                .setLastName("Cadena")
                .setAddress("calle #123")
                .setPhone("8364727476")
                .setLanguages(new String[]{"Spanish", "Danish", "Arabic", "Catalan", "Filipino"})
                .setSkill("Android")
                .setCountry("Select Country")
                .setYear("1999")
                .setMonth("March")
                .setDay("5")
                .setFile("C:\\Users\\R\\Pictures\\cruz.jpg");

        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        createAccountPage.createAccount(account);
        String expectedMessage = "Please include an '@' in the email address. '"+account.getEmail()+"' is missing an '@'.";
        System.out.println(createAccountPage.email.getAttribute("validationMessage"));
        Assert.assertTrue(createAccountPage.email.getAttribute("validationMessage").equals(expectedMessage));
    }

    @Test
    public void validEmptyYear() throws InterruptedException{

        Account account = new Account("ana123@gmail.com", "Ana12345678,", "Ana12345678,");
        account.setFirstName("Ana")
                .setLastName("Cadena")
                .setAddress("calle #123")
                .setPhone("8364727476")
                .setLanguages(new String[]{"Spanish", "Danish", "Arabic"})
                .setSkill("Android")
                .setCountry("Select Country")
                .setYear("year")
                .setMonth("March")
                .setDay("5")
                .setFile("C:\\Users\\R\\Pictures\\cruz.jpg");
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        Assert.assertTrue(createAccountPage.goToRegister());
        createAccountPage.createAccount(account);
        String expectedMessage = "Please select an item in the list.";
        System.out.println(createAccountPage.year.getAttribute("validationMessage"));
        Assert.assertTrue(createAccountPage.year.getAttribute("validationMessage").equals(expectedMessage));
    }

    @Test
    public void validEmptyMonth() throws InterruptedException{

        Account account = new Account("ana123@gmail.com", "Ana12345678,", "Ana12345678,");
        account.setFirstName("Ana")
                .setLastName("Cadena")
                .setAddress("calle #123")
                .setPhone("8364727476")
                .setLanguages(new String[]{"Spanish", "Danish", "Arabic"})
                .setSkill("Android")
                .setCountry("Select Country")
                .setYear("1999")
                .setMonth("Month")
                .setDay("5")
                .setFile("C:\\Users\\R\\Pictures\\cruz.jpg");
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        Assert.assertTrue(createAccountPage.goToRegister());
        createAccountPage.createAccount(account);
        String expectedMessage = "Please select an item in the list.";
        System.out.println(createAccountPage.month.getAttribute("validationMessage"));
        Assert.assertTrue(createAccountPage.month.getAttribute("validationMessage").equals(expectedMessage));
    }

    @Test
    public void validEmptyDay() throws InterruptedException{

        Account account = new Account("ana123@gmail.com", "Ana12345678,", "Ana12345678,");
        account.setFirstName("Ana")
                .setLastName("Cadena")
                .setAddress("calle #123")
                .setPhone("8364727476")
                .setLanguages(new String[]{"Spanish", "Danish", "Arabic"})
                .setSkill("Android")
                .setCountry("Select Country")
                .setYear("1999")
                .setMonth("March")
                .setDay("Day")
                .setFile("C:\\Users\\R\\Pictures\\cruz.jpg");
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        Assert.assertTrue(createAccountPage.goToRegister());
        createAccountPage.createAccount(account);
        String expectedMessage = "Please select an item in the list.";
        System.out.println(createAccountPage.day.getAttribute("validationMessage"));
        Assert.assertTrue(createAccountPage.day.getAttribute("validationMessage").equals(expectedMessage));
    }

    @Test
    public void invalidPhone(){

        Account account = new Account("ana123@gmail.com", "Ana12345678,", "Ana12345678,");
        account.setFirstName("Ana")
                .setLastName("Cadena")
                .setAddress("calle #123")
                .setPhone("mi numero")
                .setLanguages(new String[]{"Spanish", "Danish", "Arabic"})
                .setSkill("Android")
                .setCountry("Select Country")
                .setYear("1999")
                .setMonth("March")
                .setDay("5")
                .setFile("C:\\Users\\R\\Pictures\\cruz.jpg");
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        Assert.assertTrue(createAccountPage.goToRegister());
        createAccountPage.createAccount(account);
        String expectedMessage = "Please match the requested format.";
        Assert.assertTrue(createAccountPage.phone.getAttribute("validationMessage").equals(expectedMessage));
    }

    @Test
    public void LessRangePhone(){

        Account account = new Account("ana123@gmail.com", "Ana12345678,", "Ana12345678,");
        account.setFirstName("Ana")
                .setLastName("Cadena")
                .setAddress("calle #123")
                .setPhone("12345")
                .setLanguages(new String[]{"Spanish", "Danish", "Arabic"})
                .setSkill("Android")
                .setCountry("Select Country")
                .setYear("1999")
                .setMonth("March")
                .setDay("5")
                .setFile("C:\\Users\\R\\Pictures\\cruz.jpg");
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        Assert.assertTrue(createAccountPage.goToRegister());
        createAccountPage.createAccount(account);
        String expectedMessage = "Please match the requested format.";
        Assert.assertTrue(createAccountPage.phone.getAttribute("validationMessage").equals(expectedMessage));
    }

    @Test
    public void MajorRangePhone(){
        Account account = new Account("ana123@gmail.com", "Ana12345678,", "Ana12345678,");
        account.setFirstName("Ana")
                .setLastName("Cadena")
                .setAddress("calle #123")
                .setPhone("12345678901")
                .setLanguages(new String[]{"Spanish", "Danish", "Arabic"})
                .setSkill("Android")
                .setCountry("Select Country")
                .setYear("1999")
                .setMonth("March")
                .setDay("5")
                .setFile("C:\\Users\\R\\Pictures\\cruz.jpg");
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        Assert.assertTrue(createAccountPage.goToRegister());
        createAccountPage.createAccount(account);
        String expectedMessage = "Please match the requested format.";
        Assert.assertTrue(createAccountPage.phone.getAttribute("validationMessage").equals(expectedMessage));
    }

    @Test
    public void invalidPassword(){
        Account account = new Account("ana123@gmail.com", "ana12345678", "Ana12345678,");
        account.setFirstName("Ana")
                .setLastName("Cadena")
                .setAddress("calle #123")
                .setPhone("1234567890")
                .setLanguages(new String[]{"Spanish", "Danish", "Arabic"})
                .setSkill("Android")
                .setCountry("Select Country")
                .setYear("1999")
                .setMonth("March")
                .setDay("5")
                .setFile("C:\\Users\\R\\Pictures\\cruz.jpg");
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        Assert.assertTrue(createAccountPage.goToRegister());
        createAccountPage.createAccount(account);
        String expectedMessage = "Please Enter an UpperCase,LowerCase Alphabet and a Number";
        System.out.println(createAccountPage.password.getAttribute("validationMessage"));
        Assert.assertTrue(createAccountPage.password.getAttribute("validationMessage").equals(expectedMessage));
    }

    @Test
    public void invalidNoEqualsPasswords(){
        Account account = new Account("ana123@gmail.com", "Bna12345678,", "Ana12345678,");
        account.setFirstName("Ana")
                .setLastName("Cadena")
                .setAddress("calle #123")
                .setPhone("1234567890")
                .setLanguages(new String[]{"Spanish", "Danish", "Arabic"})
                .setSkill("Android")
                .setCountry("Select Country")
                .setYear("1999")
                .setMonth("March")
                .setDay("5")
                .setFile("C:\\Users\\R\\Pictures\\cruz.jpg");
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        Assert.assertTrue(createAccountPage.goToRegister());
        createAccountPage.createAccount(account);
        String expectedMessage = "Passwords dont match";
        System.out.println(createAccountPage.confirmPassword.getAttribute("validationMessage"));
        Assert.assertTrue(createAccountPage.confirmPassword.getAttribute("validationMessage").equals(expectedMessage));
    }

    @Test
    public void fileTest(){
        Account account = new Account("ana123@gmail.com", "Ana12345678,", "Ana12345678,");
        account.setFirstName("Ana")
                .setLastName("Cadena")
                .setAddress("calle #123")
                .setPhone("1234567890")
                .setLanguages(new String[]{"Spanish", "Danish", "Arabic"})
                .setSkill("Android")
                .setCountry("Select Country")
                .setYear("1999")
                .setMonth("March")
                .setDay("5")
                .setFile("C:\\Users\\R\\Downloads\\paper_218958.pdf");
                //.setFile("C:\\Users\\R\\Downloads\\01.GIT_jala.pptx");
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        Assert.assertTrue(createAccountPage.goToRegister());
        createAccountPage.createAccount(account);
    }
}
