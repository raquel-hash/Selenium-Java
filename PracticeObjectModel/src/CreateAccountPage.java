import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class CreateAccountPage extends PageBase{

    //variables constantes
    private final static By registerLinkLocator = By.linkText("Register");
    private final static By registerPageLocator = By.xpath("//*[@id=\"section\"]/div/h2");
    private final static By firstName = By.xpath("//input[@ng-model='FirstName']");
    private final static By lastName = By.xpath("//input[@ng-model='LastName']");
    private final static By address = By.xpath("//textarea[@ng-model='Adress']");
    private final static By email = By.xpath("//input[@ng-model='EmailAdress']");
    private final static By phone = By.xpath("//input[@ng-model='Phone']");
    private final static By gender = By.xpath("//input[@value='FeMale']");
    private final static By hobbie1 = By.id("checkbox1");
    private final static By hobbie2 = By.id("checkbox3");
    private final static By displayedLanguages = By.id("msdd");
    private final static By languages = By.xpath("//a[@class='ui-corner-all']");
    private final static By skill = By.id("Skills");
    private final static By country = By.xpath("//*[@id=\"countries\"]");
    private final static By displayedStates = By.xpath("//*[@id=\"basicBootstrapForm\"]/div[10]/div/span/span[1]/span");
    private final static By state = By.xpath("//*[@id=\"select2-country-results\"]/li[11]");
    private final static By year = By.id("yearbox");
    private final static By month = By.xpath("//select[@ng-model='monthbox']");
    private final static By day = By.xpath("//select[@ng-model='daybox']");
    private final static By password = By.id("firstpassword");
    private final static By confirmPassword = By.id("secondpassword");
    private final static By uploadFile = By.id("imagesrc");
    private final static By submitButton = By.id("submitbtn");
    private final static By verifyMessageEmailInvalid = By.xpath("//*[@id=\"basicBootstrapForm\"]/div[3]/div[2]/span");

    List<By> hobbies= new ArrayList<>();

    public CreateAccountPage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean goToRegister(){
        clickElement(registerLinkLocator);
        return isDisplayed(registerPageLocator);
    }

    public void createAccount(Account account){
        hobbies.add(hobbie1);
        hobbies.add(hobbie2);
        type(firstName, account.getFirstName());
        type(lastName, account.getLastName());
        type(phone, account.getPhone());
        type(email, account.getEmail());
        type(address, account.getAddress());
        selectRadio(gender);
        selectCheckBox(hobbies);
        clickElement(displayedLanguages);
        selectElements(languages, account.getLanguages());
        selectDropDown(skill, account.getSkill());
        selectDropDown(country,account.getCountry());
        clickElement(displayedStates);
        clickElement(state);
        selectDropDown(year, account.getYear());
        selectDropDown(month, account.getMonth());
        selectDropDown(day, account.getDay());
        type(password, account.getPassword());
        type(confirmPassword, account.getConfirmPassword());
        selectDropDown(country,account.getCountry());
        type(uploadFile, account.getFile());
        clickElement(submitButton);
    }

    public void verifyEmptyOptions(Account account){
        hobbies.add(hobbie1);
        hobbies.add(hobbie2);
        type(firstName, account.getFirstName());
        type(lastName, account.getLastName());
        type(phone, account.getPhone());
        type(email, account.getEmail());
        type(address, account.getAddress());
        //selectRadio(gender);
        selectCheckBox(hobbies);
        clickElement(displayedLanguages);
        selectElements(languages, account.getLanguages());
        selectDropDown(skill, account.getSkill());
        selectDropDown(country,account.getCountry());
        clickElement(displayedStates);
        clickElement(state);
        selectDropDown(year, account.getYear());
        selectDropDown(month, account.getMonth());
        selectDropDown(day, account.getDay());
        type(password, account.getPassword());
        type(confirmPassword, account.getConfirmPassword());
        selectDropDown(country,account.getCountry());
        type(uploadFile, account.getFile());
        clickElement(submitButton);
    }

    public boolean verifyInvalidMessageEmail(){
        mouseMove(email);
        return isDisplayed(verifyMessageEmailInvalid);
    }

    public String getAttributePhone(String type){
        return getAttribute(findElement(phone), type);
    }

    public String getAttributeEmail(String type){
        return getAttribute(findElement(email), type);
    }

    public String getAttributePassword(String type){
        return getAttribute(findElement(password), type);
    }

    public String getAttributeConfirmPassword(String type){
        return getAttribute(findElement(confirmPassword), type);
    }

    public String getAttributeName(String type){
        return getAttribute(findElement(firstName), type);
    }

    public String getAttributeLastName(String type){
        return getAttribute(findElement(lastName), type);
    }

    public String getAttributeGender(String type){
        return getAttribute(findElement(gender), type);
    }

    public String getAttributeCountry(String type){
        return getAttribute(findElement(country), type);
    }

}
