package com.demo.katcha.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.demo.katcha.pageobject.web.LanderPage;
import com.demo.katcha.util.SelectorBrowser;

public class StepsHelper {

	protected WebDriver driver;
	protected static LanderPage landerPage;

	/**
	 * this method execute the browser selected previously and send the url to the browser
	 * 
	 * @param String
	 *            with the browser name.
	 * 
	 * @return LoginEmailPage
	 */
	protected LanderPage startBrowser(boolean mobile) {
		System.out.println("Starting driver for Browser Chrome");
		driver = SelectorBrowser.createDriverWithoutCapabilities(mobile, driver);
		return PageFactory.initElements(driver, LanderPage.class);
	}

	/**
	 * this method send the url to the browser
	 * 
	 * @param String
	 *            with the url
	 */
	protected void navigateTo(String url) {
		System.out.println("Starting to send the url: " + url);
		driver.navigate().to(url);
	}

}
