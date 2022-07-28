package com.bankingproject.pageobjectclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loinpage {
	
	WebDriver ldriver;
	
    @FindBy(xpath =" //input[@name='uid']")
	
	WebElement userID;
	
    @FindBy(xpath =" //input[@name='password']")
	
   	WebElement password;
   	
	
     @FindBy(xpath ="//input[@name='btnLogin']")
	
   	WebElement loginbutton;
   	
	public Loinpage(WebDriver rdriver)
	
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);

	}
	
	public void setUsername(String name)
	
	{
		userID.sendKeys(name);
	}
	
    public void setPassword(String pass)
	
	{
		password.sendKeys(pass);
	}
	
    public void loginbut()
    {
    	loginbutton.click();
    }
	
}