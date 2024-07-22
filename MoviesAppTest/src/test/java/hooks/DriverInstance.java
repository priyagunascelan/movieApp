package hooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverInstance {
	private WebDriver driver;
	public WebDriver getDriver() {
		return driver;
	}
	public void setDriver(WebDriver driver) {
		driver = new ChromeDriver();
		this.driver = driver;
	}
}
