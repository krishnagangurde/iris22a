package com.iris22a.kidtests;

import java.util.Iterator;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.iris22a.config.TestBase;
import com.iris22a.keyword.UIKeywords;
import com.iris22a.pages.kids.KIdsPage;
import com.iris22a.pages.kids.KidsDropDownPage;
import com.iris22a.utils.Environment;

public class KidsProducts extends TestBase {
	@Test(enabled = true)
	public void verifyIfAllLinksHaveTexts() {
		int linksWithText=0;
		int totalLinks=0;
		UIKeywords.launchUrl(Environment.URL);
		KidsDropDownPage kids = new KidsDropDownPage();
		KIdsPage kid = new KIdsPage();
		kids.clickOnKidsTab();
		List<String> linksText = kid.listOfAllLinksOnKidsPage();
		totalLinks = linksText.size();
		System.out.println("Links which has texts are as follows");
		Iterator<String> itr = linksText.iterator();
		while(itr.hasNext()) {
			String text = itr.next();
			if(text!="") {
			System.out.println(text);
			linksWithText++;}
		}
		System.out.println("Number of links having texts are :"+linksWithText);
		System.out.println("Number of links not having texts are :"+(totalLinks-linksWithText));
		System.out.println("Total number of links are :"+totalLinks);
		Assert.assertTrue(linksWithText==totalLinks, "Not all links have a text");
	}

}
