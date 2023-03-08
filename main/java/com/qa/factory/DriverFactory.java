package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory
{
    public WebDriver driver;

    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public WebDriver init_driver(String browser)
    {
        System.out.println("Browser is :" + browser);

        if (browser.equals("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            tlDriver.set(new ChromeDriver());
        }
        else
            if (browser.equals("firefox"))
            {
                WebDriverManager.firefoxdriver().setup();
                tlDriver.set(new ChromeDriver());
            }
            else
            {
                System.out.println("Please pass the correct browser value" + browser);
            }
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();

        return getDriver();
    }

    public static synchronized WebDriver getDriver()
    {
        return tlDriver.get();
    }

}
