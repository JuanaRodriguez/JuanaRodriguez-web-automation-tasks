package todoist.org.StepsDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import selenium.DriverManager;
import utils.GradleProperties;

import static org.testng.Assert.assertTrue;

public class LoginSteps {
    private LoginPage loginPage;
    private HomePage homePage;

    public LoginSteps(HomePage homePage){
        this.homePage = homePage;
    }

    @Given("^I go to Todoist page$")
    public void iGoToTodoistPage(){
        if (!DriverManager.getInstance().getCurrentUrl().contains("https://todoist.com/app")) {
            DriverManager.getInstance().setUrl(GradleProperties.getInstance().getSite());
            loginPage = new LoginPage();
        }
    }

    @When("^I login with email \"(.*?)\" and the password \"(.*?)\"$")
    public void iSetEmailAndPassword(String email, String password){
        if (!DriverManager.getInstance().getCurrentUrl().contains("https://todoist.com/app")) {
            loginPage.setEmail(email);
            loginPage.setPassword(password);
            homePage = loginPage.clickLoginButton();
        }
    }

    @Then("^I expect the login is successfully$")
    public void iExpectLoginIsSuccessfully(){
        assertTrue(homePage.headerPage.isSettingDisplayed());
    }
}
