package pages;

import org.checkerframework.checker.units.qual.K;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.BaseTest;

public class ProfilePage extends BasePage {

        @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[3]")
        private WebElement myProfileBtn;

        @FindBy(xpath = "//*[@id=\"name\"]")
        private WebElement name;

        @FindBy(id = "phone")
        private WebElement phone;

        @FindBy(id = "city")
        private WebElement city;

        @FindBy(id = "country")
        private WebElement country;

        @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div/div[8]/button")
        private WebElement saveBtn;

        @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]")
        private WebElement message;

        @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div/div[4]/span/div/div/div[1]/div[1]/div[1]/div/button")
        private WebElement deleteCityBtn;

        @FindBy(id = "urlTwitter")
        private WebElement twitterURL;



    public ProfilePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void myProfilePage(){
        myProfileBtn.click();
        driverWait.until(ExpectedConditions.visibilityOf(name));
    }
    public void editName(String nameString){
        name.click();
        name.sendKeys(Keys.CONTROL + "a");
        name.sendKeys(Keys.DELETE);
        name.sendKeys(nameString);
    }
    public void editPhoneNumber(String phoneString){
        phone.click();
        phone.sendKeys(Keys.CONTROL + "a");
        phone.sendKeys(Keys.DELETE);
        phone.sendKeys(phoneString);
    }
    public void editCity(String cityName){
        deleteCityBtn.click();
        city.sendKeys(Keys.CONTROL + "a");
        city.sendKeys(Keys.DELETE);
        city.sendKeys(cityName);
        city.sendKeys(Keys.ENTER);
    }
    public void editCountry(String countryName){
        country.click();
        country.sendKeys(Keys.CONTROL + "a");
        country.sendKeys(Keys.DELETE);
        country.sendKeys(countryName);
    }
   public void editTwitter(String twitterUrl){
        twitterURL.click();
        twitterURL.sendKeys(Keys.CONTROL + "a");
        twitterURL.sendKeys(Keys.DELETE);
        twitterURL.sendKeys(twitterUrl);
   }
   public void saveBtn(){
        saveBtn.click();
   }

    public String message(){
        return message.getText();
    }

    public WebElement getName() {
        return name;
    }

    public WebElement getPhone() {
        return phone;
    }

    public WebElement getCity() {
        return city;
    }

    public WebElement getCountry() {
        return country;
    }
}
