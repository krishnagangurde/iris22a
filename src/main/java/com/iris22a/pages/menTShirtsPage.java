package com.iris22a.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.iris22a.keyword.UIKeywords;

public class menTShirtsPage {
	@FindBy(xpath = "//div[@class=\"sort-sortBy\"]")
	public WebElement sortByFilter;
//	public WebElement countryOrigin;
	@FindBy(xpath = "//label[contains(text(),'Popularity')]" )
	public WebElement popularityFilter;

//	public menTShirtsPage() {
//		sortByFilter=UIKeywords.driver.findElement(By.xpath("//div[@class=\"sort-sortBy\"]"));
//		popularityFilter=UIKeywords.driver.findElement(By.xpath("//label[contains(text(),'Popularity')]"));
//		
//	}
	
	
	 public void selectPopularityFilter() {
		UIKeywords.mouseMove(sortByFilter);
		 UIKeywords.click(popularityFilter);

	}

}
