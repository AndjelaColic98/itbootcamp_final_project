package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.BaseTest;

public class AdminCitiesPage extends BasePage {

    @FindBy(className = "btnAdmin")
    private WebElement adminBtn;

    @FindBy(className = "btnAdminCities")
    private WebElement adminCitiesBtn;

    public AdminCitiesPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void adminCities() {
        adminBtn.click();
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("btnAdminCities")));
        adminCitiesBtn.click();
    }

}
