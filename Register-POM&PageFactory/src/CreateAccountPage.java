import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CreateAccountPage extends PageBase{

    @FindBy(how = How.LINK_TEXT, using = "Register")
    WebElement registerLinkLocator;

    @FindBy(xpath = "//*[@id=\"section\"]/div/h2")
    WebElement registerPageLocator;

    @FindBy(xpath = "//input[@ng-model='FirstName']")
    WebElement firstName;

    @FindBy(xpath = "//input[@ng-model='LastName']")
    WebElement lastName;

    @FindBy(xpath = "//textarea[@ng-model='Adress']")
    WebElement address;

    @FindBy(xpath = "//input[@ng-model='EmailAdress']")
    WebElement email;

    @FindBy(xpath = "//input[@ng-model='Phone']")
    WebElement phone;

    @FindBy(xpath = "//input[@value='FeMale']")
    WebElement genderFemale;

    @FindBy(xpath = "//input[@value='Male']")
    WebElement genderMale;

    @FindBy(id = "checkbox1")
    WebElement hobbieCricket;

    @FindBy(id = "checkbox2")
    WebElement hobbieMovies;

    @FindBy(id = "checkbox3")
    WebElement hobbieHockey;

    @FindBy(id = "msdd")
    WebElement displayLanguages;

    @FindBy(xpath = "//a[@class='ui-corner-all']")
    List<WebElement> languages;

    @FindBy(id = "Skills")
    WebElement skills;

    @FindBy(xpath = "//*[@id=\"countries\"]")
    WebElement country;


    @FindBy(xpath = "//*[@id=\"basicBootstrapForm\"]/div[10]/div/span/span[1]/span")
    WebElement displayStates;

    @FindBy(xpath = "//*[@id=\"select2-country-results\"]/li[11]")
    WebElement state;

    @FindBy(id = "yearbox")
    WebElement year;

    @FindBy(xpath = "//select[@ng-model='monthbox']")
    WebElement month;

    @FindBy(xpath = "//select[@ng-model='daybox']")
    WebElement day;

    @FindBy(id = "firstpassword")
    WebElement password;

    @FindBy(id = "secondpassword")
    WebElement confirmPassword;

    @FindBy(id = "imagesrc")
    WebElement uploadFile;

    @FindBy(id = "submitbtn")
    WebElement submitButton;

    @FindBy(xpath = "//*[@id=\"basicBootstrapForm\"]/div[3]/div[2]/span")
    WebElement getMessgeEmail;

    public CreateAccountPage(WebDriver driver) {
        super(driver);
        driver.get("http://demo.automationtesting.in/Register.html");
        PageFactory.initElements(driver,this);
    }

    public boolean goToRegister(){
        registerLinkLocator.click();
        return registerPageLocator.isDisplayed();
    }

    public void createAccount(Account account){
        firstName.sendKeys(account.getFirstName());
        lastName.sendKeys(account.getLastName());
        phone.sendKeys(account.getPhone());
        email.sendKeys(account.getEmail());
        address.sendKeys(account.getAddress());
        genderFemale.click();
        WebElement[] hobbies = new WebElement[]{ hobbieCricket, hobbieHockey};
        selectCheckBox(hobbies);
        displayLanguages.click();
        //Select languages
        for(WebElement option : languages){
            for(String value: account.getLanguages()){
                if(option.getText().equals(value)){
                    option.click();
                }
            }
        }
        selectDropDown(skills,account.getSkill());
        selectDropDown(country,account.getCountry());
        displayStates.click();
        state.click();
        selectDropDown(year,account.getYear());
        selectDropDown(month,account.getMonth());
        selectDropDown(day,account.getDay());
        password.sendKeys(account.getPassword());
        confirmPassword.sendKeys(account.getConfirmPassword());
        uploadFile.sendKeys(account.getFile());
        submitButton.click();
    }

    public void verifyEmptyOptions(Account account){
        firstName.sendKeys(account.getFirstName());
        lastName.sendKeys(account.getLastName());
        phone.sendKeys(account.getPhone());
        email.sendKeys(account.getEmail());
        address.sendKeys(account.getAddress());
        //genderFemale.click();
        WebElement[] hobbies = new WebElement[]{ hobbieCricket, hobbieHockey};
        selectCheckBox(hobbies);
        displayLanguages.click();
        //Select languages
        for(WebElement option : languages){
            for(String value: account.getLanguages()){
                if(option.getText().equals(value)){
                    option.click();
                }
            }
        }
        selectDropDown(skills,account.getSkill());
        selectDropDown(country,account.getCountry());
        displayStates.click();
        state.click();
        selectDropDown(year,account.getYear());
        selectDropDown(month,account.getMonth());
        selectDropDown(day,account.getDay());
        password.sendKeys(account.getPassword());
        confirmPassword.sendKeys(account.getConfirmPassword());
        uploadFile.sendKeys(account.getFile());
        submitButton.click();
    }


    public boolean getMessageValidateEmail(){
        mouseMove(email);
        return getMessgeEmail.isDisplayed();
    }

}
