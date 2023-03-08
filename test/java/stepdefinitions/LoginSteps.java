package stepdefinitions;


import org.junit.Assert;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps
{
    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver()); 
    private static String title; 
    
    @Given("user is on login page")
    public void user_is_on_login_page() {
        DriverFactory.getDriver().get("https://ui.cogmento.com/");
    }

    @When("user enters password {string}")
    public void user_enters_password(String pwd) {
        loginPage.enterPassword(pwd);
    }
    
    @When("user enters username {string}")
    public void user_enters_username(String user) {
        loginPage.enterUserName(user);
    }

    @When("user clicks on Login button")
    public void user_clicks_on_login_button() {
        loginPage.clickOnLogin();
    }

    @Then("username should be displayed on the page")
    public void username_should_be_displayed_on_the_page() throws InterruptedException {
        Thread.sleep(3000);
        loginPage.usernameDisplay();
    }

    @When("forgot our password link should be displayed")
    public void forgot_our_password_link_should_be_displayed() {
        Assert.assertTrue(loginPage.isForgotPwdLinkExist());
    }
    
    @Then("I click on contacts tab")
    public void i_click_on_contacts_tab() {
       loginPage.moveMouseover();
    }

    @Then("I click on one Category")
    public void i_click_on_one_Category() {
        loginPage.clickOnCategoryValue(); 
    }
}
