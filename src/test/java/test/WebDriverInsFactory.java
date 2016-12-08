package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDriverInsFactory {
private static WebDriver driver = null;
public static WebDriver getBrowser(String browserType)
{
if(driver == null){
if(browserType.equals("Firefox")){
driver = new FirefoxDriver();
}
else if(browserType.equals("Chrome")){
driver = new ChromeDriver();
}
else if(browserType.equals("IE")){
driver = new InternetExplorerDriver();
}
}
return driver;
}
} 