package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AdminCitiesPage;
import pages.HomePage;
import pages.LoginPage;

import java.util.HashMap;

public class LocaleTests extends BaseTest{

    private HomePage homePage;

    @BeforeClass
    @Override
    public void beforeClass() {
        super.beforeClass();
        homePage = new HomePage(driver, driverWait);
    }

    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
        homePage.localeBtn();
    }

    @Test
    public void localeES(){
        homePage.localeES();
        Assert.assertTrue(homePage.header().contains("Página de aterrizaje"));
    }

    @Test
    public void localeEN(){
        homePage.localeEN();
        Assert.assertTrue(homePage.header().contains("Landing"));
    }

    @Test
    public void localeFR(){
        homePage.localeFR();
        Assert.assertTrue(homePage.header().contains("Page d'atterrissage"));
    }
}
