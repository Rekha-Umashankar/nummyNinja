package com.juicetry.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {

	  	public static WebDriver driver;
	  	public static Properties prop;
	  	
	public TestBase() {
		try {
			prop=new Properties();
			FileInputStream ip= new FileInputStream("C:\\Users\\kiran\\Desktop\\Test\\TryOut\\src\\main\\java\\com\\juicetry\\qa\\config\\config.properties");
			prop.load(ip);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
		public static void initialization() {
			//read properties from config file
			String browserName = prop.getProperty("browser");
			if(browserName.equals("chrome")) {
				System.setProperty("webdriver.driver.chrome","C:\\Users\\kiran\\Desktop\\Test\\JuiceShop\\src\\main\\java\\com\\juiceshop\\ga\\config\\config.properties");
				 driver = new ChromeDriver();
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			
			//driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			//driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			
			driver.get(prop.getProperty("url"));				
			
		
	}

}
