package StepDefinitions;

import Utils.CommonMethods;
import Utils.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Login extends CommonMethods {
    @Given("driver is initiated and navigates to URL")
    public void driver_is_initiated_and_navigates_to_url() {
        OpenBrowser();
    }

    @When("User enters correct credentials")
    public void user_enters_correct_credentials() {

        sendText(loginPage.UsernameTxtBox, ConfigReader.getProperties("AdminUsername"));
        sendText(loginPage.PasswordBox, ConfigReader.getProperties("AdminPassword"));

    }

    @When("User clicks login")
    public void user_clicks_login() {
        doClick(loginPage.LoginBtn);
    }

    @Then("Dashboard should be displayed")
    public void dashboard_should_be_displayed() {
        if (loginPage.WelcomeMsg.isDisplayed()) ;
        System.out.println("WELCOME TO THE DASHBOARD!!!");
    }

}
