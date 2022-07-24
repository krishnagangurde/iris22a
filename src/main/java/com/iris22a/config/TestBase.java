package com.iris22a.config;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;

import com.iris22a.keyword.UIKeywords;

public class TestBase {
	@BeforeMethod
	public void setUp(@ Optional String browserName) throws Exception {
		if (browserName==null) {
			browserName="Chrome";
		}
		if (browserName.isEmpty()) {
			browserName="Chrome";
			System.out.println("Default browser is chrome");
		}
		
		UIKeywords.openBrowser(browserName);
		
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		UIKeywords.closeBrowser();
		
	}
	


}
