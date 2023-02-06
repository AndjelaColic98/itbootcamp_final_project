package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr")
    private WebElement firstRowSearched;

    @FindBy(id = "delete")
    private WebElement deleteBtn;

    @FindBy(xpath = "/html/body/div/div[6]/div/div/div[2]/button[2]")
    private WebElement deleteClick;


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

    public String successfullyMessage() {
        return message.getText();
    }

    public String searchingCities(){
        driverWait.until(ExpectedConditions.visibilityOf(firstRowSearched));
        return firstRowSearched.getText();
    }

    public String numberOfRows(){
        WebElement numberRows = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[3]/div[2]"));
        driverWait.until(ExpectedConditions.visibilityOf(numberRows));
        return numberRows.getText();
    }

    public void deletingCity(){
        driverWait.until(ExpectedConditions.visibilityOf(deleteBtn));
        deleteBtn.click();
        driverWait.until(ExpectedConditions.visibilityOf(deleteClick));
        deleteClick.click();
        driverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"))));
    }
}
