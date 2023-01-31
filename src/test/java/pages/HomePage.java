package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/header/div/div[3]/a[3]")
    private WebElement login;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/header/div/div[3]/button[2]")
    private WebElement logout;

    public HomePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void openLogin(){
        login.click();
    }

    public void logout(){
        logout.click();
    }
}
