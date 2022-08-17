package com.iris22a.mentests;
import java.util.ArrayList;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.iris22a.config.TestBase;
import com.iris22a.keyword.UIKeywords;
import com.iris22a.pages.men.MenDropDownPage;
import com.iris22a.utils.Environment;
import com.iris22a.utils.PropUtils;

public class MenProducts extends TestBase {

	@Test
	public  void VerifyIfHoveronMenTab() {

	UIKeywords.launchUrl(Environment.URL);
	MenDropDownPage men = new MenDropDownPage();
	
    // MenPage mp= new MenPage();
	  men.clickOnMenMenu();
	  }
	@Test
	public void VerifyselectonTopwear() {
	    	  List<String> expected= new ArrayList<String>();
	    	   expected.add("Tshirts");
	    	   expected.add("Shirts"); 
	    	   expected.add("Kurtas");
	    	   expected.add("Sweatshirts");
	    	   expected.add("Jacket");
	    	   expected.add("Sweater");
	    	   expected.add("Blazer");
	    	   PropUtils repo = new PropUtils();
	    	   UIKeywords.launchUrl(Environment.URL);
	    	   UIKeywords.mouseMove (repo.getLocator("men_menu")[0],repo.getLocator("men_menu")[1]);
	    	   UIKeywords.click(repo.getLocator("menu_topwear")[0],repo.getLocator("menu_topwear")[1]);
	    	   com.iris22a.utils.WaitFor.elementToBePresent(repo.getLocator("categories_list")[0],repo.getLocator("categories_list")[1]);
	          List<String> actualCategories = UIKeywords.getTexts(repo.getLocator("categories_list")[0],repo.getLocator("categories_list")[1]);
	    	 for(int i=0; i<actualCategories.size();i++){
	    		 actualCategories.set(i,actualCategories.get(i).split(" ")[0]);
	    	
	    	 }
	    	 
	          Assert.assertTrue(actualCategories.containsAll(expected),"List didnt match:expected: "+expected+"\n Actual:"+actualCategories); 
	    	   }
	      @Test
	      public void veryfyItemCountofFormalShirts() {
	    	   UIKeywords.launchUrl(Environment.URL);
		
	      
	    	   //HomePage  home =new HomePage();
	    	   MenDropDownPage formal = new MenDropDownPage();
	       formal.hoverOnMenMenu();
	       formal.clickonFormalShirts();
	     //  FormalShirtsPage formal = new FormalShirtsPage();
	       
	      int itemCount = formal.getItemCount();
	        System.out.println("itemCount");
	       }
	 
	}

