package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddProjectPage extends BasePage {

    private By nameField = By.id("edit_project_modal_field_name");
    private By addButton = By.cssSelector("button[type='submit']");

    public AddProjectPage(WebDriver driver) {
        super(driver);
    }

    public AddProjectPage setProjectName(String projectName) {
        driver.findElement(nameField).sendKeys(projectName);
        return this;
    }

    public HomePage clickAddProjectButton() {
        driver.findElement(addButton).click();
        return new HomePage(driver);
    }
}
