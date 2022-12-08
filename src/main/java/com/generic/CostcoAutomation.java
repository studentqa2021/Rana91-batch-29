package com.generic;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import com.drivermanager.DriverManager;
import com.seleniumpagefactory.SeleniumPagefactory;
import com.seleniumwait.SeleniumWait;
import com.util.Constants;
import com.util.Highlighter;
import com.util.ScreenShot;

public class CostcoAutomation {
public static void productHandle(){
	WebDriver driver=DriverManager.getBrowser("chrome");
	driver.manage().window().maximize();
	driver.navigate().to(Constants.Costco_URL);
	SeleniumWait.getImplicitWait(driver,5);
	System.out.println("Home page Title/name=" + driver.getTitle());
	//Check=validate current URL is matched or not==> getCurrentURL()
			System.out.println("Current page URl = "+driver.getCurrentUrl());
			try {
				ScreenShot.getScreenShot(driver,"Costco home welcome page" );
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//Expectation = Constants.COSTCO_URL , actual =driver.getCurrentUrl()
			SoftAssert sf = new SoftAssert();
			sf.assertEquals(driver.getCurrentUrl(),Constants.Costco_URL);
			SeleniumPagefactory pf = new SeleniumPagefactory(driver);
			pf.getCostCoSignIn().get(0).click();
			System.out.println("Login page Title/name=" + driver.getTitle());
			try {
				ScreenShot.getScreenShot(driver,"Costco Login welcome page" );
			} catch (Throwable e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			while(true) {//true==> infinite loop
				if(pf.getCostCoSignIn().size()>0) {
					break;
				}else {
					driver.navigate().back();
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			System.out.println("Menu count = "+pf.getCostcoMenuBtn().size());
			
			for(int i=0;i<pf.getCostcoMenuBtn().size();i++) {
				Highlighter.getColor(driver, pf.getCostcoMenuBtn().get(i), "white");
				System.out.println(pf.getCostcoMenuBtn().get(i).getText());
				
			}
			//8 >If the deal was there, then mouse over it and read all options
			//mouse hover= Actions class= moveToElement()
			
			
			for(int i=0;i<pf.getCostcoMenuBtn().size();i++) {
				
				if(pf.getCostcoMenuBtn().get(i).getText().contains("Deals")) {//true
					Highlighter.getColor(driver, pf.getCostcoMenuBtn().get(i), "red");
					Actions ac = new Actions(driver);
					ac.moveToElement(pf.getCostcoMenuBtn().get(i)).perform();
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("Deal options count = "+pf.getDealOptions().size());
					//Read name of All deal options==> loop
					for(int j=0;j<pf.getDealOptions().size();j++) {//2nd loop
						Highlighter.getColor(driver, pf.getDealOptions().get(j), "green");
						System.out.println(pf.getDealOptions().get(j).getText());
				
			}
				}
				
			}
			
			
	sf.assertAll();
}
public static void main(String[] args) {
	CostcoAutomation.productHandle();
	
}



}
