package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AdminCitiesPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;

public class ProfileTests extends BaseTest{
    //Test #1: Edits profile
    //Podaci: random podaci korišćenjem faker library-ja
    //assert:
    //•	Verifikovati da je prikazana poruka Profile saved successfuly
    //•	Verifikovati da svaki input sada za value atribut ima vrednost koja je uneta u okviru forme

    private ProfilePage profilePage;
    private HomePage homePage;
    private LoginPage loginPage;
    private String name;
    private String phone;
    private String city;
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
        city = faker.country().capital();
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
    public void editProfile(){
        profilePage.editProfile(name,phone,city,country);
        Assert.assertTrue(profilePage.message().contains("Profile saved successfuly"));
        Assert.assertEquals(profilePage.getName().getAttribute("value"),name);
        Assert.assertEquals(profilePage.getPhone().getAttribute("value"),phone);
        Assert.assertEquals(profilePage.getCity().getAttribute("value"),city);
        Assert.assertEquals(profilePage.getCountry().getAttribute("value"),country);
    }

}
