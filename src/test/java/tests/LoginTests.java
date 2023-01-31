package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
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

    @Test
    public void loginCheckURL() {
        homePage.openLogin();
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

    @Test
    public void inputTypesCheck() {
        homePage.openLogin();
        Assert.assertEquals(loginPage.email().getAttribute("type"), "email");
        Assert.assertEquals(loginPage.password().getAttribute("type"), "password");
    }

    @Test
    public void userDoesNotExist() {
        Faker faker = new Faker();
        homePage.openLogin();
        loginPage.login(faker.internet().emailAddress(), faker.internet().password());
        Assert.assertEquals(loginPage.messageToString(), "User does not exists");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }
}
