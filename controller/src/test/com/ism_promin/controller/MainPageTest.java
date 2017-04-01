package com.ism_promin.controller;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class MainPageTest {
    public static String DRIVER_PATH = "D:\\!!!JAVA\\chromedriver.exe";
    private static final Logger LOGGER = Logger.getLogger(MainPageTest.class);
    private final String PAGE_ADDRESS = "http://localhost:8083/";
    private final String PAGE_TITLE = "Login";

    private WebDriver driver;

    @Before
    public void init(){
        System.setProperty("webdriver.chrome.driver",DRIVER_PATH);
        driver  = new ChromeDriver();
    }

    @After
    public void after(){
        if (driver != null){
            driver.quit();
        }
    }

    @Test
    public void testDirver(){
        driver.get(PAGE_ADDRESS);
        LOGGER.info(driver.getTitle());
        Assert.assertTrue(driver.getTitle().equals(PAGE_TITLE));
    }
}
