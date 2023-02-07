package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;
import pages.SingupPage;

public class SingupTests extends BaseTest{
    private HomePage homePage;
    private SingupPage singupPage;


    @BeforeClass
    @Override
    public void beforeClass() {
        super.beforeClass();
        homePage = new HomePage(driver, driverWait);
        singupPage = new SingupPage(driver, driverWait);

    }

    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
        homePage.signUp();
    }

    @Test
    public void urlConfirmation() {
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"));
    }

    @Test
    public void inputTypesCheck() {
        Assert.assertEquals(singupPage.email().getAttribute("type"), "email");
        Assert.assertEquals(singupPage.password().getAttribute("type"), "password");
        Assert.assertEquals(singupPage.confirmPassword().getAttribute("type"), "password");
    }

    @Test
    public void userAlreadyExists(){
        singupPage.singUp("Test Test","admin@admin.com","123654","123654");
        Assert.assertEquals(singupPage.message(),"E-mail already exists");
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"));
    }

    @Test
    public void verifyAcc(){
        singupPage.singUp("Andjela Čolić", "andjela123@gmail.com","123456","123456");
        driverWait.until(ExpectedConditions.urlContains("/home"));
        Assert.assertEquals(singupPage.messageHeader(),"IMPORTANT: Verify your account");
    }
}
