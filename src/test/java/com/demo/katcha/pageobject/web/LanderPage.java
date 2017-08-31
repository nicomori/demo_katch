package com.demo.katcha.pageobject.web;

import org.openqa.selenium.WebDriver;

import com.demo.katcha.util.TabUtils;

import core.ZipContainer;
import core.ZipFactory;

/**
 * Created by william.russell on 8/28/17.
 *
 * The Each page is broken down into components. In the framework, each component has a factory, and
 * changes depending on the site being tested.
 *
 *
 * Page Object can have logic (such as the submitZipCode) that knows how to use each components, so
 * test cases are written normally.
 */
public class LanderPage extends BasePageObject { // Try to use the methods from base page object.

	public ZipContainer zc;

	public LanderPage(WebDriver driver) {
		super(driver);
		zc = ZipFactory.newZipContainer(driver);
	}

	public void setZipCode(String zipCode) {
		System.out.println("Sending the value " + zipCode + " to the field zipCode");
		zc.setZipInput(zipCode);
	}

	public FormPage pressTheButtonSearch() {
		System.out.println("Making clic in the button search");
		zc.clickZipButton();
		TabUtils.switchTab(driver, 1);
		return new FormPage(driver);
	}
}
