package test;

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

public class TestCaseItemBusiness {
	// private StringBuffer verificationErrors = new StringBuffer();

		private WebDriver dr;
		private StringBuffer verificationErrors = new StringBuffer();

		@BeforeClass(alwaysRun = true)
		public void Setup() {
			dr = WebDriverInsFactory.getBrowser("Firefox");

		}

		@Test
		public void ItemBusinessNumCheck() throws InterruptedException {

			/** 商城条目数验证 **/

			dr.switchTo().defaultContent();
			System.out.println("开始核对商品资料条目数");
			WebElement omdmain = dr.findElement(By
					.xpath("//ul[contains(@class,'has-transitions')]/li[3]/a"));
			omdmain.click();
			Actions builder = new Actions(dr);
			builder.moveToElement(omdmain).perform();
			dr.findElement(By.xpath("//a[text()[contains(.,'商品资料维护')]]")).click();
			System.out.println("开始找查询按钮");
			Thread.sleep(3000);
			dr.switchTo().frame(
					dr.findElement(By
							.xpath("/html/body/div[2]/ul/li[2]/div/iframe")));
			WebDriverWait wait = new WebDriverWait(dr, 30);
			wait.until(
					ExpectedConditions.elementToBeClickable(By
							.xpath("//span[text()[contains(.,'查询')]]"))).click();
			System.out.println("开始设置页面条数");
			Thread.sleep(5000);
			wait = new WebDriverWait(dr, 30);
			wait.until(
					ExpectedConditions.elementToBeClickable(By
							.xpath("//span[contains(@class,'mini-pager-size')][2]/span[1]/span/span/span[2]")))
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
					.xpath("//div[contains(@class,'mini-pager-right')]")));
			WebElement pageRight = dr.findElement(By
					.xpath("//div[contains(@class,'mini-pager-right')]"));
			System.out.println("####itembusiness#####"+pageRight.getText()+"#########");
			Assert.assertEquals(pageRight.getText(),"每页 50 条,共 100 条");
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
