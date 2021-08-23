package cucumber;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinations {


	static WebDriver driver;

	@Given("User should be on the login page")
	public void user_should_be_on_the_login_page() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php");
	}

	@When("User entered valid username")
	public void user_entered_valid_username() {

		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
	}

	@When("User entered valid password")
	public void user_entered_valid_password() {

		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
	}

	@When("Clicked on signin button")
	public void clicked_on_signin_button() {
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();

	}

	@SuppressWarnings("deprecation")
	@Then("User should be on the homepage")
	public void user_should_be_on_the_homepage() {

		Assert.assertEquals("Dashboard", driver.findElement(By.xpath("//h1[contains(text(),'Dashboard')]")).getText());
	}

	@When("User entered invalid username")
	public void user_entered_invalid_username() {

		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admins");
	}

	@When("User entered invalid password")
	public void user_entered_invalid_password() {
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123@");

	}

	@SuppressWarnings("deprecation")
	@Then("Application should show some validation message")
	public void application_should_show_some_validation_message() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		Assert.assertEquals("Invalid credentials", driver.findElement(By.xpath("//span[@id='spanMessage']")).getText());
	}
}
