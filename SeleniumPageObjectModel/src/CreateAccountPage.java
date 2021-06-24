import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateAccountPage extends PageBase{

    //variables constantes
    private final static By registerLinkLocator = By.linkText("REGISTER");
    private final static By registerPageLocator = By.xpath("//img[@src='images/mast_register.gif']");
    private final static By firstName = By.name("firstName");
    private final static By lastName = By.name("lastName");
    private final static By phone = By.name("phone");
    private final static By email = By.id("userName");
    private final static By address = By.name("address1");
    private final static By city = By.name("city");
    private final static By stateProvince = By.name("state");
    private final static By postalCode = By.name("postalCode");
    private final static By userName = By.name("email");
    private final static By password = By.name("password");
    private final static By confirmPassword = By.name("confirmPassword");
    private final static By country = By.name("country");
    private final static By submitButton = By.name("submit");

    public CreateAccountPage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean goToRegister(){
        clickElement(registerLinkLocator);
        return isDisplayed(registerPageLocator);
    }

    public void createAccount(Account account){
        type(firstName, account.getFirstName());
        type(lastName, account.getLastName());
        type(phone, account.getPhone());
        type(email, account.getEmail());
        type(address, account.getAddress());
        type(city,account.getCity());
        type(stateProvince, account.getStateProvince());
        type(postalCode, account.getPostalCode());
        type(userName, account.getUserName());
        type(password, account.getPassword());
        type(confirmPassword, account.getConfirmPassword());
        selectDropDown(country,account.getCountry());
        clickElement(submitButton);
    }

}
