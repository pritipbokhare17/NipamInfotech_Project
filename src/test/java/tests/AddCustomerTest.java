package tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CustomerPage;
import pages.LoginPage;

public class AddCustomerTest extends BaseTest {
    @DataProvider(name = "customerData")
    public Object[][] customerData() {
        return new Object[][]{
                {"admin", "admin123", "Test Customer 1"},
                {"admin", "admin123", "Automation Customer"},
        };
    }



    @Test(dataProvider = "customerData")
    public void addCustomer(String user, String pass, String customerName) {
        LoginPage login = new LoginPage(driver);
        login.enterUsername(user);
        login.enterPassword(pass);
        login.clickLogin();

        CustomerPage cust = new CustomerPage(driver);

        cust.openCustomerTab();
        cust.clickAddCustomer();
        cust.enterCustomerName(customerName);
        cust.clickSave();

        String toast = cust.getToastMsg();
        Assert.assertTrue(toast.contains("Customer"), "Customer Add Failed!");
    }

    @AfterMethod
    public void close() {
       //tearDown();
    }
}
