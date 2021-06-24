import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountPage extends PageBase{

    @FindBy(how = How.LINK_TEXT, using = "REGISTER")
    WebElement registerLinkLocator;

    @FindBy(xpath = "//img[@src='images/mast_register.gif']")
    WebElement registerPageLocator;

    @FindBy(name = "firstName")
    WebElement firstName;

    @FindBy(name = "lastName")
    WebElement lastName;

    @FindBy(name = "phone")
    WebElement phone;

    @FindBy(id = "userName")
    WebElement email;

    @FindBy(name = "address1")
    WebElement address;

    @FindBy(name = "city")
    WebElement city;

    @FindBy(name = "state")
    WebElement stateProvince;

    @FindBy(name = "postalCode")
    WebElement postalCode;

    @FindBy(name = "email")
    WebElement userName;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(name = "confirmPassword")
    WebElement confirmPassword;

    @FindBy(name = "country")
    WebElement country;

    @FindBy(name = "submit")
    WebElement submitButton;

    public CreateAccountPage(WebDriver driver) {
        super(driver);
        driver.get("http://demo.guru99.com/test/newtours/");
        PageFactory.initElements(driver, this);
    }

    public boolean goToRegister(){
        registerLinkLocator.click();
        return registerPageLocator.isDisplayed();
    }

    public void createAccount(@NotNull Account account){
        firstName.sendKeys(account.getFirstName());
        lastName.sendKeys(account.getLastName());
        phone.sendKeys(account.getPhone());
        email.sendKeys(account.getEmail());
        address.sendKeys(account.getAddress());
        city.sendKeys(account.getCity());
        stateProvince.sendKeys(account.getStateProvince());
        postalCode.sendKeys(account.getPostalCode());
        userName.sendKeys(account.getUserName());
        password.sendKeys(account.getPassword());
        confirmPassword.sendKeys(account.getConfirmPassword());
        Select countryPais = new Select(country);
        countryPais.selectByVisibleText(account.getCountry());
        submitButton.click();
    }


}
