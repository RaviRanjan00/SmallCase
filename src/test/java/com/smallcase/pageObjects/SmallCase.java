package com.smallcase.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SmallCase {

	WebDriver driver;

	@BeforeMethod
    public void launchbrowser()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @AfterMethod
    public void close()
    {
        driver.quit();
    }
}
