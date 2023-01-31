package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
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
    public void beforeMethod(){
        super.beforeMethod();
        homePage.signUp();
    }
}
