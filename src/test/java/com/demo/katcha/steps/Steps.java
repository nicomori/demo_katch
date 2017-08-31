package com.demo.katcha.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class Steps extends StepsHelper {

	@And("I set the zip code \"(.*)?\"")
	public void setTheZipCode(String zipCode) {
		System.out.println("Starting to set the zip code");
		landerPage.setZipCode(zipCode);
	}

	@Then("I press in the button search")
	public void pressInTheButtonSearch() {
		System.out.println("make click in the button search");
		landerPage.pressTheButtonSearch();
	}

}