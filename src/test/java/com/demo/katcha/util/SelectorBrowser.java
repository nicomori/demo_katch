package com.demo.katcha.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SelectorBrowser {

	public static DesiredCapabilities capabilities;

	public static WebDriver createDriverWithoutCapabilities(boolean mobile, WebDriver driver) {

		if (mobile) {
			driver = OpenBrowserChrome.openBowserWithOutCapabilitiesForEmulateMobile(driver, true);
		} else {
			driver = OpenBrowserChrome.openBowserWithOutCapabilities(driver);
		}
		return driver;
	}
}
