	package com.iris22a.utils;
    import java.time.Duration;
    import org.openqa.selenium.By;
	import org.openqa.selenium.ElementClickInterceptedException;
	import org.openqa.selenium.NoSuchElementException;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.ui.ExpectedCondition;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.FluentWait;

import com.iris22a.keyword.UIKeywords;


	public class WaitFor {


	private static FluentWait<WebDriver> wait =null;
	static {
	   
		wait =new FluentWait<WebDriver>(UIKeywords.driver);
		wait.withTimeout(Duration.ofSeconds(30));
		wait.withMessage("wait is finished & element is not available");
	    wait.pollingEvery(Duration.ofMillis(5000));

	}



	public static void elementToBePresent(By locator) {
	wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	wait.ignoring(NoSuchElementException.class,ElementClickInterceptedException.class);



	}


	public static void elementToBePresent(String locatorType , String locatorValue) {
	//	wait.until(ExpectedConditions.presenceOfElementLocated((By) UIKeywords.getWebElement(locatorType ,locatorValue )));
		wait.ignoring(NoSuchElementException.class,ElementClickInterceptedException.class);


	}

	public static void elementToBeClickable(WebElement element) {
	wait.ignoring(NoSuchElementException.class);
	wait.until(ExpectedConditions.elementToBeClickable(element));

	}


	}
	