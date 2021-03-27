package com.test;

import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class TestDocker {
	RemoteWebDriver driver ;
	
	@Test
	@Parameters("browser")
	public void testDocker(String browser) throws Throwable{
		DesiredCapabilities capabilities ;
		if(browser.equalsIgnoreCase("chrome")){
			 capabilities = DesiredCapabilities.chrome();
			capabilities.setPlatform(Platform.LINUX);
			capabilities.setBrowserName("chrome");
		}else {
			 capabilities = DesiredCapabilities.firefox();
			capabilities.setPlatform(Platform.LINUX);
			capabilities.setBrowserName("firefox");
		}


		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);

		driver.get("https://google.com");
		System.out.println(driver.getTitle());


		Thread.sleep(15000);
	}

		@AfterMethod
		public  void teardown() {
			driver.quit();
		}
}
