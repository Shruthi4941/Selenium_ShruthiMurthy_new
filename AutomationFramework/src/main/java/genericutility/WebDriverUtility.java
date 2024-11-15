package genericutility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

/**
 * @author Shruthi
 */

public class WebDriverUtility {
	
	/**
	 * This method is used to maximize the window
	 * @param driver
	 */
	
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * This method is used to capture size of a window
	 * @param driver
	 * @return
	 */
	public Dimension getSize(WebDriver driver)
	{
		return driver.manage().window().getSize();
	}
	
	/**
	 * This metod is used to switch driver control to window based on url
	 * @param driver
	 * @param url
	 */
	public void switchToWindow(WebDriver driver, String url)
	{
		//step 1: capture window ids
		Set<String> allWondowIds = driver.getWindowHandles();
		//step 2: navigate through all the windows
		for(String id:allWondowIds)
		{
			driver.switchTo().window(id);
			String actUrl = driver.getCurrentUrl();
			if(actUrl.contains(url))
				break;
		}
	}
	/**
	 * This method is used to perform right click on webelement
	 * @param driver
	 */

public void rightClick(WebDriver driver)
{
	Actions act = new Actions(driver);
	act.contextClick().perform();
	
}
/**
 * This method is used to perform clickAndHold on webelement
 * @param driver
 * @param element
 */
public void clickAndHold(WebDriver driver, WebElement element)
{
	Actions act = new Actions(driver);
	act.clickAndHold(element).perform();
}
/**
 * This method is used to perform mouseHover on webelement
 * @param driver
 * @param element
 */
public void mouseHover(WebDriver driver, WebElement element)
{
	Actions act = new Actions(driver);
	act.moveToElement(element).perform();
}
/**
 * This method is used to perform dragAndDrop on webelement
 * @param driver
 * @param x
 * @param y
 */
public void dragAndDrop(WebDriver driver, int x, int y) 
{
	Actions act = new Actions(driver);
	act.moveByOffset(x, y).perform();
}
/**
 * This method is used to doubleClick on webelement
 * @param driver
 * @param element
 */
public void doubleClick(WebDriver driver, WebElement element)
{
	Actions act = new Actions(driver);
	act.doubleClick(element).perform();
}
/**
 ** This method is used to perform switchToFrame using index
 * @param driver
 * @param index
 */
public void switchToFrame(WebDriver driver, int index)
{
	driver.switchTo().frame(index);
}
/**
 * This method is used to switchTo Alert And Get the Text
 * @param driver
 * @return
 */
public String switchToAlertAndGetText(WebDriver driver)
{
	return driver.switchTo().alert().getText();
}

/**
 * This method is used to capture the screenshot of the webpage
 * @param driver
 * @throws IOException
 */
public void takesScreenshot(WebDriver driver) throws IOException
{
	String timestamp = LocalDateTime.now().toString().replace(":", "-");
	TakesScreenshot ts = (TakesScreenshot) driver;
	File temp = ts.getScreenshotAs(OutputType.FILE);
	File dest=new File("./screenshots/"+timestamp+".png");
	FileHandler.copy(temp, dest);
	
}
/**
 * This method is used to perform switchToFrame using nameOrId
 * @param driver
 * @param nameOrId
 */
public void switchToFrame(WebDriver driver, String nameOrId)
{
	driver.switchTo().frame(nameOrId);
}
/**
 * This method is used to perform switchToFrame using frame element
 * @param driver
 * @param element
 */
public void switchToFrame(WebDriver driver, WebElement element)

{
	driver.switchTo().frame(element);
}
/**
 * This method is used to perform switchBackToMainPage
 * @param driver
 * @param element
 */
public void switchBackToMainPage(WebDriver driver, WebElement element)
{
	driver.switchTo().defaultContent();
}
/**
 *  This method is used to perform selectDropdown By Index 
 * @param element
 * @param index
 */
public void selectDropdownByIndex(WebElement element, int index)
{
	Select select=new Select(element);
	select.selectByIndex(index);
	
}
/**
 * 
 * This method is used to perform selectDropdown by value
 * @param element
 * @param value
 */
public void selectDropdownByValue(WebElement element, String value)
{
	Select select=new Select(element);
	select.selectByValue(value);;
	
}
/**
 * This method is used to perform selectDropdown by Visible text
 * @param element
 * @param text
 */
public void selectDropdownByVisibleText(WebElement element, String text)
{
	Select select=new Select(element);
	select.selectByVisibleText(text);;
	
}
/**
 * This method is used to perform switchToAlert
 * @param driver
 * @return
 */
public Alert switchToAlert(WebDriver driver)
{
	return driver.switchTo().alert();
}
/**
 * 
 * This method is used to perform switchToAlert And Accept
 * @param driver
 */
public void switchToAlertAndAccept(WebDriver driver)
{
	driver.switchTo().alert().accept();
}
/**
 * 
 * This method is used to perform switchToAlert And Dismiss
 * @param driver
 */
public void switchToAlertAndDismiss(WebDriver driver)
{
	driver.switchTo().alert().dismiss();
}
/**
 * This method is used to perform switchToAlert And SendKeys
 * @param driver
 * @param data
 */
public void switchToAlertAndSendKeys(WebDriver driver, String data)
{
	 driver.switchTo().alert().sendKeys(data);
}
/**
 * This method is used to perform scroll by using js it will scroll the webpage from scrollbar position 
 * @param driver
 * @param x
 * @param y
 */
public void jsScrollBy(WebDriver driver, int x, int y)
{
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy("+x+","+y+")");
}
/**
 * This method is used to perform scroll by using js it will scroll the webpage from starting position of the scrollbar
 * @param driver
 * @param x
 * @param y
 */
public void jsScrollTo(WebDriver driver, int x, int y)
{
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollTo("+x+","+y+")");
}
/**
 * this method is used to scroll the webpage till the bottom
 * @param driver
 * @param x
 */
public void jsScrollToBottom(WebDriver driver, int x)
{
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollTo("+x+",document.body.scrollHeight)");
}

/**
 * This method is used to click on webelement using JavaScript executor
 * @param driver
 * @param element
 */
public void jsClick(WebDriver driver,WebElement element )
{
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].click()",element);
}


}
