package packSteps;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition
{
	WebDriver driver;
	WebDriverWait wait;
	String url,title,fn;
	
	@Before("@RegistrationForm")
	public void Open()
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		wait=new WebDriverWait(driver,Duration.ofSeconds(20));
	}	
	
	@Given("Registration Form is Open")
	public void registration_form_is_open() {
		url="file:///C:/Selenium-Setup/SampleHTML/Registration-Form.html";
	    driver.get(url);
	    title=driver.getTitle();
	    System.out.println("Home Page : " + title);
	}

	@When("i enter valid Data on RegistrationPage")
	public void i_enter_valid_data_on_registration_page(DataTable dataTable) 
	{
		List<List<String>> myDataTable=dataTable.asLists();
		
		driver.findElement(By.name("firstname")).sendKeys(myDataTable.get(1).get(1));
		driver.findElement(By.name("middlename")).sendKeys(myDataTable.get(2).get(1));
		driver.findElement(By.name("lastname")).sendKeys(myDataTable.get(3).get(1));
		WebElement course=driver.findElement(By.name("Course"));
		Select select=new Select(course);
		select.selectByValue(myDataTable.get(4).get(1));
		driver.findElement(By.name(myDataTable.get(5).get(1))).click();
		driver.findElement(By.name("phone")).sendKeys(myDataTable.get(6).get(1));
		driver.findElement(By.name("address")).sendKeys(myDataTable.get(7).get(1));
		driver.findElement(By.name("email")).sendKeys(myDataTable.get(8).get(1));
		driver.findElement(By.name("pass")).sendKeys(myDataTable.get(9).get(1));
		driver.findElement(By.name("repass")).sendKeys(myDataTable.get(9).get(1));
		
	}

	@When("Click on Submit")
	public void click_on_submit() {
	    driver.findElement(By.linkText("SUBMIT")).click();
	}

	@Then("Submit Page Opens")
	public void submit_page_opens() throws Exception {
	    Assert.assertTrue(driver.getCurrentUrl().contains("SUBMIT"), "Page Not Open");
	    Thread.sleep(7000);
	}
	@After("@RegistrationForm")
	public void Close()
	{
		driver.quit();
	}

}
