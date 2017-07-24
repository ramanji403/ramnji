package tabandpophandling;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TabHandling3 {
	
	FirefoxDriver driver;
	@BeforeTest
	public void openurl()
	{
		 driver=new FirefoxDriver();
		 driver.get("http://www.bing.com/");
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}
     @Test
     public void  navigation() throws InterruptedException
     {
          @SuppressWarnings("unused")
		String mainpage=driver.getWindowHandle();
          driver.findElement(By.linkText("MSN")).click();
         ArrayList<String> childWindows=new ArrayList<String>(driver.getWindowHandles());
         
         driver.switchTo().window(childWindows.get(1));
         driver.findElement(By.xpath("//*[@id='main']/div[1]/div[1]/div/ul/li[1]/a/h3")).click();
         childWindows=new ArrayList<String>(driver.getWindowHandles());
         driver.switchTo().window(childWindows.get(2));
         driver.findElement(By.linkText("Get premium")).click();
          
     } 
}