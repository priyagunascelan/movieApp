package steps;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import hooks.DriverInstance;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class HeaderSectionTest {
	DriverInstance driverInstance;
	public HeaderSectionTest(DriverInstance driverInstance) {
		this.driverInstance = driverInstance;
	}
	@Given("Test whether the Website logo is displayed")
	public void testWhetherTheWebsiteLogoIsDisplayed() {
	    WebElement webSiteLogo =driverInstance.getDriver().findElement(By.className("website-logo"));
	    Assert.assertTrue(webSiteLogo.isDisplayed(),"Logo didn't displayed");;
	}
	@Then("Test the Navbar elements")
	public void testTheNavbarElements() {
	    List<WebElement> navEL = driverInstance.getDriver().findElements(By.xpath("//nav//child::li/a"));
	    for(WebElement aa: navEL) {
	    	if(aa.getText().equalsIgnoreCase("Home")) {
	    		Assert.assertEquals(aa.getText(), "Home","Home nav element didn't display");
	    	}
	    	else if(aa.getText().equalsIgnoreCase("Popular")) {
	    		Assert.assertEquals(aa.getText(), "Popular","Popular nav element didn't display");
	    	}
	    }
	    
	}
}
