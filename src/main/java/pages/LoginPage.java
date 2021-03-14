package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @FindBy(id = "email")
    @CacheLookup
    WebElement emailField;

    @FindBy(id = "password")
    @CacheLookup
    WebElement passwordField;

    @FindBy(css = "button.submit_btn")
    @CacheLookup
    WebElement loginButton;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public void setEmail(String email) {
        emailField.sendKeys(email);
    }

    public void setPassword(String password) {
        passwordField.sendKeys(password);
    }

    public HomePage clickLoginButton() {
        loginButton.click();
        return new HomePage();
    }
}
