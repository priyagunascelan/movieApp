package steps;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import hooks.DriverInstance;
import io.cucumber.java.en.When;

public class HomePageTest {
	DriverInstance driverInstance;
	public HomePageTest(DriverInstance driverInstance) {
		this.driverInstance = driverInstance;
	}
	@When("Test the heading texts of each section")
	public void testTheHeadingTextsOfEachSection() {
	    List<WebElement> heading = driverInstance.getDriver().findElements(By.tagName("h1"));
	    for(WebElement aa: heading) {
	    	if(aa.getText().equalsIgnoreCase("The Pursuit of Happyness")) {
	    		System.out.println("The Pursuit of Happyness heading is present");
	    	}
	    	else if(aa.getText().equalsIgnoreCase("Trending Now")) {
	    		System.out.println("Trending Now is present");
	    	}
	    	else if(aa.getText().equalsIgnoreCase("Originals")){
	    		System.out.println("Originals");
	    	}
	    }
	}
	@When("Test whether the play button is displayed or not")
	public void testWhetherThePlayButtonIsDisplayedOrNot() {
	    WebElement playBtnEl =driverInstance.getDriver().findElement(By.xpath("(//button)[3]"));
	    Assert.assertTrue(playBtnEl.isDisplayed(),"play button didn't present");
	}
	@When("Test whether the Movies are displayed, in the corresponding movies sections")
	public void testWhetherTheMoviesAreDisplayedInTheCorrespondingMoviesSections() {
		 List<WebElement> moviesList = driverInstance.getDriver().findElements(By.cssSelector("img.poster"));
		 for(WebElement aa:moviesList) {
			 if(aa.getAttribute("src").equalsIgnoreCase("https://assets.ccbp.in/frontend/react-js/movies-app/shang-chi-and-the-legend-of-the-ten-rings-movie-poster.png")) {
				 System.out.println("Movies are displayed");
			 }
		 }
	}
	@When("Test the Contact Us Section")
	public void testTheContactUsSection() {
		WebElement contact = driverInstance.getDriver().findElement(By.className("contact-us-paragraph"));
        boolean checkContact = contact.isDisplayed();
        Assert.assertTrue(checkContact);
        List<WebElement> contactItems = driverInstance.getDriver().findElements(By.xpath("//div[@class=\"footer-icons-container\"]/child::*"));
        Assert.assertEquals(contactItems.size(),4,"Contact item size didn't match");
	}
	
}
