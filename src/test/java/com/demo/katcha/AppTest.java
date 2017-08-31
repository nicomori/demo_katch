package com.demo.katcha;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

/**
 * Demo Nicolas Mori for the project Applause-Katcha
 */
@CucumberOptions(plugin = { "html:target/cucumber-html-reports", "json:target/cucumber-html-reports/cucumber.json",
		"junit:target/surefire-reports/cucumber-junit.xml" }, features = "src/test/resources/features", tags = "@zipcode", glue = {
				"com.demo.katcha.steps" })
public class AppTest extends AbstractTestNGCucumberTests {
}
