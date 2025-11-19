package tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {
    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][]{
                {"pritibokhare00@gmail.com", "Bokhare@12"},
        };
    }

    @BeforeMethod
    public void init() {
        setUp();
    }

    @Test(dataProvider = "loginData")
    public void loginTest(String user, String pass) {
        LoginPage login = new LoginPage(driver);

        login.enterUsername(user);
        login.enterPassword(pass);
        login.clickLogin();

        Assert.assertTrue(login.validateDashboard(), "Login Failed!");
    }

    @AfterMethod
    public void close() {
        tearDown();
    }
}
