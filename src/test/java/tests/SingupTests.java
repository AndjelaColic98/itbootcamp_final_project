package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
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
        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div/div[1]/main/div/div[2]/div/div/div[3]/div/div/div/div/div[1]/ul/li")).getText(),"E-mail already exists");
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"));
    }

    @Test
    public void verifyAcc(){
        singupPage.singUp("Andjela Čolić", "andjela123@gmail.com","123456","123456");
        driverWait.until(ExpectedConditions.urlContains("/home"));
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[1]")).getText(),"IMPORTANT: Verify your account");
    }
}
