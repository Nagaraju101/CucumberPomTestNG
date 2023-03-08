package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class LoginPage
{
    private WebDriver driver;

    // 1.By Locators
    private By username = By.xpath("//input[@name='email']");
    private By password = By.xpath("//input[@name='password']");
    private By signInButton = By.xpath("//div[text()='Login']");
    private By forgotPasswordLink = By.xpath("//a[text()='Forgot your password?']");
    private By usernameDisplay = By.xpath("//span[@class='user-display']");
    private By contactsTab = By.xpath("//span[text()='Contacts']");
    private By Category = By.xpath("//td[text='Customer']"); 
    
    Actions actions = new Actions(driver);

    // 2. Constructor of the page Object
    public LoginPage(WebDriver driver)
    {
        this.driver = driver;

    }

    // 3. Page Actions
    public String getLoginPageTitle()
    {
        return driver.getTitle();
    }

    public boolean isForgotPwdLinkExist()
    {
        return driver.findElement(forgotPasswordLink).isDisplayed();
    }

    public void enterUserName(String user)
    {
        driver.findElement(username).sendKeys(user);
    }

    public void enterPassword(String pwd)
    {
        driver.findElement(password).sendKeys(pwd);
    }

    public void clickOnLogin()
    {
        driver.findElement(signInButton).click();
    }

    public boolean usernameDisplay()
    {
        return driver.findElement(usernameDisplay).isDisplayed();
    }
    
    public void moveMouseover() {        
        actions.moveToElement(driver.findElement(contactsTab)).build().perform();
    }
    
    public void clickOnCategoryValue() {
        actions.moveToElement(driver.findElement(Category)).build().perform();
    }

}
