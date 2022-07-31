package com.iris22a.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.iris22a.keyword.UIKeywords;

public class HomePage {
	@FindBy(xpath="//div[@class='desktop-navLink']/a[@href='/shop/men']")
	public WebElement menMenu;
	@FindBy(xpath="//a[@href=\"/men-tshirts\"]")
	public WebElement menTShirt;
	
	
	public HomePage() {
		PageFactory.initElements(UIKeywords.driver, this);
	}
	
//	public HomePage(){
//      menMenu=UIKeywords.driver.findElement(By.xpath("//div[@class='desktop-navLink']/a[@href='/shop/men']"));
//      menTShirt=UIKeywords.driver.findElement(By.xpath("//a[@href=\"/men-tshirts\"]"));
// }
	public void hoverOnMenMenu() {
      UIKeywords.mouseMove(menMenu);
	}
	public void clickOnmenTShirt() {
		UIKeywords.click(menTShirt);

	}

}
