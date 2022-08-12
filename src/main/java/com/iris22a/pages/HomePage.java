package com.iris22a.pages;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.iris22a.keyword.UIKeywords;

public class HomePage {
	public static final Logger log = Logger.getLogger(HomePage.class);
	@FindBy(xpath = "//div[@class='desktop-navLink']/a[@href='/shop/men']")
	public WebElement menMenu;
	
	@FindBy(xpath = "//a[@href=\"/men-tshirts\"]")
	public WebElement menTShirt;

	@FindBy(css = "input[placeholder='Search for products, brands and more']")
	public WebElement searchPolotext;

	@FindBy(css = "h3.product-brand")
	public List<WebElement> productText;
	
   @FindBy(xpath="//a[contains(text(),\"Formal Shirts\")]")
	public WebElement menFormalShirts;

	public HomePage() {
		PageFactory.initElements(UIKeywords.driver, this);
	}

//	public HomePage(){
//      menMenu=UIKeywords.driver.findElement(By.xpath("//div[@class='desktop-navLink']/a[@href='/shop/men']"));
//      menTShirt=UIKeywords.driver.findElement(By.xpath("//a[@href=\"/men-tshirts\"]"));
// }
	public void hoverOnMenMenu() {
		UIKeywords.mouseMove(menMenu);
		log.info("mouse move to men menu");

	}
  
	public void clickOnmenTShirt() {
		UIKeywords.click(menTShirt);
		log.info("click om menTshirt");

	}

	
	public void searchForPoloText(String productname) {
		UIKeywords.enterText(searchPolotext, productname);
		UIKeywords.hitButton(KeyEvent.VK_ENTER);

	}

	public List<String> getSearchResultText() {
		List<String> productText = new ArrayList<String>();
		for (WebElement product : this.productText) {
			productText.add(product.getText());
		}

		return productText;

	}

	public void clickOnmenFormalShirts() {
		UIKeywords.click(menFormalShirts);
		log.info("click om menFormalshirts");

	}

}
