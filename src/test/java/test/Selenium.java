package test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import com.thoughtworks.selenium.DefaultSelenium;  
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import org.testng.annotations.*;

import static org.testng.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Selenium {
	private WebDriver dr;
	private StringBuffer verificationErrors = new StringBuffer();
	String urlHost="";
	@BeforeClass(alwaysRun = true)
	public void Setup() throws InterruptedException {
		String url;
		dr = WebDriverInsFactory.getBrowser("Firefox");
		urlHost=Config.HOST;
	    url=urlHost+"amp-ui-business/portal/index.html#login";
		dr.get(url); 
		dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void logIn() throws InterruptedException {
		System.out.println("1111");
		WebElement userName = dr.findElement(By.id("nameInput"));
		System.out.println("222");
		userName.sendKeys(sendKeyString("yztTest"));
		System.out.println("333");
		WebElement userPassWord = dr.findElement(By.id("password"));
		userPassWord.sendKeys(sendKeyString("111111"));
		WebElement login = dr.findElement(By.id("cn"));
		login.click();
		dr.manage().window().maximize(); // 鏈�ぇ鍖�
		dr.close();
	}
	 
	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		//dr.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			Assert.fail(verificationErrorString);
		}
	}

	public static CharSequence[] sendKeyString(String sendKeyString) {
		List<String> keyList = Arrays.asList(sendKeyString);
		CharSequence[] sendKeyChars = keyList.toArray(new CharSequence[1]);
		return sendKeyChars;

	}


	public static void MouseHoverByJavaScript2(WebElement targetElement,
			WebDriver dr) {
		JavascriptExecutor js = (JavascriptExecutor) dr;
		String myjs = "document.getElementsByClassName('(//a[@id='undefined'])[29]').click();";
		js.executeScript(myjs);
	}

	public static void MouseHoverByJavaScript(WebElement targetElement,
			WebDriver dr) {

		String mouseHoverjs = "var evObj = document.createEvent('MouseEvents');"
				+ "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
				+ "arguments[0].dispatchEvent(evObj);";
		JavascriptExecutor js = (JavascriptExecutor) dr;
		js.executeScript(mouseHoverjs, targetElement);
	}

 
	public void waitMyElement(By by, WebDriver driver) {
		System.out.println("aaa");
		for (int second = 0;; second++) {
			if (second >= 60)
				System.out.println("bbb");
				Assert.fail("timeout");
			try {
				if (driver.findElement(by).isDisplayed())
					break;
			} catch (Exception e) {
			}
		}

	}

	public WebElement waitAndGetElement(By by, WebDriver driver) {
		for (int second = 0;; second++) {
			if (second >= 60)
				Assert.fail("timeout");
			try {
				if (driver.findElement(by).isDisplayed()) {
					System.out.println("find!!!"
							+ driver.findElement(by).getText());
					return driver.findElement(by);
				}
			} catch (Exception e) {
			}
		}

	}

}
