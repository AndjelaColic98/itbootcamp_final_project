package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;

public class LoginTests extends BaseTest{
    private HomePage homePage;

    @BeforeClass
    @Override
    public void beforeClass() {
        super.beforeClass();
        homePage = new HomePage(driver, driverWait);
    }

    @Test
    public void loginCheckURL() {
        homePage.openLogin();
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }
}
