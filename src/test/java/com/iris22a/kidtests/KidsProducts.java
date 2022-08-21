package com.iris22a.kidtests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.iris22a.config.TestBase;
import com.iris22a.keyword.UIKeywords;
import com.iris22a.pages.kids.KidsPage;
import com.iris22a.pages.kids.KidsDropDownPage;
import com.iris22a.pages.kids.KidsPage;
import com.iris22a.utils.Environment;

public class KidsProducts extends TestBase {
	@Test(enabled = true)
	public void verifyIfAllLinksHaveTexts() {
		int linksWithText = 0;
		int totalLinks = 0;
		UIKeywords.launchUrl(Environment.URL);
		KidsDropDownPage kids = new KidsDropDownPage();
		KidsPage kid = new KidsPage();
		kids.clickOnKidsTab();
		List<String> linksText = kid.listOfAllLinksOnKidsPage();
		totalLinks = linksText.size();
		System.out.println("Links which has texts are as follows");
		Iterator<String> itr = linksText.iterator();
		while (itr.hasNext()) {
			String text = itr.next();
			if (text != "") {
				System.out.println(text);
				linksWithText++;
			}
		}
		System.out.println("Number of links having texts are :" + linksWithText);
		System.out.println("Number of links not having texts are :" + (totalLinks - linksWithText));
		System.out.println("Total number of links are :" + totalLinks);
		Assert.assertTrue(linksWithText == totalLinks, "Not all links have a text");
	}

	@Test
	public void checkBrokenUrls() {
		UIKeywords.launchUrl(Environment.URL);
		KidsPage kid = new KidsPage();
		List<WebElement> links = kid.allLinksOnKidsPage;
		List<String> brokenLinks = new ArrayList<String>();
		for (WebElement element : links) {
			String link = element.getAttribute("href");
			String brokenLink = UIKeywords.checkBrokenLink(link);
			brokenLinks.add(brokenLink);
		}
		Assert.assertTrue(!brokenLinks.isEmpty(),
				"there are " + brokenLinks.size() + " number of broken links on the kids page");
	}

	public static void checkKidsProductsForPolo() {

	}
}
