package com.demo.katcha.steps;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

public class StepsGeneric extends StepsHelper {

	@Given("I start the browser with emulation to mobile in \"(.*)?\"")
	public void accessToTheBrowserSpecial(boolean mobile) {
		System.out.println("Starting the browser and setuping this to mobile in: " + mobile);
		landerPage = startBrowser(mobile);
	}

	@And("I access to this url \"(.*)?\"")
	public void a111(String url) {
		System.out.println("Accessint to the url: " + url);
		navigateTo(url);
	}

	@After
	public void afterMethod() {
		System.out.println("++++++++++++++++++++++ Correct Finish Start ++++++++++++++++++++++");
		driver.quit();
	}
}