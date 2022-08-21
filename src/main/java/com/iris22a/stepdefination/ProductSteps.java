package com.iris22a.stepdefination;

import java.util.List;

import org.testng.Assert;

import com.iris22a.keyword.UIKeywords;
import com.iris22a.pages.HomePage;
import com.iris22a.utils.Environment;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductSteps {
	@Given("chrome browser should open.")
	public void browseropen() {
		UIKeywords.openBrowser("Chrome");
	}

	@And("myntra url should launch.")
	public void launMyntraUrl() {
		UIKeywords.launchUrl(Environment.URL);
	}

	@When("user search for polo tshirt.")
	public void searchPoloTshirts() {
		HomePage home = new HomePage();
		home.searchForPoloText("Polo");
	}

	@Then("all result should be related polo tshirt.")
	public void verifyAllResult() {
		HomePage home = new HomePage();
		List<String> productTexts = home.getSearchResultText();
		for (String text : productTexts) {
			Assert.assertTrue(text.contains("Polo"), "Text is mismatch " + text);
		}
	}
	@Then("browser should be close.")
	public void closeBrowser() {
		UIKeywords.closeBrowser();

	}
}
