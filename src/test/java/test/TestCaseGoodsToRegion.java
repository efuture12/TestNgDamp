package test;

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

public class TestCaseGoodsToRegion {

	private WebDriver dr;
	private StringBuffer verificationErrors = new StringBuffer();

	@BeforeClass(alwaysRun = true)
	public void Setup() {
		dr = WebDriverInsFactory.getBrowser("Firefox");

	}

	@Test
	public void goodsToRegion() throws InterruptedException {
		/** 商品资料生成商城数据 **/

		dr.switchTo().defaultContent();
		Actions builder = new Actions(dr);
		System.out.println("开始发布区域");
		WebElement omdmain = dr.findElement(By
				.xpath("//ul[contains(@class,'has-transitions')]/li[3]/a"));
		builder.moveToElement(omdmain).perform();
		dr.findElement(By.xpath("//a[text()[contains(.,'商城商品维护')]]")).click();
		Thread.sleep(3000);
		dr.switchTo().frame(
				dr.findElement(By
						.xpath("/html/body/div[2]/ul/li[2]/div/iframe")));
		WebDriverWait wait = new WebDriverWait(dr, 30);
		wait.until(
				ExpectedConditions.elementToBeClickable(By
						.xpath("//span[text()[contains(.,'查询')]]"))).click();
		Thread.sleep(7000);
		System.out.println("开始点击checkbook");
		int pageNum = getPageMaxNum(dr);
		System.out.println("getPageMaxNum:" + pageNum);
		int pageNow = 1;
		while (pageNow <= pageNum) {
			System.out.println("getPageMaxNum1:" + pageNow);
			checkall(dr, pageNow);
			dr.findElement(
					By.xpath("//span[contains(@class,'mini-pager-next')]"))
					.click();
			Thread.sleep(3000);
			pageNow++;
			System.out.println("getPageMaxNum2:" + pageNow);
		}
	
	}

	// 得到商品页数
	public int getPageMaxNum(WebDriver dr) throws InterruptedException {
		int pageNum = 0;
		String pageNumText = dr.findElement(
				By.xpath("//span[contains(@class,'mini-pager-pages')]"))
				.getText();
		System.out.println("pageNumText3" + pageNumText);
		String pageNumString = pageNumText.substring(2);
		System.out.println("pageNumText3" + pageNumString);
		pageNum = Integer.parseInt(pageNumString);
		return pageNum;
	}

	// 全选后生成商城数据
	public void checkall(WebDriver dr, int pageIndex)
			throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(dr, 30);
		wait.until(
				ExpectedConditions.elementToBeClickable(By
						.xpath("//div[contains(@class,'mini-fit')]/div/div/div[2]/div[2]/div[2]/table/tbody/tr[2]/td[2]/div[1]/div[1]/input")))
				.click();
		 
		WebElement pageNum = dr
				.findElement(By
						.xpath("//div[contains(@class,'mini-fit')]/div/div/div[2]/div[2]/div[2]/table/tbody/tr[2]/td[2]/div[1]/div[1]/input"));
		if (pageIndex != 1) {
			pageNum.click();
		}
		wait = new WebDriverWait(dr, 30);
		wait.until(
				ExpectedConditions.elementToBeClickable(By
						.xpath("//span[text()[contains(.,'发布到所有销售区域')]]")))
				.click();
		 
		// 选择商城
		Thread.sleep(3000);
		System.out.println("选框架start！");
		// wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("/html/body/div[4]/div/div[2]/div[2]/iframe")));
		waitMyElement(By.xpath("/html/body/div[4]/div/div[2]/div[2]/iframe"),
				dr);
		dr.switchTo().frame(
				dr.findElement(By
						.xpath("/html/body/div[4]/div/div[2]/div[2]/iframe")));
		System.out.println("选框架end！");
		wait = new WebDriverWait(dr, 60);
		wait.until(
				ExpectedConditions.elementToBeClickable(By
						.xpath("//input[contains(@class,'mini-tree-checkbox')]")))
				.click();
		wait = new WebDriverWait(dr, 60);
		wait.until(
				ExpectedConditions.elementToBeClickable(By
						.xpath("//span[text()[contains(.,'确定')]]"))).click();
		Thread.sleep(4000);
		dr.switchTo().defaultContent();
		// wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//li[contains(@class,'active')]/div/iframe")));
		waitMyElement(By.xpath("//li[contains(@class,'active')]/div/iframe"),
				dr);
		dr.switchTo().frame(
				dr.findElement(By
						.xpath("//li[contains(@class,'active')]/div/iframe")));
		wait = new WebDriverWait(dr, 60);
		wait.until(
				ExpectedConditions.elementToBeClickable(By
						.xpath("//div[contains(@class,'mini-messagebox-buttons')]/a")))
				.click();
		Thread.sleep(1000);
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		// dr.quit();
		dr.switchTo().defaultContent();
		WebElement closetab = dr.findElement(By
				.xpath("//em[contains(@class,'closetab')]"));
		closetab.click();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			Assert.fail(verificationErrorString);
		}
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
}
