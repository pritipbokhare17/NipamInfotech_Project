package tests;


import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;

import pages.PunchPage;

public class PunchInTest extends BaseTest {

    @BeforeMethod
    public void init() {
        setUp();
    }

    @Test
    public void punchInToastVerification() {
        LoginPage login = new LoginPage(driver);
        login.enterUsername("admin");
        login.enterPassword("admin123");
        login.clickLogin();

        PunchPage dash = new PunchPage(driver);
        dash.clickPunchIn();

        String toast = dash.getToastMessage();
        System.out.println("Toast : " + toast);

        Assert.assertTrue(toast.contains("Punch In"), "PunchIn Toast Not Verified!");
    }

    @AfterMethod
    public void close() {
        tearDown();
    }
}