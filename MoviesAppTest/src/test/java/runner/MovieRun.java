package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;

@CucumberOptions(
		features = "C:\\Users\\lenovo\\eclipse-workspace\\MoviesAppTest\\src\\test\\java\\feature",
		snippets = SnippetType.CAMELCASE,
		glue = {"steps","hooks"},
		dryRun = !true,
		plugin = {"pretty",
				"html:C:\\Users\\lenovo\\eclipse-workspace\\MoviesAppTest\\src\\test\\resources\\Reports\\index.html",
				"json:C:\\Users\\lenovo\\eclipse-workspace\\MoviesAppTest\\src\\test\\resources\\Reports\\index.json",
				"junit:C:\\Users\\lenovo\\eclipse-workspace\\MoviesAppTest\\src\\test\\resources\\Reports\\index.xml"})
		
public class MovieRun extends AbstractTestNGCucumberTests{

}
