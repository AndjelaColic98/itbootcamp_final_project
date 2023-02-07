package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;


public class LoginTests extends BaseTest{
    private HomePage homePage;
    private LoginPage loginPage;

    @BeforeClass
    @Override
    public void beforeClass() {
        super.beforeClass();
        homePage = new HomePage(driver, driverWait);
        loginPage = new LoginPage(driver, driverWait);
    }

    @BeforeMethod
    @Override
    public void beforeMethod(){
        super.beforeMethod();
        homePage.openLogin();
    }
    @Test
    public void loginCheckURL() {
        driverWait.until(ExpectedConditions.urlContains("/login"));
        loginPage.urlContains("/login");
    }

    @Test
    public void inputTypesCheck() {
        Assert.assertEquals(loginPage.email().getAttribute("type"), "email");
        Assert.assertEquals(loginPage.password().getAttribute("type"), "password");
    }

    @Test
    public void userDoesNotExist() {
        loginPage.login(faker.internet().emailAddress(), faker.internet().password());
        Assert.assertEquals(loginPage.messageToString(), "User does not exists");
        loginPage.urlContains("/login");
    }

    @Test
    public void wrongPasswordLogin() {
        loginPage.login("admin@admin.com", faker.internet().password());
        Assert.assertEquals(loginPage.messageToString(), "Wrong password");
        loginPage.urlContains("/login");
    }

    @Test
    public void login() {
        loginPage.login("admin@admin.com", "12345");
        driverWait.until(ExpectedConditions.urlContains("/home"));
        loginPage.urlContains("/home");
        homePage.logout();
    }

    @Test
    public void logout() {
        loginPage.login("admin@admin.com", "12345");
        driverWait.until(ExpectedConditions.urlContains("/home"));
        Assert.assertTrue(homePage.logoutBtn().isDisplayed());
        homePage.logout();
        loginPage.urlContains("/login");
        driver.get("https://vue-demo.daniel-avellaneda.com/home");
        loginPage.urlContains("/login");
    }
}
