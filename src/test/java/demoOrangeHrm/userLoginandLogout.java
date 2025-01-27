package demoOrangeHrm;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class userLoginandLogout {

	String userName = "Admin";
	String password = "admin123";
	WebDriver driver;
	
	@Test(priority=0)
	public void startUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	@Test(priority = 1)
	public void verifyLoginPageTitleTest() {
	String actualTitle = driver.getTitle();
	String expectedTitle = "OrangeHRM";
	Assert.assertEquals(actualTitle, expectedTitle, "OOPS!!! Title of login page mismatched");
		
	}
	
	@Test(priority=2)
	public void loginUserTest() throws Throwable {
		driver.findElement(By.name("username")).sendKeys(userName);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String dashBoard = driver.findElement(By.xpath("//span[@class='oxd-topbar-header-breadcrumb']")).getText();
		String expectedText = "Dashboard";
		Assert.assertEquals(dashBoard, expectedText);
		
		Thread.sleep(5000);
	
	}
	
	@Test(priority=3)
	public void logoutUserTest() {
		driver.findElement(By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")).click();
		driver.findElement(By.linkText("Logout")).click();
	}
	
	
}
