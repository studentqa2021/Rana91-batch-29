package com.seleniumpagefactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeleniumPagefactory {
	WebDriver driver;
	public SeleniumPagefactory(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements( driver,this);
	}
	@FindBy(xpath ="//*[@id='navigation-widget']//a")
	private List<WebElement> costcoMenuBtn;
	
	public List<WebElement> getCostcoMenuBtn() {
		return costcoMenuBtn;
	}
	public void setCostcoMenuBtn(List<WebElement> costcoMenuBtn) {
		this.costcoMenuBtn = costcoMenuBtn;
	}
	@FindBy(xpath ="//*[@class='authorization-link']")
	private List<WebElement> signinBtn;
	@FindBy(xpath ="//*[@id='email']")
	private WebElement email;
	@FindBy(xpath ="//*[@title='Password']")
	private WebElement password;
	@FindBy(xpath ="//*[@class='action login primary']")
	private WebElement secondSigninBtn;
	@FindBy(xpath ="//*[@class='greet welcome']")
	private List<WebElement> welcome;
	@FindBy(xpath ="//*[text()='Sign In / Register']")
	private List<WebElement> costCoSignIn;
	
	
	
	public List<WebElement> getCostCoSignIn() {
		return costCoSignIn;
	}
	@FindBy(xpath ="//*[@class='sub-item']")
	private List<WebElement> dealOptions;

	public List<WebElement> getDealOptions() {
		return dealOptions;
	}
	public void setCostCoSignIn(List<WebElement> costCoSignIn) {
		this.costCoSignIn = costCoSignIn;
	}
	public WebDriver getDriver() {
		return driver;
	}
	public List<WebElement> getSigninBtn() {
		return signinBtn;
	}
	public WebElement getEmail() {
		return email;
	}
	public WebElement getPassword() {
		return password;
	}
	public WebElement getSecondSigninBtn() {
		return secondSigninBtn;
	}
	public List<WebElement> getWelcome() {
		return welcome;
	}
	

}
