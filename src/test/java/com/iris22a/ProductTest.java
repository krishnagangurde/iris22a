package com.iris22a;

import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.iris22a.config.TestBase;
import com.iris22a.keyword.UIKeywords;

public class ProductTest extends TestBase {
	@Test
	public static void verifySerchResultForPoloMen() {
		UIKeywords.launchUrl("https://www.myntra.com/");

		UIKeywords.enterText(By.xpath("//input[@placeholder='Search for products, brands and more']"), "polo men");

		UIKeywords.hitButton(KeyEvent.VK_ENTER);
 
		List<String> productTitles = UIKeywords.getTexts(By.xpath("//h3[@class='product-brand']"));

		for (String producttitle : productTitles) {
			Assert.assertTrue(producttitle.contains("Polo"), " product title  doesnt contain polo men " + producttitle);
//            Assert.assertTrue(producttitle.contains("Polo"));
		}
	}

}
