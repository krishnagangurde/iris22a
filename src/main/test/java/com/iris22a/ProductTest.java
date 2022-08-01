package com.iris22a;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.iris22a.config.TestBase;
import com.iris22a.keyword.UIKeywords;
import com.iris22a.utils.Environment;
import com.iris22a.utils.PropUtils;

public class ProductTest extends TestBase {
	@Test
	public static void verifySerchResultForPoloMen() {

		PropUtils repo = new PropUtils();
		UIKeywords.launchUrl(Environment.URL);

		UIKeywords.enterText(repo.getLocator("search_txt_bx")[0], repo.getLocator("search_txt_bx")[1], "polo men");

		UIKeywords.hitButton(KeyEvent.VK_ENTER);

		List<String> productTitles = UIKeywords.getTexts(repo.getLocator("product_title_txt")[0],
				repo.getLocator("product_title_txt")[1]);

		for (String producttitle : productTitles) {
			Assert.assertTrue(producttitle.contains("Polo"),
					" product title  doesnt contain polo men it contains:- " + producttitle);
		}

	}

	@Test
	public void verifyCategryListForTopwear() {
		List<String> expected = new ArrayList<String>();
		expected.add("Tshirts");
		expected.add("Shirts");
		expected.add("Kurtas");
		expected.add("Sweatshirts");
		expected.add("Jackets");
		expected.add("Sweaters");
		expected.add("Blazers");


		PropUtils repo = new PropUtils();
		UIKeywords.launchUrl(Environment.URL);
		UIKeywords.mouseMove(repo.getLocator("men_menu")[0], repo.getLocator("men_menu")[1]);
		UIKeywords.click(repo.getLocator("topwear_menu")[0], repo.getLocator("topwear_menu")[1]);
		List<String> actualcategory = UIKeywords.getTexts(repo.getLocator("category_text")[0],
				repo.getLocator("category_text")[1]);
		for (int i = 0; i < actualcategory.size(); i++) {
			actualcategory.set(i, actualcategory.get(i).split("\\(")[0]);
		}
		System.out.println("List of category" + actualcategory);

		Assert.assertTrue(actualcategory.containsAll(expected), "List of Categaory is not matching" + actualcategory);

		UIKeywords.launchUrl("https://www.myntra.com/");

		UIKeywords.enterText(By.xpath("//input[@placeholder='Search for products, brands and more']"), "polo men");

		UIKeywords.hitButton(KeyEvent.VK_ENTER);

		List<String> productTitles = UIKeywords.getTexts(By.xpath("//h3[@class='product-brand']"));

		for (String producttitle : productTitles) {
			Assert.assertTrue(producttitle.contains("Polo"), " product title  doesnt contain polo men " + producttitle);
		}
	}

}
