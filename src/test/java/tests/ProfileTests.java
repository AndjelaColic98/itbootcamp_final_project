package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;

public class ProfileTests extends BaseTest{

    private ProfilePage profilePage;
    private HomePage homePage;
    private LoginPage loginPage;
    private String name;
    private String phone;
    private String country;

    @BeforeClass
    @Override
    public void beforeClass() {
        super.beforeClass();
        profilePage = new ProfilePage(driver,driverWait);
        homePage = new HomePage(driver,driverWait);
        loginPage = new LoginPage(driver,driverWait);
        name = faker.name().firstName();
        phone = faker.phoneNumber().cellPhone();
        country = faker.country().name();
    }

    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
        homePage.openLogin();
        loginPage.login("admin@admin.com", "12345");
    }

    @Test
    public void editProfile() {
        profilePage.editName(name);
        profilePage.editPhoneNumber(phone);
        profilePage.editCity("New York");
        profilePage.editCountry(country);
        profilePage.editTwitter("https://" + faker.internet().url() + "/twitter");
        profilePage.saveBtn();


        Assert.assertTrue(profilePage.message().contains("Profile saved successfuly"));
        Assert.assertEquals(profilePage.getName().getAttribute("value"), name);
        Assert.assertEquals(profilePage.getPhone().getAttribute("value"), phone);
        Assert.assertEquals(profilePage.getCity().getAttribute("value"), "New York");
        Assert.assertEquals(profilePage.getCountry().getAttribute("value"), country);
    }

}
