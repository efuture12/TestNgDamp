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

public class TestCaseOrgAuthority {
	private WebDriver dr;
	private StringBuffer verificationErrors = new StringBuffer();

	@BeforeClass(alwaysRun = true)
	public void Setup() {
		System.out.println("aaa");
		dr = WebDriverInsFactory.getBrowser("Firefox");

	}

	@Test
	public void setOrgAuthority() throws InterruptedException {
		System.out.println("bbb");
		dr.switchTo().defaultContent();
		System.out.println("数据范围授权(按机构)");
		WebElement userCenter = dr.findElement(By
				.xpath("//ul[contains(@class,'has-transitions')]/li[2]/a"));
		userCenter.click();
		Actions builder = new Actions(dr);
		builder.moveToElement(userCenter).perform();
		dr.findElement(By.xpath("//a[text()[contains(.,'数据范围授权(按机构)')]]"))
				.click();
		System.out.println("开始点击数据范围授权(按机构)");
		// waitMyElement(By.xpath("/html/body/div[2]/ul/li[2]/div/iframe"), dr);
		Thread.sleep(7000);
		dr.switchTo().frame(
				dr.findElement(By
						.xpath("/html/body/div[2]/ul/li[2]/div/iframe")));
		WebDriverWait wait = new WebDriverWait(dr, 30);
		wait.until(
				ExpectedConditions.elementToBeClickable(By
						.xpath("//span[text()[contains(.,'B011    自动化测试商城')]]")))
				.click();
		addOrgAuthority(dr);
		Thread.sleep(3000);
		wait = new WebDriverWait(dr, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//span[text()[contains(.,'B011    自动化测试商城')]]")));
		new Actions(dr)
				.doubleClick(
						dr.findElement(By
								.xpath("//span[text()[contains(.,'B011    自动化测试商城')]]")))
				.perform();
		wait = new WebDriverWait(dr, 30);
		wait.until(
				ExpectedConditions.elementToBeClickable(By
						.xpath("//span[text()[contains(.,'C001    自动化测试区域')]]")))
				.click();
		addOrgAuthority(dr);
		dr.switchTo().defaultContent();
		WebElement closetab = dr.findElement(By
				.xpath("//em[contains(@class,'closetab')]"));
		closetab.click();
	}

	private void addOrgAuthority(WebDriver dr) {
		WebDriverWait wait = new WebDriverWait(dr, 30);
		wait.until(
				ExpectedConditions.elementToBeClickable(By
						.xpath("//span[text()[contains(.,'新增')]]"))).click();
		wait = new WebDriverWait(dr, 30);
		wait.until(
				ExpectedConditions.elementToBeClickable(By
						.xpath("//div[contains(@class,'fwt_flow')]/div[3]/span/a")))
				.click();
		System.out.println("开始选商城");
		String inputShop = "//div[contains(@class,'mini-window-drag')]/div/div[2]/div[2]/div/div/div[1]/div[2]/div/div/div[2]/div/div[2]/div[4]/div[2]/div/table/tbody/tr[2]/td[2]/div";
		wait = new WebDriverWait(dr, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(inputShop)))
				.click();
		wait = new WebDriverWait(dr, 30);
		wait.until(
				ExpectedConditions.elementToBeClickable(By
						.xpath("//span[text()[contains(.,'确定')]]"))).click();
		String makesureInput = "/html/body/div[2]/div/div[1]/div[2]/div/div/div[1]/div[2]/div/div/div[2]/div/div[2]/div[4]/div[2]/div/table/tbody/tr[2]/td[2]/div";
		wait = new WebDriverWait(dr, 30);
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath(makesureInput)))
				.click();
		wait = new WebDriverWait(dr, 30);
		wait.until(
				ExpectedConditions.elementToBeClickable(By
						.xpath("//span[text()[contains(.,'保存')]]"))).click();
		wait = new WebDriverWait(dr, 30);
		wait.until(
				ExpectedConditions.elementToBeClickable(By
						.xpath("//div[contains(@class,'mini-messagebox-buttons')]/a")))
				.click();

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
