package pages;

import com.github.javafaker.Faker;
import org.checkerframework.checker.formatter.qual.Format;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.BaseTest;

import java.time.Duration;

public class AdminCitiesPage extends BasePage {

    @FindBy(className = "btnAdmin")
    private WebElement adminBtn;

    @FindBy(className = "btnAdminCities")
    private WebElement adminCitiesBtn;

    @FindBy(className = "btnNewItem")
    private WebElement newItemBtn;

    @FindBy(id = "name")
    private WebElement nameOfCity;

    @FindBy(className = "btnSave")
    private WebElement saveBtn;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")
    private WebElement message;

    @FindBy(id = "search")
    private WebElement searchInput;

    @FindBy(id = "edit")
    private WebElement edit;


    public AdminCitiesPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void adminCities() {
        adminBtn.click();
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("btnAdminCities")));
        adminCitiesBtn.click();
    }

    public void createNewCity(String city) {
        newItemBtn.click();
        nameOfCity.sendKeys(city);
        saveBtn.click();
    }

    public void searchCity(String city){
        searchInput.click();
        searchInput.sendKeys(city);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    public void editNameCity(String editedName) {
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody")));
        edit.click();
        driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys(editedName);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[5]/div/div/div[3]/button[2]/span")).click();
    }

    public String savedSuccessfully() {
        return message.getText();
    }



}
