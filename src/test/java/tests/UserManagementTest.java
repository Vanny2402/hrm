package tests;

import base.BaseTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AdminPage;
import pages.LoginPage;
import utils.ExcelReader;

import java.util.List;
import java.util.Map;

public class UserManagementTest extends BaseTest {
    LoginPage loginPage;
    AdminPage adminPage;

    @BeforeMethod
    public void setUp() {
        initializeDriver("chrome");
        driver.get("https://opensource-demo.orangehrmlive.com/");
        loginPage = new LoginPage(driver);
        adminPage = new AdminPage(driver);
        // Login as Admin
        loginPage.login("Admin", "admin123");

    }

    @Test(dataProvider = "userData")
    public void testAddUsers(String role, String employeeName, String username, String status, String password) throws Exception {
    	adminPage.navigateToAdminTab();
        adminPage.clickAddButton();
        adminPage.addUser(driver,role, employeeName, username, status, password);
        // Validate user creation
//        Assert.assertTrue(adminPage.isSuccessMessageDisplayed(), "User creation failed for username: " + username);
    }

    @DataProvider(name = "userData")
    public Object[][] getUserData() {
        List<Map<String, String>> data = ExcelReader.getTestData("src/main/resources/data/user_data.xlsx", "Sheet1");
        Object[][] dataArray = new Object[data.size()][5];
        for (int i = 0; i < data.size(); i++) {
            dataArray[i][0] = data.get(i).get("Role");
            dataArray[i][1] = data.get(i).get("Employee Name");
            dataArray[i][2] = data.get(i).get("Username");
            dataArray[i][3] = data.get(i).get("Status");
            dataArray[i][4] = data.get(i).get("Password");
        }
        return dataArray;
    }
    @AfterMethod
    public void tearDown() {
//    	tearDown();    
    	System.out.print("tear down \n");
    	}
}
