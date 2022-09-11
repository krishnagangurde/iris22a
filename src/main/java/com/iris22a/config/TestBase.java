package com.iris22a.config;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.iris22a.keyword.UIKeywords;
import com.iris22a.utils.Environment;

public class TestBase {
	public static final Logger log = Logger.getLogger(TestBase.class);

	@BeforeMethod
	public void setUp() throws Exception {
		String browserName = Environment.BROWSER;
		if (browserName == null || browserName.isEmpty()) {
			browserName = "Chrome";
		}
		if (browserName.isEmpty()) {
			browserName = "Chrome";
			log.info("\"Default browser is chrome\"");
		}

		UIKeywords.openBrowser(browserName);
		log.info(browserName + " is open ");

	}

	@AfterMethod
	public void tearDown() throws Exception {
		UIKeywords.closeBrowser();

	}

}
