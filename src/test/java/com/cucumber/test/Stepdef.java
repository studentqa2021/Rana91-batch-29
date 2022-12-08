package com.cucumber.test;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import com.drivermanager.DriverManager;
import com.seleniumpagefactory.SeleniumPagefactory;
import com.seleniumwait.SeleniumWait;
import com.util.Constants;
import com.util.Highlighter;
import com.util.ScreenShot;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdef {

	WebDriver driver;
	SeleniumPagefactory pf;
	@Given("open any browser")
	public void open_any_browser() {
		 driver =DriverManager.getBrowser("edge");
		driver.manage().window().maximize();
		SeleniumWait.getImplicitWait(driver, 3);
	}

	@Given("go to application URL")
	public void go_to_application_URL() {
		driver.navigate().to(Constants.URL);
		try {
			ScreenShot.getScreenShot(driver, "Home Page");
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//explicit wait=WebDriver wait
		 pf = new SeleniumPagefactory(driver);
		SeleniumWait.getExplicitWait(driver, pf.getSigninBtn().get(0), 3);
	}

	@When("click sign in button")
	public void click_sign_in_button() {
		Highlighter.getColor(driver, pf.getSigninBtn().get(0));
		pf.getSigninBtn().get(0).click();
		
		try {
			ScreenShot.getScreenShot(driver, "Login Page");
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("put email")
	public void put_email() {
		Highlighter.getColor(driver, pf.getEmail());
		pf.getEmail().click();
		pf.getEmail().sendKeys(Constants.user);
	}

	@When("put password")
	public void put_password() {
		Highlighter.getColor(driver, pf.getPassword());
		pf.getPassword().click();
		pf.getPassword().sendKeys(Constants.passWord);
	}

	@When("click secod sign button")
	public void click_secod_sign_button() {
		Highlighter.getColor(driver, pf.getSecondSigninBtn());
		pf.getSecondSigninBtn().click();
		try {
			ScreenShot.getScreenShot(driver, "Login Validation");
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("validate login was successful")
	public void validate_login_was_successful() {
		boolean status =pf.getWelcome().get(0).isDisplayed();
		//Assertion = Hard & soft
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(status);//condition =true or false
		
		sa.assertAll();//validation
	}

}
