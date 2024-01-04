package steps;

import common.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoginPageSteps {
    private LoginPage loginpage;
    WebDriver driver;
    Properties prop;
    DriverFactory driverFactory;

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() throws FileNotFoundException {
        driverFactory=new DriverFactory();
        prop=driverFactory.initProperties();
        driver=driverFactory.initDriver(prop);

    }

    @Given("user logins in with valid username and password")
    public void user_logins_in_with_valid_username_and_password() {
        loginpage=new LoginPage(driver);
       loginpage.doLogin("ram","4566");

    }

//    @When("the user click on the login button")
//    public void the_user_click_on_the_login_button() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//    @Then("I should be logged in successfully")
//    public void i_should_be_logged_in_successfully() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }


}
