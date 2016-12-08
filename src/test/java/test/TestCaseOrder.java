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

public class TestCaseOrder {
	// private StringBuffer verificationErrors = new StringBuffer();
	private WebDriver dr;
	private StringBuffer verificationErrors = new StringBuffer();

	@BeforeClass(alwaysRun = true)
	public void Setup() {
		dr = WebDriverInsFactory.getBrowser("Firefox");

	}

	@Test
	public void orderNumCheck() throws InterruptedException {

		/** 商城条目数验证 **/
		dr.switchTo().defaultContent();
		System.out.println("开始找订单中心");
		WebElement OrderCenter = dr.findElement(By
				.xpath("//ul[contains(@class,'has-transitions')]/li[4]/a"));
		OrderCenter.click();
		Actions builder = new Actions(dr);
		builder.moveToElement(OrderCenter).perform();
		dr.findElement(By.xpath("//a[text()[contains(.,'订单查询')]]")).click();
		System.out.println("开始找查询按钮");
		Thread.sleep(3000);
		// dr.switchTo().frame(1);
		dr.switchTo().frame(
				dr.findElement(By
						.xpath("/html/body/div[2]/ul/li[2]/div/iframe")));

		WebDriverWait wait = new WebDriverWait(dr, 30);
		wait.until(
				ExpectedConditions.elementToBeClickable(By
						.xpath("//div[contains(@class,'ocm-tabfit')]/span[12]/span/span/span[2]")))
				.click();
		wait = new WebDriverWait(dr, 30);
		wait.until(
				ExpectedConditions.elementToBeClickable(By
						.xpath("//span[text()[contains(.,'清除')]]"))).click();
		wait = new WebDriverWait(dr, 30);
		wait.until(
				ExpectedConditions.elementToBeClickable(By
						.xpath("//div[contains(@class,'ocm-tabfit')]/span[13]/span/span/span[2]")))
				.click();
		wait = new WebDriverWait(dr, 30);
		wait.until(
				ExpectedConditions.elementToBeClickable(By
						.xpath("//span[text()[contains(.,'清除')]]"))).click();
		wait = new WebDriverWait(dr, 30);
		wait.until(
				ExpectedConditions.elementToBeClickable(By
						.xpath("//span[text()[contains(.,'查询')]]"))).click();
		System.out.println("开始设置页面条数");
		Thread.sleep(5000);
		wait = new WebDriverWait(dr, 30);
		wait.until(
				ExpectedConditions.elementToBeClickable(By
						.xpath("/html/body/div[1]/div[4]/div/div[1]/table/tbody/tr/td[1]/span[1]/span[1]/span/span/span[2]")))
				.click();
		System.out.println("开始点击页面条数");
		wait = new WebDriverWait(dr, 30);
		wait.until(
				ExpectedConditions.elementToBeClickable(By
						.xpath("//div[contains(@class,'mini-popup')]/div/div[1]/div[2]/div/table/tbody/tr[3]")))
				.click();
		Thread.sleep(3000);
		wait = new WebDriverWait(dr, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("/html/body/div[1]/div[4]/div/div[2]")));
		WebElement pageRight = dr.findElement(By
				.xpath("/html/body/div[1]/div[4]/div/div[2]"));
		System.out.println("#########"+pageRight.getText()+"#########");
		Assert.assertEquals(pageRight.getText(),"每页 50 条,共 5 条");
		

	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		// dr.quit();
		Thread.sleep(1000);
		dr.switchTo().defaultContent();
		WebElement closetab = dr.findElement(By
				.xpath("//em[contains(@class,'closetab')]"));
		closetab.click();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			Assert.fail(verificationErrorString);
		}
	}
}
