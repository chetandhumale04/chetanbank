package com.bankingproject.testclass;

import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.bankingproject.pageobjectclass.BaseClass;
import com.bankingproject.pageobjectclass.Loinpage;

public class TestClass_001 extends BaseClass {
	@Test
	public void loginTest() throws InterruptedException, IOException
	{   
		
    try {
	test = extent.createTest("Verify Application Login");	
	Loinpage login = new Loinpage(driver);
	
    login.setUsername(username);
   test.log(Status.PASS, "ussername successfully entered");
    
    login.setPassword(password);
    test.log(Status.PASS, "password successfully entered");
    
    login.loginbut();
    test.log(Status.PASS, "clicked on login button");
    
   
    String pagetitle= "GTPL Bank Manager HomePage";
    		
    		
    		if(driver.getTitle().equals(pagetitle))
    		{
    			System.out.println("tile is correct");
    		}else
    {
    			 test.log(Status.FAIL, "Login failed");
    			    String screenshotpath = BaseClass.captureScreen();
    			    test.addScreenCaptureFromPath(screenshotpath);
    			    
	}
    }
    catch(Exception e)
    {
    test.log(Status.FAIL, "Login failed");
    String screenshotpath = BaseClass.captureScreen();
    test.addScreenCaptureFromPath(screenshotpath);
    

    } 
}
}

