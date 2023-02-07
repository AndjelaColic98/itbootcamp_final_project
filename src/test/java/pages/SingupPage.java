package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SingupPage extends BasePage{

    @FindBy(id = "name")
    private WebElement name;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "confirmPassword")
    private WebElement confirmPassword;

    @FindBy(xpath = "//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[2]/span/form/div/div[5]/button")
    private WebElement singMeUpBtn;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[3]/div/div/div/div/div[1]/ul/li")
    private WebElement message;

    @FindBy(xpath = "//*[@id=\"app\"]/div[4]/div/div/div[1]")
    private WebElement header;

    public SingupPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement email() {
        return email;
    }

    public WebElement password() {
        return password;
    }

    public WebElement confirmPassword() {
        return confirmPassword;
    }

    public void singUp(String nameStr, String emailStr, String passwordStr, String passwordConfStr) {
        name.sendKeys(nameStr);
        email.sendKeys(emailStr);
        password.sendKeys(passwordStr);
        confirmPassword.sendKeys(passwordConfStr);
        singMeUpBtn.click();
    }
    public String message(){
        return message.getText();
    }
    public String messageHeader(){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return header.getText();
    }
}
