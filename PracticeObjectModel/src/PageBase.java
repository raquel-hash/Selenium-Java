import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PageBase {
    protected WebDriver driver;
    public PageBase(WebDriver webDriver){
        this.driver=webDriver;
    }

    public void  url(String urlSite){
        driver.get(urlSite);
    }

    public WebDriver chromeDriverConnection(){
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        return driver;
    }

    public WebElement findElement(By locator){
        return driver.findElement(locator);
    }

    public List<WebElement> findElements(By locator){
        return driver.findElements(locator);
    }

    public String getText(WebElement element){
        return element.getText();
    }

    public String getText(By element){
        return driver.findElement(element).getText();
    }

    public  void type(By locator, String inputText){
        driver.findElement(locator).sendKeys(inputText);
    }

    public void clickElement(By locator){
        driver.findElement(locator).click();
    }

    public String getTitle(){
        return driver.getTitle();
    }

    public void selectDropDown(By locator, String selectValue){
        Select select = new Select(driver.findElement(locator));
        select.selectByVisibleText(selectValue);
    }

    public void selectRadio(By locator){
        driver.findElement(locator).click();
    }

    public void selectCheckBox(List<By> locators){
        for(By locator: locators){
            driver.findElement(locator).click();
        }
    }

    public void  selectElements(By locator, List<String> values){
        List<WebElement> options = driver.findElements(locator);
        for(WebElement option : options){
            //System.out.println(option.getText());
            for(String value: values){
                if(option.getText().equals(value)){
                    option.click();
                }
            }
        }
    }

    public boolean isDisplayed(By locator){
        try{
            return  driver.findElement(locator).isDisplayed();
        }catch (org.openqa.selenium.NoSuchElementException e){
            return false;
        }
    }

    public boolean isTextPresent(String text){
        try {
            return  driver.findElement(By.tagName("body")).getText().contains(text);
        }catch (org.openqa.selenium.NoSuchElementException e){
            return false;
        }
    }

    public void mouseMove(By locator){
        WebElement element=driver.findElement(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.release().perform();
    }

    public String getAttribute(WebElement element, String type){
       return element.getAttribute(type);
    }

}//end class
