package com.iris22a;

import org.testng.annotations.Test;

import com.iris22a.config.TestBase;
import com.iris22a.keyword.UIKeywords;
import com.iris22a.pages.HomePage;
import com.iris22a.utils.Environment;


public class MenFormalShirtTest extends TestBase{
  UIKeywords keyword = new UIKeywords();

  @Test
public void verifySearchResultByPopularity(){
    UIKeywords.launchUrl(Environment.URL);
    
	 
       HomePage home = new HomePage();
		home.hoverOnMenMenu();
		home.clickOnmenFormalShirts();
	
}
}