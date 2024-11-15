package giftcards;

import java.io.IOException;


import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericutility.BaseClass;
import genericutility.ListenerUtility;
import objectrepository.HomePage;

@Listeners(ListenerUtility.class)
public class TC_DWS_008_Test extends BaseClass {
	@Test
	public void clickOnGiftCards() throws EncryptedDocumentException, IOException
	{
		
		hp=new HomePage(driver);
				
		hp.getGiftcardsLink().click();
		Assert.assertEquals(driver.getTitle(), eUtil.getStringDataFromExcelFile("Giftcards", 1, 0),"Electronics page is not displayed");
	    test.log(Status.PASS, "Gift Cards page is displayed");

	}


}