package pages;

import org.checkerframework.checker.formatter.qual.Format;
import org.checkerframework.checker.signature.qual.FieldDescriptor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage extends BasePage {

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[3]/span/form/div/div[3]/button")
    private WebElement loginBtn;

    @FindBy (xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]/ul/li")
    private WebElement message;

    public LoginPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement email() {
        return email;
    }

    public WebElement password() {
        return password;
    }

    public void login(String emailStr, String passwordStr){
        email.click();
        password.clear();
        email.sendKeys(emailStr);
        password.sendKeys(passwordStr);
        loginBtn.click();
    }
    public String messageToString(){
       return message.getText();
    }

    public void urlContains(String string){
        Assert.assertTrue(driver.getCurrentUrl().contains(string));
    }
}
