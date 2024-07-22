package hooks;

import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	DriverInstance driverInstance;
	WebDriver driver;
	public Hooks(DriverInstance driverInstance) {
		this.driverInstance = driverInstance;
	}
	@Before
	public void beforeScenario(Scenario scenario) {
		System.out.println(scenario.getName());
		System.out.println(scenario.getLine());
		driverInstance.setDriver(driver);
		driverInstance.getDriver().manage().window().maximize();
		driverInstance.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driverInstance.getDriver().get("https://qamoviesapp.ccbp.tech");
	}
	@AfterStep
	public void afterScenario(Scenario scenario) {
		if(scenario.isFailed()) {
			TakesScreenshot ts = (TakesScreenshot)driverInstance.getDriver();
			byte[] shotAs = ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(shotAs, "image/png", "Screenshot captured...");
		}
		System.out.println(scenario.getStatus());
	}
	@After
	public void tearDown() {
		driverInstance.getDriver().quit();
	}
}
