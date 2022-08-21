package com.iris22a.keyword;

import java.awt.AWTException;
import java.awt.Robot;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UIKeywords {
	public static final Logger log = Logger.getLogger(UIKeywords.class);
	public static RemoteWebDriver driver;

	public static void openBrowser(String browserName) {

		if (browserName.equalsIgnoreCase("Chrome")) {
			ChromeOptions option = new ChromeOptions();
			option.addArguments("−−incognito");
			option.addArguments("start-maximized");
//			option.addArguments("–disable-notifications");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(option);
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
		log.info("url is launched " + url);

	}

	public static void closeBrowser() {
		driver.close();
		log.info("url is closed succefully");
	}

	public static void switchWindow(String bytitle) {
		Set<String> windows = driver.getWindowHandles();
		for (String window : windows) {
			if (driver.switchTo().window(window).getTitle().equals(bytitle)) {
				log.info("switch on window " + bytitle);
				break;
			}
		}

	}

	public static void hitButton(int keyvalue) {

		Robot robo;
		try {
			robo = new Robot();
			robo.keyPress(keyvalue);
			robo.keyRelease(keyvalue);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("Enter button has press ");
	}

	public static List<String> getTexts(By element) {
		List<WebElement> elements = driver.findElements(element);
		List<String> texts = new ArrayList<String>();
		for (WebElement elemnt : elements) {
			texts.add(elemnt.getText());
		}
		return texts;

	}

	public static void mouseMove(By xpath) {
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(xpath)).build().perform();
		;

	}

	public static void click(By xpath) {
		driver.findElement(xpath).click();
	}

	public static void click(String locatortype, String locatorvalue) {
		getWebElement(locatortype, locatorvalue).click();
	}

	public static WebElement getWebElement(String locatortype, String locatorvalue) {
		WebElement element = null;
		if (locatortype.equalsIgnoreCase("xpath")) {
			element = driver.findElement(By.xpath(locatorvalue));
		} else if (locatortype.equalsIgnoreCase("id")) {
			element = driver.findElement(By.id(locatorvalue));
		} else if (locatortype.equalsIgnoreCase("cssSelector")) {
			element = driver.findElement(By.cssSelector(locatorvalue));
		} else if (locatortype.equalsIgnoreCase("linkText")) {
			element = driver.findElement(By.linkText(locatorvalue));
		} else if (locatortype.equalsIgnoreCase("partialLinkText")) {
			element = driver.findElement(By.partialLinkText(locatorvalue));
		} else if (locatortype.equalsIgnoreCase("className")) {
			element = driver.findElement(By.className(locatorvalue));
		} else if (locatortype.equalsIgnoreCase("tagName")) {
			element = driver.findElement(By.tagName(locatorvalue));
		} else if (locatortype.equalsIgnoreCase("name")) {
			element = driver.findElement(By.name(locatorvalue));

		}
		return element;
	}

	public static List<WebElement> getWebElements(String locatortype, String locatorvalue) {
		List<WebElement> elements = new ArrayList<WebElement>();
		if (locatortype.equalsIgnoreCase("xpath")) {
			elements = driver.findElements(By.xpath(locatorvalue));
		} else if (locatortype.equalsIgnoreCase("id")) {
			elements = driver.findElements(By.id(locatorvalue));
		} else if (locatortype.equalsIgnoreCase("cssSelector")) {
			elements = driver.findElements(By.cssSelector(locatorvalue));
		} else if (locatortype.equalsIgnoreCase("linkText")) {
			elements = driver.findElements(By.linkText(locatorvalue));
		} else if (locatortype.equalsIgnoreCase("partialLinkText")) {
			elements = driver.findElements(By.partialLinkText(locatorvalue));
		} else if (locatortype.equalsIgnoreCase("className")) {
			elements = driver.findElements(By.className(locatorvalue));
		} else if (locatortype.equalsIgnoreCase("tagName")) {
			elements = driver.findElements(By.tagName(locatorvalue));
		} else if (locatortype.equalsIgnoreCase("name")) {
			elements = driver.findElements(By.name(locatorvalue));

		}
		return elements;

	}

	public static void mouseMove(String locatortype, String locatorvalue) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(locatortype, locatorvalue)).perform();

	}

	public static List<String> getTexts(String locatortype, String locatorvalue) {
		List<WebElement> elements = getWebElements(locatortype, locatorvalue);
		List<String> texts = new ArrayList<String>();
		for (WebElement elemnt : elements) {
			texts.add(elemnt.getText());
		}
		return texts;
	}

	public static void enterText(String locatortype, String locatorvalue, String text) {
	getWebElement(locatortype, locatorvalue).sendKeys(text);
	}

	public static void mouseMove(WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();

	}

	public static void click(WebElement element) {
		element.click();

	}

	public static RemoteWebDriver getDriver() {
		return driver;
	}

	public static void enterText(WebElement element, String productname) {
		element.sendKeys(productname);

	}

	public static void enterText(By element, String text) {
		driver.findElement(element).sendKeys(text);

	}
	public static List<String> getTexts(List<WebElement> element) {
		List<String> texts = new ArrayList<String>();
		for (WebElement ele : element) {
			texts.add(ele.getText());
		}
		return texts;

	}

	public static String checkBrokenLink(String linkUrl) {
		String brokenLink = null;
		try {
			URL url = new URL(linkUrl);
			HttpURLConnection httpUrlConnection = (HttpURLConnection) url.openConnection();
			httpUrlConnection.setConnectTimeout(5000);
			httpUrlConnection.connect();
			
			if (httpUrlConnection.getResponseCode()>=400) {
				System.out.println(linkUrl+"===========>"+httpUrlConnection.getResponseMessage()+" a broken link");
				brokenLink = linkUrl;
			}else {
				System.out.println(linkUrl+"===========>"+httpUrlConnection.getResponseMessage());
			}
		} catch (Exception e) {
			
		}
		return brokenLink;
	}
	

}
