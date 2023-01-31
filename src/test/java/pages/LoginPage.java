package pages;

import org.checkerframework.checker.formatter.qual.Format;
import org.checkerframework.checker.signature.qual.FieldDescriptor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "password")
    private WebElement password;

    public LoginPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement email() {
        return email;
    }

    public WebElement password() {
        return password;
    }
}
