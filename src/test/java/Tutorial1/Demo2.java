package Tutorial1;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Demo2 {
	public static  WebDriver driver;
	@Given("User is on home page")
	public void user_is_on_home_page() {
	   System.setProperty("webdriver.chrome.driver","C:\\\\Users\\\\SAI\\\\Desktop\\\\chromedriver-win64\\\\chromedriver-win64\\\\chromedriver.exe");
	 driver=new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)).pageLoadTimeout(Duration.ofSeconds(30));
	 driver.manage().deleteAllCookies();
	 driver.get("https://demo.guru99.com/test/newtours/register.php");
	 
	}

	@When("user enter valid firstname, lastname, phone and email")
	public void user_enter_valid_firstname_lastname_phone_and_email() {
	   driver.findElement(By.name("firstName")).sendKeys("sujata");
	   driver.findElement(By.name("lastName")).sendKeys("kale");
	   driver.findElement(By.name("phone")).sendKeys("2415958989");
	   driver.findElement(By.name("userName")).sendKeys("suja123@gmail.com");
	}

	@When("user enter valid address, city, state,postol code and select country")
	public void user_enter_valid_address_city_state_postol_code_and_select_country() {
		 driver.findElement(By.name("address1")).sendKeys("viman nager");
		 driver.findElement(By.name("city")).sendKeys("pune");
		 driver.findElement(By.name("state")).sendKeys("MH");
		 driver.findElement(By.name("postalCode")).sendKeys("431578");
		 WebElement selcountry=driver.findElement(By.name("country"));
		 Select sel=new Select(selcountry);
		 sel.selectByVisibleText("INDIA");
	}

	@When("user enter valid username, password, confirm password and click on submit button")
	public void user_enter_valid_username_password_confirm_password_and_click_on_submit_button() {
		driver.findElement(By.name("email")).sendKeys("suja@gmail.com");
		driver.findElement(By.name("password")).sendKeys("sujata");
		driver.findElement(By.name("confirmPassword")).sendKeys("sujata");
	}

	@Then("user is on regester sucess page")
	public void user_is_on_regester_sucess_page() {
		String a = driver.findElement(By.xpath("//h3[text()='Login Successfully']")).getText();

		Assert.assertEquals(a, "Login Successfully");
	}


}
