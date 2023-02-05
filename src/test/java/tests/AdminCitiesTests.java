package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AdminCitiesPage;
import pages.HomePage;
import pages.LoginPage;

import java.nio.file.WatchEvent;

public class AdminCitiesTests extends BaseTest {
    private AdminCitiesPage adminCitiesPage;
    private HomePage homePage;
    private LoginPage loginPage;
    private String cityName;

    @BeforeClass
    @Override
    public void beforeClass() {
        super.beforeClass();
        homePage = new HomePage(driver, driverWait);
        loginPage = new LoginPage(driver, driverWait);
        adminCitiesPage = new AdminCitiesPage(driver, driverWait);
        cityName = faker.address().city();
    }

    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
        homePage.openLogin();
    }

    @Test
    public void urlCheck() {
        loginPage.login("admin@admin.com", "12345");
        adminCitiesPage.adminCities();
        loginPage.urlContains("/admin/cities");
        Assert.assertTrue(driver.findElement(By.className("btnLogout")).isDisplayed());
    }

    @Test
    public void createNewCity() {
        loginPage.login("admin@admin.com", "12345");
        adminCitiesPage.adminCities();
        adminCitiesPage.createNewCity(cityName);
        Assert.assertTrue(adminCitiesPage.savedSuccessfully().contains("Saved successfully"));
    }

    @Test
    public void editCityName() {
        loginPage.login("admin@admin.com", "12345");
        adminCitiesPage.adminCities();
        adminCitiesPage.createNewCity(cityName);
        adminCitiesPage.searchCity(cityName);
        adminCitiesPage.editNameCity(cityName + " - edited");
        Assert.assertTrue(adminCitiesPage.savedSuccessfully().contains("Saved successfully"));

    }
}