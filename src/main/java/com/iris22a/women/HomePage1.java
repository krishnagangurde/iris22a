package com.iris22a.women;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.iris22a.keyword.UIKeywords;

public class HomePage1 {
	@FindBy(css = "a[href='/shop/women']:nth-child(1)")
	public WebElement womenMenu;
	@FindBy(css = "a[href='/fusion-wear']")
	public WebElement indianfusionwear;
	@FindBy(css = "input[placeholder=\"Search for products, brands and more\"]")
	public WebElement searchKurta;
	@FindBy(css = "h4.product-product")
	public List<WebElement> kurtaList;

	public HomePage1() {
		PageFactory.initElements(UIKeywords.driver, this);
	}

	public void hoverOnWomenMenu() {
		UIKeywords.mouseMove(womenMenu);

	}

	public void clickOnindianfusionwear() {
		UIKeywords.click(indianfusionwear);
	}

	public void searchforkurta(String productname) {
		UIKeywords.enterText(searchKurta, productname);
		UIKeywords.hitButton(KeyEvent.VK_ENTER);

	}

	public List<String> getKurtaList() {
		List<String> kurtaList = new ArrayList<String>();
		for (WebElement itemkurta : this.kurtaList) {
			kurtaList.add(itemkurta.getText());

		}

		return kurtaList;

	}

}
