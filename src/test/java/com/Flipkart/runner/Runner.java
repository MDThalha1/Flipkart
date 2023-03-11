package com.Flipkart.runner;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Runner {
	public static WebDriver driver;
	
public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", ".\\Driver\\chromedriver.exe");
	 driver=new ChromeDriver();
	 driver.get("https://www.flipkart.com/");
	Actions act=new Actions(driver);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	WebElement button = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
	button.click();
	WebElement text = driver.findElement(By.xpath("//input[@type='text']"));
	text.sendKeys("shoes");
	WebElement search = driver.findElement(By.cssSelector("svg[width='20']"));
	search.click();
	driver.manage().window().maximize();
	
}
}
