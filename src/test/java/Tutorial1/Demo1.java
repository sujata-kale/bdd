package Tutorial1;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Demo1 {
	public static  WebDriver driver;
	@Given("user is on Login Page")
	public void user_is_on_login_page() {
	    System.setProperty("webdriver.chrome.driver", "C:\\Users\\SAI\\Desktop\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().deleteAllCookies();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@When("user enter valid credentails")
	public void user_enter_valid_credentails() {

driver.findElement(By.name("username")).sendKeys("Admin");
driver.findElement(By.name("password")).sendKeys("admin123");
driver.findElement(By.xpath("//button[text()=' Login ']")).click();

	}

	@Then("Use validate home page title")
	public void use_validate_home_page_title() {
	   String abc= driver.getTitle();
	   Assert.assertEquals(abc,"OrangeHRM");
	}

		
	}