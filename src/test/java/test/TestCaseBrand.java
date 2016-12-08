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

public class TestCaseBrand {
	private WebDriver dr;
	private StringBuffer verificationErrors = new StringBuffer();

	@BeforeClass(alwaysRun = true)
	public void Setup() {
		dr = WebDriverInsFactory.getBrowser("Firefox");

	}

	@Test
	public void brandNumCheck() throws InterruptedException {

		dr.switchTo().defaultContent();
		System.out.println("寮�鎵句富鏁版嵁1");
		WebElement omdmain = dr.findElement(By
				.xpath("//ul[contains(@class,'has-transitions')]/li[3]/a"));
		omdmain.click();
		Actions builder = new Actions(dr);
		builder.moveToElement(omdmain).build().perform();
		dr.findElement(By.xpath("//a[text()[contains(.,'鍝佺墝瀹氫箟')]]")).click();
		System.out.println("寮�鎵炬煡璇㈡寜閽�");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		dr.switchTo().frame(
				dr.findElement(By
						.xpath("/html/body/div[2]/ul/li[2]/div/iframe")));
		WebDriverWait wait = new WebDriverWait(dr, 30);
		wait.until(
				ExpectedConditions.elementToBeClickable(By
						.xpath("//span[text()[contains(.,'鏌ヨ')]]"))).click();
		System.out.println("寮�鎵剧‘瀹氭寜閽�");
		System.out.println("寮�璁剧疆椤甸潰鏉℃暟1");
		wait = new WebDriverWait(dr, 30);
		wait.until(
				ExpectedConditions.elementToBeClickable(By
						.xpath("//span[contains(@class,'mini-pager-size')][2]/span[1]/span/span/span[2]")))
				.click();
		System.out.println("寮�鐐瑰嚮椤甸潰鏉℃暟1");
		wait = new WebDriverWait(dr, 30);
		wait.until(
				ExpectedConditions.elementToBeClickable(By
						.xpath("//div[contains(@class,'mini-popup')]/div/div[1]/div[2]/div/table/tbody/tr[3]")))
				.click();
		Thread.sleep(3000);
		wait = new WebDriverWait(dr, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//div[contains(@class,'mini-pager-right')]")));
		WebElement brandPageRight = dr.findElement(By
				.xpath("//div[contains(@class,'mini-pager-right')]"));
		System.out.println("brandPageRight####"+brandPageRight.getText()+"###");
		Assert.assertEquals(brandPageRight.getText(),"ddd");
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		// dr.quit();
		Thread.sleep(1000);
		dr.switchTo().defaultContent();
		WebElement brandClosetab = dr.findElement(By
				.xpath("//em[contains(@class,'closetab')]"));
		brandClosetab.click();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			Assert.fail(verificationErrorString);
		}
	}

}
