import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class CreateAccountTest {
    private WebDriver driver;
    CreateAccountPage createAccountPage;

    @BeforeTest
    public void setUp() throws Exception{
        createAccountPage = new CreateAccountPage(driver);
        driver = createAccountPage.chromeDriverConnection();
        createAccountPage.url("http://demo.automationtesting.in/Register.html");
    }

    @AfterTest
    public void closeSite() throws Exception{
        //driver.quit();
    }

    @Test
    public void validRegistrationTest() throws InterruptedException{
        List<String> languages = new ArrayList<>();
        languages.add("Arabic");
        languages.add("Danish");

        Account account = new Account("ana123@gmail.com", "Ana12345678,", "Ana12345678,");
        account.setFirstName("Ana")
                .setLastName("Cadena")
                .setAddress("calle #123")
                .setPhone("8364727476")
                .setLanguages(languages)
                .setSkill("Android")
                .setCountry("Bolivia")
                .setYear("1999")
                .setMonth("March")
                .setDay("5")
                .setFile("C:\\Users\\R\\Pictures\\cruz.jpg");

        Assert.assertTrue(createAccountPage.goToRegister());
        createAccountPage.createAccount(account);
    }

    @Test
    public void validEmptyFirstNameTest() throws InterruptedException{
        List<String> languages = new ArrayList<>();
        languages.add("Arabic");
        languages.add("Danish");

        Account account = new Account("ana123@gmail.com", "Ana12345678,", "Ana12345678,");
        account.setFirstName("")
                .setLastName("Cadena")
                .setAddress("calle #123")
                .setPhone("8364727476")
                .setLanguages(languages)
                .setSkill("Android")
                .setCountry("Bolivia")
                .setYear("1999")
                .setMonth("March")
                .setDay("5")
                .setFile("C:\\Users\\R\\Pictures\\cruz.jpg");

        Assert.assertTrue(createAccountPage.goToRegister());
        createAccountPage.createAccount(account);
        String expectedMessage = "Please fill out this field.";
        System.out.println(createAccountPage.getAttributeName("validationMessage"));
        Assert.assertTrue(createAccountPage.getAttributeName("validationMessage").equals(expectedMessage));
    }

    @Test
    public void validEmptyLastNameTest() throws InterruptedException{
        List<String> languages = new ArrayList<>();
        languages.add("Arabic");
        languages.add("Danish");

        Account account = new Account("ana123@gmail.com", "Ana12345678,", "Ana12345678,");
        account.setFirstName("Ana")
                .setLastName("")
                .setAddress("calle #123")
                .setPhone("8364727476")
                .setLanguages(languages)
                .setSkill("Android")
                .setCountry("Bolivia")
                .setYear("1999")
                .setMonth("March")
                .setDay("5")
                .setFile("C:\\Users\\R\\Pictures\\cruz.jpg");

        Assert.assertTrue(createAccountPage.goToRegister());
        createAccountPage.createAccount(account);
        String expectedMessage = "Please fill out this field.";
        System.out.println(createAccountPage.getAttributeLastName("validationMessage"));
        Assert.assertTrue(createAccountPage.getAttributeLastName("validationMessage").equals(expectedMessage));
    }

    @Test
    public void validEmptyOptions() throws InterruptedException{
        List<String> languages = new ArrayList<>();
        languages.add("Arabic");
        languages.add("Danish");

        Account account = new Account("ana123@gmail.com", "Ana12345678,", "Ana12345678,");
        account.setFirstName("Ana")
                .setLastName("Cadena")
                .setAddress("calle #123")
                .setPhone("8364727476")
                .setLanguages(languages)
                .setSkill("Android")
                .setCountry("Bolivia")
                .setYear("1999")
                .setMonth("March")
                .setDay("5")
                .setFile("C:\\Users\\R\\Pictures\\cruz.jpg");

        Assert.assertTrue(createAccountPage.goToRegister());
        createAccountPage.verifyEmptyOptions(account);
        String expectedMessage = "Please select one of these options.";
        System.out.println(createAccountPage.getAttributeGender("validationMessage"));
        Assert.assertTrue(createAccountPage.getAttributeGender("validationMessage").equals(expectedMessage));
    }

    @Test
    public void validEmptySelected() throws InterruptedException {
        List<String> languages = new ArrayList<>();
        languages.add("Arabic");
        languages.add("Danish");

        Account account = new Account("ana123@gmail.com", "Ana12345678,", "Ana12345678,");
        account.setFirstName("Ana")
                .setLastName("Cadena")
                .setAddress("calle #123")
                .setPhone("8364727476")
                .setLanguages(languages)
                .setSkill("Android")
                .setCountry("Select Country")
                .setYear("1999")
                .setMonth("March")
                .setDay("5")
                .setFile("C:\\Users\\R\\Pictures\\cruz.jpg");

        Assert.assertTrue(createAccountPage.goToRegister());
        createAccountPage.createAccount(account);
        String expectedMessage = "Please select an item in the list.";
        System.out.println(createAccountPage.getAttributeCountry("validationMessage"));
        Assert.assertTrue(createAccountPage.getAttributeCountry("validationMessage").equals(expectedMessage));
    }

    @Test
    public void validSelectMultipleTest() throws InterruptedException{
        List<String> languages = new ArrayList<>();
        languages.add("Arabic");
        languages.add("Danish");
        languages.add("English");
        languages.add("Catalan");
        languages.add("Filipino");

        Account account = new Account("ana123@gmail.com", "Ana12345678,", "Ana12345678,");
        account.setFirstName("Ana")
                .setLastName("Cadena")
                .setAddress("calle #123")
                .setPhone("8364727476")
                .setLanguages(languages)
                .setSkill("Android")
                .setCountry("Bolivia")
                .setYear("1999")
                .setMonth("March")
                .setDay("5")
                .setFile("C:\\Users\\R\\Pictures\\cruz.jpg");

        Assert.assertTrue(createAccountPage.goToRegister());
        createAccountPage.createAccount(account);
        Assert.assertNotNull(createAccountPage);
    }


    @Test
    public void invalidMessageEmailTest() throws InterruptedException{
        Assert.assertTrue(createAccountPage.goToRegister());
        Assert.assertTrue(createAccountPage.verifyInvalidMessageEmail());
    }

    @Test
    public void invalidEmail(){
        List<String> languages = new ArrayList<>();
        languages.add("Arabic");
        languages.add("Danish");

        Account account = new Account("ana123", "Ana12345678,", "Ana12345678,");
        account.setFirstName("Ana")
                .setLastName("Cadena")
                .setAddress("calle #123")
                .setPhone("8364727476")
                .setLanguages(languages)
                .setSkill("Android")
                .setCountry("Bolivia")
                .setYear("1999")
                .setMonth("March")
                .setDay("5")
                .setFile("C:\\Users\\R\\Pictures\\cruz.jpg");

        Assert.assertTrue(createAccountPage.goToRegister());
        createAccountPage.createAccount(account);
        String expectedMessage = "Please include an '@' in the email address. '"+account.getEmail()+"' is missing an '@'.";
        System.out.println(createAccountPage.getAttributeEmail("validationMessage"));
        System.out.println(expectedMessage);
        Assert.assertTrue(createAccountPage.getAttributeEmail("validationMessage").equals(expectedMessage));
    }


    @Test
    public void invalidPhone(){
        List<String> languages = new ArrayList<>();
        languages.add("Arabic");
        languages.add("Danish");

        Account account = new Account("ana123@gmail.com", "Ana12345678,", "Ana12345678,");
        account.setFirstName("Ana")
                .setLastName("Cadena")
                .setAddress("calle #123")
                .setPhone("mi numero")
                .setLanguages(languages)
                .setSkill("Android")
                .setCountry("Bolivia")
                .setYear("1999")
                .setMonth("March")
                .setDay("5")
                .setFile("C:\\Users\\R\\Pictures\\cruz.jpg");

        Assert.assertTrue(createAccountPage.goToRegister());
        createAccountPage.createAccount(account);
        String expectedMessage = "Please match the requested format.";
        Assert.assertTrue(createAccountPage.getAttributePhone("validationMessage").equals(expectedMessage));
    }

    @Test
    public void LessRangePhone(){
        List<String> languages = new ArrayList<>();
        languages.add("Arabic");
        languages.add("Danish");

        Account account = new Account("ana123@gmail.com", "Ana12345678,", "Ana12345678,");
        account.setFirstName("Ana")
                .setLastName("Cadena")
                .setAddress("calle #123")
                .setPhone("12345")
                .setLanguages(languages)
                .setSkill("Android")
                .setCountry("Bolivia")
                .setYear("1999")
                .setMonth("March")
                .setDay("5")
                .setFile("C:\\Users\\R\\Pictures\\cruz.jpg");

        Assert.assertTrue(createAccountPage.goToRegister());
        createAccountPage.createAccount(account);
        String expectedMessage = "Please match the requested format.";
        Assert.assertTrue(createAccountPage.getAttributePhone("validationMessage").equals(expectedMessage));
    }

    @Test
    public void majorRangePhone(){
        List<String> languages = new ArrayList<>();
        languages.add("Arabic");
        languages.add("Danish");

        Account account = new Account("ana123@gmail.com", "Ana12345678,", "Ana12345678,");
        account.setFirstName("Ana")
                .setLastName("Cadena")
                .setAddress("calle #123")
                .setPhone("12345678901")
                .setLanguages(languages)
                .setSkill("Android")
                .setCountry("Bolivia")
                .setYear("1999")
                .setMonth("March")
                .setDay("5")
                .setFile("C:\\Users\\R\\Pictures\\cruz.jpg");

        Assert.assertTrue(createAccountPage.goToRegister());
        createAccountPage.createAccount(account);
        String expectedMessage = "Please match the requested format.";
        Assert.assertTrue(createAccountPage.getAttributePhone("validationMessage").equals(expectedMessage));
    }

    @Test
    public void invalidPassword(){
        List<String> languages = new ArrayList<>();
        languages.add("Arabic");
        languages.add("Danish");

        Account account = new Account("ana123@gmail.com", "ana12345678", "Ana12345678,");
        account.setFirstName("Ana")
                .setLastName("Cadena")
                .setAddress("calle #123")
                .setPhone("1234567890")
                .setLanguages(languages)
                .setSkill("Android")
                .setCountry("Bolivia")
                .setYear("1999")
                .setMonth("March")
                .setDay("5")
                .setFile("C:\\Users\\R\\Pictures\\cruz.jpg");

        Assert.assertTrue(createAccountPage.goToRegister());
        createAccountPage.createAccount(account);
        String expectedMessage = "Please Enter an UpperCase,LowerCase Alphabet and a Number";
        System.out.println(createAccountPage.getAttributePassword("validationMessage"));
        Assert.assertTrue(createAccountPage.getAttributePassword("validationMessage").equals(expectedMessage));
    }

    @Test
    public void invalidNoEqualsPasswords(){
        List<String> languages = new ArrayList<>();
        languages.add("Arabic");
        languages.add("Danish");

        Account account = new Account("ana123@gmail.com", "Bna12345678,", "Ana12345678,");
        account.setFirstName("Ana")
                .setLastName("Cadena")
                .setAddress("calle #123")
                .setPhone("1234567890")
                .setLanguages(languages)
                .setSkill("Android")
                .setCountry("Bolivia")
                .setYear("1999")
                .setMonth("March")
                .setDay("5")
                .setFile("C:\\Users\\R\\Pictures\\cruz.jpg");

        Assert.assertTrue(createAccountPage.goToRegister());
        createAccountPage.createAccount(account);
        String expectedMessage = "Passwords dont match";
        System.out.println(createAccountPage.getAttributeConfirmPassword("validationMessage"));
        Assert.assertTrue(createAccountPage.getAttributeConfirmPassword("validationMessage").equals(expectedMessage));
    }

}

