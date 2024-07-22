package steps;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;


import org.testng.Assert;

import hooks.DriverInstance;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageTest {
	DriverInstance driverInstance;
	public LoginPageTest(DriverInstance driverInstance) {
		this.driverInstance = driverInstance;
	}
	@Given("user passes the url as {string}")
	public void userPassesTheUrlAs(String url) {
		driverInstance.getDriver().get(url);
	}
	@When("Test whether the Website logo image is displayed")
	public void testWhetherTheWebsiteLogoImageIsDisplayed() {
	   WebElement logoEL = driverInstance.getDriver().findElement(By.xpath("//img[@class =\"login-website-logo\"]"));
	   Assert.assertTrue(logoEL.isDisplayed());
	}
	@When("Test whether the Heading text is Login present")
	public void testWhetherTheHeadingTextIsLoginPresent() {
	    WebElement headEl = driverInstance.getDriver().findElement(By.xpath("//h1[@class ='sign-in-heading']"));
	    Assert.assertEquals(headEl.getText(),"Login","Heading Text Login didn't present");
	}
	@When("Test whether the Username label text is USERNAME is display")
	public void testWhetherTheUsernameLabelTextIsUSERNAMEIsDisplay() {
		WebElement usernameEl = driverInstance.getDriver().findElement(By.xpath("//label[@for='usernameInput']"));
	    Assert.assertEquals(usernameEl.getText(),"USERNAME","Username Text didn't present");
	}
	@When("Test whether the Password label text is PASSWORD is display")
	public void testWhetherThePasswordLabelTextIsPASSWORDIsDisplay() {
		WebElement passwordEl = driverInstance.getDriver().findElement(By.xpath("//label[@for='passwordInput']"));
	    Assert.assertEquals(passwordEl.getText(),"PASSWORD","Password Text didn't present");
	}
	@Then("Test the Login button is present")
	public void testTheLoginButtonIsPresent() {
		WebElement loginBtnEl = driverInstance.getDriver().findElement(By.xpath("//button[@class='login-button']"));
	    Assert.assertEquals(loginBtnEl.getText(),"Login","Login button didn't present");
	}
	@Given("user enters username as {string}")
	public void userEntersUsernameAs(String string) {
		WebElement userNameEl = driverInstance.getDriver().findElement(By.id("usernameInput"));
		userNameEl.sendKeys(string);
	    
	}
	@Given("user enters password as {string}")
	public void userEntersPasswordAs(String string) {
		WebElement passwordEl = driverInstance.getDriver().findElement(By.id("passwordInput"));
		passwordEl.sendKeys(string);
	    
	}
	@Given("user click login button")
	public void userClickButton() {
		WebElement loginBtnEl = driverInstance.getDriver().findElement(By.xpath("//button[@class='login-button']"));
		loginBtnEl.click();
		System.out.println(driverInstance.getDriver().getCurrentUrl());
	    
	}
	
}
