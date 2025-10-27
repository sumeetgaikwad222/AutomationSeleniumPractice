package stepDefinitions_Cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class LoginSteps {

    @Given("User is on login page")
    public void user_on_login_page() {
        System.out.println("User navigates to login page");
    }

    @When("User enters valid username and password")
    public void user_enters_credentials() {
        System.out.println("User enters username and password");
    }

    @Then("User should be redirected to homepage")
    public void user_redirected_homepage() {
        System.out.println("User is on homepage");
    }
}
