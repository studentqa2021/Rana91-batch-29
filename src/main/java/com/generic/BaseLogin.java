package com.generic;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.drivermanager.DriverManager;
import com.seleniumpagefactory.SeleniumPagefactory;
import com.seleniumwait.SeleniumWait;
import com.util.Constants;
import com.util.Highlighter;
import com.util.ScreenShot;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseLogin {
	public void getlogin(){
		//open a browser
		WebDriver driver =DriverManager.getBrowser("edge");
		driver.manage().window().maximize();
		SeleniumWait.getImplicitWait(driver, 3);
		// go to URL
		driver.navigate().to(Constants.URL);
		
		try {
			ScreenShot.getScreenShot(driver, "HomePage");
		} catch (Throwable e1) {
			e1.printStackTrace();
		}
		//explicit wait=WebDriver wait
		SeleniumPagefactory pf = new SeleniumPagefactory(driver);
		SeleniumWait.getExplicitWait(driver, pf.getSigninBtn().get(0), 3);
		//click sign in
		Highlighter.getColor(driver, pf.getSigninBtn().get(0));
		pf.getSigninBtn().get(0).click();
		
		try {
			ScreenShot.getScreenShot(driver, "Login Page");
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//put user
		Highlighter.getColor(driver, pf.getEmail());
		pf.getEmail().click();
		pf.getEmail().sendKeys(Constants.user);
		//put pass
		Highlighter.getColor(driver, pf.getPassword());
		pf.getPassword().click();
		pf.getPassword().sendKeys(Constants.passWord);
		//click second sign in
		Highlighter.getColor(driver, pf.getSecondSigninBtn());
		pf.getSecondSigninBtn().click();
		try {
			ScreenShot.getScreenShot(driver, "Login Validation");
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//validation	
		boolean status =pf.getWelcome().get(0).isDisplayed();
		//Assertion = Hard & soft
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(status);//condition =true or false
		
		sa.assertAll();//validation
		
	}
		
	}


