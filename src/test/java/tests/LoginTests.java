package tests;

import org.testng.annotations.BeforeClass;
import pages.HomePage;

public class LoginTests extends BaseTest{
    private HomePage homePage;

    @BeforeClass
    @Override
    public void beforeClass(){
        super.beforeClass();
        homePage = new HomePage(driver,driverWait);
    }
}
