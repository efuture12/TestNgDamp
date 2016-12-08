package test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCaseOgnization {
	private WebDriver dr;
	private StringBuffer verificationErrors = new StringBuffer();

	@BeforeClass(alwaysRun = true)
	public void Setup() {
		dr = WebDriverInsFactory.getBrowser("Firefox");

	}

	@Test
	public void setShop() throws InterruptedException {

		System.out.println("开始设置商城222");
		WebElement omdmain = dr.findElement(By
				.xpath("//ul[contains(@class,'has-transitions')]/li[3]/a"));
		omdmain.click();
		Actions builder = new Actions(dr);
		builder.moveToElement(omdmain).perform();
		dr.findElement(By.xpath("//a[text()[contains(.,'组织机构定义')]]")).click();
		System.out.println("开始点击机构数");
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(dr, 60);
		System.out.println("开始等待框架");
		// wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("/html/body/div[2]/ul/li[2]/div/iframe")));
		dr.switchTo().frame(
				dr.findElement(By
						.xpath("/html/body/div[2]/ul/li[2]/div/iframe")));
		System.out.println("开始点击全部机构");
		wait = new WebDriverWait(dr, 60);
		wait.until(
				ExpectedConditions.elementToBeClickable(By
						.xpath("//span[text()[contains(.,'全部组织')]]"))).click();
		wait = new WebDriverWait(dr, 30);
		wait.until(
				ExpectedConditions.elementToBeClickable(By
						.xpath("//div[contains(@class,'mini-toolbar')]/div[2]/span/a[2]")))
				.click();
		Thread.sleep(3000);
		// 键入机构编码
		wait = new WebDriverWait(dr, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("/html/body/div[2]/div/div[1]/div[2]/div/div/div/div/div[2]/table/tbody/tr[1]/td[1]/div/table/tbody/tr/td[2]/span/span[1]/input")));
		WebElement ognizationCode = dr
				.findElement(By
						.xpath("/html/body/div[2]/div/div[1]/div[2]/div/div/div/div/div[2]/table/tbody/tr[1]/td[1]/div/table/tbody/tr/td[2]/span/span[1]/input"));
		ognizationCode.sendKeys(sendKeyString("B011"));
		// 键入机构名称
		wait = new WebDriverWait(dr, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("/html/body/div[2]/div/div[1]/div[2]/div/div/div/div/div[2]/table/tbody/tr[1]/td[2]//div/table/tbody/tr/td[2]/span/span[1]/input")));
		WebElement ognizationName = dr
				.findElement(By
						.xpath("/html/body/div[2]/div/div[1]/div[2]/div/div/div/div/div[2]/table/tbody/tr[1]/td[2]//div/table/tbody/tr/td[2]/span/span[1]/input"));
		ognizationName.sendKeys(sendKeyString("自动化测试商城"));
		// 选择商城
		wait = new WebDriverWait(dr, 30);
		wait.until(
				ExpectedConditions.elementToBeClickable(By
						.xpath("/html/body/div[2]/div/div[1]/div[2]/div/div/div/div/div[2]/table/tbody/tr[2]/td[2]/div/table/tbody/tr/td[2]/span/span/span/span[2]/span")))
				.click();
		wait = new WebDriverWait(dr, 30);
		wait.until(
				ExpectedConditions.elementToBeClickable(By
						.xpath("//table[contains(@class,'mini-listbox-items')]/tbody/tr[2]")))
				.click();
		wait = new WebDriverWait(dr, 30);
		wait.until(
				ExpectedConditions.elementToBeClickable(By
						.xpath("//input[contains(@class,'mini-checkbox-check')]")))
				.click();
		wait = new WebDriverWait(dr, 30);
		wait.until(
				ExpectedConditions.elementToBeClickable(By
						.xpath("//span[text()[contains(.,'保存')]]"))).click();
		Thread.sleep(3000);
		dr.switchTo().defaultContent();

	}

	@Test(dependsOnMethods = { "setShop" })
	public void setRegion() throws InterruptedException {
		dr.switchTo().frame(
				dr.findElement(By
						.xpath("/html/body/div[2]/ul/li[2]/div/iframe")));
		System.out.println("设置区域");
		dr.findElement(
				By.xpath("//div[contains(@class,'mini-tree-nodes')]/table/tbody/tr[12]/td[2]/div/div/span[3]"))
				.click();
		;

		WebDriverWait wait = new WebDriverWait(dr, 30);
		wait.until(
				ExpectedConditions.elementToBeClickable(By
						.xpath("//div[contains(@class,'mini-toolbar')]/div[2]/span/a[2]")))
				.click();
		Thread.sleep(3000);
		// 键入机构编码
		wait = new WebDriverWait(dr, 60);
		wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("/html/body/div[2]/div/div[1]/div[2]/div/div/div/div/div[2]/table/tbody/tr[1]/td[1]/div/table/tbody/tr/td[2]/span/span[1]/input")));
		WebElement ognizationCode = dr
				.findElement(By
						.xpath("/html/body/div[2]/div/div[1]/div[2]/div/div/div/div/div[2]/table/tbody/tr[1]/td[1]/div/table/tbody/tr/td[2]/span/span[1]/input"));
		ognizationCode.sendKeys(sendKeyString("C001"));
		// 键入机构名称
		WebElement ognizationName = dr
				.findElement(By
						.xpath("/html/body/div[2]/div/div[1]/div[2]/div/div/div/div/div[2]/table/tbody/tr[1]/td[2]//div/table/tbody/tr/td[2]/span/span[1]/input"));
		// ognizationName.click();
		ognizationName.sendKeys(sendKeyString("自动化测试区域"));
		// 选择商城
		WebElement ognizationType = dr
				.findElement(By
						.xpath("/html/body/div[2]/div/div[1]/div[2]/div/div/div/div/div[2]/table/tbody/tr[2]/td[2]/div/table/tbody/tr/td[2]/span/span[1]/span"));
		ognizationType.click();
		WebElement ognizationShopShoose = dr
				.findElement(By
						.xpath("//table[contains(@class,'mini-listbox-items')]/tbody/tr[7]"));
		ognizationShopShoose.click();
		wait = new WebDriverWait(dr, 30);
		wait.until(
				ExpectedConditions.elementToBeClickable(By
						.xpath("//input[contains(@class,'mini-checkbox-check')]")))
				.click();
		WebElement ognizationShopSave = dr.findElement(By
				.xpath("//span[text()[contains(.,'保存')]]"));
		ognizationShopSave.click();

		Thread.sleep(3000);
		dr.switchTo().defaultContent();
		WebElement closetab = dr.findElement(By
				.xpath("//em[contains(@class,'closetab')]"));
		closetab.click();
	}

	public static CharSequence[] sendKeyString(String sendKeyString) {
		List<String> keyList = Arrays.asList(sendKeyString);
		CharSequence[] sendKeyChars = keyList.toArray(new CharSequence[1]);
		return sendKeyChars;

	}

	public void waitMyElement(By by, WebDriver driver) {
		for (int second = 0;; second++) {
			System.out.println("*******************开始  查找元素111");
			if (second >= 60)
				fail("timeout");
			try {
				System.out.println("*******************开始  查找元素222");
				if (driver.findElement(by).isDisplayed())
					break;
			} catch (Exception e) {
			}
		}

	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		// dr.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			Assert.fail(verificationErrorString);
		}
	}
}
