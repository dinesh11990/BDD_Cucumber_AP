package stepDefinitions;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class DataTableWithHeader {
	
	WebDriver driver;

	@Given("^Go to login page$")
	public void go_to_login_page() throws Throwable {
		
		System.setProperty("webdriver.chrome.driver", "C:\\New folder\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");

	}

	@When("^Enter the below credentials$")
	public void enter_the_below_credentials(DataTable dataTable) throws Throwable {
		
	List<Map<String,String>> keyValuePair=dataTable.asMaps(String.class, String.class);
	
	//get(0) --> 1st Row in Datatable
	
	String userName=keyValuePair.get(0).get("Username");
	String passWord=keyValuePair.get(0).get("Password");
	
	driver.findElement(By.id("txtUsername")).sendKeys("userName");
	driver.findElement(By.id("txtPassword")).sendKeys("passWord");
	
	}

	@When("^click login button$")
	public void click_login_button() throws Throwable {
		driver.findElement(By.id("btnLogin")).click();
	}
	
}
