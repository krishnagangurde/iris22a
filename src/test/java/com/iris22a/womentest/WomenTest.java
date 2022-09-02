package com.iris22a.womentest;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.iris22a.config.TestBase;
import com.iris22a.keyword.UIKeywords;
import com.iris22a.utils.Environment;
import com.iris22a.women.HomePage1;

public class WomenTest extends TestBase {
	public static final Logger log = Logger.getLogger(WomenTest.class);

	@Test
	public void verifyserchforIndianFusionwear() {
		UIKeywords.launchUrl(Environment.URL);
		log.info("myntra url launched");
//      HomePage1 home = PageFactory.initElements(UIKeywords.driver, HomePage1.class);
		HomePage1 home = new HomePage1();
		home.hoverOnWomenMenu();
		log.info("hover on women menu");
		home.clickOnindianfusionwear();
		log.info("click on indian & fusionwear");


	}
	@Test
	public void verifysearchresultforkurta() throws InterruptedException {
		UIKeywords.launchUrl(Environment.URL);
		HomePage1 home = new HomePage1();
		home.searchforkurta("kurta");
		List<String> productTexts = home.getKurtaList();
		for (String text : productTexts) {
			Assert.assertTrue(text.contains("kurta"), "Text is mismatch " + text);
		}
		
		
	}

}
