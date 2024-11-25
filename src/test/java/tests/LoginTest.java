package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.DashboardPage;
import pages.LoginPage;

public class LoginTest extends BaseTest {

	LoginPage loginPage;
    DashboardPage dashboardPage;

    @BeforeMethod
    public void setUp() {
        initializeDriver("chrome");
        driver.get("https://opensource-demo.orangehrmlive.com");
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
    }	
    
    @Test
    public void testValidLogin() {
        loginPage.login("admin", "admin123");
        Assert.assertTrue(dashboardPage.getWelcomeMessage().contains("Dashboard"), "Login failedssssssss!");
        dashboardPage.logout();
    }

    @Test
    public void testInvalidLogin() {
        loginPage.login("InvalidUser", "InvalidPass");
        Assert.assertEquals(loginPage.getErrorMessage(), "Invalid credentials", "Error message mismatch!");
    }

    @AfterMethod
    public void tearDown() {
//        tearDown();
        System.out.println("Tearing down after method...");
        driver.close();
        driver.quit();

    }
}
