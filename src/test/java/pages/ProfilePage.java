package pages;

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



    public ProfilePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void editProfile(String nameStr, String phoneStr, String cityStr, String countryStr){
        myProfileBtn.click();
        driverWait.until(ExpectedConditions.visibilityOf(name));
        name.clear();
        name.sendKeys(nameStr);
        phone.clear();
        phone.sendKeys(phoneStr);
        city.clear();
        city.sendKeys(cityStr);
        country.clear();
        driverWait.until(ExpectedConditions.textToBePresentInElementValue(country,""));
        country.sendKeys(countryStr);
        saveBtn.click();
        myProfileBtn.click();
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
