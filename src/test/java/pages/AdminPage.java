package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminPage {
	WebDriver driver;
	// Locators w

	private By ADMINLABEL = By.xpath("//li[1]//a[1]//span[1]");
	private By BUTTON_ADD_USER = By.xpath("//button[normalize-space()='Add']");
	private By USER_ROLE_DROPDOWN = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]");

	private By EMP_NAME = By.xpath("//input[@placeholder='Type for hints...']");
	private By USER_STATUS = By.xpath("//div[3]//div[1]//div[2]//div[1]//div[1]//div[2]//i[1]");
	private By USER_NAME = By.xpath("//label[text()='Username']/following-sibling::div/input");
	private By PASSWORD = By.xpath("//input[contains(@class, 'oxd-input--error') and @type='password']");
	private By CON_PASSWORD = By
			.xpath("//label[text()='Confirm Password']/following-sibling::div/input[@type='password']");

	private By BUTTON_SAVE = By.xpath("//button[@type='submit']");

	public AdminPage(WebDriver driver) {
		this.driver = driver;

	}

	public void navigateToAdminTab() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement adminLink = wait.until(ExpectedConditions.visibilityOfElementLocated(ADMINLABEL));
		adminLink.click();
	}

	public void clickAddButton() {
		driver.findElement(BUTTON_ADD_USER).click();
	}

	public void addUser(WebDriver driver, String role, String employeeName, String username, String status,
			String password) throws Exception {
		selectDropdownValue(driver, "User Role", role);

//		driver.findElement(EMP_NAME).sendKeys(employeeName)
//		driver.findElement(USER_NAME).sendKeys(username);
//		selectDropdownValue(USER_STATUS,status);
//		driver.findElement(PASSWORD).sendKeys(password);
//		driver.findElement(CON_PASSWORD).sendKeys(password);
//		driver.findElement(BUTTON_SAVE).click();
	}

	public void selectDropdownValue(WebDriver driver, String label, String optionText) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                String.format("//label[text()='%s']/following::div[contains(@class, 'oxd-select-wrapper')][1]", label)
        )));
        dropdown.click();
        System.out.println("Dropdown expanded");

        // Wait for the desired option to appear and then click it
        WebElement dropdownOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                String.format("//div[@class='oxd-select-text-input' and normalize-space()='%s']", optionText)
        )));
        dropdownOption.click();
        System.out.println("Option selected: " + optionText);
	}

	public boolean isSuccessMessageDisplayed() {
		try {
			return driver.findElement(BUTTON_SAVE).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

}
