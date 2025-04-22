package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.constants.Browser;

public abstract class BrowserUtility {
	 private static ThreadLocal<WebDriver> driver =new ThreadLocal<WebDriver>();
	Logger logger=LoggerUtility.getLogger(this.getClass());


	public WebDriver getDriver() {
		return driver.get();
	}

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver);
	}
	
	public BrowserUtility(String browserName) {
		logger.info("Launching Browser for" +browserName);
		
		if(browserName.equalsIgnoreCase("chrome")){
			driver.set(new ChromeDriver());
		}
		else if(browserName.equalsIgnoreCase("edge")){
			driver.set(new EdgeDriver());
		}
		else {
			logger.error("Invalide browser Name ..... Please selsect Chrome or Edge only...");
			System.out.println("Invalide browser Name ..... Please selsect Chrome or Edge only ...");
		}
	}
	
	public BrowserUtility(Browser browserName) {
		logger.info("Launching Browser for" +browserName);
		
		if(browserName==Browser.CHROME){
			driver.set(new ChromeDriver());
		}
		else if(browserName==Browser.EDGE){
			driver.set(new EdgeDriver());
		}
		else if(browserName==Browser.FIREFOX){
			driver.set(new FirefoxDriver());
		}
		
	}
	
	
	public BrowserUtility(Browser browserName, boolean isHeadless) {
		logger.info("Launching Browser for" +browserName);
		
		if(browserName==Browser.CHROME ){
			if(isHeadless) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless=new");
			options.addArguments("--window-size=1920,1080");
			options.addArguments("--disable-gpu"); // Disable GPU rendering
			options.addArguments("--no-sandbox"); // Bypass OS-level 
			driver.set(new ChromeDriver(options));
			}
			else {
				driver.set(new ChromeDriver());
			}
		}
		else if(browserName==Browser.EDGE){
			if(isHeadless) {
				EdgeOptions options=new EdgeOptions();
				options.addArguments("--headless=new");
				options.addArguments("disable-gpu");
				options.addArguments("--no-sandbox");
	                options.addArguments("--disable-dev-shm-usage");
				driver.set(new EdgeDriver(options));
			}
			else {
			driver.set(new EdgeDriver());
			}
		}
		else if(browserName==Browser.FIREFOX){
			if(isHeadless) {
				FirefoxOptions options=new FirefoxOptions();
				options.addArguments("--headless=old");
				driver.set(new FirefoxDriver(options));
			}
			else {
			driver.set(new FirefoxDriver());
			}
		}
		
	}
	
	
	
	
	
	public void goToWebsite(String url) {
		logger.info("Visiting the Website " + url);
		driver.get().get(url);
	}
	
	public void maximizeWindow() {
		logger.info(" Maximizing the browser Window ");
		driver.get().manage().window().maximize();
	}
	
	public void clickOn(By locator) {
		logger.info(" Finding the Element with the locator " + locator);
		
		WebElement element = driver.get().findElement(locator);//find element
		logger.info(" Element found and now performing Click ");
		
		element.click();
	}
	
	public void enterText (By locator,String textToEnter) {
		logger.info(" Finding the Element with the locator " + locator);
		
		WebElement element = driver.get().findElement(locator);
		logger.info(" Element found and now enter Text "+textToEnter);
		
		element.sendKeys(textToEnter);
	}
	
	public String getVisibleText(By locator) {
		logger.info(" Finding the Element with the locator " + locator);
		
		WebElement element = driver.get().findElement(locator);
		logger.info(" Element found and now returning the visible"+element.getText());
		
		return element.getText();
		
	}
	

	public String takeScreenShot(String name) {
		TakesScreenshot screenshot=(TakesScreenshot)driver.get();
		
		File screenshotData=screenshot.getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
		String timeStamp = format.format(date);
		String path ="./screenshots/"+name + " - "+ timeStamp + ".png";
		File screenshotFile = new File(path);
		try {
			FileUtils.copyFile(screenshotData, screenshotFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}
	
	public void quit() {
		driver.get().quit();
	}

}
