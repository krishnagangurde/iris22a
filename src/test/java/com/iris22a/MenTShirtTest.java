package com.iris22a;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.iris22a.config.TestBase;
import com.iris22a.keyword.UIKeywords;
import com.iris22a.pages.HomePage;
import com.iris22a.pages.menTShirtsPage;
import com.iris22a.utils.Environment;

public class MenTShirtTest extends TestBase {
	UIKeywords keyword = new UIKeywords();

	@Test
	public void verifySearchResultByPopularity() {
		keyword.launchUrl(Environment.URL);
		HomePage home = new HomePage();
		home.hoverOnMenMenu();
		home.clickOnmenTShirt();
		menTShirtsPage menTShirt1 =PageFactory.initElements(UIKeywords.driver, menTShirtsPage.class);
		menTShirt1.selectPopularityFilter();
		

	}

}
