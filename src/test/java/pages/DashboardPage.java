package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
    WebDriver driver;

    // Locators
//    private By logoutLink = By.linkText("Logout");
    
    
    private By welcomeMessage = By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']");
    private By PROFILE_LOGOUT_CLICK = By.xpath("//img[@class='oxd-userdropdown-img']");
    private By LABLE_LOGOUT = By.xpath("//a[normalize-space()='Logout']");
    private By HOME_SCREEN = By.xpath("//h5[@class='oxd-text oxd-text--h5 orangehrm-login-title']");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getWelcomeMessage() {
        return driver.findElement(welcomeMessage).getText();
    }

    public void logout() {
        driver.findElement(PROFILE_LOGOUT_CLICK).click();
        driver.findElement(LABLE_LOGOUT).click();
        driver.findElement(HOME_SCREEN);
    }
}
