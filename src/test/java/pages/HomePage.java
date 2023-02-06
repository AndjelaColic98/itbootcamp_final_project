package pages;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/header/div/div[3]/a[3]")
    private WebElement login;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]")
    private WebElement logout;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/header/div/div[3]/a[4]")
    private WebElement singupBtn;

    @FindBy(className = "btnLocaleActivation")
    private WebElement localeBtn;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/h1")
    private WebElement header;

    @FindBy(xpath = "//*[@id=\"list-item-75\"]")
    private WebElement localeES;

    @FindBy(xpath = "//*[@id=\"list-item-73\"]")
    private WebElement localeEN;

    @FindBy(xpath = "//*[@id=\"list-item-77\"]")
    private WebElement localeFR;

    public HomePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void openLogin(){
        login.click();
    }

    public void logout(){
        logout.click();
    }

    public void signUp(){
        singupBtn.click();
    }

    public WebElement logoutBtn() {
        return logout;
    }

    public void localeBtn(){
        localeBtn.click();
    }

    public String header(){
       return header.getText();
    }

    public void localeES (){
        driverWait.until(ExpectedConditions.visibilityOf(localeES));
        localeES.click();
    }

    public void localeEN(){
        driverWait.until(ExpectedConditions.visibilityOf(localeEN));
        localeEN.click();
    }

    public void localeFR(){
        driverWait.until(ExpectedConditions.visibilityOf(localeFR));
        localeFR.click();
    }
}
