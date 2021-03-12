package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class AddProjectPage {
    private WebDriver driver;
    private By nameField = By.id("edit_project_modal_field_name");
    private By addButton = By.cssSelector("button.ist_button:nth-child(2)");

    public AddProjectPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    public AddProjectPage clickAddProjectButton() {
        driver.findElement(addButton).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        return new AddProjectPage(driver);
    }
}
