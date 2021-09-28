package com.qa.testscripts;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC_W3SchoolAutomation_001 extends TestBase
{
	@Test
	public void framesAndAlertDemo() throws InterruptedException
	{
		//w3SchoolOR.getTutorialsSection().click();;
		//w3SchoolOR.getLearnJS().click();
		Thread.sleep(2000);
		WebElement learnJS=w3SchoolOR.getLearnJS();
		js.executeScript("arguments[0].scrollIntoView(true)",learnJS);
		Thread.sleep(2000);
		learnJS.click();
		Thread.sleep(2000);
		w3SchoolOR.getSearchBtn().click();
		WebElement searchBox=w3SchoolOR.getSearchTxtBox();
		Reporter.log("Default text is "+searchBox.getText(),true);
		searchBox.clear();
		searchBox.sendKeys(prop.getProperty("topicName"));
		Thread.sleep(2000);
		String parent=driver.getWindowHandle();
		w3SchoolOR.getGoogleSearchBtn().click();
		List<WebElement> allOptions=w3SchoolOR.getAllJSOptions();
		Reporter.log("size is "+allOptions.size(),true);
		for(WebElement option:allOptions)
		{
			if(option.getText().contains("alert()"))
			{
				Thread.sleep(2000);
				option.click();
				break;
			}
		}
		//Reporter.log("pass",true);
		
		Set<String> allWindow=driver.getWindowHandles();
		for(String child:allWindow)
		{
			if(!child.equals(parent))
			{
				driver.switchTo().window(child);
				w3SchoolOR.getTryYourself1().click();
				allWindow=driver.getWindowHandles();
				for(String child2:allWindow)
				{
					if(!child2.equals(parent) && !child2.equals(child))
					{
						driver.switchTo().window(child2);
						driver.switchTo().frame(w3SchoolOR.getIframe());
						Thread.sleep(2000);
						w3SchoolOR.getTryIt().click();
						Thread.sleep(2000);
						driver.switchTo().alert().accept();
						driver.switchTo().defaultContent();
						//driver.switchTo().parentFrame();
						Thread.sleep(2000);
						w3SchoolOR.getChangeTheme().click();
						Thread.sleep(2000);
						driver.switchTo().window(parent);
						Thread.sleep(2000);
						w3SchoolOR.getClose().click();
						Thread.sleep(2000);
						Reporter.log(driver.getTitle(),true);
					}
				}
			}
		}
		
	}
}
