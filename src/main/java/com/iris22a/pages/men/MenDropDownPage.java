package com.iris22a.pages.men;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.iris22a.keyword.UIKeywords;
public class MenDropDownPage{

	public static final Logger LOG = Logger.getLogger(MenDropDownPage.class);

	 public MenDropDownPage() {
         PageFactory.initElements(UIKeywords.driver, this);	
         }
   
	@FindBy(css="div[data-reactid=\"19\"]")
      public WebElement MenMenu; 
	 
	@FindBy(xpath="a[data-reactid=\"29\"]")
	  public WebElement Topwear; 
	

	@FindBy(xpath="//a[contains(text(),\"Formal Shirts\")]")
	public WebElement FormalShirts;
	
	
	
	
     public void hoverOnMenMenu() {
		UIKeywords.mouseMove(MenMenu);
	}
      public void clickOnMenMenu() {
         UIKeywords.click(MenMenu);
	
    }
      public void mouseMoveonMenMenu() {
     UIKeywords.mouseMove(MenMenu);
	}
	public void clickonTopwear() {
		UIKeywords.click(Topwear);
	}
	public void clickonFormalShirts() { 
		UIKeywords.click(FormalShirts);
	
	LOG.info("Clicked on FormalShirt");
	
	}
	
	
     public By itemCount=By.xpath("//span[@class=\"title-count\"]");
        public int  getItemCount() {
		String itemCount=UIKeywords.driver.findElement(this.itemCount).getText();
     	Pattern p=Pattern.compile("//d");
		Matcher m=p.matcher(itemCount);
		String count = m.group();
		return Integer.parseInt(itemCount); 
	 }
	
	
}
	

