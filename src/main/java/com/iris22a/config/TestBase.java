package com.iris22a.config;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.iris22a.keyword.UIKeywords;

public class TestBase {
	
	@Parameters("browserName")
	@BeforeMethod
	public void setUp(@ Optional String browserName) throws Exception {
		if (browserName==null || browserName.isEmpty()) {
			browserName="Chrome";
		}
		UIKeywords.openBrowser(browserName);
		
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		UIKeywords.closeBrowser();
		
	}
	


}
