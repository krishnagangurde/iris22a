package com.iris22a.keyword;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UIKeywords {
	public static RemoteWebDriver driver;

	public static void openBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("Ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}

	}

	public static void launchUrl(String url) {
		driver.get(url);
		System.out.println("url is launched " + url);

	}

	public static void closeBrowser() {
		driver.close();
		System.out.println("url is closed succefully");
	}

	public static void switchWindow(String bytitle) {
		String ParentWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		String title = driver.getTitle();
		for (String window : windows) {
			if (driver.switchTo().window(window).getTitle().equals(bytitle)) {
				System.out.println("switch on window " + bytitle);
				break;
			}
		}

	}

	public static void enterText(By element, String text) {
		driver.findElement(element).sendKeys(text);
		System.out.println(text + ": text enter in serch box ");

	}
	
	public static void hitButton(int keyvalue)    {
		Robot robo;
		try {
			robo = new Robot();
			robo.keyPress(keyvalue);
			robo.keyRelease(keyvalue);


		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Enter button has press ");
	}

	public static List<String> getTexts(By element) {
		List<WebElement>elements = driver.findElements(element);
		List<String> texts=new ArrayList<String>();
		for(WebElement elemnt:elements) {
			texts.add(elemnt.getText());
		}
		return texts;
		
		       
		
		
	}
	
	
	
}

