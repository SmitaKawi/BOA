package cucumberTest;


import org.junit.runner.RunWith;

import org.testng.annotations.Test;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



@RunWith(Cucumber.class)
@CucumberOptions
(
		
		plugin = {"pretty",
						"html:target/cucumber/report.html",
						"json:results/cucumber.json",
					},
		features = {"src/test/resources/Features/Registration.feature"},
		glue = { "packSteps"},
		tags = "@RegistrationForm"
)

public class MyCucumberRun extends AbstractTestNGCucumberTests

{

	@Test
	public void TC()
	{
		
	}

	 
}
