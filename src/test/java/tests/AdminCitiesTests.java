package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AdminCitiesPage;
import pages.HomePage;
import pages.LoginPage;

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
        loginPage.login("admin@admin.com", "12345");
        adminCitiesPage.adminCities();
    }

    @Test
    public void urlCheck() {
        loginPage.urlContains("/admin/cities");
        Assert.assertTrue(driver.findElement(By.className("btnLogout")).isDisplayed());
    }

    @Test
    public void createNewCity() {
        adminCitiesPage.createNewCity(cityName);
        Assert.assertTrue(adminCitiesPage.successfullyMessage().contains("Saved successfully"));
    }

    @Test
    public void editCityName() {
        adminCitiesPage.createNewCity(cityName);
        adminCitiesPage.searchCity(cityName);
        adminCitiesPage.editNameCity(" - edited");
        Assert.assertTrue(adminCitiesPage.successfullyMessage().contains("Saved successfully"));
    }

    @Test
    public void searchCity() {
        adminCitiesPage.createNewCity(cityName);
        adminCitiesPage.searchCity(cityName);
        Assert.assertTrue(adminCitiesPage.searchingCities().contains(cityName));
    }

    @Test
    public void deleteCity() {
        adminCitiesPage.createNewCity(cityName);
        adminCitiesPage.searchCity(cityName);
        adminCitiesPage.editNameCity(" - edited");
        Assert.assertTrue(adminCitiesPage.numberOfRows().contains("1 - 1"));
        Assert.assertTrue(adminCitiesPage.searchingCities().contains(cityName + " - edited"));
        adminCitiesPage.deletingCity();
        Assert.assertTrue(adminCitiesPage.successfullyMessage().contains("Deleted successfully"));
    }

    @AfterMethod
    public void afterMethod() {
        homePage.logout();
    }
}