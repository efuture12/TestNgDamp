package test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCaseCategory {

	private WebDriver dr;
	private StringBuffer verificationErrors = new StringBuffer();

	@BeforeClass(alwaysRun = true)
	public void Setup() {
		dr = WebDriverInsFactory.getBrowser("Firefox");

	}

	@Test
	public void catoryNumCheck() throws InterruptedException {

		/** 品类条目数验证 **/
		dr.switchTo().defaultContent();
		System.out.println("开始找主数据2");
		WebElement omdmain = dr.findElement(By
				.xpath("//ul[contains(@class,'has-transitions')]/li[3]/a"));
		omdmain.click();
		Actions builder = new Actions(dr);
		builder.moveToElement(omdmain).perform();
		dr.findElement(By.xpath("//a[text()[contains(.,'接收品类查询')]]")).click();
		Thread.sleep(3000);
		dr.switchTo().frame(
				dr.findElement(By
						.xpath("/html/body/div[2]/ul/li[2]/div/iframe")));

		WebDriverWait wait = new WebDriverWait(dr, 30);
		wait.until(
				ExpectedConditions.elementToBeClickable(By
						.xpath("//span[text()[contains(.,'查询')]]"))).click();
		System.out.println("开始找确定按钮2");
		wait = new WebDriverWait(dr, 30);
		wait.until(
				ExpectedConditions.elementToBeClickable(By
						.xpath("//span[text()[contains(.,'确定')]]"))).click();

		/*
		 * waitMyElement(By.xpath("//span[text()[contains(.,'确定')]]"), dr);
		 * WebElement categoryMakesure1 = dr.findElement(By
		 * .xpath("//span[text()[contains(.,'确定')]]"));
		 * categoryMakesure1.click();
		 */
		System.out.println("开始设置页面条数2");
		wait = new WebDriverWait(dr, 30);
		wait.until(
				ExpectedConditions.elementToBeClickable(By
						.xpath("//span[contains(@class,'mini-pager-size')][2]/span[1]/span/span/span[2]")))
				.click();

		System.out.println("开始点击页面条数2");

		wait = new WebDriverWait(dr, 30);
		wait.until(
				ExpectedConditions.elementToBeClickable(By
						.xpath("//div[contains(@class,'mini-popup')]/div/div[1]/div[2]/div/table/tbody/tr[3]")))
				.click();
		Thread.sleep(3000);
		wait = new WebDriverWait(dr, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//div[contains(@class,'mini-pager-right')]")));
		WebElement categoryRight = dr.findElement(By
				.xpath("//div[contains(@class,'mini-pager-right')]"));
		System.out.println("categoryRight####"+categoryRight.getText()+"###");
		Assert.assertEquals(categoryRight.getText(),"每页 50 条,共 0 条");
		
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		// dr.quit();
		Thread.sleep(1000);
		dr.switchTo().defaultContent();
		WebElement categoryClosetab = dr.findElement(By
				.xpath("//em[contains(@class,'closetab')]"));
		categoryClosetab.click();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			Assert.fail(verificationErrorString);
		}
	}

}
